package br.unipe.pos.web.service;

import java.util.List;

import br.unipe.pos.web.model.UsuarioModel;

public interface UsuarioServiceInterface {

	public UsuarioModel findUserByEmail(String email);

	public List<UsuarioModel> findAll();

	public void save(UsuarioModel usuario);

	public void delete(int id);

	public UsuarioModel findOne(int id);

}
