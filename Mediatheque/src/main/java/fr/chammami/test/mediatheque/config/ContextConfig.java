package fr.chammami.test.mediatheque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.chammami.test.mediatheque.dao.AbstractDaoFactory;
import fr.chammami.test.mediatheque.dao.AbstractDaoFactory.TypeDao;
import fr.chammami.test.mediatheque.dao.DAO;
import fr.chammami.test.mediatheque.models.Media;

@Configuration
public class ContextConfig {

    @Bean
    public DAO<Media> csvFileMediaDao() {
	AbstractDaoFactory adf = AbstractDaoFactory.getFactory(TypeDao.FILE_DAO_FACTORY);

	return adf.getMediaDao();
    }
}
