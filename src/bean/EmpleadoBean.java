package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Empleado;
import model.TipoDocumento;
import serv.EmpleadoServ;
import serv.TipoDocumentoServ;

@ManagedBean
@SessionScoped
public class EmpleadoBean {
private int empl_id;
private String 
	empl_docu,
	empl_nomb,
	empl_apel,
	empl_espe,
	empl_telf,
	empl_dire;
private Character 
	empl_tipo,
	empl_esta;
private Date empl_fnac;
private TipoDocumento tipoDocumento;


private TipoDocumentoServ oTipoDocumentoServ = new TipoDocumentoServ();
private EmpleadoServ oEmpleadoServ = new EmpleadoServ();


private List<TipoDocumento> listaTipoDocumento;
private List<Empleado> listaEmpleado;

private int listaEmpleadoTamano;

private boolean sw_edit;

private int fila_seleccionada;


public void llenarCombos() throws Exception{
	listaTipoDocumento=oTipoDocumentoServ.listar();
}


public boolean accion_insertar() throws Exception{
	sw_edit=false;
	llenarCombos();
	return sw_edit;
}

public boolean accion_editar() throws Exception{
	sw_edit=true;
	llenarCombos();
	return sw_edit;
}

public void insertar() throws Exception{
	Empleado oEmpleado=new Empleado();
	oEmpleado.setEmpl_docu(empl_docu);
	oEmpleado.setEmpl_nomb(empl_nomb);
	oEmpleado.setEmpl_apel(empl_apel);
	oEmpleado.setEmpl_dire(empl_dire);
	oEmpleado.setEmpl_tipo(empl_tipo);
	oEmpleado.setEmpl_espe(empl_espe);
	oEmpleado.setEmpl_fnac(empl_fnac);
	oEmpleado.setEmpl_telf(empl_telf);
	oEmpleado.setEmpl_dire(empl_dire);
	oEmpleado.setTipoDocumento(tipoDocumento);
	oEmpleado.setEmpl_esta('A');
	Thread.sleep(4500);
	oEmpleadoServ.insertar(oEmpleado);
	limpiar();
}

public void limpiar(){
	setEmpl_id(0);
	setTipoDocumento(new TipoDocumento());
	setEmpl_docu(null);
	setEmpl_nomb(null);
	setEmpl_apel(null);
	setEmpl_tipo(null);
	setEmpl_espe(null);
	setEmpl_fnac(null);
	setEmpl_telf(null);
	setEmpl_dire(null);
	setEmpl_esta(null);
}
public void seleccionar(ActionEvent e) throws Exception
{
	String fila=e.getComponent().getAttributes().get("atributo_id").toString();
	System.out.println(fila);
	fila_seleccionada=Integer.parseInt(fila);
}

public void obtener_datos(ActionEvent e) throws Exception{
	seleccionar(e);
	accion_editar();
	Empleado em = new Empleado();
	em.setEmpl_id(fila_seleccionada);
	Empleado oEmpleado= oEmpleadoServ.obtener(em);
	setEmpl_id(oEmpleado.getEmpl_id());
	setTipoDocumento(oEmpleado.getTipoDocumento());
	setEmpl_docu(oEmpleado.getEmpl_docu());
	setEmpl_nomb(oEmpleado.getEmpl_nomb());
	setEmpl_apel(oEmpleado.getEmpl_apel());
	setEmpl_tipo(oEmpleado.getEmpl_tipo());
	setEmpl_espe(oEmpleado.getEmpl_espe());
	setEmpl_fnac(oEmpleado.getEmpl_fnac());
	setEmpl_telf(oEmpleado.getEmpl_telf());
	setEmpl_dire(oEmpleado.getEmpl_dire());
	setEmpl_esta(oEmpleado.getEmpl_esta());
	
	
}

public void modificar() throws Exception{
	Empleado oEmpleado = new Empleado();
	oEmpleado.setEmpl_id(empl_id);
	oEmpleado.setEmpl_docu(empl_docu);
	oEmpleado.setEmpl_nomb(empl_nomb);
	oEmpleado.setEmpl_apel(empl_apel);
	oEmpleado.setEmpl_dire(empl_dire);
	oEmpleado.setEmpl_tipo(empl_tipo);
	oEmpleado.setEmpl_espe(empl_espe);
	oEmpleado.setEmpl_fnac(empl_fnac);
	oEmpleado.setEmpl_telf(empl_telf);
	oEmpleado.setEmpl_dire(empl_dire);
	oEmpleado.setTipoDocumento(tipoDocumento);
	oEmpleado.setEmpl_esta('A');
	Thread.sleep(4500);
	oEmpleadoServ.actualizar(oEmpleado);
}

public void busqueda() throws Exception{
	Empleado oEmpleado = new Empleado();
	oEmpleado.setEmpl_nomb(empl_nomb);
	listaEmpleado=oEmpleadoServ.buscar(oEmpleado);
	listaEmpleadoTamano=listaEmpleado.size();
}

public void borrar() throws Exception{
	Empleado oEmpleado = new Empleado();
	oEmpleado.setEmpl_id(fila_seleccionada);
	oEmpleadoServ.eliminar(oEmpleado);
	busqueda();
	limpiar();
}

public int getEmpl_id() {
	return empl_id;
}
public void setEmpl_id(int empl_id) {
	this.empl_id = empl_id;
}
public String getEmpl_docu() {
	return empl_docu;
}
public void setEmpl_docu(String empl_docu) {
	this.empl_docu = empl_docu;
}
public String getEmpl_nomb() {
	return empl_nomb;
}
public void setEmpl_nomb(String empl_nomb) {
	this.empl_nomb = empl_nomb;
}
public String getEmpl_apel() {
	return empl_apel;
}
public void setEmpl_apel(String empl_apel) {
	this.empl_apel = empl_apel;
}
public String getEmpl_espe() {
	return empl_espe;
}
public void setEmpl_espe(String empl_espe) {
	this.empl_espe = empl_espe;
}
public String getEmpl_telf() {
	return empl_telf;
}
public void setEmpl_telf(String empl_telf) {
	this.empl_telf = empl_telf;
}
public String getEmpl_dire() {
	return empl_dire;
}
public void setEmpl_dire(String empl_dire) {
	this.empl_dire = empl_dire;
}
public Character getEmpl_tipo() {
	return empl_tipo;
}
public void setEmpl_tipo(Character empl_tipo) {
	this.empl_tipo = empl_tipo;
}
public Character getEmpl_esta() {
	return empl_esta;
}
public void setEmpl_esta(Character empl_esta) {
	this.empl_esta = empl_esta;
}
public Date getEmpl_fnac() {
	return empl_fnac;
}
public void setEmpl_fnac(Date empl_fnac) {
	this.empl_fnac = empl_fnac;
}
public TipoDocumento getTipoDocumento() {
	return tipoDocumento;
}
public void setTipoDocumento(TipoDocumento tipoDocumento) {
	this.tipoDocumento = tipoDocumento;
}



public TipoDocumentoServ getoTipoDocumentoServ() {
	return oTipoDocumentoServ;
}
public void setoTipoDocumentoServ(TipoDocumentoServ oTipoDocumentoServ) {
	this.oTipoDocumentoServ = oTipoDocumentoServ;
}
public EmpleadoServ getoEmpleadoServ() {
	return oEmpleadoServ;
}
public void setoEmpleadoServ(EmpleadoServ oEmpleadoServ) {
	this.oEmpleadoServ = oEmpleadoServ;
}
public List<TipoDocumento> getListaTipoDocumento() {
	return listaTipoDocumento;
}
public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
	this.listaTipoDocumento = listaTipoDocumento;
}
public List<Empleado> getListaEmpleado() {
	return listaEmpleado;
}
public void setListaEmpleado(List<Empleado> listaEmpleado) {
	this.listaEmpleado = listaEmpleado;
}
public int getListaEmpleadoTamano() {
	return listaEmpleadoTamano;
}
public void setListaEmpleadoTamano(int listaEmpleadoTamano) {
	this.listaEmpleadoTamano = listaEmpleadoTamano;
}
public boolean isSw_edit() {
	return sw_edit;
}
public void setSw_edit(boolean sw_edit) {
	this.sw_edit = sw_edit;
}
public int getFila_seleccionada() {
	return fila_seleccionada;
}
public void setFila_seleccionada(int fila_seleccionada) {
	this.fila_seleccionada = fila_seleccionada;
}
@PostConstruct
public void init() {
	tipoDocumento = new TipoDocumento();
}

}
