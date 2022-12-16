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
package com.mycompany.adotapet.credencial;

import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.usuario.Usuario;

/**
 * Classe Credencial
 *
 * @author Breno Vambaster C. L
 */
public class Credencial extends Entidade {

    private String email;
    private String senha;
    private boolean ativo;
    private Usuario usuario;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Credencial() {
    }

    public Credencial(String email, String senha, boolean ativo) {
        this.email = email.length() > 45 ? email.substring(0, 45) : email;
        this.senha = senha;
        this.ativo = ativo;

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    public String getEmail() {
        return email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || email.trim().length() > 45 || email.trim().length() == 0) {
            throw new IllegalArgumentException("Email não pode ter mais que 35 caracteres ou vazio!");
        } else {
            this.email = email.trim();
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().length() == 0) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        } else {
            this.senha = senha.trim();
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    //</editor-fold>
    public static void validarCredencial(Credencial credencial) throws Exception {
        Credencial credencial2 = new CredencialDAO().findByEmail(credencial);
        if (credencial2 != null) {
            throw new Exception("Email ja cadastrado!");
        }
    }

    @Override
    public String toString() {
        return "Credencial{"
                + "email=" + email
                + ", senha=" + senha
                + ", ativo=" + ativo
                + ", " + super.toString()
                + '}';
    }

}
