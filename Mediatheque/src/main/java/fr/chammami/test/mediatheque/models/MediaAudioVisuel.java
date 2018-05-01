package fr.chammami.test.mediatheque.models;

import com.opencsv.bean.CsvBindByName;

public abstract class MediaAudioVisuel extends Media {
    @CsvBindByName
    protected Integer duree;

    public Integer getDuree() {
	return duree;
    }

    public void setDuree(Integer duree) {
	this.duree = duree;
    }
}
