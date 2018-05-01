package fr.chammami.test.mediatheque.dao;

import java.util.List;

import fr.chammami.test.mediatheque.models.Media;
import fr.chammami.test.mediatheque.models.MediaFileObject;

public abstract class FileDao<T> implements DAO<T> {

    protected String path;

    protected FileDao() {
    }

    protected FileDao(String path) {
	this.path = path;
    }

    public String getPath() {
	return path;
    }

    protected abstract List<MediaFileObject> lireFichier();

    protected abstract List<Media> parseMediaFileToMedia(List<MediaFileObject> listMfo)
	    throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
