package fr.chammami.test.mediatheque.models;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class DVD extends MediaAudioVisuel {
    @CsvBindByName
    private String realisateur;

    @CsvBindByName(column = "acteurs")
    private List<String> listActeurs;

    public String getRealisateur() {
	return realisateur;
    }

    public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
    }

    public List<String> getListActeurs() {
	return listActeurs;
    }

    public void setListActeurs(List<String> listActeurs) {
	this.listActeurs = listActeurs;
    }

    public void addActeur(String acteur) {
	this.listActeurs.add(acteur);
    }

    public void removeActeur(String acteur) {
	this.listActeurs.remove(acteur);
    }
}
