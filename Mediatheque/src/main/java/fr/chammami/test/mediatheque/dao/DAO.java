package fr.chammami.test.mediatheque.dao;

import java.util.List;

import fr.chammami.test.mediatheque.models.Media;

public interface DAO<T> {
    List<Media> getAllMedias();

    Media getMediaById(Integer id);

    List<Media> getDvds();

    List<Media> getCds();

    List<Media> getLivres();
}
