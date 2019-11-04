package com.onlinebank.Models;

public class Users extends BaseModelORM{

    private Integer id;

    String tableName = "Users";

    private String name;
    private String firstName;
    private String email;
    private String password;


    public String getTableName(){ return tableName; }

    public Integer getId(){ return id; }

    public String getName() {
        return name;
    }

    public Users setName(String name) {
        this.name = name;

        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Users setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public Users setEmail(String email) {
        this.email = email;

        return this;
    }

    public String getPassword() { return this.password; }

    public Users setPassword(String password) {
        this.password = password;

        return this;
    }

}
