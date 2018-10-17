package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public interface UsuarioDao {

	public Usuario obtener(String login) throws IWDaoException;
}
