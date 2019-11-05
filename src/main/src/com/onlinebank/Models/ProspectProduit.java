package com.onlinebank.Models;

public class ProspectProduit  extends BaseModelORM {
    private Integer id;

    String tableName = "ob_prospectproduit";

    private Integer id_prospect;
    private Integer id_produit;
    private String created_at;
    private String updated_at;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public ProspectProduit setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId_prospect() {
        return id_prospect;
    }

    public ProspectProduit setId_prospect(Integer id_prospect) {
        this.id_prospect = id_prospect;
        return this;
    }

    public Integer getId_produit() {
        return id_produit;
    }

    public ProspectProduit setId_produit(Integer id_produit) {
        this.id_produit = id_produit;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public ProspectProduit setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public ProspectProduit setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }
}