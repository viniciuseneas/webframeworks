package br.unipe.pos.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.unipe.pos.web.dao.RoleDAO;
import br.unipe.pos.web.dao.UsuarioDAO;
import br.unipe.pos.web.model.RoleModel;
import br.unipe.pos.web.model.UsuarioModel;

@Service("UsuarioService")
public class UsuarioService implements UsuarioServiceInterface, UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private RoleDAO roleDAO;
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
		return usuarioDAO.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.unipe.pos.web.service.UsuarioServiceInterface#findAll()
	 */
	@Override
	public List<UsuarioModel> findAll() {

		List<UsuarioModel> usuario = usuarioDAO.findAll();

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
		usuario.setAtivo(true);
		RoleModel role = roleDAO.findByRole("ADMIN");
		usuario.setRoles(new HashSet<RoleModel>(Arrays.asList(role)));
		usuarioDAO.save(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.unipe.pos.web.service.UsuarioServiceInterface#delete(int)
	 */
	@Override
	public void delete(Integer id) {
		usuarioDAO.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.unipe.pos.web.service.UsuarioServiceInterface#findOne(int)
	 */
	@Override
	public UsuarioModel findOne(Integer id) {

		UsuarioModel usuario = usuarioDAO.findOne(id);

		return usuario;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UsuarioModel usuario = usuarioDAO.findByEmail(email);
		List<GrantedAuthority> authorities = getUserAuthority(usuario.getRoles());

		return buildUserForAuthentication(usuario, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<RoleModel> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		
		for (RoleModel role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(UsuarioModel usuario, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(),
				usuario.isAtivo(), true, true, true, authorities);
	}

}
