package fr.chammami.test.mediatheque.dao;

import fr.chammami.test.mediatheque.models.Media;

public abstract class AbstractDaoFactory {
    public enum TypeDao {
	// Type fichier, bdd, etc...
	FILE_DAO_FACTORY;
    }

    public abstract DAO<Media> getMediaDao();

    public static AbstractDaoFactory getFactory(TypeDao typeDao) {
	AbstractDaoFactory daoFactory;

	switch (typeDao) {
	case FILE_DAO_FACTORY:
	    daoFactory = new FileDaoFactory();
	    break;
	default:
	    daoFactory = null;
	}

	return daoFactory;
    }
}
