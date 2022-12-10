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
package com.mycompany.adotapet.credencial;

import com.mycompany.adotapet.repositorio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe CredencialDAO
 *
 * @author Breno Vambaster C. L
 */
/*
CREATE TABLE `credencial` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL,
  `senha` varchar(40) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB
 */
public class CredencialDAO extends DAO<Credencial> {

    public static final String TABLE = "credencial";

    @Override

    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (email, senha) values (?, MD5(?)) ";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE  " + TABLE + " SET  email=?, senha=MD5(?)  WHERE id=? ";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Credencial e) {

        try {
            pstmt.setString(1, e.getEmail());
            pstmt.setString(2, e.getSenha());

            if (e.getId() != null) {
                pstmt.setLong(3, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ? ";
    }

    @Override
    public String getFindAllStatment() {
        return "SELECT * FROM " + TABLE;
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "SELECT * FROM " + TABLE + " WHERE ativo=false";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "UPDATE  " + TABLE + " SET ativo=false WHERE id=?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE  " + TABLE + " SET ativo=true WHERE id=?";
    }

    @Override
    public Credencial extractObject(ResultSet resultSet) {
        Credencial cred = new Credencial();
        try {
            cred.setId(resultSet.getLong("id"));
            cred.setEmail(resultSet.getString("email"));
            cred.setSenha(resultSet.getString("senha"));
            cred.setAtivo(resultSet.getBoolean("ativo"));
        } catch (SQLException ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cred;
    }

}
