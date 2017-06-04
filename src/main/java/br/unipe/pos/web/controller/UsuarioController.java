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

import br.unipe.pos.web.model.UsuarioModel;
import br.unipe.pos.web.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("listar")
	public String index(Model model) {

		List<UsuarioModel> usuarios = usuarioService.findAll();

		model.addAttribute("usuarios", usuarios);

		return "usuario/listar";
	}

	@RequestMapping(value = "incluir", method = RequestMethod.GET)
	public String incluir(Model model) {

		UsuarioModel usuario = new UsuarioModel();

		model.addAttribute("usuario", usuario);

		return "usuario/form-usuario";
	}

	@RequestMapping(value = "incluir", method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute("usuario") UsuarioModel usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("type", "error");
			model.addAttribute("message", "Erro ao tentar cadastrar!");

			return "usuario/form-usuario";
		}
		usuarioService.save(usuario);

		model.addAttribute("type", "success");
		model.addAttribute("message", "Cadastrado com sucesso!");

		return "redirect:usuario/listar";

	}

	@RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
	public String consultar(@PathVariable Integer id, Model model) {

		UsuarioModel usuario = usuarioService.findOne(id);

		model.addAttribute("usuario", usuario);

		return "usuario/editar";
	}

	@RequestMapping(value = "editar/{id}", method = RequestMethod.POST)
	public String editar(@PathVariable Integer id, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("type", "error");
			model.addAttribute("errorMessage", "Erro ao tentar editar!");

			return "usuario/editar";
		}

		UsuarioModel usuario = usuarioService.findOne(id);

		usuarioService.save(usuario);

		model.addAttribute("type", "success");
		model.addAttribute("message", "Editado com sucesso!");

		return "redirect:/usuario/listar";
	}

	@RequestMapping("remover/{id}")
	public String remover(@PathVariable Integer id, Model model) {

		usuarioService.delete(id);
		model.addAttribute("success", "Cadastrado com sucesso!");

		return "redirect:/usuario/listar";

	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
