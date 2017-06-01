package br.unipe.pos.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.pos.web.dao.ContatoDAO;
import br.unipe.pos.web.model.ContatoModel;

@Service("contatoService")
public class ContatoService implements ContatoServiceInterface {

	@Autowired
	private ContatoDAO contatoDAO;

	/**
	 * Listar todos
	 */
	@Override
	public List<ContatoModel> findAll() {

		List<ContatoModel> contato = contatoDAO.findAll();

		return contato;
	}

	/**
	 * Salvar registro
	 */
	@Override
	public void save(ContatoModel contato) {

		contatoDAO.save(contato);
	}

	/**
	 * Deletar registro
	 */
	@Override
	public void delete(int id) {
		contatoDAO.delete(id);
	}

	/**
	 * Pesquisar por um registro
	 */
	@Override
	public ContatoModel findOne(int id) {

		ContatoModel contato = contatoDAO.findOne(id);

		return contato;
	}
}
