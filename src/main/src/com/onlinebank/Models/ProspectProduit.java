package com.onlinebank.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProspectProduit  extends BaseModelORM {

    @NotBlank
    @NotNull
    private Integer id;

    String tableName = "ob_prospectproduit";

    @NotBlank
    @NotNull
    private Integer id_prospect;

    @NotBlank
    @NotNull
    private Integer id_produit;

    @NotBlank
    @NotNull
    private String created_at;

    @NotBlank
    @NotNull
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

    public String getTablename() {
        return tableName;
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