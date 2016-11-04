package daoi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import daol.EmpleadoDAOL;
import model.Empleado;
import util.Conexion;

public class EmpleadoDAOI implements EmpleadoDAOL {

	Conexion cn = new Conexion();
	@Override
	public Empleado insertar(Empleado obj) throws Exception {

		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.flush();
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
		}
		return obj;
	}

	@Override
	public List<Empleado> buscar(Empleado obj) throws Exception {
		cn.abrir();
		
		String busqueda=obj.getEmpl_nomb();
		busqueda='%'+busqueda.toLowerCase() +'%';
		
		String sentencia= "select e, "
				+"e.tipoDocumento.tdoc_id "
				+"from Empleado e "
				+"where "
				+ "(lower(e.empl_nomb) like :busqueda "
				+"or lower(e.empl_apel) like :busqueda ) "
				+ "and e.empl_esta='A'";
		
	
		Query q= cn.em.createQuery(sentencia);
		
		q.setParameter("busqueda", busqueda);
		
		List<Object[]> lista_objetos =q.getResultList();

		
		List<Empleado> lista = new ArrayList<Empleado>();
		
		for(Object objs[]: lista_objetos){
			Empleado Empleado=(Empleado) objs[0];
			lista.add(Empleado);
		}

		return lista;
	}

	@Override
	public void eliminar(Empleado obj) throws Exception {
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			Empleado oEmpleado=cn.em.find(Empleado.class, obj.getEmpl_id());
			oEmpleado.setEmpl_esta('D');
			cn.em.merge(oEmpleado);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public void actualizar(Empleado obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public Empleado obtener(Empleado obj) throws Exception {
		// TODO Auto-generated method stub
		Empleado e=null;
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			e=cn.em.find(Empleado.class, obj.getEmpl_id());
			
			cn.em.getTransaction().commit();
			
		} catch (Exception ex) {
			cn.em.getTransaction().rollback();
			System.out.println(ex.getMessage());
			// TODO: handle exception
		}
		return e;
	
	}

}
