package pe.edu.tecsup.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.tecsup.models.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TemplateRestController {

	private static final Logger log = Logger.getLogger(TemplateRestController.class);

	@Autowired
	private pe.edu.tecsup.services.TemplateService TemplateService;

	@GetMapping("/users")
	public List<User> getUsers() throws Exception {
		log.info("calling getUsers");
		List<User> users = TemplateService.list();
//        return new ResponseEntity<>(users, HttpStatus.OK);
		return users;
	}

	@GetMapping("/message")
	public ResponseEntity<String> getMessage() throws Exception {
		log.info("calling getMessage");

		return new ResponseEntity<>("Registro guardado satisfactoriamente", HttpStatus.OK);
	}

}
