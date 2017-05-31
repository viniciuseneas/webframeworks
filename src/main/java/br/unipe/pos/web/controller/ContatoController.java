package br.unipe.pos.web.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

		return "contato/listar";
	}

	@RequestMapping("incluir")
	public String incluir() {

		return "contato/form-contato";
	}

	@RequestMapping(value = "incluir", method = RequestMethod.POST)
	@ResponseBody
	public String salvar(@Valid ContatoModel contato, Model model, BindingResult result) {

		if (result.hasErrors()) {
			return "contato/form-contato";
		}
		
		if (repositorio.save(contato) == null) {

			model.addAttribute("type", "error");
			model.addAttribute("message", "Erro ao tentar cadastrar!");

		}
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
