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
package com.mycompany.adotapet.pet;

import com.mycompany.adotapet.aplicacao.AplicacaoDAO;
import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.larTemporario.LarTemporarioDAO;
import com.mycompany.adotapet.raca.RacaDAO;
import com.mycompany.adotapet.repositorio.DAO;
import com.mycompany.adotapet.repositorio.DbConnection;
import com.mycompany.adotapet.tutor.TutorDAO;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>CREATE TABLE `pet` (
 * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
 * `nome` varchar(35) NOT NULL,
 * `idRaca` bigint(20) unsigned NOT NULL,
 * `idLartemporario` bigint(20) unsigned NOT NULL,
 * `nascimento` date DEFAULT NULL,
 * `peso` float DEFAULT NULL,
 * `macho` tinyint(1) NOT NULL,
 * `castrado` tinyint(1) DEFAULT 0,
 * `comentario` varchar(200) DEFAULT NULL,
 * `vivo` tinyint(1) DEFAULT 1,
 * `idTutor` bigint(20) unsigned DEFAULT NULL,
 * `excluido` tinyint(1) DEFAULT 0,
 * PRIMARY KEY (`id`),
 * UNIQUE KEY `id` (`id`),
 * KEY `idRaca` (`idRaca`),
 * KEY `idLartemporario` (`idLartemporario`),
 * KEY `idTutor` (`idTutor`),
 * CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`idRaca`) REFERENCES `raca` (`id`),
 * CONSTRAINT `pet_ibfk_2` FOREIGN KEY (`idLartemporario`) REFERENCES `lartemporario` (`id`),
 * CONSTRAINT `pet_ibfk_3` FOREIGN KEY (`idTutor`) REFERENCES `tutor` (`id`)
 * ) ENGINE=InnoDB</pre> Classe PetDAO
 *
 * @author Pedro Dias
 */
public class PetDAO extends DAO<Pet> {

    public static final String TABLE = "pet";

    @Override
    public String getSaveStatment() {
        return "INSERT INTO " + TABLE + "  (nome, idRaca, idLartemporario, nascimento, peso, macho, castrado, comentario, vivo) "
                + "VALUES(?,?,?,?,?,?,?,?,?);";
    }

    @Override
    public String getUpdateStatment() {
        return "UPDATE " + TABLE + "  SET nome = ? , idRaca = ?,  idLartemporario = ?, nascimento = ?, peso = ?"
                + ", macho = ?, castrado = ?, comentario = ?, vivo = ? WHERE id = ? ";
    }

    public String getAddTutorStatment() {
        return "UPDATE " + TABLE + "  SET idTutor WHERE id = ? ";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Pet e) {
        try {
            pstmt.setString(1, e.getNome());
            pstmt.setLong(2, e.getRaca().getId());
            pstmt.setLong(3, e.getLarTemporario().getId());
            pstmt.setObject(4, e.getNascimento(), java.sql.Types.DATE);
            pstmt.setFloat(5, e.getPeso());
            pstmt.setObject(6, e.isMacho(), java.sql.Types.BOOLEAN);
            pstmt.setObject(7, e.isCastrado(), java.sql.Types.BOOLEAN);
            pstmt.setString(8, e.getComentario());
            pstmt.setObject(9, e.isVivo(), java.sql.Types.BOOLEAN);

            if (e.getId() != null) {
                pstmt.setLong(9, e.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adicionarTutor(Pet e) {

        if (e.getTutor() != null && e.getId() != null) {

            // try-with-resources
            try ( PreparedStatement preparedStatement
                    = DbConnection.getConexao().prepareStatement(
                            getAddTutorStatment())) {

                preparedStatement.setObject(1, e.getTutor().getId(), java.sql.Types.BIGINT);
                preparedStatement.setLong(2, e.getId());

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }
        }
    }

    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM " + TABLE + " WHERE id = ? ";
    }

    public String getFindByTutorStatment() {
        return "SELECT * FROM " + TABLE + " WHERE idTutor = ? ";
    }

    public String getFindByLarTemporarioStatment() {
        return "SELECT * FROM " + TABLE + " WHERE idTutor = ? ";
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
        return "UPDATE  " + TABLE + " SET excluido = true WHERE id = ?";
    }

    @Override
    public String getRestoreFromTrashStatement() {
        return "UPDATE  " + TABLE + " SET excluido = false WHERE id=?";
    }

    @Override
    public Pet extractObject(ResultSet resultSet) {
        try {
            Pet pet = new Pet();
            pet.setId(resultSet.getLong("id"));
            pet.setRaca(new RacaDAO().findById(resultSet.getLong("idRaca")));
            pet.setNome(resultSet.getString("nome"));
            pet.setNascimento(resultSet.getDate("nascimento").toLocalDate());
            pet.setPeso(resultSet.getFloat("peso"));
            pet.setMacho(resultSet.getBoolean("macho"));
            pet.setCastrado(resultSet.getBoolean("castrado"));
            pet.setComentario(resultSet.getString("comentario"));
            pet.setVivo(resultSet.getBoolean("vivo"));
            pet.setMedicamentos(new AplicacaoDAO().findByPet(pet.getId()));
            pet.setLarTemporario(new LarTemporarioDAO().findByIdSemRelacionamento(resultSet.getLong("idLartemporario")));
            return pet;
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Pet> findAllByTutor(Long id) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByTutorStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObjects(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        List<Pet> pets = new ArrayList<>();
        return pets;
    }

    public List<Pet> findByPetAvaliable() {
        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        "SELECT * FROM " + TABLE + " WHERE idTutor is NULL")) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObjects(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        List<Pet> pets = new ArrayList<>();
        return pets;
    }

    public List<Pet> findAllByLarTemporario(Long id) {

        try ( PreparedStatement preparedStatement
                = DbConnection.getConexao().prepareStatement(
                        getFindByLarTemporarioStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObjects(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        List<Pet> pets = new ArrayList<>();
        return pets;
    }
}
