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

package com.mycompany.adotapet.aplicacao;

import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.medicamento.Medicamento;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.voluntario.Voluntario;
import java.time.LocalDate;

/**
 * Classe Aplicacao
 * @author Pedro Dias
 */
public class Aplicacao extends Entidade{
    private Medicamento medicamento;
    private Voluntario responsavelAplicacao;
    private Pet pet;
    private LocalDate data; 
    private String anotacao;
    private Float qtdDose;
    
    //<editor-fold defaultstate="collapsed" desc="constructors">

    public Aplicacao() {
    }

    public Aplicacao(Medicamento medicamento, Voluntario responsavelAplicacao, Pet pet, LocalDate data, String anotacao, Float qtdDose) {
        this.medicamento = medicamento;
        this.responsavelAplicacao = responsavelAplicacao;
        this.pet = pet;
        this.data = data;
        this.anotacao = anotacao.trim().length() > 200 ? anotacao.trim().substring(0, 200) : anotacao.trim();
        this.qtdDose = qtdDose;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) throws Exception {
        if(anotacao.trim().length() > 200){
            throw new Exception ("Anotação não pode ter mais que 200 caracateres!");
        }else{
            this.anotacao = anotacao.trim();
        }
    }

    public Float getQtdDose() {
        return qtdDose;
    }

    public void setQtdDose(Float qtdDose) {
        this.qtdDose = qtdDose;
    }

    public Voluntario getResponsavelAplicacao() {
        return responsavelAplicacao;
    }

    public void setResponsavelAplicacao(Voluntario responsavelAplicacao) {
        this.responsavelAplicacao = responsavelAplicacao;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Aplicacao{" 
                + "medicamento=" + medicamento 
                + ", responsavelAplicacao=" + responsavelAplicacao 
                + ", pet=" + pet 
                + ", data=" + data 
                + ", anotacao=" + anotacao 
                + ", qtdDose=" + qtdDose 
                + ", " + super.toString()
                + '}';
    }
}
