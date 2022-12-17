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

package com.mycompany.adotapet.voluntario;

import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.larTemporario.LarTemporarioDAO;
import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.repositorio.DbConnection;
import com.mycompany.adotapet.telefone.TelefoneDAO;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `voluntario` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `cpf` bigint(20) unsigned NOT NULL,
  `idTelefone` bigint(20) unsigned NOT NULL,
  `idEndereco` bigint(20) unsigned NOT NULL,
  `idLartemporario` bigint(20) unsigned DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `idTelefone` (`idTelefone`),
  KEY `idEndereco` (`idEndereco`),
  KEY `idLartemporario` (`idLartemporario`),
  CONSTRAINT `voluntario_ibfk_1` FOREIGN KEY (`idTelefone`) REFERENCES `telefone` (`id`),
  CONSTRAINT `voluntario_ibfk_2` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`),
  CONSTRAINT `voluntario_ibfk_3` FOREIGN KEY (`idLartemporario`) REFERENCES `lartemporario` (`id`)
) ENGINE=InnoDB</pre>
 * Classe VoluntarioDAO
 * @author Pedro Dias
 */
public class VoluntarioDAO extends DAO<Voluntario>{
    
    public static final String TABLE = "voluntario";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (nome, cpf, idTelefone, idEndereco) VALUES (?,?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET nome = ?, cpf = ?, idTelefone = ?, idEndereco = ? WHERE id = ?";
    }
    
    public String getAddLarTemporarioStatment() {
        return "UPDATE " + TABLE + " SET idLartemporario = ? WHERE id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Voluntario e) {
        try {
            //formata de acordo com o bd 
            pstmt.setString(1, e.getNome());
            pstmt.setLong(2, e.getCpf());
            pstmt.setObject(3, e.getTelefone().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(4, e.getEndereco().getId(), java.sql.Types.BIGINT);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(6, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoluntarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adicionarLarTemporario(Voluntario e) {
        
        //checa se o voluntario já foi criado e está associado a um LarTemporario
        if (e.getLarTemporario() != null && e.getId() != null) {

            // try-with-resources
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConexao().prepareStatement(
                            getAddLarTemporarioStatment())) {
                
                preparedStatement.setObject(1, e.getLarTemporario().getId(), java.sql.Types.BIGINT);
                preparedStatement.setLong(2, e.getId());

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }
        }
    }
    
    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ?";
    }
    
    public String getFindByCpfStatment() {
        return "SELECT * FROM " + TABLE + " WHERE cpf = ?";
    }
    
    public String getFindByLarTemporarioIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE idLartemporario = ?";
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
    public Voluntario extractObject(ResultSet resultSet) {

        Voluntario voluntario = null;

        try {
            voluntario = new Voluntario();
            voluntario.setId(resultSet.getLong("id"));
            voluntario.setNome(resultSet.getString("nome"));
            voluntario.setCpf(resultSet.getLong("cpf"));
            voluntario.setTelefone(new TelefoneDAO().findById(resultSet.getLong("idTelefone")));
            voluntario.setEndereco(new EnderecoDAO().findById(resultSet.getLong("idEndereco")));
            voluntario.setLarTemporario(new LarTemporarioDAO().findByVoluntario(voluntario));
            if(voluntario.getLarTemporario() != null){
                voluntario.getLarTemporario().adicionarVoluntario(voluntario);
            }
            voluntario.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(VoluntarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VoluntarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voluntario;
    }
    
    public Voluntario findByCpf(Long cpf) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByCpfStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, cpf);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return null;
    }
    
    public List<Voluntario> findByLarTemporario(Long id) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByLarTemporarioIdStatment())) {

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
    
    public Voluntario findById(Long id) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByIdStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return null;
    }
}
