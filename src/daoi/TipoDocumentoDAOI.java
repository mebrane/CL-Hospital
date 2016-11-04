package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.TipoDocumentoDAOL;
import model.TipoDocumento;
import model.TipoDocumento;
import util.Conexion;

public class TipoDocumentoDAOI implements TipoDocumentoDAOL {
Conexion cn = new Conexion();
	
	@Override
	public List<TipoDocumento> listar() throws Exception {
		// TODO Auto-generated method stub
		cn.abrir();
		List<TipoDocumento> lista = null;
		try {
			Query q = cn.em.createQuery("select td from TipoDocumento td");
			lista= q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.cerrar();
		}
		return lista;
	}

}
