package br.unipe.pos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/painel")
public class PainelController {

	@RequestMapping("login")
	public String index() {

		return "painel/login";
	}

}
