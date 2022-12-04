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

package com.mycompany.adotapet.larTemporario;

import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.repositorio.DbConnection;
import com.mycompany.adotapet.voluntario.VoluntarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `lartemporario` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `endereco_id` bigint(20) unsigned NOT NULL,
  `excluido` tinyint(1) DEFAULT 0,
  `voluntario_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `endereco_id` (`endereco_id`),
  KEY `voluntario_id` (`voluntario_id`),
  CONSTRAINT `lartemporario_ibfk_1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`),
  CONSTRAINT `lartemporario_ibfk_2` FOREIGN KEY (`voluntario_id`) REFERENCES `voluntario` (`id`)
) ENGINE=InnoDB</pre>
 *
 * Classe LarTemporarioDAO
 * @author Pedro Dias
 */
public class LarTemporarioDAO extends DAO<LarTemporario>{
    
    public static final String TABLE = "lartemporario";
    
    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + "  (nome, endereco_id, voluntario_id) VALUES (?,?,?)";
    }
    
    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + "  SET nome = ? , endereco_id = ?,  voluntario_id = ? WHERE id = ? ";
    }
    
    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, LarTemporario e) {
        try {
            pstmt.setString(1, e.getNome());
            pstmt.setLong(2, e.getEndereco().getId());
            pstmt.setLong(3, e.getFundador().getId());;
            
            if (e.getId() != null) {
                pstmt.setLong(4, e.getId());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LarTemporarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ? ";
    }
    
    public String getFindByNameStatment() {
        return "SELECT * FROM " + TABLE + " WHERE nome = ? ";
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
        return "UPDATE  " + TABLE + " SET excluido = true WHERE id = ?";
    }
    
    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE  " + TABLE + " SET excluido = false WHERE id = ?";
    }
    
    @Override
    public LarTemporario extractObject(ResultSet resultSet) {
        LarTemporario larTemporario = null;
        
        larTemporario = new LarTemporario();
        try {
            larTemporario.setId(resultSet.getLong("id"));
            larTemporario.setNome(resultSet.getString("nome"));
            larTemporario.setEndereco(new EnderecoDAO().findById(resultSet.getLong("endereco_id")));
            larTemporario.setFundador(new VoluntarioDAO().findById(resultSet.getLong("voluntario_id")));
            larTemporario.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return larTemporario;
    }
    
    public LarTemporario findByName(String nome) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByNameStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setString(1, nome);

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
