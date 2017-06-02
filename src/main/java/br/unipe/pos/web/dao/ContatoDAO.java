package br.unipe.pos.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.web.model.ContatoModel;

@Repository("contatoDAO")
public interface ContatoDAO extends JpaRepository<ContatoModel, Integer> {
	
	List<ContatoModel> findAll();

	void delete(Integer id);
	
	void update(ContatoModel contato);

	ContatoModel findOne(Integer id);

}
