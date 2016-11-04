package daol;

import java.util.List;

import model.TipoDocumento;

public interface TipoDocumentoDAOL {

	public abstract List<TipoDocumento> listar() throws Exception;
}
