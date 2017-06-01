package br.unipe.pos.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.web.model.UsuarioModel;

@Repository("usuarioDAO")
public interface UsuarioDAO extends JpaRepository<UsuarioModel, Integer> {
	
	UsuarioModel findByEmail(String email);
	
	List<UsuarioModel> findAll();

	void delete(int id);

	UsuarioModel findOne(int id);

}
