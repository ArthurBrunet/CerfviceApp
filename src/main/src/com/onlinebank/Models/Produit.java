package com.onlinebank.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class Produit extends BaseModelORM {
    @NotBlank
    @NotNull
    private Integer id;

    String tableName = "ob_produit";

    @NotBlank
    @NotNull
    @Size(min = 3,max = 50)
    private String nom;

    @NotBlank
    @NotNull
    @Size(min = 3,max = 500)
    private String description;

    @NotBlank
    @NotNull
    private Integer minage;

    @NotBlank
    @NotNull
    private Integer maxage;

    @NotBlank
    @NotNull
    private String situationfamiliale;

    @NotBlank
    @NotNull
    private String situationprofessionnel;

    @NotBlank
    @NotNull
    private Integer revenumin;

    @NotBlank
    @NotNull
    private Integer revenumax;

    @NotBlank
    @NotNull
    private String depenseregulieremax;

    @NotBlank
    @NotNull
    private Integer enfants;

    @NotBlank
    @NotNull
    private String situationlogement;

    @NotBlank
    @NotNull
    private Integer minanciennetelogement;

    @NotBlank
    @NotNull
    private Integer maxanciennetelogement;

    @NotBlank
    @NotNull
    private Integer minancienneteprofessionnel;

    @NotBlank
    @NotNull
    private Integer maxancienneteprofessionnel;

    @NotBlank
    @NotNull
    private Timestamp created_at;

    @NotBlank
    @NotNull
    private Timestamp updated_at;


    @NotBlank
    @NotNull
    @Override
    public Integer getId() {
        return id;
    }

    @NotBlank
    @NotNull
    @Override
    public Produit setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTablename() {
        return tableName;
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

    public String getSituationfamiliale() {
        return situationfamiliale;
    }

    public Produit setSituationfamiliale(String situationfamiliale) {
        this.situationfamiliale = situationfamiliale;
        return this;
    }

    public String getSituationprofessionnel() {
        return situationprofessionnel;
    }

    public Produit setSituationprofessionnel(String situationprofessionnel) {
        this.situationprofessionnel = situationprofessionnel;
        return this;
    }

    public Integer getRevenumin() {
        return revenumin;
    }

    public Produit setRevenumin(Integer revenumin) {
        this.revenumin = revenumin;
        return this;
    }

    public Integer getRevenuMax() {
        return revenumax;
    }

    public Produit setRevenumax(Integer revenumax) {
        this.revenumax = revenumax;
        return this;
    }

    public String getDepenseregulieremax() {
        return depenseregulieremax;
    }

    public Produit setDepenseregulieremax(String depenseregulieremax) {
        this.depenseregulieremax = depenseregulieremax;
        return this;
    }

    public Integer getEnfants() {
        return enfants;
    }

    public Produit setEnfants(Integer enfants) {
        this.enfants = enfants;
        return this;
    }

    public String getSituationlogement() {
        return situationlogement;
    }

    public Produit setSituationlogement(String situationlogement) {
        this.situationlogement = situationlogement;
        return this;
    }

    public Integer getMinanciennetelogement() {
        return minanciennetelogement;
    }

    public Produit setMinanciennetelogement(Integer minanciennetelogement) {
        this.minanciennetelogement = minanciennetelogement;
        return this;
    }

    public Integer getMaxanciennetelogement() {
        return maxanciennetelogement;
    }

    public Produit setMaxanciennetelogement(Integer maxanciennetelogement) {
        this.maxanciennetelogement = maxanciennetelogement;
        return this;
    }

    public Integer getMinancienneteprofessionnel() {
        return minancienneteprofessionnel;
    }

    public Produit setMinancienneteprofessionnel(Integer minancienneteprofessionnel) {
        this.minancienneteprofessionnel = minancienneteprofessionnel;
        return this;
    }

    public Integer getMaxancienneteprofessionnel() {
        return maxancienneteprofessionnel;
    }

    public Produit setMaxancienneteprofessionnel(Integer maxancienneteprofessionnel) {
        this.maxancienneteprofessionnel = maxancienneteprofessionnel;
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