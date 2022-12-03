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
package com.mycompany.adotapet.endereco;

import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe EnderecoDAO
 *
 * @author Breno Vambaster C. L
 */
/*
  CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoLogradouro_id` int(11) NOT NULL,
  `logradouro` varchar(35) NOT NULL,
  `numero` int(7) NOT NULL,
  `complemento` varchar(35) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `cep` int(11) NOT NULL,
  `excluido` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `tipoLogradouro_id` (`tipoLogradouro_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1
 */
public class EnderecoDAO extends DAO<Endereco> {
    
    public static final String TABLE = "endereco";
    
    @Override
    public String getSaveStatment() {
        return "INSERT INTO  " + TABLE + "  (tipoLogradouro_id, logradouro, numero, complemento,"
                + " bairro, cidade, estado, cep ) VALUES(?,?,?,?,?,?,?,?)";
    }
    
    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + "  SET tipoLogradouro_id =? , logradouro=?,  numero=?, complemento=?,"
                + " bairro=?, cidade=?, estado=?, cep=? WHERE id=? ";
    }
    
    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Endereco e) {
        try {
            pstmt.setLong(1, e.getTipoLogradouro().getId());
            pstmt.setString(2, e.getLogadouro());
            pstmt.setInt(3, e.getNumero());
            pstmt.setString(4, e.getComplemento());
            pstmt.setString(5, e.getBairro());
            pstmt.setString(6, e.getCidade());
            pstmt.setString(7, e.getEstado());
            pstmt.setInt(8, e.getCep());
            
            if (e.getId() != null) {
                pstmt.setLong(9, e.getId());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public Endereco extractObject(ResultSet resultSet) {
        Endereco end = null;
        
        end = new Endereco();
        try {
            end.setId(resultSet.getLong("id"));
            end.setTipoLogradouro(new TipoLogradouroDAO().findById(resultSet.getLong("tipologradouro_id")));
            end.setLogadouro(resultSet.getString("logradouro"));
            end.setNumero(resultSet.getInt("numero"));
            end.setComplemento(resultSet.getString("complemento"));
            end.setBairro(resultSet.getString("bairro"));
            end.setCidade(resultSet.getString("cidade"));
            end.setEstado(resultSet.getString("estado"));
            end.setCep(resultSet.getInt("cep"));
            end.setExcluido(resultSet.getBoolean("excluido"));
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return end;
    }
    
}