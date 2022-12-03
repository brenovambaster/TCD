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

import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.telefone.TelefoneDAO;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;

/**
 *
 * @author pedro
 */
public class TesteTutorDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //criando objeto do tipo Telefone para testes
        Telefone telefone = new Telefone((short)38, 991345687, false);
        //verificando se já está salvo no bd
        Telefone telefone2 = new TelefoneDAO().findByNumber(telefone.getNumero());
        //salva caso contrario
        if (telefone2 == null){
            Long idTelefone = new TelefoneDAO().saveOrUpdate(telefone);
            telefone.setId(idTelefone);
        }else{
            telefone = telefone2;
        }
        System.out.println("> " + telefone);
        
        //criando objeto do tipo TipoLogradouro para testes
        TipoLogradouro tipoLogradouro = new TipoLogradouro("Rua");
        //verificando se já está salvo no bd
        TipoLogradouro tipoLogradouro2 = new TipoLogradouroDAO().findByName(tipoLogradouro.getNome());
        //salva caso contrario
        if(tipoLogradouro2 == null){
            Long idTipoLogradouro = new TipoLogradouroDAO().saveOrUpdate(tipoLogradouro);
            tipoLogradouro.setId(idTipoLogradouro);
        }else{
            tipoLogradouro = tipoLogradouro2;
        }
        System.out.println("> " + tipoLogradouro);
        
        Endereco endereco = new Endereco(tipoLogradouro, "301", 356, "perto do lago", "Lagos", "Patos", "PB", 2346790);
        Long idEndereco = new EnderecoDAO().saveOrUpdate(endereco);
        endereco.setId(idEndereco);
       
        //criando objeto do tipo Tutor para testes
        Tutor tutor = new Tutor("José", 12345678901L, telefone, endereco);
        //verificando se já está salvo no bd
        Tutor tutor2 = new TutorDAO().findByCpf(tutor.getCpf());
        //salva caso contrario
        if(tutor2 == null){
            Long idTutor = new TutorDAO().saveOrUpdate(tutor);
            tutor.setId(idTutor);
        }else{
            tutor = tutor2;
        }
        System.out.println("> " + tutor);
    }  
}
