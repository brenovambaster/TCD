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
 * <pre>CREATE TABLE `requerimento` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aprovado` tinyint(1) DEFAULT 0,
  `inicio` date DEFAULT NULL,
  `termino` date DEFAULT NULL,
  `idPet` bigint(20) unsigned NOT NULL,
  `idTutor` bigint(20) unsigned NOT NULL,
  `idLartemporario` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `idPet` (`idPet`),
  KEY `idTutor` (`idTutor`),
  KEY `idLartemporario` (`idLartemporario`),
  CONSTRAINT `requerimento_ibfk_1` FOREIGN KEY (`idPet`) REFERENCES `pet` (`id`),
  CONSTRAINT `requerimento_ibfk_2` FOREIGN KEY (`idTutor`) REFERENCES `tutor` (`id`),
  CONSTRAINT `requerimento_ibfk_3` FOREIGN KEY (`idLartemporario`) REFERENCES `lartemporario` (`id`)
) ENGINE=InnoDB</pre>
 *
 * @author Pedro Henrique
 */

public class RequerimentoAdocaoDAO extends DAO<RequerimentoAdocao>{

    public static final String TABLE = "requerimentoadocao";
    
    @Override
    public String getSaveStatment() {
        return " INSERT INTO " + TABLE 
                + "(idLartemporario,idTutor,idPet,pet,inicio) values (?,?,?,?,?);";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE 
                + " SET aprovado=?,termino=? WHERE id= ? ";    
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
        
        RequerimentoAdocao reqAd = new RequerimentoAdocao();
        try {
            reqAd.setId(resultSet.getLong("id"));
//            reqAd.setLarTemporario(new LarTemporarioDAO().findById(resultSet.getLong("idLartemporario")));
//            reqAd.setTutor(new TutorDAO().findById(resultSet.getLong("idTutor")));
//            reqAd.setPet(new PetDAO().findById(resultSet.getLong("idPet")));
            reqAd.setInicio(resultSet.getDate("inicio").toLocalDate());

        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return reqAd;
    }
   
}
