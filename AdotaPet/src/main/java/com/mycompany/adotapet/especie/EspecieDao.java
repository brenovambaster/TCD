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

package com.mycompany.adotapet.especie;

import com.mycompany.adotapet.repositorio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre> CREATE TABLE `especie` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `excluido` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4</pre>
 * Classe EspecieDao
 * @author Pedro Dias
 */
public class EspecieDao extends  DAO<Especie>{
    public static final String TABLE = "especie";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(nome) values(?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set nome = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Especie e) { 
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
        return "select * from " + TABLE;
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "select * from " + TABLE + " where excluido = true";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "update " + TABLE + " set excluido = true where id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "update " + TABLE + " set excluido = false where id = ?";
    }

    @Override
    public Especie extractObject(ResultSet resultSet) {

        Especie especie = null;

        try {
            especie = new Especie();
            especie.setId(resultSet.getLong("id"));
            especie.setNome(resultSet.getString("nome"));
            especie.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EspecieDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return especie;
    }
}
