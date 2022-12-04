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
package com.mycompany.adotapet.especie;

import java.util.List;

/**
 *
 * @author pedro
 */
public class TesteEspecieDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Especie especie = new Especie();
        especie.setNome("Cachorro");   
        
        //salvando
        Long idEspecie = new EspecieDAO().saveOrUpdate(especie);
        especie.setId(idEspecie);
        System.out.println("> "+ especie);
        
        //modifica
        especie.setNome("Gato");
        new EspecieDAO().saveOrUpdate(especie);
        
        //pega tudo do bd
        List<Especie> especies = new EspecieDAO().findAll();
        System.out.println("> " + especies);
        
        //marca como excluido
        new EspecieDAO().moveToTrash(idEspecie);
        
        //pega tudo da lixeira
        especies = new EspecieDAO().findAllOnTrash();
        System.out.println("> " + especies);
        
        //desmarca como excluido
        new EspecieDAO().restoreFromTrash(idEspecie);
        
        //pega tudo da lixeira
        especies = new EspecieDAO().findAll();
        System.out.println("> " + especies);
        
    }
    
}
