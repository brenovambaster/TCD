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
package com.mycompany.adotapet.tipoLogradouro;

import java.util.List;

/**
 * Classe Teste
 *
 * @author Breno Vambaster C. L
 */
public class Teste {
    
    public static void main(String[] args) throws Exception {
        TipoLogradouro lg = new TipoLogradouro("Bairro");

        // salvando
        Long id = new TipoLogradouroDAO().saveOrUpdate(lg);
        lg.setId(id);
        System.out.println(lg);

        // update;
        lg.setNome("Cidade");
        new TipoLogradouroDAO().saveOrUpdate(lg);

        // selecionar tudo da base de dados;
        List<TipoLogradouro> logradouros = new TipoLogradouroDAO().findAll();
        System.out.println(logradouros);

        //marca como excluido
        new TipoLogradouroDAO().moveToTrash(id);

        // pesquisa por todos da lixeira
        logradouros = new TipoLogradouroDAO().findAllOnTrash();
        System.out.println("> Logradouros na lixeira: " + logradouros);

        //desmarca como excluido
        new TipoLogradouroDAO().restoreFromTrash(id);

        // pesquisa por todos da lixeira
        logradouros = new TipoLogradouroDAO().findAllOnTrash();
        System.out.println("> Logradouros na lixeira: " + logradouros);
    }
    
}
