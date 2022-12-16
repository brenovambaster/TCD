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

import com.mycompany.adotapet.credencial.Credencial;
import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.tutor.TutorDAO;
import com.mycompany.adotapet.voluntario.VoluntarioDAO;

/**
 * Classe Usuario
 * @author Pedro Dias
 */
public abstract class Usuario extends Entidade{
    private String nome;
    private Long cpf;
    private Telefone telefone;
    private Endereco endereco;
    private Credencial credencial;
    
    //<editor-fold defaultstate="collapsed" desc="constructors">

    public Usuario() {
    }

    public Usuario(String nome, Long cpf, Telefone telefone, Endereco endereco) throws Exception {
        setNome(nome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) throws Exception{
    if (nome == null || nome.trim().length() > 35 || nome.trim().length() == 0){
            throw new IllegalArgumentException ("Nome não pode ter mais que 35 caracteres ou vazio!");
        }else{
            this.nome = nome.trim();
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

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
    
    //</editor-fold>
    
    public static void validarUsuario(Usuario usuario) throws Exception {
        Usuario usuario2 = new TutorDAO().findByCpf(usuario.getCpf());
        Usuario usuario3 = new VoluntarioDAO().findByCpf(usuario.getCpf());
        if (usuario2 != null || usuario3 != null) {
            throw new Exception("Usuario ja cadastrado!");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" 
                + "nome=" + nome 
                + ", cpf=" + cpf 
                + ", telefone=" + telefone 
                + ", endereco=" + endereco 
                + ", " + super.toString()
                + '}';
    }  
}
