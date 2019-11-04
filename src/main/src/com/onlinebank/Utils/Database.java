package com.onlinebank.Utils;

import com.onlinebank.Models.BaseModelORM;

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

    public static List select(BaseModelORM _object, ArrayList<String> fields){

        System.out.println("[DB] Entering SELECT");

        connect();

        List resultat = new ArrayList<>();

        if (db != null) {
            System.out.println("[DB] Got connection , Preparing statement");

            PreparedStatement _selectQuery = _object.getSelectQuery(db, fields);

            try {

                ResultSet rs = _selectQuery.executeQuery();

                while (rs.next())
                {
                    BaseModelORM _newObject = (BaseModelORM) Class.forName(_object.getClass().getName()).newInstance();
                    resultat.add(_newObject.populate(rs, fields));
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

    public static List select(BaseModelORM _object, ArrayList<String> fields, ArrayList<String> filter){

        System.out.println("[DB] Entering SELECT");

        connect();

        List resultat = new ArrayList<>();

        if (db != null) {
            System.out.println("[DB] Got connection , Preparing statement");

            PreparedStatement _selectQuery = _object.getSelectQuery(db, fields, filter);

            try {

                ResultSet rs = _selectQuery.executeQuery();

                while (rs.next())
                {
                    BaseModelORM _newObject = (BaseModelORM) Class.forName(_object.getClass().getName()).newInstance();
                    resultat.add(_newObject.populate(rs, fields));
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

}