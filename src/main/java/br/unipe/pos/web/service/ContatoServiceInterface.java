package br.unipe.pos.web.service;

import java.util.List;

import br.unipe.pos.web.model.ContatoModel;

public interface ContatoServiceInterface {

	public List<ContatoModel> findAll();

	public void save(ContatoModel contato);

	public void delete(int id);

	public ContatoModel findOne(int id);

}
