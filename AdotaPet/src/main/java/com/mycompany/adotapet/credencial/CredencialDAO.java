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
import com.mycompany.adotapet.repositorio.DbConnection;
import com.mycompany.adotapet.tutor.Tutor;
import com.mycompany.adotapet.tutor.TutorDAO;
import com.mycompany.adotapet.voluntario.VoluntarioDAO;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `credencial` (
 * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 * `email` varchar(45) NOT NULL,
 * `senha` varchar(32) NOT NULL,
 * `ativo` tinyint(1) NOT NULL DEFAULT 1,
 * `idTutor` bigint(20) unsigned DEFAULT NULL,
 * `idVoluntario` bigint(20) unsigned DEFAULT NULL,
 * PRIMARY KEY (`id`),
 * UNIQUE KEY `email` (`email`),
 * UNIQUE KEY `email_2` (`email`),
 * KEY `idTutor` (`idTutor`),
 * KEY `idVoluntario` (`idVoluntario`),
 * CONSTRAINT `credencial_ibfk_1` FOREIGN KEY (`idTutor`) REFERENCES `tutor` (`id`),
 * CONSTRAINT `credencial_ibfk_2` FOREIGN KEY (`idVoluntario`) REFERENCES `voluntario` (`id`)
 * ) ENGINE=InnoDB
 * </pre> Classe CredencialDAO
 *
 * @author Breno Vambaster C. L
 */
public class CredencialDAO extends DAO<Credencial> {

    public static final String TABLE = "credencial";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (email, senha) values (?, MD5(?)) ";
    }

    public String getSaveTutorStatment() {
        return "INSERT INTO " + TABLE + " (email, senha, idTutor) values (?, MD5(?), ?) ";
    }

    public String getSaveVoluntarioStatment() {
        return "INSERT INTO " + TABLE + " (email, senha, idVoluntario) values (?, MD5(?), ?) ";
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
    
    public void SaveTutorStatement(Credencial e, Tutor tutor) {

        try (PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByEmailSenhaStatment())){
            preparedStatement.setString(1, e.getEmail());
            preparedStatement.setString(2, e.getSenha());
            preparedStatement.setLong(3, tutor.getId());

        } catch (SQLException ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void composeUpdateStatement(PreparedStatement pstmt, Credencial e) {

        try {
            pstmt.setString(1, e.getEmail());
            pstmt.setString(2, e.getSenha());
            pstmt.setLong(3, e.getId());

        } catch (SQLException ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ? ";
    }

    public String getFindByEmailSenhaStatment() {
        return "SELECT * FROM " + TABLE + " WHERE email = ? AND senha = md5(?)";
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
        try {
            Credencial cred = new Credencial();
            Long idTutor, idVoluntario;
            cred.setId(resultSet.getLong("id"));
            cred.setEmail(resultSet.getString("email"));
            cred.setSenha(resultSet.getString("senha"));
            cred.setAtivo(resultSet.getBoolean("ativo"));
            idTutor = (Long)resultSet.getObject("idTutor");
            idVoluntario = (Long)resultSet.getObject("idVoluntario");
            // verifica se essa credencial é de tutor ou de voluntario
            if (idTutor == null) {
                if (idVoluntario != null) {
                    cred.setUsuario(new VoluntarioDAO().findById(idVoluntario));
                    //passa o enedereço da credencial 
                    cred.getUsuario().setCredencial(cred);
                }
            } else {
                cred.setUsuario(new TutorDAO().findById(idTutor));
                cred.getUsuario().setCredencial(cred);
            }
            return cred;
        } catch (SQLException ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Credencial autenticar(Credencial credencial) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByEmailSenhaStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setString(1, credencial.getEmail());
            preparedStatement.setString(2, credencial.getSenha());

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
