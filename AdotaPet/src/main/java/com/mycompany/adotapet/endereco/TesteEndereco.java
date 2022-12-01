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
package com.mycompany.adotapet.endereco;

import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;
import java.util.List;

/**
 * Classe TesteEndereco
 *
 * @author Breno Vambaster C. L
 */
public class TesteEndereco {

    public static void main(String[] args) {

        // criando e inserindo endereco 
        TipoLogradouro logr = new TipoLogradouro("Casa principal");
        Long id_logr = new TipoLogradouroDAO().saveOrUpdate(logr);
        logr.setId(id_logr);

        Endereco end1 = new Endereco(logr, "Rua Juca Prates", 12, "Atrás do Automóvel Club", "Centro",
                "Montes Claros", "MG", 39400078);
        Long id_endr = new EnderecoDAO().saveOrUpdate(end1);
        end1.setId(id_endr);

        //update ----------------------------------------------------------------------------------------------------------------------------
        end1.setLogadouro("Rua Espim Gurda ");
        new EnderecoDAO().saveOrUpdate(end1);

        // findByID--------------------------------------------------------------------------------------------------------------------------
        System.out.println("Atualizado: FIND BY ID> " + new EnderecoDAO().findById(id_endr));

        //findALL-----------------------------------------------------------------------------------------------------------------------------
        List<Endereco> enderecos = new EnderecoDAO().findAll();
        System.out.println("Enderecos >> " + enderecos);

        // MOVE TO TRASH
        new EnderecoDAO().moveToTrash(id_endr);

        //FIND ALL ON TRASH
        enderecos = new EnderecoDAO().findAllOnTrash();
        System.out.println("TRASH >> " + enderecos);

        // Restore from trash
        new EnderecoDAO().restoreFromTrash(id_endr);
        System.out.println("Restore from trash" + new EnderecoDAO().findById(id_endr));
    }
}
