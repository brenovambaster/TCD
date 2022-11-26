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

import com.mycompany.adotapet.especie.EspecieDao;
import com.mycompany.adotapet.repositorio.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe TipoLogradouroDAO
 *
 * @author Breno Vambaster C. L
 */
public class TipoLogradouroDAO extends Dao<TipoLogradouro> {

    public static final String TABLE = "TipoLogradouro";


    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (nome)    values(?)";
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
            // OR
            // pstmt.setObject(1, e.getDescription(), java.sql.Types.VARCHAR);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(2, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(EspecieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "select * from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "SELECT * FROM " + TABLE;
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "select * from " + TABLE + " where excluido = true";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "update " + TABLE + " set excluido = true where id=?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "update " + TABLE + " set excluido = false where id = ?";
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
            Logger.getLogger(EspecieDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EspecieDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return logradouro;

    }

}
