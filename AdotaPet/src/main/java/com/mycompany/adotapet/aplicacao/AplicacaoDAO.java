/*
 * Copyright (C) 2022 Pedro Dias
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.mycompany.adotapet.aplicacao;

import com.mycompany.adotapet.medicamento.MedicamentoDAO;
import com.mycompany.adotapet.pet.PetDAO;
import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.repositorio.DbConnection;
import com.mycompany.adotapet.voluntario.VoluntarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `aplicacao` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `medicamento_id` bigint(20) unsigned NOT NULL,
  `voluntario_id` bigint(20) unsigned NOT NULL,
  `pet_id` bigint(20) unsigned NOT NULL,
  `data` date NOT NULL,
  `anotacao` varchar(200) DEFAULT NULL,
  `qtdDose` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `medicamento_id` (`medicamento_id`),
  KEY `voluntario_id` (`voluntario_id`),
  KEY `pet_id` (`pet_id`),
  CONSTRAINT `aplicacao_ibfk_1` FOREIGN KEY (`medicamento_id`) REFERENCES `medicamento` (`id`),
  CONSTRAINT `aplicacao_ibfk_2` FOREIGN KEY (`voluntario_id`) REFERENCES `voluntario` (`id`),
  CONSTRAINT `aplicacao_ibfk_3` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`id`)
) ENGINE=InnoDB</pre>
 *
 * Classe AplicacaoDAO
 * @author Pedro Dias
 */
public class AplicacaoDAO extends DAO<Aplicacao>{
    
    public static final String TABLE = "aplicacao";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (medicamento_id, voluntario_id, pet_id, data, anotacao, qtdDose)"
                + " VALUES (?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET medicamento_id = ?, voluntario_id = ?, pet_id = ?, data = ?, "
                + "anotacao = ?, qtdDose = ? WHERE id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Aplicacao e) {
        try {
            //formata de acordo com o bd 
            pstmt.setLong(1, e.getMedicamento().getId());
            pstmt.setLong(2, e.getResponsavelAplicacao().getId());
            pstmt.setLong(3, e.getPet().getId());
            pstmt.setObject(4, e.getData(), java.sql.Types.DATE);
            pstmt.setString(5, e.getAnotacao());
            pstmt.setObject(6, e.getQtdDose(), java.sql.Types.FLOAT);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(7, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoluntarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ?";
    }
    
    public String getFindByPetStatment() {
        return "SELECT * FROM " + TABLE + " WHERE pet_id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "SELECT * FROM " + TABLE;
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "SELECT * FROM " + TABLE + " WHERE excluido = true";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "UPDATE " + TABLE + " SET excluido = true WHERE id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE " + TABLE + " SET excluido = false WHERE id = ?";
    }

    @Override
    public Aplicacao extractObject(ResultSet resultSet) {

        Aplicacao aplicacao = null;

        try {
            aplicacao = new Aplicacao();
            aplicacao.setId(resultSet.getLong("id"));
            aplicacao.setMedicamento(new MedicamentoDAO().findById(resultSet.getLong("medicamento_id")));
            aplicacao.setResponsavelAplicacao(new VoluntarioDAO().findById(resultSet.getLong("voluntario_id")));
            aplicacao.setPet(new PetDAO().findById(resultSet.getLong("pet_id")));
            aplicacao.setData(resultSet.getDate("data").toLocalDate());
            aplicacao.setAnotacao(resultSet.getString("anotacao"));
            aplicacao.setQtdDose(resultSet.getFloat("qtdDose"));
            aplicacao.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(AplicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AplicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aplicacao;
    }
    
    public List<Aplicacao> findByPet(Long id) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByPetStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObjects(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return null;
    }
}
