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

import com.mycompany.adotapet.endereco.Endereco;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.endereco.EnderecoDAO;
import com.mycompany.adotapet.telefone.Telefone;
import com.mycompany.adotapet.telefone.TelefoneDAO;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouroDAO;
import com.mycompany.adotapet.tutor.Tutor;

/**
 * Classe TesteCredencialDAO
 *
 * @author Breno Vambaster C. L
 */
public class TesteCredencialDAO {

    public static void main(String[] args) throws Exception {

        //<editor-fold defaultstate="collapsed" desc="Criando Endereco">
        TipoLogradouro logr = new TipoLogradouro("Casa principal");
        Long id_logr = new TipoLogradouroDAO().saveOrUpdate(logr);
        logr.setId(id_logr);

        Endereco end1 = new Endereco(logr, "Rua Juca Prates", 12, "Atrás do Automóvel Club", "Centro",
                "Montes Claros", "MG", 39400078);
        Long id_endr = new EnderecoDAO().saveOrUpdate(end1);
        end1.setId(id_endr);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Criando Telefone">
        Telefone fone1 = new Telefone((short) 33, 33999056, false);
        Long id_fone1 = new TelefoneDAO().saveOrUpdate(fone1);
        fone1.setId(id_fone1);
        //</editor-fold>

    }

}
