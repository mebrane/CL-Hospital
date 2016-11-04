package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cl_empleado")
public class Empleado {
	@Id
	@SequenceGenerator(name="cl_empleado_seq", allocationSize=1, initialValue=3)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cl_empleado_seq")  
	private int empl_id;
	@ManyToOne
	@JoinColumn(name="tdoc_id")
	private TipoDocumento tipoDocumento;
	private String empl_docu;
	private String empl_nomb,
		empl_apel, 
		empl_espe,
		empl_telf,
		empl_dire;
	private Character empl_tipo,empl_esta;
	@Temporal(TemporalType.DATE)
	private Date empl_fnac;
	public int getEmpl_id() {
		return empl_id;
	}
	public void setEmpl_id(int empl_id) {
		this.empl_id = empl_id;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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
	
	
}
