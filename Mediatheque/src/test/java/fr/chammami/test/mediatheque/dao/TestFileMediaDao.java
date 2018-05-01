package fr.chammami.test.mediatheque.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.chammami.test.mediatheque.dao.AbstractDaoFactory.TypeDao;
import fr.chammami.test.mediatheque.models.CD;
import fr.chammami.test.mediatheque.models.DVD;
import fr.chammami.test.mediatheque.models.Livre;
import fr.chammami.test.mediatheque.models.Media;
import fr.chammami.test.mediatheque.models.MediaFileObject;

public class TestFileMediaDao {

    private static FileDao<Media> fileDao;
    private static AbstractDaoFactory adf;

    @BeforeClass
    public static void beforeClass() {
	adf = AbstractDaoFactory.getFactory(TypeDao.FILE_DAO_FACTORY);
	fileDao = (FileDao<Media>) adf.getMediaDao();
    }

    @Test
    public void testLireFichierOk() {
	int expectedValue = 5;
	List<MediaFileObject> listMfo = fileDao.lireFichier();

	listMfo.forEach(System.out::println);

	Assert.assertEquals(expectedValue, listMfo.size());
    }

    @Test
    public void testParseMediaFileToMediaLivreOK()
	    throws ClassNotFoundException, InstantiationException, IllegalAccessException {

	List<Media> listMedia = fileDao.parseMediaFileToMedia(fileDao.lireFichier());

	Media media = listMedia.get(0);

	Assert.assertTrue(media instanceof Livre);
    }

    @Test
    public void testParseMediaFileToMediaDvdOK()
	    throws ClassNotFoundException, InstantiationException, IllegalAccessException {

	List<Media> listMedia = fileDao.parseMediaFileToMedia(fileDao.lireFichier());

	Media media = listMedia.get(3);

	Assert.assertTrue(media instanceof DVD);
    }

    @Test
    public void testParseMediaFileToMediaCdKO()
	    throws ClassNotFoundException, InstantiationException, IllegalAccessException {

	List<Media> listMedia = fileDao.parseMediaFileToMedia(fileDao.lireFichier());

	Media media = listMedia.get(4);

	Assert.assertFalse(media instanceof CD);
    }

}
