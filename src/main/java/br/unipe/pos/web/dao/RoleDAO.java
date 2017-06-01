package br.unipe.pos.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.web.model.RoleModel;

@Repository("roleDAO")
public interface RoleDAO extends JpaRepository<RoleModel, Integer> {

	RoleModel findByRole(String role);
}
