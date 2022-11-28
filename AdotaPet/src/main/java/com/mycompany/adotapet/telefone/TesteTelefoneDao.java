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
package com.mycompany.adotapet.telefone;

import java.util.List;

/**
 *
 * @author pedro
 */
public class TesteTelefoneDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //criando objeto
        Telefone telefone = new Telefone((short)38, 997287649, true);
        
        //salvando no bd - numero é unico 
        Long idTelefone = new TelefoneDao().saveOrUpdate(telefone);
        telefone.setId(idTelefone);
        System.out.println("> "+ telefone);
        
        //modifica
        telefone.setNumero(998397591);
        new TelefoneDao().saveOrUpdate(telefone);
        

        //pega tudo do bd
        List<Telefone> telefones = new TelefoneDao().findAll();
        System.out.println("> " + telefones);
    
        //marca como excluido
        new TelefoneDao().moveToTrash(idTelefone);
        
        //pega tudo da lixeira
        telefones = new TelefoneDao().findAllOnTrash();
        System.out.println("> " + telefones);
        
        //desmarca como excluido
        new TelefoneDao().restoreFromTrash(idTelefone);
        
        //pega tudo da lixeira
        telefones = new TelefoneDao().findAll();
        System.out.println("> " + telefones);
    }  
}
