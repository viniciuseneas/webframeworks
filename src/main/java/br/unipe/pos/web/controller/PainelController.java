package br.unipe.pos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.pos.web.model.UsuarioModel;
import br.unipe.pos.web.service.UsuarioService;

@Controller
@RequestMapping("/painel")
public class PainelController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index() {

		return "painel/login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String login(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UsuarioModel usuario = usuarioService.findUserByEmail(auth.getName());
		model.addAttribute("userName", "Welcome " + usuario.getNome() + " (" + usuario.getEmail() + ")");

		return "painel/home";
	}

	@RequestMapping(value = "/acesso-negado", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		return "redirect:/panel/login";
	}

}
