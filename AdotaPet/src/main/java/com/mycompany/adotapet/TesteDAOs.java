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
package com.mycompany.adotapet;

import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.especie.Especie;
import com.mycompany.adotapet.especie.EspecieDAO;
import com.mycompany.adotapet.larTemporario.LarTemporario;
import com.mycompany.adotapet.larTemporario.LarTemporarioDAO;
import com.mycompany.adotapet.medicamento.Medicamento;
import com.mycompany.adotapet.medicamento.MedicamentoDAO;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.pet.PetDAO;
import com.mycompany.adotapet.raca.Raca;
import com.mycompany.adotapet.raca.RacaDAO;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.telefone.TelefoneDAO;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;
import com.mycompany.adotapet.voluntario.Voluntario;
import com.mycompany.adotapet.voluntario.VoluntarioDAO;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author pedro
 */
public class TesteDAOs {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
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
        
        //criando objeto do tipo Voluntario para testes
        Voluntario voluntario = new Voluntario(null, "Paulo", 12349678901L, telefone, endereco);
        //verificando se já está salvo no bd
        Voluntario voluntario2 = new VoluntarioDAO().findByCpf(voluntario.getCpf());
        //salva caso contrario
        if(voluntario2 == null){
            Long idVoluntario = new VoluntarioDAO().saveOrUpdate(voluntario);
            voluntario.setId(idVoluntario);
        }else{
            voluntario = voluntario2;
        }
        System.out.println("> " + voluntario);
        
        //criando objeto do tipo Medicamento para testes
        Medicamento medicamento = new Medicamento("NOBIVAC® RAIVA");
        //verificando se já está salvo no bd
        Medicamento medicamento2 = new MedicamentoDAO().findByName(medicamento.getNome());
        //salva caso contrario
        if (medicamento2 == null){
            Long idMedicamento = new MedicamentoDAO().saveOrUpdate(medicamento);
            medicamento.setId(idMedicamento);
        }else{
            medicamento = medicamento2;
        }
        System.out.println("> " + medicamento);

        //criando objeto do tipo LarTemporario para testes
        LarTemporario larTemporario = new LarTemporario("PETs", endereco);
        //verificando se já está salvo no bd
        LarTemporario larTemporario2 = new LarTemporarioDAO().findByName(larTemporario.getNome());
        //salva caso contrario
        if (larTemporario2 == null){
            Long idLarTemporario = new LarTemporarioDAO().saveOrUpdate(larTemporario);
            larTemporario.setId(idLarTemporario);
        }else{
            larTemporario = larTemporario2;
        }
        System.out.println("> " + larTemporario);
        System.out.println("> " + voluntario);
        
        //criando objeto do tipo Voluntario para testes
        Voluntario voluntario3 = new Voluntario(null, "João", 12349677601L, telefone, endereco);
        //verificando se já está salvo no bd
        Voluntario voluntario4 = new VoluntarioDAO().findByCpf(voluntario3.getCpf());
        //salva caso contrario
        if(voluntario4 == null){
            Long idVoluntario = new VoluntarioDAO().saveOrUpdate(voluntario3);
            voluntario3.setId(idVoluntario);
        }else{
            voluntario3 = voluntario4;
        }
        voluntario3.setLarTemporario(larTemporario);
        new VoluntarioDAO().adicionarLarTemporario(voluntario3);
        System.out.println("> " + voluntario3);

        //criando objeto do tipo Especie para testes
        Especie especie = new Especie("Cachorro");
        //verificando se já está salvo no bd
        Especie especie2 = new EspecieDAO().findByName(especie.getNome());
        //salva caso contrario
        if (especie2 == null){
            Long idEspecie = new EspecieDAO().saveOrUpdate(especie);
            especie.setId(idEspecie);
        }else{
            especie = especie2;
        }
        System.out.println("> " + especie);
        
        //criando objeto do tipo Raca para testes
        Raca raca = new Raca("Fox Paulistinha", especie);
        //verificando se já está salvo no bd
        Raca raca2 = new RacaDAO().findByName(raca.getNome());
        //salva caso contrario
        if (raca2 == null){
            Long idRaca = new RacaDAO().saveOrUpdate(raca);
            raca.setId(idRaca);
        }else{
            raca = raca2;
        }
        System.out.println("> " + raca);
        
        Pet pet = new Pet("Pitoco", raca, larTemporario, LocalDate.of(2020, Month.OCTOBER, 22), 10.0F, true, false, "Muito estressado");
        Long idPet= new PetDAO().saveOrUpdate(pet);
        pet.setId(idPet);
        System.out.println("> " + pet);
        
    } 
}
