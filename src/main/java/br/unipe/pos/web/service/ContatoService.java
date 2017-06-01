package br.unipe.pos.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.pos.web.dao.ContatoDAO;
import br.unipe.pos.web.model.ContatoModel;

@Service("contatoService")
public class ContatoService implements ContatoServiceInterface {

	@Autowired
	private ContatoDAO repositorio;

	/**
	 * Listar todos
	 */
	@Override
	public List<ContatoModel> findAll() {

		List<ContatoModel> contato = repositorio.findAll();

		return contato;
	}

	/**
	 * Salvar registro
	 */
	@Override
	public void save(ContatoModel contato) {

		repositorio.save(contato);
	}

	/**
	 * Deletar registro
	 */
	@Override
	public void delete(int id) {
		repositorio.delete(id);
	}

	/**
	 * Pesquisar por um registro
	 */
	@Override
	public ContatoModel findOne(int id) {

		ContatoModel contato = repositorio.findOne(id);

		return contato;
	}
}
