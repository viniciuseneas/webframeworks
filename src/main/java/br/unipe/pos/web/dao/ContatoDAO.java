package br.unipe.pos.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.web.model.ContatoModel;

@Repository
public interface ContatoDAO extends JpaRepository<ContatoModel, Integer> {

}
