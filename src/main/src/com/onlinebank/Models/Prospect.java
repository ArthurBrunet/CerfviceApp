package com.onlinebank.Models;

public class Prospect {
    private Integer id;

    String tableName = "ob_prospect";

    private String nom;
    private String prenom;
    private Integer age;
    private String situationfamiliale;
    private Integer revenu;
    private Integer depensereguliere;
    private String situationprofessionnel;
    private String telephone;
    private Integer enfants;
    private String departement;
    private String typehabitat;
    private String situationlogement;
    private String anciennetelogement;
    private String ancienneteprofessionnel;
    private String notification;
    private Boolean bloquepub;
    private Boolean active;
    private String created_at;
    private String updated_at;
    private Integer id_compte;

    public Integer getId() {
        return id;
    }

    public Prospect setId(Integer id) {
        this.id = id;
        return this;
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

    public Integer getAge() {
        return age;
    }

    public Prospect setAge(Integer age) {
        this.age = age;
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

    public String getAnciennetelogement() {
        return anciennetelogement;
    }

    public Prospect setAnciennetelogement(String anciennetelogement) {
        this.anciennetelogement = anciennetelogement;
        return this;
    }

    public String getAncienneteprofessionnel() {
        return ancienneteprofessionnel;
    }

    public Prospect setAncienneteprofessionnel(String ancienneteprofessionnel) {
        this.ancienneteprofessionnel = ancienneteprofessionnel;
        return this;
    }

    public String getNotification() {
        return notification;
    }

    public Prospect setNotification(String notification) {
        this.notification = notification;
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

    public String getCreated_at() {
        return created_at;
    }

    public Prospect setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public Prospect setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    public Integer getId_compte() {
        return id_compte;
    }

    public Prospect setId_compte(Integer id_compte) {
        this.id_compte = id_compte;
        return this;
    }
}
