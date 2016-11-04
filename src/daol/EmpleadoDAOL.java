package daol;

import java.util.List;

import model.Empleado;

public interface EmpleadoDAOL {
 public abstract Empleado insertar(Empleado obj) throws Exception;
 public abstract List<Empleado> buscar (Empleado obj) throws Exception;
 public abstract void eliminar(Empleado obj) throws Exception;
 public abstract void actualizar (Empleado obj) throws Exception;
 public abstract Empleado obtener (Empleado obj) throws Exception;
}
