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
package com.mycompany.adotapet;

import com.mycompany.adotapet.especie.Especie;
import com.mycompany.adotapet.especie.EspecieDAO;
import com.mycompany.adotapet.raca.Raca;
import com.mycompany.adotapet.raca.RacaDAO;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;

/**
 * Classe CargaInicial
 *
 * @author Breno Vambaster C. L
 */
public class CargaInicial {

    public static void main(String[] args) throws Exception {
        // criando e  adicionando especiea ao bd
        Especie esp = new Especie("Cachorro");
        Long idEspecie = new EspecieDAO().saveOrUpdate(esp);
        esp.setId(idEspecie);

        Raca raca1 = new Raca("Fox Paulistinha", esp);
        Long idRaca1 = new RacaDAO().saveOrUpdate(raca1);
        raca1.setId(idRaca1);

        // criando e adicionando raca ao bd
        Raca raca = new Raca("Caramelo", esp);
        Long idRaca = new RacaDAO().saveOrUpdate(raca);
        raca.setId(idRaca);

        // criando e salvando tipo logradouro
        TipoLogradouro tpL1 = new TipoLogradouro("Recanto");
        TipoLogradouro tpL2 = new TipoLogradouro("Rua");

        // salvando
        Long id = new TipoLogradouroDAO().saveOrUpdate(tpL1);
        Long id2 = new TipoLogradouroDAO().saveOrUpdate(tpL2);
        tpL1.setId(id);
        tpL2.setId(id2);
        System.out.println(tpL1);

    }
}
