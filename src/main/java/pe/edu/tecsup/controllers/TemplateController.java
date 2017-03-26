package pe.edu.tecsup.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;
import pe.edu.tecsup.models.User;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TemplateController {

	private static final Logger log = Logger.getLogger(TemplateController.class);

	@Autowired
	private pe.edu.tecsup.services.TemplateService TemplateService;

	@GetMapping("/")
	public String index(Model model) throws Exception {
		log.info("calling index");

		List<User> users = TemplateService.list();
		model.addAttribute("users", users);

        //hack for Thymeleaf plugin - duplicate model properties: https://youtrack.jetbrains.com/issue/IDEA-132738#u=1464285487161
        if (false) {
            WebContext context = new WebContext(null, null, null);
            context.setVariable("users", users);
        }

		return "index";
	}

}
