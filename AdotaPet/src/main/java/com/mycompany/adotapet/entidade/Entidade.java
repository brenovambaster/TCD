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

package com.mycompany.adotapet.entidade;

/**
 * Classe Entidade
 * @author pedro
 */
public abstract class Entidade {
    private Long id;
    private boolean excluido;
    
    //<editor-fold defaultstate="collapsed" desc="construtores">

    public Entidade() {
    }

    public Entidade(Long id, boolean excluido) {
        this.id = id;
        this.excluido = excluido;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return  "id=" + id 
                + ", excluido=" + excluido;
    }  
}
