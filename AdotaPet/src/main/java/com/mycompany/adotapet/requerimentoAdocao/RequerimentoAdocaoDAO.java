/*
 * Copyright (C) 2022 Pedro Henrique
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
package com.mycompany.adotapet.requerimentoAdocao;

import com.mycompany.adotapet.repositorio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pedro Henrique
 */

/*
<pre>CREATE TABLE `requerimentoadocao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  `id_lartemporario` int(11) NOT NULL,
  `id_tutor` int(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `aprovado` tinyint(1) DEFAULT '0',
  `inicio` datetime NOT NULL,
  `termino` datetime DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  CONSTRAINT PRIMARY KEY (`id`),
  CONSTRAINT FOREGEIN KEY (`idlartemporario`) REFERENCES lartemporario (id),
  CONSTRAINT FOREGEIN KEY (`idtutor`) REFERENCES tutor (id)
  ) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 </pre>
 */

public class RequerimentoAdocaoDAO extends DAO<RequerimentoAdocao>{

    public static final String TABLE = "requerimentoadocao";
    
    @Override
    public String getSaveStatment() {
        return " INSERT INTO " + TABLE + " (nome) values (?);"; 
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET nome=? WHERE id= ? ";    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, RequerimentoAdocao e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id=?";    }

    @Override
    public String getFindAllStatment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFindAllOnTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMoveToTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getRestoreFromTrashStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RequerimentoAdocao extractObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
