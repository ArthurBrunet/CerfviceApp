package com.onlinebank.Utils;

import com.onlinebank.Models.BaseModelORM;
import com.onlinebank.Models.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Connection db;

    public static void connect()
    {

        if( db == null )
        {
            System.out.println("[DB] Entering Database Connect.");
            try
            {
                Class.forName("org.postgresql.Driver");
                db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "postgres");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }

    public static void close(){

        if (db != null){
            System.out.println("Closing Database");
            try {

                db.close();
                db = null;

            }
            catch (SQLException e)
            {

                System.out.println(e);

            }
        }

    }

    public static Integer insert(BaseModelORM _object) {

        Integer _newId = null;

        System.out.println("[DB] Entering INSERT.");

        connect();

        if( db != null )
        {
            System.out.println("[DB] Got connection. Preparing statement.");

            PreparedStatement _insertQuery = _object.getInsertQuery(db);

            try
            {
                _insertQuery.executeUpdate();

                System.out.println("[DB] Statement ran. Picking last inserted ID.");

                // ... yeah. Bit strange, but works, so ...
                ResultSet keys = _insertQuery.getGeneratedKeys();
                keys.next();

                _newId = keys.getInt(1);

                System.out.println("[DB] Got last inserted ID. Setting it in object ( maybe for future 'UPDATE' query ? )");

                _object.setId(_newId);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        close();

        System.out.println("[DB] Exiting INSERT.");

        return _newId;

    }

    public static void update(BaseModelORM _object){

        System.out.println("[DB] Entering UPDATE.");

        connect();

        if( db != null )
        {
            System.out.println("[DB] Got connection. Preparing statement.");

            PreparedStatement _updateQuery = _object.getUpdateQuery(db);

            try
            {
                _updateQuery.execute();

                System.out.println("[DB] Statement ran.");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        close();

        System.out.println("[DB] Exiting UPDATE.");

    }

    public static List<Users> select(BaseModelORM _object){

        System.out.println("[DB] Entering SELECT");

        connect();

        List<Users> resultat = new ArrayList<>();

        if (db != null) {
            System.out.println("[DB] Got connection , Preparing statement");

            PreparedStatement _selectQuery = _object.getSelectQuery(db);

            try {

                ResultSet rs = _selectQuery.executeQuery();

                while (rs.next())
                {
                    Users item = new Users();
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    String firstname = rs.getString("firstName");
                    String email = rs.getString("email");
                    item.setId(id);
                    item.setName(name);
                    item.setFirstName(firstname);
                    item.setEmail(email);

                    //Déclaration de la variable impératiement ici pour permettre de récup les données, a voir pour faire cela dans un tableau
//                    item[0] = id;
//                    item[1] = name;
//                    item[2] = firstname;
//                    item[3] = email;

                    resultat.add(item);
                }

                System.out.println("[DB] Statement ran.");

            } catch (Exception e) {

                e.printStackTrace();
            }

            close();

            System.out.println("[DB] Existing Select");
        }

        return resultat;

    }

    public static void remove(BaseModelORM _object, Integer id){

        System.out.println("Entering DELETE");

        connect();

        if (db != null){
            System.out.println("Got to connection");

            PreparedStatement _removeQuery = _object.getRemoveQuery(db, id);

            try
            {
                _removeQuery.execute();

                System.out.println("Remove effectué");
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }
        close();

        System.out.println("Databse closing");
    }

    public static void updateId(BaseModelORM _object, Integer id){

        System.out.println("Entering UpdateId");

        connect();

        if (db != null){

            System.out.println("Go the connection");

            PreparedStatement _updateIdQuery = _object.getUpdateIdQuery(db, id);

            try
            {
                _updateIdQuery.execute();

                System.out.println("Update Effectué");
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }
        close();
    }

    public static List<Users> selectId(BaseModelORM _object, String emaill){
        System.out.println("[DB] Entering SELECT");

        connect();

        List<Users> resultat = new ArrayList<>();

        if (db != null) {
            System.out.println("[DB] Got connection , Preparing statement");

            PreparedStatement _selectQuery = _object.getSelectIdQuery(db, emaill);

            try
            {

                ResultSet rs = _selectQuery.executeQuery();

                while (rs.next()){
                    Users item = new Users();
                    Integer idi = rs.getInt("id");
                    String name = rs.getString("name");
                    String firstname = rs.getString("firstName");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    item.setId(idi);
                    item.setName(name);
                    item.setFirstName(firstname);
                    item.setEmail(email);
                    item.setPassword(password);

                    resultat.add(item);
                }

                System.out.println("[DB] Statement ran.");

            } catch (Exception e) {

                e.printStackTrace();
            }

//            close();

            System.out.println("[DB] Existing Select Id");
        }


        return resultat;
    }

//    public static BaseModelORM selectId(BaseModelORM _object){
//        System.out.println("[DB] Entering SELECT");
//
//        connect();
//
//        if (db != null) {
//            System.out.println("[DB] Got connection , Preparing statement");
//
//            PreparedStatement _selectQuery = _object.getSelectIdQuery(db);
//
//            try
//            {
//
//                ResultSet rs = _selectQuery.executeQuery();
//
//                while (rs.next()){
//                    System.out.println(
//                            rs.getString("name")
//                                    + " " + rs.getString("firstName")
//                                    + " " + rs.getString("email")
//                    );
//                }
//
//                System.out.println("[DB] Statement ran.");
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//
////            close();
//
//            System.out.println("[DB] Existing Select Id");
//        }
//
//        return _object;
//    }


}
