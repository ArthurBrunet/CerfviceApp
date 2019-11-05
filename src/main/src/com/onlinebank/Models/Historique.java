package com.onlinebank.Models;

public class Historique extends BaseModelORM{
    private Integer id;

    String tableName= "ob_historique";
    private String dateappel;
    private String resultat_appel;
    private String created_at;
    private String updated_at;
    private Integer id_produit;
    private Integer id_compte;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Historique setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDateappel() {
        return dateappel;
    }

    public Historique setDateappel(String dateappel) {
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

    public String getCreated_at() {
        return created_at;
    }

    public Historique setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public Historique setUpdated_at(String updated_at) {
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
