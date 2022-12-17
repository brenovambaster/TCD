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
import java.util.List;

/**
 * Classe LarTemporario
 *
 * @author Pedro Dias
 */
public class LarTemporario extends Entidade {

    private String nome;
    private Endereco endereco;
    private List<Voluntario> voluntario;
    private List<Pet> pets;

    //<editor-fold defaultstate="collapsed" desc="constructor">
    public LarTemporario() {
    }

    public LarTemporario(String nome, Endereco endereco) throws Exception {
        setNome(nome);
        this.endereco = endereco;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) throws Exception {
        if (nome == null || nome.trim().length() > 45 || nome.trim().length() == 0) {
            throw new IllegalArgumentException("Nome não pode ter mais que 45 caracteres ou vazio!");
        } else {
            this.nome = nome.trim();
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    //</editor-fold>
    public void adicionarVoluntario(Voluntario voluntario) {
        voluntario.setLarTemporario(this);
    }

    public void adicionarPet(Pet pet) {
        pet.setLarTemporario(this);
    }

    @Override
    public String toString() {
        return "LarTemporario{"
                + "nome=" + nome
                + ", endereco=" + endereco
                + '}';
    }

}
