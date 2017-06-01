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

	@RequestMapping("incluir")
	public String incluir() {

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

	@RequestMapping("consultar/{id}")
	public String consultar(@PathVariable(name = "id") int id) {

		UsuarioModel usuario = usuarioService.findOne(id);

		if (usuario != null) {
			return usuario.toString();
		}

		return "Sem resultado";

	}

	@RequestMapping("remover/{id}")
	public String remover(@PathVariable(name = "id") int id, Model model) {

		usuarioService.delete(id);
		model.addAttribute("success", "Cadastrado com sucesso!");

		return "redirect:/usuario/listar";

	}

}
