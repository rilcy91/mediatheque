package fr.chammami.test.mediatheque.models;

import com.opencsv.bean.CsvBindByName;

public class MediaFileObject {
    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "titre")
    private String titre;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "date_ajout")
    private String dateTimeAjout;

    @CsvBindByName(column = "date_sortie")
    private String dateTimeSortie;

    @CsvBindByName(column = "chanteurs")
    private String chanteurs;

    @CsvBindByName(column = "chansons")
    private String listChansons;

    @CsvBindByName(column = "duree")
    private Integer duree;

    @CsvBindByName(column = "acteurs")
    private String listActeurs;

    @CsvBindByName(column = "realisateur")
    private String realisateur;

    @CsvBindByName(column = "auteurs")
    private String auteurs;

    @CsvBindByName(column = "chapitres")
    private String listChapitres;

    @CsvBindByName(column = "nb_pages")
    private Integer nbPages;

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getTitre() {
	return titre;
    }

    public void setTitre(String titre) {
	this.titre = titre;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getRealisateur() {
	return realisateur;
    }

    public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
    }

    public String getDateTimeAjout() {
	return dateTimeAjout;
    }

    public void setDateTimeAjout(String dateTimeAjout) {
	this.dateTimeAjout = dateTimeAjout;
    }

    public String getDateTimeSortie() {
	return dateTimeSortie;
    }

    public void setDateTimeSortie(String dateTimeSortie) {
	this.dateTimeSortie = dateTimeSortie;
    }

    public String getAuteurs() {
	return auteurs;
    }

    public void setAuteurs(String auteurs) {
	this.auteurs = auteurs;
    }

    public Integer getNbPages() {
	return nbPages;
    }

    public void setNbPages(Integer nbPages) {
	this.nbPages = nbPages;
    }

    public Integer getDuree() {
	return duree;
    }

    public void setDuree(Integer duree) {
	this.duree = duree;
    }

    public String getChanteurs() {
	return chanteurs;
    }

    public void setChanteurs(String chanteurs) {
	this.chanteurs = chanteurs;
    }

    public String getListChansons() {
	return listChansons;
    }

    public void setListChansons(String listChansons) {
	this.listChansons = listChansons;
    }

    public String getListActeurs() {
	return listActeurs;
    }

    public void setListActeurs(String listActeurs) {
	this.listActeurs = listActeurs;
    }

    public String getListChapitres() {
	return listChapitres;
    }

    public void setListChapitres(String listChapitres) {
	this.listChapitres = listChapitres;
    }

}
