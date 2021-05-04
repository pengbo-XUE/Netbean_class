/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_database;


public class ConnectionDetails 
{
    private static final String userName = "admin8"; 
    private static final String passWord ="pwdd8";
    private static final String driver ="com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:8080/products?autoReconnect=true";
       public static String getUserName() {
        return userName;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static String getDriver() {
        return driver;
    }

    public static String getURL() {
        return URL;
    }
}
