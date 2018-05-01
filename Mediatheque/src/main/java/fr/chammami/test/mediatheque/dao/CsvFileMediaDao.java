package fr.chammami.test.mediatheque.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import fr.chammami.test.mediatheque.models.CD;
import fr.chammami.test.mediatheque.models.DVD;
import fr.chammami.test.mediatheque.models.Livre;
import fr.chammami.test.mediatheque.models.Media;
import fr.chammami.test.mediatheque.models.MediaFileObject;
import fr.chammami.test.mediatheque.models.enums.TypeMedia;
import fr.chammami.test.mediatheque.utils.FichierUtils;

@Repository
public class CsvFileMediaDao extends CsvFileDao<Media> {

    private static final Logger LOGGER = LogManager.getLogger(CsvFileMediaDao.class);

    private static final String LIST_SEPARATOR = ",";

    public CsvFileMediaDao() {
	super();
    }

    public CsvFileMediaDao(String path) {
	super(path);
    }

    public CsvFileMediaDao(String path, String separator) {
	super(path, separator);
    }

    @Override
    protected List<MediaFileObject> lireFichier() {
	Path pathObject = FichierUtils.getFichier(path);
	List<MediaFileObject> listMfo = null;

	try (Reader reader = Files.newBufferedReader(pathObject, StandardCharsets.UTF_8)) {

	    CsvToBean<MediaFileObject> csvMediaFile = new CsvToBeanBuilder<MediaFileObject>(reader)
		    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS).withType(MediaFileObject.class)
		    .withIgnoreLeadingWhiteSpace(true).withSeparator(';').build();

	    listMfo = csvMediaFile.parse();

	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	}

	return listMfo;
    }

    @Override
    protected List<Media> parseMediaFileToMedia(List<MediaFileObject> listMfo)
	    throws ClassNotFoundException, InstantiationException, IllegalAccessException {

	if (CollectionUtils.isEmpty(listMfo)) {
	    return null;
	}

	List<Media> listMedia = new ArrayList<>();
	AtomicInteger ai = new AtomicInteger(0);

	for (MediaFileObject mfo : listMfo) {
	    // Création de l'instanciation en fonction du type de Media
	    Class<?> c = Class.forName(
		    "fr.chammami.test.mediatheque.models." + TypeMedia.getEnumByLabel(mfo.getType()).getLabel());
	    Media media = (Media) c.newInstance();

	    media.setListAuteurs(Arrays.asList(mfo.getAuteurs().split(LIST_SEPARATOR)));
	    media.setDescription(mfo.getDescription());
	    media.setId(ai.incrementAndGet());
	    media.setTitre(mfo.getTitre());
	    media.setDateTimeAjout(
		    LocalDate.parse(mfo.getDateTimeAjout(), DateTimeFormatter.ofPattern(FichierUtils.DATE_PATTERN)));
	    media.setDateTimeSortie(
		    LocalDate.parse(mfo.getDateTimeSortie(), DateTimeFormatter.ofPattern(FichierUtils.DATE_PATTERN)));

	    if (TypeMedia.CD.toString().equals(mfo.getType())) {
		((CD) media).setListChanteurs(Arrays.asList(mfo.getChanteurs().split(LIST_SEPARATOR)));
		((CD) media).setListChansons(Arrays.asList(mfo.getListChansons().split(LIST_SEPARATOR)));
		((CD) media).setDuree(mfo.getDuree());

	    } else if (TypeMedia.DVD.toString().equals(mfo.getType())) {
		((DVD) media).setListActeurs(Arrays.asList(mfo.getListActeurs().split(LIST_SEPARATOR)));
		((DVD) media).setRealisateur(mfo.getRealisateur());
		((DVD) media).setDuree(mfo.getDuree());

	    } else if (TypeMedia.LIVRE.toString().equals(mfo.getType())) {
		((Livre) media).setChapitres(Arrays.asList(mfo.getListChapitres().split(LIST_SEPARATOR)));
		((Livre) media).setNbPages(mfo.getNbPages());

	    }

	    listMedia.add(media);
	}

	return listMedia;
    }

    @Override
    public List<Media> getAllMedias() {
	List<MediaFileObject> listMfo = lireFichier();

	if (CollectionUtils.isEmpty(listMfo)) {
	    return null;
	}

	List<Media> listMedia = new ArrayList<>();

	try {

	    listMedia.addAll(parseMediaFileToMedia(listMfo));

	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    LOGGER.error(e.getMessage());
	}

	return listMedia;
    }

    @Override
    public List<Media> getDvds() {
	List<Media> listMedias = getAllMedias();

	listMedias.removeIf(m -> !(m instanceof DVD));

	return listMedias;
    }

    @Override
    public List<Media> getCds() {
	List<Media> listMedias = getAllMedias();

	listMedias.removeIf(m -> !(m instanceof CD));

	return listMedias;
    }

    @Override
    public List<Media> getLivres() {
	List<Media> listMedias = getAllMedias();

	listMedias.removeIf(m -> !(m instanceof Livre));

	return listMedias;
    }

    @Override
    public Media getMediaById(Integer id) {
	List<Media> listMedias = getAllMedias();

	Media media = (Media) CollectionUtils.find(listMedias, (Object m) -> ((Media) m).getId() == id);

	return media;
    }
}
