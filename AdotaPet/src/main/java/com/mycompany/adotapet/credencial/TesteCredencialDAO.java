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

import java.util.List;

/**
 * Classe TesteCredencialDAO
 *
 * @author Breno Vambaster C. L
 */
public class TesteCredencialDAO {

    public static void main(String[] args) throws Exception {

        //<editor-fold defaultstate="collapsed" desc="Criando credencial">
        Credencial cred = new Credencial("breno@gmail", "1234", true);
        Long id_cred = new CredencialDAO().saveOrUpdate(cred);
        cred.setId(id_cred);
        //</editor-fold>

        // alterando  cred e salvando
        cred.setEmail("brenovambaster@gmail.com");
        new CredencialDAO().saveOrUpdate(cred);

        // pesquisar por ID e por todos
        System.out.println("> Pesquisar por id: " + new CredencialDAO().findById(id_cred));
        List<Credencial> credenciais = new CredencialDAO().findAll();
        System.out.println("> Credendiais: " + credenciais);

        //  listar lixeira
        credenciais = new CredencialDAO().findAllOnTrash();
        System.out.println("> Lixeira: " + credenciais);

        // mover para lixeira e listar lixeira;
        new CredencialDAO().moveToTrash(id_cred);
        System.out.println("> Movido para Lixeira " + new CredencialDAO().findById(id_cred));

        // restaurar da lixeira
        new CredencialDAO().restoreFromTrash(id_cred);
        System.out.println("> Restaurado da Lixeira " + new CredencialDAO().findById(id_cred));

    }

}
