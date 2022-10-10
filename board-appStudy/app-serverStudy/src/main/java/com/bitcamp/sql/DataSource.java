package com.bitcamp.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

  String jdbcUrl;
  String userName;
  String password;

  ThreadLocal<Connection> conStore = new ThreadLocal<>();

  public DataSource(String driver, String jdbcUrl, String userName, String password) throws Exception {

    Class.forName(driver);

    this.jdbcUrl = jdbcUrl;
    this.userName = userName;
    this.password = password;
  }

  public Connection getConnection() throws Exception {
    Thread currThread = Thread.currentThread();
    System.out.printf("%s=> getConnection() 호출\n", currThread.getName());

    Connection con = conStore.get();
    if(con == null) {
      con = DriverManager.getConnection(jdbcUrl, userName, password);
      conStore.set(con);
    }
    return con;

  }
}
