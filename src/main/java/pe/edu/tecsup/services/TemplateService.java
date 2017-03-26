package pe.edu.tecsup.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.models.User;
import pe.edu.tecsup.repositories.TemplateRepository;

import java.util.List;

@Service
public class TemplateService {

	private static Logger log = Logger.getLogger(TemplateService.class);
	
	@Autowired
	private TemplateRepository templateDao;
	
	public List<User> list() {
		log.info("calling list: ");
		
		return templateDao.list();
	}

}
