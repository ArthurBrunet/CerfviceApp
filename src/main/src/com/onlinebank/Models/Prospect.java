package com.onlinebank.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

public class Prospect extends BaseModelORM{

    @NotBlank
    @NotNull
    private Integer id;


    @NotBlank
    @NotNull
    private String nom;

    @NotBlank
    @NotNull
    private String prenom;

    public String getAge() {
        return age;
    }

    public Prospect setAge(String age) {
        this.age = age;
        return this;
    }

    @NotBlank
    @NotNull
    private String age;


    @NotBlank
    @NotNull
    private String situationfamiliale;

    @NotBlank
    @NotNull
    private Integer revenu;

    @NotBlank
    @NotNull
    private Integer depensereguliere;

    @NotBlank
    @NotNull
    private String situationprofessionnel;

    @NotBlank
    @NotNull
    private String telephone;

    @NotBlank
    @NotNull
    private Integer enfants;

    @NotBlank
    @NotNull
    private String departement;

    @NotBlank
    @NotNull
    private String typehabitat;

    @NotBlank
    @NotNull
    private String situationlogement;

    @NotBlank
    @NotNull
    private Integer anciennetelogement;

    @NotBlank
    @NotNull
    private Integer ancienneteprofessionnel;

    private Boolean bloquepub;

    private Boolean active;

    private Timestamp created_at;

    private Timestamp updated_at;

    private Boolean verifLj;

    private Boolean verifCcp;

    private Boolean verifLa;

    private Boolean verifPel;

    private Boolean verifAv;

    private Boolean verifCe;

    private Boolean verifCc;

    private Boolean verifCi;

    private Boolean verifCa;

    public Boolean getVerifLj() {
        return verifLj;
    }

    public Prospect setVerifLj(Boolean verifLj) {
        this.verifLj = verifLj;
        return this;
    }

    public Boolean getVerifCcp() {
        return verifCcp;
    }

    public Prospect setVerifCcp(Boolean verifCcp) {
        this.verifCcp = verifCcp;
        return this;
    }

    public Boolean getVerifLa() {
        return verifLa;
    }

    public Prospect setVerifLa(Boolean verifLa) {
        this.verifLa = verifLa;
        return this;
    }

    public Boolean getVerifPel() {
        return verifPel;
    }

    public Prospect setVerifPel(Boolean verifPel) {
        this.verifPel = verifPel;
        return this;
    }

    public Boolean getVerifAv() {
        return verifAv;
    }

    public Prospect setVerifAv(Boolean verifAv) {
        this.verifAv = verifAv;
        return this;
    }

    public Boolean getVerifCe() {
        return verifCe;
    }

    public Prospect setVerifCe(Boolean verifCe) {
        this.verifCe = verifCe;
        return this;
    }

    public Boolean getVerifCc() {
        return verifCc;
    }

    public Prospect setVerifCc(Boolean verifCc) {
        this.verifCc = verifCc;
        return this;
    }

    public Boolean getVerifCi() {
        return verifCi;
    }

    public Prospect setVerifCi(Boolean verifCi) {
        this.verifCi = verifCi;
        return this;
    }

    public Boolean getVerifCa() {
        return verifCa;
    }

    public Prospect setVerifCa(Boolean verifCa) {
        this.verifCa = verifCa;
        return this;
    }

    String tableName = "ob_prospect";

    public String getTableName() {
        return tableName;
    }

    public String getNom() {
        return nom;
    }

    public Prospect setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Prospect setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }


    public String getSituationfamiliale() {
        return situationfamiliale;
    }

    public Prospect setSituationfamiliale(String situationfamiliale) {
        this.situationfamiliale = situationfamiliale;
        return this;
    }

    public Integer getRevenu() {
        return revenu;
    }

    public Prospect setRevenu(Integer revenu) {
        this.revenu = revenu;
        return this;
    }

    public Integer getDepensereguliere() {
        return depensereguliere;
    }

    public Prospect setDepensereguliere(Integer depensereguliere) {
        this.depensereguliere = depensereguliere;
        return this;
    }

    public String getSituationprofessionnel() {
        return situationprofessionnel;
    }

    public Prospect setSituationprofessionnel(String situationprofessionnel) {
        this.situationprofessionnel = situationprofessionnel;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Prospect setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Integer getEnfants() {
        return enfants;
    }

    public Prospect setEnfants(Integer enfants) {
        this.enfants = enfants;
        return this;
    }

    public String getDepartement() {
        return departement;
    }

    public Prospect setDepartement(String departement) {
        this.departement = departement;
        return this;
    }

    public String getTypehabitat() {
        return typehabitat;
    }

    public Prospect setTypehabitat(String typehabitat) {
        this.typehabitat = typehabitat;
        return this;
    }

    public String getSituationlogement() {
        return situationlogement;
    }

    public Prospect setSituationlogement(String situationlogement) {
        this.situationlogement = situationlogement;
        return this;
    }

    public Integer getAnciennetelogement() {
        return anciennetelogement;
    }

    public Prospect setAnciennetelogement(Integer anciennetelogement) {
        this.anciennetelogement = anciennetelogement;
        return this;
    }

    public Integer getAncienneteprofessionnel() {
        return ancienneteprofessionnel;
    }

    public Prospect setAncienneteprofessionnel(Integer ancienneteprofessionnel) {
        this.ancienneteprofessionnel = ancienneteprofessionnel;
        return this;
    }


    public Boolean getBloquepub() {
        return bloquepub;
    }

    public Prospect setBloquepub(Boolean bloquepub) {
        this.bloquepub = bloquepub;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Prospect setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Prospect setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Prospect setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }

}
