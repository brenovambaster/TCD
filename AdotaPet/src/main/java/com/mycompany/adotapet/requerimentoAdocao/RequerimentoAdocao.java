/*
 * Copyright (C) 2022 Pedro Henrique
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
package com.mycompany.adotapet.requerimentoAdocao;

import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.larTemporario.LarTemporario;
import com.mycompany.adotapet.pet.Pet;
import com.mycompany.adotapet.tutor.Tutor;
import java.time.LocalDate;

/**
 *
 * @author Pedro Henrique
 */
public class RequerimentoAdocao extends Entidade{
    private Boolean ativo;
    private Boolean aprovado;
    private LocalDate inicio;
    private LocalDate termino;
    private Pet pet;
    private Tutor   tutor;
    private LarTemporario larTemporario;
    
    public RequerimentoAdocao(LocalDate inicio, Pet pet,Tutor tutor, LarTemporario larTemporario) {
        this.ativo = true;
        this.inicio = inicio;
        this.pet = pet;
        this.tutor = tutor;
        this.larTemporario = larTemporario;
    }

    public RequerimentoAdocao() {
        
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
    public Boolean getAtivo() {
        return ativo;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public Pet getPet() {
        return pet;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public LarTemporario getLarTemporario() {
        return larTemporario;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setLarTemporario(LarTemporario larTemporario) {
        this.larTemporario = larTemporario;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "requerimentoAdocao{" 
                + "ativo=" + ativo 
                + ", aprovado=" + aprovado 
                + ", inicio=" + inicio 
                + ", termino=" + termino 
                + ", pet=" + pet
                + ", tutor=" + tutor 
                + ", larTemporario=" + larTemporario
                +'}';
    }    
}
