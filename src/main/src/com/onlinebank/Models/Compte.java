package com.onlinebank.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class Compte extends BaseModelORM{
    String tableName = "ob_compte";

    @NotBlank
    @NotNull
    private Integer id;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @Size(min = 8, max = 64)
    @NotNull
    @NotBlank
    private String motdepasse;

    @NotNull
    @NotBlank
    private String token;

    @NotBlank
    @NotNull
    private String role;

    @NotBlank
    @NotNull
    private String google;

    @NotBlank
    @NotNull
    private Timestamp created_at;

    private Timestamp updated_at;

    @NotBlank
    @NotNull
    private Integer id_prospect;

    public Integer getId_prospect() {
        return id_prospect;
    }

    public Compte setId_prospect(Integer id_prospect) {
        this.id_prospect = id_prospect;
        return this;
    }
    
    @Override
    public Integer getId() {
        return id;
    }


    public String getTableName(){ return tableName; }

    public String getEmail() {
        return email;
    }

    public Compte setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public Compte setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Compte setToken(String token) {
        this.token = token;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Compte setRole(String role) {
        this.role = role;
        return this;
    }

    public String getGoogle() {
        return google;
    }

    public Compte setGoogle(String google) {
        this.google = google;
        return this;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Compte setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Compte setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }

}
