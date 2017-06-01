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
	private ContatoService repositorio;

	@RequestMapping("listar")
	public String index(Model model) {

		List<ContatoModel> contatos = repositorio.findAll();

		model.addAttribute("contatos", contatos);

		return "contato/listar";
	}

	@RequestMapping("incluir")
	public String incluir() {

		return "contato/form-contato";
	}

	@RequestMapping(value = "incluir", method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute("contato") ContatoModel contato, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("type", "error");
			model.addAttribute("message", "Erro ao tentar cadastrar!");

			return "contato/form-contato";
		}
		repositorio.save(contato);

		model.addAttribute("type", "success");
		model.addAttribute("message", "Cadastrado com sucesso!");

		return "redirect:contato/list";

	}

	@RequestMapping("consultar/{id}")
	public String consultar(@PathVariable(name = "id") int id) {

		ContatoModel contato = repositorio.findOne(id);

		if (contato != null) {
			return contato.toString();
		}

		return "Sem resultado";

	}

	@RequestMapping("remover/{id}")
	public String remover(@PathVariable(name = "id") int id, Model model) {

		repositorio.delete(id);
		model.addAttribute("success", "Cadastrado com sucesso!");

		return "redirect:/contato/list";

	}

	/**
	 * @return the repositorio
	 */
	public ContatoService getRepositorio() {
		return repositorio;
	}

	/**
	 * @param repositorio
	 *            the repositorio to set
	 */
	public void setRepositorio(ContatoService repositorio) {
		this.repositorio = repositorio;
	}

}
