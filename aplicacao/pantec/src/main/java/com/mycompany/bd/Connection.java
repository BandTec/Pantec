/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author sakurah
 */
public class Connection {

    private final BasicDataSource datasource;

    public Connection() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setUrl("jdbc:sqlserver://svrpantec.database.windows.net:1433;"
                        + "database=pantec;"
                        + "user=adminlocal@svrpantec;"
                        + "password=#Pantec123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }

    
}
