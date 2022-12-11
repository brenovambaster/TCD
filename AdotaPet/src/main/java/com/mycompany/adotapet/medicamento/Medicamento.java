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

package com.mycompany.adotapet.medicamento;

import com.mycompany.adotapet.entidade.Entidade;

/**
 * Classe Medicamento
 * @author Pedro Dias
 */
public class Medicamento extends Entidade{
    private String nome;
    
    //<editor-fold defaultstate="collapsed" desc="constructors">

    public Medicamento() {
    }

    public Medicamento(String nome) throws Exception {
        setNome(nome);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) throws Exception {
        if (nome == null||nome.trim().length() > 35 || nome.trim().length() == 0){
            throw new IllegalArgumentException ("Nome não pode ter mais que 35 caracteres ou vazio!");
        }else{
            this.nome = nome.trim();
        }
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Medicamento{" 
                + "nome=" + nome 
                + ", " + super.toString()
                + '}';
    } 
}
