package com.onlinebank.Models;

public class Compte extends BaseModelORM{
    private Integer id;

    String tableName = "ob_compte";

    private String email;
    private String motdepasse;
    private String token;
    private String role;
    private String google;
    private String created_at;
    private String updated_at;
    private Integer id_prospect;
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
