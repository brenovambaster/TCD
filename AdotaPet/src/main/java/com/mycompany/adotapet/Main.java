/*
 * Copyright (C) 2022 pedro
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

import com.mycompany.adotapet.aplicacao.Aplicacao;
import com.mycompany.adotapet.credencial.Credencial;
import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.especie.Especie;
import com.mycompany.adotapet.larTemporario.LarTemporario;
import com.mycompany.adotapet.medicamento.Medicamento;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.raca.Raca;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tutor.Tutor;
import com.mycompany.adotapet.voluntario.Voluntario;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author pedro e Breno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        Telefone fone = new Telefone((short) 33, 999301145, "comercial");
        System.out.println(fone);

        TipoLogradouro logradouro = new TipoLogradouro("Rua");
        System.out.println(logradouro);
        
        String stringEstado = "MG";
        Character estado[] = new Character[2];
        estado[0] = stringEstado.charAt(0);
        estado[1] = stringEstado.charAt(1);
        Endereco endereco = new Endereco(logradouro, "2", 678, "casa", "Monte", "Montes Claros", estado , 4567);
        System.out.println("> " + endereco);
        
        Especie especie = new Especie();
        especie.setNome("Cachorro");     
        Raca raca = new Raca();
        raca.setNome("Dachshund");
        raca.setEspecie(especie);
        System.out.println("> " + raca);
        
        Medicamento medicamento = new Medicamento("Vacina para raiva");
        Aplicacao aplicacao = new Aplicacao(medicamento, LocalDate.now(), "Necessita de outra dose", 1F);
        System.out.println("> " + aplicacao);
        
        Pet pet = new Pet("Maik", raca, null, LocalDate.of(2020, Month.AUGUST, 28), (byte)10, true, false, "Muito agitado");
        pet.setAdotado(true);
        System.out.println("> " + pet);
        
        Voluntario voluntario = new Voluntario(null, "Breno", 123456789010L, fone, endereco);
        System.out.println("> "+ voluntario);
        
        LarTemporario larTemporario = new LarTemporario("AdotaPet", endereco, voluntario);
        larTemporario.adicionarPet(pet);
        System.out.println("> " + larTemporario);
        
        Tutor tutor = new Tutor("Pedro", 123456789010L, fone, endereco);
        tutor.adicionarPet(pet);
        System.out.println("> " + tutor);
        
        Credencial cred = new Credencial("brenovambaster@gmail.com", "teste", true, voluntario);
        System.out.println(cred);
   
                
    }

}
