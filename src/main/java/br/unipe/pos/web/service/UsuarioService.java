package br.unipe.pos.web.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.unipe.pos.web.dao.RoleDAO;
import br.unipe.pos.web.dao.UsuarioDAO;
import br.unipe.pos.web.model.RoleModel;
import br.unipe.pos.web.model.UsuarioModel;

@Service("UsuarioService")
public class UsuarioService implements UsuarioServiceInterface {

	@Autowired
	private UsuarioDAO usuarioRepository;
	@Autowired
	private RoleDAO roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.unipe.pos.web.service.UsuarioServiceInterface#findUserByEmail(java.
	 * lang.String)
	 */
	@Override
	public UsuarioModel findUserByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.unipe.pos.web.service.UsuarioServiceInterface#findAll()
	 */
	@Override
	public List<UsuarioModel> findAll() {

		List<UsuarioModel> usuario = usuarioRepository.findAll();

		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.unipe.pos.web.service.UsuarioServiceInterface#save(br.unipe.pos.web.
	 * model.UsuarioModel)
	 */
	@Override
	public void save(UsuarioModel usuario) {

		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));

		RoleModel role = roleRepository.findByRole("ADMIN");
		usuario.setRoles(new HashSet<RoleModel>(Arrays.asList(role)));
		usuarioRepository.save(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.unipe.pos.web.service.UsuarioServiceInterface#delete(int)
	 */
	@Override
	public void delete(int id) {
		usuarioRepository.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.unipe.pos.web.service.UsuarioServiceInterface#findOne(int)
	 */
	@Override
	public UsuarioModel findOne(int id) {

		UsuarioModel usuario = usuarioRepository.findOne(id);

		return usuario;
	}

}
