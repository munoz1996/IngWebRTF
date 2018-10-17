package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface que describe los estados que un cliente puede realizar contra
 * la base de datos
 * @author Sebastian
 *
 */

public interface ClienteDao {
	
	/**
	 * crea un nuevo cliente en el sistema
	 * @param cliente intancia del cliente a crear
	 * @return cliente insertado 
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */

	public Cliente insertar(Cliente cliente) throws IWDaoException;
	
	/**
	 * Modifica la informacion de un cliente en el sistema
	 * @param cliente intancia del cliente con los datos a modificar
	 * @return cliente modificado
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	
	public Cliente modificar(Cliente cliente) throws IWDaoException;
	
	/**
	 * Elimina ogicamene un cliente en el sistema
	 * @param cliente instancia del cliente a eliminar
	 * @throws IWDaoException
	 */
	
	public Cliente eliminar(Cliente cliente) throws IWDaoException;
	
	/**
	 * Entrega la lista d elos cliente s activos en el sistemas
	 * @return lista de clientes
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	
	public List<Cliente> obtener() throws IWDaoException;
	
	/**
	 * Entrega la informacion de un cliente dada su cedula
	 * @param cedula identificacion del cliente 
	 * @return intancia con los datos del cliente
	 * @throws IWDaoException cuando ocurre cualquier error en la comunicacion con la BD
	 */
	
	public Cliente obtener(String cedula) throws IWDaoException;
}
