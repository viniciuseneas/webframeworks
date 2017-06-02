package br.unipe.pos.web.service;

import java.util.List;

import br.unipe.pos.web.model.UsuarioModel;

public interface UsuarioServiceInterface {

	public UsuarioModel findUserByEmail(String email);

	public List<UsuarioModel> findAll();

	public void save(UsuarioModel usuario);

	public void delete(Integer id);

	public UsuarioModel findOne(Integer id);

}
