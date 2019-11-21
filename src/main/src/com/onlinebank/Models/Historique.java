package com.onlinebank.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class Historique extends BaseModelORM{
    @NotBlank
    @NotNull
    private Integer id;

    String tableName= "ob_historique";

    @NotBlank
    @NotNull
    private Timestamp dateappel;

    @NotBlank
    @NotNull
    private String resultat_appel;

    @NotBlank
    @NotNull
    private Timestamp created_at;

    @NotBlank
    @NotNull
    private Timestamp updated_at;

    @NotBlank
    @NotNull
    private Integer id_produit;

    @NotBlank
    @NotNull
    private Integer id_compte;

    public String getTableName() {
        return tableName;
    }

    public Timestamp getDateappel() {
        return dateappel;
    }

    public Historique setDateappel(Timestamp dateappel) {
        this.dateappel = dateappel;
        return this;
    }

    public String getResultat_appel() {
        return resultat_appel;
    }

    public Historique setResultat_appel(String resultat_appel) {
        this.resultat_appel = resultat_appel;
        return this;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Historique setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Historique setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    public Integer getId_produit() {
        return id_produit;
    }

    public Historique setId_produit(Integer id_produit) {
        this.id_produit = id_produit;
        return this;
    }

    public Integer getId_compte() {
        return id_compte;
    }

    public Historique setId_compte(Integer id_compte) {
        this.id_compte = id_compte;
        return this;
    }
}
