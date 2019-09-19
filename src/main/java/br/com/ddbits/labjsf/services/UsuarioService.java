package br.com.ddbits.labjsf.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.ddbits.labjsf.entity.Usuario;

@Stateless
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "default")
	EntityManager em;

	public Usuario salvar(Usuario usuario) {
		return em.merge(usuario);
	}

	public void delete(Usuario usuario) {
		em.remove(salvar(usuario));
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> all() {
		final Query query = em.createNamedQuery("Usuario.findAll");
		return query.getResultList();

	}

}