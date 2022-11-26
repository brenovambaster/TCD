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
package com.mycompany.adotapet.medicamento;

import java.util.List;

/**
 * Classe TesteMedicamento medicamento | CREATE TABLE `medicamento` ( `id`
 * int(11) NOT NULL AUTO_INCREMENT, `nome` varchar(35) NOT NULL, `excluido`
 * tinyint(1) DEFAULT '0', PRIMARY KEY (`id`) ) ENGINE=MyISAM AUTO_INCREMENT=12
 * DEFAULT CHARSET=latin1
 *
 * @author Breno Vambaster C. L
 */
public class TesteMedicamento {

    public static void main(String[] args) {
        Medicamento med = new Medicamento("Nimesulida");

        //salvando
        Long id = new MedicamentoDAO().saveOrUpdate(med);
        med.setId(id);
        System.out.println(med);

        // atualizando
        med.setNome("Dipirone");
        new MedicamentoDAO().saveOrUpdate(med);
        System.out.println("> Atualizado:   " + med);

        // selecionar tudo bd
        List<Medicamento> medicamentos = new MedicamentoDAO().findAll();
        System.out.println("> Todos os registros:  " + medicamentos);

        //marca como excluido
        new MedicamentoDAO().moveToTrash(id);

        // pesquisa por todos da lixeira
        medicamentos = new MedicamentoDAO().findAllOnTrash();
        System.out.println("> Logradouros na lixeira: " + medicamentos);

        //desmarca como excluido
        new MedicamentoDAO().restoreFromTrash(id);

        // pesquisa por todos da lixeira
        medicamentos = new MedicamentoDAO().findAllOnTrash();
        System.out.println("> Logradouros na lixeira: " + medicamentos);

    }
}
