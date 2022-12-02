/*
 * Copyright (C) 2022 Breno Vambaster C. L
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
package com.mycompany.adotapet.tipoLogradouro;

import com.mycompany.adotapet.repositorio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>
 * CREATE TABLE `tipologradouro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `excluido` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 </pre>
 * Classe TipoLogradouroDAO
 *
 * @author Breno Vambaster C. L
 */

public class TipoLogradouroDAO extends DAO<TipoLogradouro> {

    public static final String TABLE = "TipoLogradouro";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (nome) values(?)";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET nome = ? WHERE id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, TipoLogradouro e) {
        try {
            //formata de acordo com o bd 
            pstmt.setString(1, e.getNome());

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(2, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoLogradouroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ?";
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
        return "update " + TABLE + " SET excluido = true WHERE id=?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE " + TABLE + " SET excluido = false WHERE id = ?";
    }

    @Override
    public TipoLogradouro extractObject(ResultSet resultSet) {
        TipoLogradouro logradouro = null;
        try {
            logradouro = new TipoLogradouro();
            logradouro.setId(resultSet.getLong("id"));
            logradouro.setNome(resultSet.getString("nome"));
            logradouro.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(TipoLogradouroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoLogradouroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logradouro;
    }
}
