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

package com.mycompany.adotapet.voluntario;

import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.larTemporario.LarTemporario;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.usuario.Usuario;

/**
 * Classe Voluntario
 * @author Pedro Dias
 */
public class Voluntario extends Usuario{
    private LarTemporario larTemporario;

    //<editor-fold defaultstate="collapsed" desc="constructors">
    
    public Voluntario() {
    }

    public Voluntario(LarTemporario larTemporario, String nome, Long cpf, Telefone telefone, Endereco endereco) {
        super(nome, cpf, telefone, endereco);
        this.larTemporario = larTemporario;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public LarTemporario getLarTemporario() {
        return larTemporario;
    }

    public void setLarTemporario(LarTemporario larTemporario) {
        this.larTemporario = larTemporario;
    }
        
    //</editor-fold>

    @Override
    public String toString() {
        return "Voluntario{" 
                + super.toString()
                + '}';
    }
}
