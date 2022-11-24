/*
 * Copyright (C) 2022 Breno Vambaster C. L
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
package com.mycompany.adotapet.tipoLogadouro;

import com.mycompany.adotapet.entidade.Entidade;

/**
 * Classe TipoLogadouro
 *
 * @author Breno Vambaster C. L
 */
public class TipoLogadouro extends Entidade {

    private String nome;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public TipoLogadouro() {
    }

    public TipoLogadouro(String nome) {
        this.nome = nome;
        setId(null);
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "TipoLogadouro{" + "nome=" + nome + ", ID:" + super.toString();
    }

}
