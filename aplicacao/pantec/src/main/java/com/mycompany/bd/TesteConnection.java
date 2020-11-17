/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author sakurah
 */
public class TesteConnection {

    public static void main(String args[]) {

        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());

        List primeiroSelect = con.queryForList("select*from documento");

        System.out.println(primeiroSelect);

    }

}
