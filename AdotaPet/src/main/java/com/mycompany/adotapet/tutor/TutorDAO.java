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
package com.mycompany.adotapet.tutor;

import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.pet.PetDAO;
import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.repositorio.DbConnection;
import com.mycompany.adotapet.requerimentoAdocao.RequerimentoAdocaoDAO;
import com.mycompany.adotapet.telefone.TelefoneDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `tutor` (
 * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 * `nome` varchar(35) NOT NULL,
 * `cpf` bigint(20) unsigned NOT NULL,
 * `idTelefone` bigint(20) unsigned NOT NULL,
 * `idEndereco` bigint(20) unsigned NOT NULL,
 * `excluido` tinyint(1) DEFAULT 0,
 * PRIMARY KEY (`id`),
 * UNIQUE KEY `id` (`id`),
 * UNIQUE KEY `cpf` (`cpf`),
 * KEY `idTelefone` (`idTelefone`),
 * KEY `idEndereco` (`idEndereco`),
 * CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`idTelefone`) REFERENCES `telefone` (`id`),
 * CONSTRAINT `tutor_ibfk_2` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`id`)
 * ) ENGINE=InnoDB</pre> Classe TutorDAO
 *
 * @author Pedro Dias
 */
public class TutorDAO extends DAO<Tutor> {

    public static final String TABLE = "tutor";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + " (nome, cpf, idTelefone, idEndereco) VALUES (?,?,?,?)";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + " SET nome = ?, cpf = ?, idTelefone = ?, idEndereco = ? WHERE id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Tutor e) {
        try {
            //formata de acordo com o bd 
            pstmt.setString(1, e.getNome());
            pstmt.setLong(2, e.getCpf());
            pstmt.setObject(3, e.getTelefone().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(4, e.getEndereco().getId(), java.sql.Types.BIGINT);

            // Just for the update
            if (e.getId() != null) {
                pstmt.setLong(5, e.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ?";
    }

    public String getFindByCpfStatment() {
        return "SELECT * FROM " + TABLE + " WHERE cpf = ?";
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
        return "UPDATE " + TABLE + " SET excluido = true WHERE id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE " + TABLE + " SET excluido = false WHERE id = ?";
    }

    @Override
    public Tutor extractObject(ResultSet resultSet) {

        try {
            Tutor tutor = new Tutor();
            tutor.setId(resultSet.getLong("id"));
            tutor.setNome(resultSet.getString("nome"));
            tutor.setCpf(resultSet.getLong("cpf"));
            tutor.setTelefone(new TelefoneDAO().findById(resultSet.getLong("idTelefone")));
            tutor.setEndereco(new EnderecoDAO().findById(resultSet.getLong("idEndereco")));
            tutor.setPets(new PetDAO().findAllByTutor(tutor.getId()));
            for (Pet pet : tutor.getPets()) {
                pet.setTutor(tutor);
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
            tutor.setExcluido(resultSet.getBoolean("excluido"));
            return tutor;
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Tutor findByCpf(Long cpf) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByCpfStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, cpf);

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
    
    public Tutor findByIdComRequerimentoDeAdocao(Long id) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByIdStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObjectReq(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }
    
    public Tutor extractObjectReq(ResultSet resultSet) {

        try {
            Tutor tutor = new Tutor();
            tutor.setId(resultSet.getLong("id"));
            tutor.setNome(resultSet.getString("nome"));
            tutor.setCpf(resultSet.getLong("cpf"));
            tutor.setTelefone(new TelefoneDAO().findById(resultSet.getLong("idTelefone")));
            tutor.setEndereco(new EnderecoDAO().findById(resultSet.getLong("idEndereco")));
            tutor.setPets(new PetDAO().findAllByTutor(tutor.getId()));
            tutor.setRequerimentos(new RequerimentoAdocaoDAO().findAllByTutor(tutor));
            for (Pet pet : tutor.getPets()) {
                pet.setTutor(tutor);
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
            tutor.setExcluido(resultSet.getBoolean("excluido"));
            return tutor;
        } catch (SQLException ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
