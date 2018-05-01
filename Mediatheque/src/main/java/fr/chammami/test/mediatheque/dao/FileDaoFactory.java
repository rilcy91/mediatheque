package fr.chammami.test.mediatheque.dao;

import java.util.ResourceBundle;

import fr.chammami.test.mediatheque.models.Media;

public class FileDaoFactory extends AbstractDaoFactory {

    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("application");

    // Récupération du path dans les properties
    private static final String PATH = CONFIG.getString("fichier.source");

    @Override
    public DAO<Media> getMediaDao() {
	return new CsvFileMediaDao(PATH);
    }

}
