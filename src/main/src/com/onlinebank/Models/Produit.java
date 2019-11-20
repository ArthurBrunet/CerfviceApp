package com.onlinebank.Models;

import java.sql.Timestamp;

public class Produit extends BaseModelORM{
    String tableName= "ob_produit";

    private Integer id;
    private String nom;
    private String description;
    private Integer minage;
    private Integer maxage;
    private Integer revenumin;
    private Integer revenumax;
    private String situationprofessionnel;
    private Timestamp created_at;
    private Timestamp updated_at;

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Produit setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Produit setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Produit setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMinage() {
        return minage;
    }

    public Produit setMinage(Integer minage) {
        this.minage = minage;
        return this;
    }

    public Integer getMaxage() {
        return maxage;
    }

    public Produit setMaxage(Integer maxage) {
        this.maxage = maxage;
        return this;
    }

    public Integer getRevenumin() {
        return revenumin;
    }

    public Produit setRevenumin(Integer revenumin) {
        this.revenumin = revenumin;
        return this;
    }

    public Integer getRevenumax() {
        return revenumax;
    }

    public Produit setRevenumax(Integer revenumax) {
        this.revenumax = revenumax;
        return this;
    }

    public String getSituationprofessionnel() {
        return situationprofessionnel;
    }

    public Produit setSituationprofessionnel(String situationprofessionnel) {
        this.situationprofessionnel = situationprofessionnel;
        return this;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Produit setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Produit setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }
}
