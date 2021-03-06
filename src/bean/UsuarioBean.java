package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Empleado;
import model.Usuario;
import serv.UsuarioServ;
import util.Paginas;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private int user_id;
	private String user_user,user_pass;
	private Character user_esta;
	private Empleado oEmpleado;
	
	Usuario obj = new Usuario();
	UsuarioServ oUsuarioServ = new UsuarioServ();
	
	private List<Usuario> lista;
	
	
	Paginas pag=new Paginas();

	
	public String validar()throws Exception{
		String val=pag.pagina_error;
		Usuario oUsuario = new Usuario();
		oUsuario.setUser_user(getUser_user());
		oUsuario.setUser_pass(getUser_pass());
		obj=oUsuarioServ.validar(oUsuario);
		Thread.sleep(4500);
		if(obj!=null && obj.getUser_user()!=null){
			val=pag.pagina_principal;
			setUser_user(obj.getUser_user());
			setUser_pass(obj.getUser_pass());
		}
		return val;
	}
	
	public void limpiar() {
		setUser_id(0);
		setUser_user(null);
		setUser_pass(null);
		setUser_esta(null);
		setoEmpleado(new Empleado());
	}
	
	

	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_user() {
		return user_user;
	}


	public void setUser_user(String user_user) {
		this.user_user = user_user;
	}


	public String getUser_pass() {
		return user_pass;
	}


	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public Character getUser_esta() {
		return user_esta;
	}


	public void setUser_esta(Character user_esta) {
		this.user_esta = user_esta;
	}


	public Empleado getoEmpleado() {
		return oEmpleado;
	}


	public void setoEmpleado(Empleado oEmpleado) {
		this.oEmpleado = oEmpleado;
	}


	public Usuario getObj() {
		return obj;
	}


	public void setObj(Usuario obj) {
		this.obj = obj;
	}


	public UsuarioServ getoUsuarioServ() {
		return oUsuarioServ;
	}


	public void setoUsuarioServ(UsuarioServ oUsuarioServ) {
		this.oUsuarioServ = oUsuarioServ;
	}


	public List<Usuario> getLista() {
		return lista;
	}


	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}


	public Paginas getPag() {
		return pag;
	}


	public void setPag(Paginas pag) {
		this.pag = pag;
	}
	
	
	
	
}
