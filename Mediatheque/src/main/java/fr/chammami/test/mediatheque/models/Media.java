package fr.chammami.test.mediatheque.models;

import java.time.LocalDate;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

public abstract class Media {

    protected Integer id;

    @CsvBindByName
    protected String titre;

    @CsvBindByName
    protected String description;

    @CsvBindByName(column = "date_ajout")
    protected LocalDate dateTimeAjout;

    @CsvBindByName(column = "date_sortie")
    protected LocalDate dateTimeSortie;

    @CsvBindByName(column = "auteurs")
    protected List<String> listAuteurs;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
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

    public LocalDate getDateTimeAjout() {
	return dateTimeAjout;
    }

    public void setDateTimeAjout(LocalDate dateTimeAjout) {
	this.dateTimeAjout = dateTimeAjout;
    }

    public LocalDate getDateTimeSortie() {
	return dateTimeSortie;
    }

    public void setDateTimeSortie(LocalDate dateTimeSortie) {
	this.dateTimeSortie = dateTimeSortie;
    }

    public List<String> getListAuteurs() {
	return listAuteurs;
    }

    public void setListAuteurs(List<String> auteurs) {
	this.listAuteurs = auteurs;
    }
}
