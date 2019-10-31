package com.onlinebank.Models;

//Importation des paquest de javasql

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Définissions de notre classe
public class BaseModelORM {

    //Nous définissons les variables qui seront utilisées
    private Integer id;

    private String tableName = "";
    private String insertQueryString = "INSERT INTO ";
    private String updateQueryString = "UPDATE ";
    private String selectQueryString = "SELECT id, ";
    private String removeQueryString = "DELETE FROM ";
    private String updateIdQueryString = "UPDATE ";


    private String ucFirst(String string)
    {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    //Voici la fonction qui va nous permettre de fabriquer l'id en bdd
    public BaseModelORM setId(Integer id)
    {
        this.id = id;

        return this;
    }

    //Celle qui nous récupère id
    public Integer getId()
    {
        return this.id;
    }

    //Fonction qui récup le nom de la table
    public String getTableName()
    {

        return "";
    }

    //Ici nous définissons la reqête verbale pour l'insertion
    private String getInsertString()
    {

        //Définissons des variables
        //On précise que les champs seront des tableaux mais les valeurs seront des chaînes de caractères
        ArrayList<String> fields = new ArrayList<String>();
        //Voila la définition des caractères qui sépareront les différents champs
        ArrayList<String> marks  = new ArrayList<String>();
        //Ici nous établissons une variable qui va récupérer toute la requête
        StringBuilder total      = new StringBuilder();

        //On lui intègre le début de la requête
        total.append(this.insertQueryString);
        //Insertion du nom de la Table
        total.append(this.getTableName());

        //On définit la variable f et lui dire qu'elle récupère les chamsp déclarés
        for (Field f : getClass().getDeclaredFields()) {
            try {
                //Si l'id est différents de 0 et le nom de la table aussi on continue
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0) {
                    //Du coup on ajoute les champs à insérer
                    fields.add(f.getName());
                    //Ici on donne une valeur a notre variable marks
                    marks.add("?");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //On ajoute cette fin à la requête
        total.append(" (");
        total.append(String.join(",", fields));
        total.append(")");

        total.append(" VALUES (");
        total.append(String.join(",", marks));
        total.append(")");

        System.out.println(total.toString());
        return total.toString();
    }

    //Ici pour la méthode update
    private String getUpdateString()
    {
        //Définition des variable utilisées lors de la fonction
        //Définition de la variable pour récupérer nos champs
        ArrayList<String> fields = new ArrayList<String>();
        //Ici on définit notre variable pour rajouter des parametres a la requete
        String where             = "WHERE id = ?";
        //Variable pour effectué la requete
        StringBuilder total      = new StringBuilder();

        //Début de la requete
        total.append(this.updateQueryString);
        //On ajout la table
        total.append(this.getTableName());
        //On met la variable Set pour appliquer le changement
        total.append(" SET ");

        //On définit f qui est un champs et récupérer les champs déclarés dans notre classe
        for (Field f : getClass().getDeclaredFields())
        {
            try {
                //Si ni nos id ni notre nom de table est nul alors
                if( f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0 ) {

                    //On ajout nos champs et si vide alors on met un ?
                    fields.add(f.getName() + " = ?");

                }
            }
            catch( Exception e )
            {
                System.out.println(e);
            }
        }

        //Ici on fini la requete avec les chamsp a modifier et on les délimite
        total.append(String.join(",", fields));
        //On met notre variable where pour préciser un id
        total.append(where);

        return total.toString();
    }


    //Méthode pour effectuer notre requete SQL avec notre bdd
    public PreparedStatement getUpdateQuery(Connection dbConnection)
    {
        //On récupère notre chaîne de caractère qui est la requete et on la transmet à une variable
        String updateQueryString    = this.getUpdateString();
        //On définit que statement est null car aucune requete est effectué
        PreparedStatement statement = null;

        Integer id  = null;
        Integer i   = 1;
        try
        {
            //Ici on établit la connection et on prépare notre requete
            statement = dbConnection.prepareStatement(updateQueryString, Statement.RETURN_GENERATED_KEYS);

            //Pour nos champs on les déclare avec nos varibales de notre classe/Objet
            for (Field f : getClass().getDeclaredFields())
            {
                try {
                    // We are in a INSERT : no need for ID.
                    if( f.getName().compareTo("id") == 0 )
                    {
                        //On ajoute une ùaje en plus des champs sur cette variable
                        String fieldName    = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // "getName"

                        //On définit comment on récupèe les champs
                        Method classMethod  = getClass().getMethod(targetMethod);

                        id = (Integer) classMethod.invoke(this);
                    }
                    else
                    {
                        i = addParameter(statement, i, f);
                    }

                }
                catch( Exception e )
                {
                    System.out.println(e);
                }
            }

            statement.setInt (i,  id );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return statement;
    }


    //Exécution de notre requete insert
    public PreparedStatement getInsertQuery(Connection dbConnection)
    {
        //On récupère notre requete sous forme de chapine de caractère
        String insertQueryString = this.getInsertString();
        //On définit ici qu'il se passe rien donc pas de requête
        PreparedStatement statement = null;

        try
        {
            //On établi notre connection avec sa preparation
            statement = dbConnection.prepareStatement(insertQueryString, Statement.RETURN_GENERATED_KEYS);

            Integer i = 1;

            for (Field f : getClass().getDeclaredFields())
            {
                try
                {
                    // We are in a INSERT : no need for ID, filtered in addParameter.
                    i = addParameter(statement, i, f);
                }
                catch( Exception e )
                {
                    System.out.println(e);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return statement;
    }

    private String getSelectQueryString(){

        ArrayList<String> fields = new ArrayList<String>();
        StringBuilder total      = new StringBuilder();

        total.append(this.selectQueryString);

        for (Field f : getClass().getDeclaredFields())
        {
            try {
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableNme") != 0 && f.getName() != "tableName"){

                    fields.add(f.getName());  //On étbalit les valeurs des chmaps comme des strings

                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        total.append(String.join(",", fields));
        total.append(" FROM ");
        total.append(this.getTableName());


        System.out.println(total.toString());
        return total.toString();

    }

    public PreparedStatement getSelectQuery(Connection dbConnection){

        String selectQueryString = this.getSelectQueryString();
        PreparedStatement statement = null;


        try{
            statement = dbConnection.prepareStatement(selectQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields())
            {
                try
                {
                    if (f.getName().compareTo("id") != 0)
                    {

                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // On établit la méthode de la requete et du coup get avec les champs retournés

                        Method classMethod = getClass().getMethod(targetMethod);

                        classMethod.invoke(this);

                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        catch (SQLException e){

            System.out.println(e);

        }

        return statement;
    }

    public String getRemoveQueryString(Integer id){

        ArrayList<String> fields = new ArrayList<String>();
        String where             = " WHERE id = ";
        StringBuilder total      = new StringBuilder();

        total.append(this.removeQueryString);
        total.append(this.getTableName());

        for (Field f : getClass().getDeclaredFields())
        {
            try {
                if( f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0 ) {

                    fields.add(f.getName() + " = ?");

                }
            }
            catch( Exception e )
            {
                System.out.println(e);
            }
        }

        total.append(where);
        total.append(id);

        System.out.println(total.toString());
        return total.toString();

    }

    public PreparedStatement getRemoveQuery(Connection db, Integer id) {
        String removeQueryString = this.getRemoveQueryString(id);
        PreparedStatement statement = null;

        try {

            statement = db.prepareStatement(removeQueryString, Statement.RETURN_GENERATED_KEYS);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    private String getUpdateIdQueryString(Integer id){

        ArrayList<String> fields = new ArrayList<String>();
        String where             = "WHERE id = ";
        StringBuilder total      = new StringBuilder();

        total.append(this.updateIdQueryString);
        total.append(this.getTableName());
        total.append(" SET ");

        for (Field f : getClass().getDeclaredFields())
        {
            try {
                if( f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0 ) {

                    fields.add(f.getName() + " = ?");

                }
            }
            catch( Exception e )
            {
                System.out.println(e);
            }
        }

        total.append(String.join(",", fields));
        total.append(where);
        total.append(id);

        System.out.println(total.toString());
        return total.toString();

    }

    public PreparedStatement getUpdateIdQuery(Connection db, Integer id){
        String updateIdQueryString = this.getUpdateIdQueryString(id);
        PreparedStatement statement = null;

        Integer i = 1;
        try {

            statement = db.prepareStatement(updateIdQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields())
            {
                try {
                    // We are in a INSERT : no need for ID.
                    if( f.getName().compareTo("id") == 0 )
                    {
                        String fieldName    = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // "getName"

                        Method classMethod  = getClass().getMethod(targetMethod);

                        classMethod.invoke(this);
                    }
                    else
                    {
                        i = addParameter(statement, i, f);
                    }
                }
                catch( Exception e )
                {
                    System.out.println(e);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return statement;
    }

    private String getSelectIdQueryString(String emaill){
        ArrayList<String> fields = new ArrayList<String>();
        StringBuilder total      = new StringBuilder();
        String where             = " WHERE email = " + "'" + emaill + "'";


        total.append(this.selectQueryString);

        for (Field f : getClass().getDeclaredFields())
        {
            try {
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableNme") != 0 && f.getName() != "tableName"){

                    fields.add(f.getName());  //On étbalit les valeurs des chmaps comme des strings

                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        total.append(String.join(",", fields));
        total.append(" FROM ");
        total.append(this.getTableName());
        total.append(where);


        System.out.println(total.toString());
        return total.toString();

    }


    public PreparedStatement getSelectIdQuery(Connection dbConnection, String emaill){
        String selectIdQueryString = this.getSelectIdQueryString(emaill);
        PreparedStatement statement = null;

        Integer i = 1;

        try{
            statement = dbConnection.prepareStatement(selectIdQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields())
            {
                try
                {
                    if (f.getName().compareTo("id") != 0)
                    {

                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // On établit la méthode de la requete et du coup get avec les champs retournés

                        Method classMethod = getClass().getMethod(targetMethod);

                        classMethod.invoke(this);

                    }
                    else
                    {
                        i = addParameter(statement, i, f);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        catch (SQLException e){

            System.out.println(e);

        }

        return statement;
    }

//    public PreparedStatement getSelectIdQuery(Connection dbConnection){
//        String selectIdQueryString = this.getSelectIdQueryString(id);
//        PreparedStatement statement = null;
//
//
//        try{
//            statement = dbConnection.prepareStatement(selectIdQueryString, Statement.RETURN_GENERATED_KEYS);
//
//            for (Field f : getClass().getDeclaredFields())
//            {
//                try
//                {
//                    if (f.getName().compareTo("id") != 0)
//                    {
//
//                        String fieldName = ucFirst(f.getName());
//                        String targetMethod = "get" + fieldName; // On établit la méthode de la requete et du coup get avec les champs retournés
//
//                        Method classMethod = getClass().getMethod(targetMethod);
//
//                        classMethod.invoke(this);
//
//                    }
//                }
//                catch (Exception e)
//                {
//                    System.out.println(e);
//                }
//            }
//        }
//        catch (SQLException e){
//
//            System.out.println(e);
//
//        }
//
//        return statement;
//    }


    private Integer addParameter(PreparedStatement statement, Integer i, Field field)
    {
        try
        {
            if( field.getName().compareTo("id") != 0 && field.getName().compareTo("tableName") != 0 ) {
                // Ex : "name" => "Name"
                String fieldName    = ucFirst(field.getName());
                String targetMethod = "get" + fieldName; // "getName"

                Method classMethod  = getClass().getMethod(targetMethod);

                if( field.getType() == Integer.class )
                {
                    statement.setInt (i,  (Integer) classMethod.invoke(this) );
                }

                if( field.getType() == String.class )
                {
                    statement.setString (i,  (String) classMethod.invoke(this) );
                }

                i = i + 1;
            }
        }
        catch( Exception e)
        {

        }

        return i;
    }


}