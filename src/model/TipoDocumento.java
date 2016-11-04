package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cl_tipodocumento")
public class TipoDocumento {
	@Id
	@SequenceGenerator(name="cl_tipodocumento_seq", allocationSize=1, initialValue=3)
	private int tdoc_id;
	private String tdoc_nomb;
	public int getTdoc_id() {
		return tdoc_id;
	}
	public void setTdoc_id(int tdoc_id) {
		this.tdoc_id = tdoc_id;
	}
	public String getTdoc_nomb() {
		return tdoc_nomb;
	}
	public void setTdoc_nomb(String tdoc_nomb) {
		this.tdoc_nomb = tdoc_nomb;
	}
	
	
}
