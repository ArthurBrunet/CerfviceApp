package com.onlinebank.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String created_at;

    @NotBlank
    @NotNull
    private String updated_at;

    @NotBlank
    @NotNull
    private Integer id_prospect;

    @NotBlank
    @NotNull
    private Integer id_historique;

    public Integer getId_prospect() {
        return id_prospect;
    }

    public Compte setId_prospect(Integer id_prospect) {
        this.id_prospect = id_prospect;
        return this;
    }

    public Integer getId_historique() {
        return id_historique;
    }

    public Compte setId_historique(Integer id_historique) {
        this.id_historique = id_historique;
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

    public String getCreated_at() {
        return created_at;
    }

    public Compte setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public Compte setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

}
