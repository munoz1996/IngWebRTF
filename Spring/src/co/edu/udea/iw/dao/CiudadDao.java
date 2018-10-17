	package co.edu.udea.iw.dao;

	import java.util.List;

	import co.edu.udea.iw.dto.Ciudad;
	import co.edu.udea.iw.exception.IWDaoException;

	/**
	 * Interface que define los metodos que va a proveer el dao de ciudad
	 * @author Sebastian
	 *
	 */

	public interface CiudadDao {
		
		/**
		 * Entrega la lista de ciudades desde la base de datos
		 * @return lista de ciudades 
		 * @throws IWDaoException Ocurre un error en la conexion
		 */

		public List<Ciudad> obtener() throws IWDaoException;
		
		/**
		 * Entrega los datos de una ciudad dado si codigo
		 * @param codigo de la ciudad a consultar
		 * @return una instancia de los datos de la ciudad obtenid, si no existe 
		 * una ciudad con el codigo dado retorna null
		 * @throws IWDaoException ocurre un error con la base de datos
		 */
		public Ciudad obtenerCiudad(Integer codigo) throws IWDaoException;
		
	
	}

