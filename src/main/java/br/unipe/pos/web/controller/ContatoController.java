package br.unipe.pos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.unipe.pos.web.dao.ContatoDAO;
import br.unipe.pos.web.model.ContatoModel;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoDAO repositorio;

	@RequestMapping("listar")
	public String index(Model model) {

		List<ContatoModel> contatos = repositorio.findAll();

		model.addAttribute("contatos", contatos);

		return "listar";
	}

	/**
	 * @return the repositorio
	 */
	public ContatoDAO getRepositorio() {
		return repositorio;
	}

	/**
	 * @param repositorio
	 *            the repositorio to set
	 */
	public void setRepositorio(ContatoDAO repositorio) {
		this.repositorio = repositorio;
	}

}
