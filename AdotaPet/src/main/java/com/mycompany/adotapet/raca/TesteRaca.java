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
package com.mycompany.adotapet.raca;

import com.mycompany.adotapet.especie.Especie;
import com.mycompany.adotapet.especie.EspecieDAO;
import java.util.List;

/**
 * Classe TesteRaca
 *
 * @author Breno Vambaster C. L
 */
public class TesteRaca {

    public static void main(String[] args) throws Exception {
        // criando e  adicionando especiea ao bd
        Especie esp = new Especie("lobus");
        Long id_especie = new EspecieDAO().saveOrUpdate(esp);
        esp.setId(id_especie);

        // criando e adicionando raca ao bd
        Raca raca = new Raca("pitbull", esp);
        Long id_raca = new RacaDAO().saveOrUpdate(raca);
        raca.setId(id_raca);

        // Alterando o nome da raca;
        raca.setNome("Xuaua");
        new RacaDAO().saveOrUpdate(raca);

        // pega tudo do bd
        List<Raca> racas = new RacaDAO().findAll();
        System.out.println("> " + racas);

        //marca como excluido
        new RacaDAO().moveToTrash(id_raca);

        //pega tudo da lixeira
        racas = new RacaDAO().findAllOnTrash();
        System.out.println("> " + racas);

        //desmarca como excluido
        new RacaDAO().restoreFromTrash(id_raca);

        //pega tudo da lixeira
        racas = new RacaDAO().findAllOnTrash();
        System.out.println("> " + racas);

    }
}
