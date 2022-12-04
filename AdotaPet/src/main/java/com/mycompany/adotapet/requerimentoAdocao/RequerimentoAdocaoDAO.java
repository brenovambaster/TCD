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

import com.mycompany.adotapet.larTemporario.LarTemporarioDAO;
import com.mycompany.adotapet.pet.PetDAO;
import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.tutor.TutorDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Henrique
 */

/**
  CREATE TABLE `requerimentoadocao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lartemporario_id` int(11) NOT NULL,
  `lartemporario` varchar(35),
  `tutor_id` int(11) NOT NULL,
  `tutor` varchar(35),
  `pet_id` int(11) NOT NULL, 
  `pet` varchar(35),
  `ativo` tinyint(1) DEFAULT '1',
  `aprovado` tinyint(1) DEFAULT '0',
  `inicio` datetime NOT NULL,
  `termino` datetime DEFAULT NULL,
  `excluido` tinyint(1) DEFAULT '0',
  CONSTRAINT PRIMARY KEY (`id`),
  CONSTRAINT FOREGEIN KEY (`lartemporario_id`) REFERENCES lartemporario (id),
  CONSTRAINT FOREGEIN KEY (`tutor_id`) REFERENCES tutor (id),
  CONSTRAINT FOREIGN key (`pet_id`) references pet(id)
  ) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 
  */

public class RequerimentoAdocaoDAO extends DAO<RequerimentoAdocao>{

    public static final String TABLE = "requerimentoadocao";
    
    @Override
    public String getSaveStatment() {
        return " INSERT INTO " + TABLE 
                + "(lartemporario_id,lartemporario,tutor_id,tutor,pet_id,pet,inicio) values (?,?,?,?,?,?,?);";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE 
                + " ativo=?,SET aprovado=?,termino=? WHERE id= ? ";    
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, RequerimentoAdocao e) {
            try {
            pstmt.setLong(1, e.getLarTemporario().getId());
            pstmt.setString(2, e.getLarTemporario().getNome());
            pstmt.setLong(3, e.getTutor().getId());
            pstmt.setString(4, e.getTutor().getNome());
            pstmt.setLong(5, e.getPet().getId());
            pstmt.setString(6, e.getPet().getNome());
            pstmt.setObject(7, e.getAtivo(), java.sql.Types.BOOLEAN);
            pstmt.setObject(8, e.getAprovado(), java.sql.Types.BOOLEAN);
            pstmt.setObject(9, e.getInicio(), java.sql.Types.DATE);
            pstmt.setObject(10, e.getTermino(), java.sql.Types.DATE);
            
            if (e.getId() != null) {
                pstmt.setLong(11, e.getId());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RequerimentoAdocaoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return "select * FROM" + TABLE + " where excluido = true";
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
    public RequerimentoAdocao extractObject(ResultSet resultSet) {
        RequerimentoAdocao reqAd = null;
        
        
        reqAd= new RequerimentoAdocao();
        try {
            reqAd.setId(resultSet.getLong("id"));
            reqAd.setLarTemporario(new LarTemporarioDAO().findById(resultSet.getLong("lartemporario_id")));
            reqAd.setTutor(new TutorDAO().findById(resultSet.getLong("tutor_id")));
            reqAd.setPet(new PetDAO().findById(resultSet.getLong("pet_id")));
            reqAd.setAtivo(resultSet.getBoolean("ativo"));
            reqAd.setInicio(resultSet.getDate("inicio").toLocalDate());

        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return reqAd;
    }
   
}
