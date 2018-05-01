package fr.chammami.test.mediatheque.models;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Livre extends MediaPapier {
    @CsvBindByName(column = "chapitres")
    private List<String> listChapitres;

    public List<String> getChapitres() {
	return listChapitres;
    }

    public void setChapitres(List<String> chapitres) {
	this.listChapitres = chapitres;
    }

    public void addChapitre(String chapitre) {
	this.listChapitres.add(chapitre);
    }

    public void removeChapitre(String chapitre) {
	this.listChapitres.remove(chapitre);
    }
}
