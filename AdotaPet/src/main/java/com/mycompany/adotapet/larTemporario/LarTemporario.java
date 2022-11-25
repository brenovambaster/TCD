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

package com.mycompany.adotapet.larTemporario;

import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.voluntario.Voluntario;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe LarTemporario
 * @author Pedro Dias
 */
public class LarTemporario extends Entidade {
    private String nome;
    private Endereco endereco;
    private List<Pet> pets;
    private Voluntario fundador;
    private List<Voluntario> voluntarios;
    
    //<editor-fold defaultstate="collapsed" desc="constructor">

    public LarTemporario(Voluntario fundador) {
        voluntarios = new ArrayList<>();
        pets = new ArrayList<>();
        this.fundador = fundador;
    }

    public LarTemporario(String nome, Endereco endereco, Voluntario fundador) {
        this(fundador);
        this.nome = nome.length() > 45 ? nome.substring(0, 45) : nome;
        this.endereco = endereco;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null || nome.length() > 45){
            throw new Exception ("Nome não pode ter mais que 45 caracteres ou vazio!");
        }else{
            this.nome = nome;
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public Voluntario getFundador() {
        return fundador;
    }

    public void setFundador(Voluntario fundador) {
        this.fundador = fundador;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
    //</editor-fold>
    
    public void adicionarVoluntario(Voluntario voluntario){
        voluntarios.add(voluntario);
    }
    
    public Voluntario getVoluntario(int indice){
        return voluntarios.get(indice);
    }
    
    public void adicionarPet(Pet pet){
        pets.add(pet);
    }
    
    public Pet getPet(int indice){
        return pets.get(indice);
    }

    @Override
    public String toString() {
        return "LarTemporario{" 
                + "nome=" + nome 
                + ", endereco=" + endereco
                + ", fundador=" + fundador 
                + ", voluntarios=" + voluntarios 
                + ", Pets=" + pets
                + '}';
    }
    
    
    
}
