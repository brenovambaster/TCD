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
package com.mycompany.adotapet.telefone;

import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.repositorio.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <pre>CREATE TABLE `telefone` (
 * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 * `ddd` tinyint(4) NOT NULL,
 * `numero` int(11) NOT NULL,
 * `mensagem` tinyint(1) DEFAULT 0,
 * `excluido` tinyint(1) DEFAULT 0,
 * PRIMARY KEY (`id`),
 * UNIQUE KEY `id` (`id`),
 * UNIQUE KEY `numero` (`numero`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4</pre> Classe TelefoneDAO
 *
 * @author Pedro Dias
 */
public class TelefoneDAO extends DAO<Telefone> {

    public static final String TABLE = "telefone";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (ddd, numero, mensagem) VALUES(?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET ddd = ?, numero = ?, mensagem = ? WHERE id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Telefone e) {
        try {
            //formata de acordo com o bd 
            pstmt.setObject(1, e.getDDD(), java.sql.Types.TINYINT);
            pstmt.setObject(2, e.getNumero(), java.sql.Types.INTEGER);
            pstmt.setObject(3, e.getMensagem(), java.sql.Types.BOOLEAN);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(4, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ?";
    }

    public String getFindByNumberStatment() {
        return "SELECT * FROM " + TABLE + " WHERE numero = ?";
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
    public Telefone extractObject(ResultSet resultSet) {

        Telefone telefone = null;

        try {
            telefone = new Telefone();
            telefone.setId(resultSet.getLong("id"));
            telefone.setDDD(resultSet.getShort("ddd"));
            telefone.setNumero(resultSet.getInt("numero"));
            telefone.setMensagem(resultSet.getBoolean("mensagem"));
            telefone.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return telefone;
    }
    
    public Telefone findByNumber(Integer numero) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByNumberStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setInt(1, numero);

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
