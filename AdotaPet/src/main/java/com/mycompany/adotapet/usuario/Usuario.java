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

package com.mycompany.adotapet.usuario;

import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.telefone.Telefone;

/**
 * Classe Usuario
 * @author Pedro Dias
 */
public class Usuario extends Entidade{
    private String nome;
    private Long cpf;
    private Telefone telefone;
    private Endereco endereco;
    
    //<editor-fold defaultstate="collapsed" desc="constructors">

    public Usuario() {
    }

    public Usuario(String nome, Long cpf, Telefone telefone, Endereco endereco) {
        this.nome = nome.length() > 35 ? nome.substring(0, 35) : nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        if (nome == null || nome.length() > 35){
            throw new Exception ("Nome não pode ter mais que 35 caracteres!");
        }else{
            this.nome = nome;
        }
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
