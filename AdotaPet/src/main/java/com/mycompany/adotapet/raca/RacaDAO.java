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
package com.mycompany.adotapet.raca;

import com.mycompany.adotapet.especie.Especie;
import com.mycompany.adotapet.repositorio.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe RacaDAO
 *
 * @author Breno Vambaster C. L
 */
/*
CREATE TABLE `raca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  `especie_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `especie_id` (`especie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1
 */
public class RacaDAO extends Dao<Raca> {

    public static final String TABLE = "raca";

    @Override
    public String getSaveStatment() {
        return " INSERT INTO " + TABLE + " (nome, especie_id) values (?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET nome=? WHERE id= ? ";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Raca raca) {
        try {
            //formata de acordo com o bd 
            pstmt.setString(1, raca.getNome());
            pstmt.setLong(2, raca.getEspecie().getId());

            // Just for the update
            if (raca.getId() != null) {
                pstmt.setLong(3, raca.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(RacaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id=?";
    }

    @Override
    public String getFindAllStatment() {
        return "SELECT * FROM " + TABLE;
    }

    @Override
    public String getFindAllOnTrashStatement() {
        return "SELECT * FROM " + TABLE + " WHERE excluido=true";
    }

    @Override
    public String getMoveToTrashStatement() {
        return "UPDATE  " + TABLE + " SET excluido=true WHERE id=?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE  " + TABLE + " SET excluido=false WHERE id=?";
    }

    @Override
    public Raca extractObject(ResultSet resultSet) {
        Raca raca = null;

        try {
            raca = new Raca();
            raca.setId(resultSet.getLong("id"));
            raca.setExcluido(resultSet.getBoolean("excluido"));
            raca.setNome(resultSet.getString("nome"));
        } catch (SQLException ex) {
            Logger.getLogger(RacaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RacaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return raca;
    }

}
