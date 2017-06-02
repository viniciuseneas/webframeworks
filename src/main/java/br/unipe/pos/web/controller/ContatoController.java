package br.unipe.pos.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.pos.web.model.ContatoModel;
import br.unipe.pos.web.service.ContatoService;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@RequestMapping("listar")
	public String index(Model model) {

		List<ContatoModel> contatos = contatoService.findAll();

		model.addAttribute("contatos", contatos);

		return "contato/listar";
	}

	@RequestMapping(value = "incluir", method = RequestMethod.GET)
	public String incluir(Model model) {

		ContatoModel contato = new ContatoModel();

		model.addAttribute("contato", contato);

		return "contato/form-contato";
	}

	@RequestMapping(value = "incluir", method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute("contato") ContatoModel contato, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("type", "error");
			model.addAttribute("errorMessage", "Erro ao tentar cadastrar!");

			return "contato/form-contato";
		}
		contatoService.save(contato);

		model.addAttribute("type", "success");
		model.addAttribute("message", "Cadastrado com sucesso!");

		return "redirect:/contato/listar";

	}

	@RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
	public String consultar(@PathVariable Integer id, Model model) {

		ContatoModel contato = contatoService.findOne(id);
		
		contatoService.save(contato);
		
		model.addAttribute("contato", contato);
		

		return "contato/editar";

	}
	
	@RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable Integer id) {

		
		return "redirect:/contato/listar";

	}

	@RequestMapping("excluir/{id}")
	public String remover(@PathVariable Integer id, Model model) {

		contatoService.delete(id);

		model.addAttribute("message", "Removido com sucesso!");

		return "redirect:/contato/listar";

	}

	/**
	 * @return the contatoService
	 */
	public ContatoService getContatoService() {
		return contatoService;
	}

	/**
	 * @param contatoService
	 *            the contatoService to set
	 */
	public void setContatoService(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
}
