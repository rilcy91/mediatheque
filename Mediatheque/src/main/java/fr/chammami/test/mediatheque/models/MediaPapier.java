package fr.chammami.test.mediatheque.models;

import com.opencsv.bean.CsvBindByName;

public abstract class MediaPapier extends Media {
    @CsvBindByName(column = "nb_pages")
    protected Integer nbPages;

    public Integer getNbPages() {
	return nbPages;
    }

    public void setNbPages(Integer nbPages) {
	this.nbPages = nbPages;
    }
}
