package fr.chammami.test.mediatheque.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.chammami.test.mediatheque.dao.CsvFileMediaDao;
import fr.chammami.test.mediatheque.models.Media;

@RestController
@RequestMapping(value = "/mediatheque-api")
public class MediaController {
    @Autowired
    private CsvFileMediaDao csvFileMediaDao;

    @RequestMapping(value = "/media/{id}", method = RequestMethod.GET)
    public Media getMedia(@PathVariable Integer id) {
	return csvFileMediaDao.getMediaById(id);
    }

    @RequestMapping(value = "/listMedias", method = RequestMethod.GET)
    public List<Media> getListMedias() {
	return csvFileMediaDao.getAllMedias();
    }

    @RequestMapping(value = "/listLivres", method = RequestMethod.GET)
    public List<Media> getListLivres() {
	return csvFileMediaDao.getLivres();
    }

    @RequestMapping(value = "/listCds", method = RequestMethod.GET)
    public List<Media> getListCds() {
	return csvFileMediaDao.getCds();
    }

    @RequestMapping(value = "/listDvds", method = RequestMethod.GET)
    public List<Media> getListDvds() {
	return csvFileMediaDao.getDvds();
    }

}
