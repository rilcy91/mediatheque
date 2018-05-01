package fr.chammami.test.mediatheque.models;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class CD extends MediaAudioVisuel {
    @CsvBindByName(column = "chanteurs")
    private List<String> listChanteurs;

    @CsvBindByName(column = "chansons")
    private List<String> listChansons;

    public List<String> getListChanteurs() {
	return listChanteurs;
    }

    public void setListChanteurs(List<String> chanteurs) {
	this.listChanteurs = chanteurs;
    }

    public List<String> getListChansons() {
	return listChansons;
    }

    public void setListChansons(List<String> listChansons) {
	this.listChansons = listChansons;
    }

    public void addChanson(String chanson) {
	this.listChansons.add(chanson);
    }

    public void removeChanson(String chanson) {
	this.listChansons.remove(chanson);
    }
}
