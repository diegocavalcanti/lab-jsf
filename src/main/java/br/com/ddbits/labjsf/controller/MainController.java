package br.com.ddbits.labjsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.ddbits.labjsf.entity.Usuario;
import br.com.ddbits.labjsf.services.UsuarioService;

@ManagedBean(name="mainController")
@RequestScoped
public class MainController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8475388044238859816L;
	
	private String nome;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario ;
	
	@PostConstruct
	public void init() {
		setUsuario(new Usuario());
		System.out.println("Inicio do Manage Bean");
	}
	
	
	public void actionGravarUsuario() {		
		
	  usuarioService.salvar(this.getUsuario() );
	  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" salvou usuário "));
		
	}
	
	public void actionApagarUsuario() {		
		
		  usuarioService.delete(this.getUsuario() );
		  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("  usuário excluido "));
			
		}
	
	public List<Usuario> getListaUsuarios(){
		return usuarioService.all(); 
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
