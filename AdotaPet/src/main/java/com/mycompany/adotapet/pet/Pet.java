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

import com.mycompany.adotapet.aplicacao.Aplicacao;
import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.larTemporario.LarTemporario;
import com.mycompany.adotapet.raca.Raca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Pet
 * @author Pedro Dias
 */
public class Pet extends Entidade{
    private String nome;
    private boolean adotado;
    private Raca raca;
    private LarTemporario larTemporario;
    private LocalDate nascimento;
    private Byte peso;
    private Boolean macho;
    private boolean castrado;
    private String comentario;
    private boolean vivo;
    private List<Aplicacao> medicamentos;
    
    //<editor-fold defaultstate="collapsed" desc="constructors">

    public Pet() {
        medicamentos = new ArrayList<>();
    }

    public Pet(String nome, Raca raca, LarTemporario larTemporario, LocalDate nascimento, Byte peso, Boolean macho, boolean castrado, String comentario) {
        this();
        this.nome = nome.length() > 35 ? nome.substring(0, 35) : nome;
        this.raca = raca;
        this.larTemporario = larTemporario;
        this.nascimento = nascimento;
        this.peso = peso;
        this.macho = macho;
        this.castrado = castrado;
        this.comentario = comentario.length() > 200 ? comentario.substring(0, 200) : comentario;
    }
        
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
    if (nome == null || nome.length() > 35){
            throw new Exception ("Nome não pode ter mais que 35 caracteres ou vazio!");
        }else{
            this.nome = nome;
        }
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public LarTemporario getLarTemporario() {
        return larTemporario;
    }

    public void setLarTemporario(LarTemporario larTemporario) {
        this.larTemporario = larTemporario;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public Byte getIdade(){
        return (byte) nascimento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public Byte getPeso() {
        return peso;
    }

    public void setPeso(Byte peso) {
        this.peso = peso;
    }

    public Boolean getMacho() {
        return macho;
    }

    public void setMacho(Boolean macho) {
        this.macho = macho;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) throws Exception {
        if(comentario.length() > 200){
            throw new Exception ("Comentario não pode ter mais que 200 caracateres!");
        }else{
            this.comentario = comentario;
        }
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public List<Aplicacao> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Aplicacao> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    //</editor-fold>
    
    public void adicionarMedicamento(Aplicacao aplicacao){
        medicamentos.add(aplicacao);
    }
    
    public Aplicacao getMedicamento(int indice){
        return medicamentos.get(indice);
    }

    @Override
    public String toString() {
        return "Pet{" 
                + "nome=" + nome 
                + ", adotado=" + adotado 
                + ", raca=" + raca 
                + ", idade=" + getIdade()
                + ", larTemporario=" + larTemporario 
                + ", nascimento=" + nascimento 
                + ", peso=" + peso 
                + ", macho=" + macho 
                + ", castrado=" + castrado 
                + ", comentario=" + comentario 
                + ", vivo=" + vivo 
                + ", medicamentos=" + medicamentos 
                + ", " + super.toString()
                + '}';
    }
    
    
}
