package com.pql.design.factory.instance;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DBConnectionPool pool = DBConnectionPool.getInstance();
        Connection connection = pool.getConnection();

    }
}
