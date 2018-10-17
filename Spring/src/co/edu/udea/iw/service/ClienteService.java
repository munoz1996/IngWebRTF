package co.edu.udea.iw.service;



import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.functors.FalsePredicate;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;


public class ClienteService {
	
	private ClienteDao clienteDao;
	private UsuarioDao usuarioDao;
	
	public void guardaCliente(String cedula, String nombres, String apellidos, 
			String correoElectronico, String usuarioCrea) throws IWDaoException, IWServiceException{
		
		
        Cliente cliente = null;

		if(cedula == null && "".equals(cedula)) {
			throw new IWServiceException("la cedula del cliente no puede se nula, ni una cadena de caracteres vacia");
			
		}
		if(nombres == null && "".equals(nombres)) {
			throw new IWServiceException("los nombres del cliente no puede se nula, ni una cadena de caracteres vacia");
		}	
		if(apellidos == null && "".equals(apellidos)) {
			throw new IWServiceException("los apellidos del cliente no puede se nula, ni una cadena de caracteres vacia");
		}	
		if(correoElectronico == null && "".equals(correoElectronico)) {
			throw new IWServiceException("El correo electronico del cliente no puede se nula, ni una cadena de caracteres vacia");
		}	
		if(usuarioCrea == null && "".equals(usuarioCrea)) {
			throw new IWServiceException("los nombres del cliente no puede se nula, ni una cadena de caracteres vacia");
		}	
		
		Usuario usuario = usuarioDao.obtener(usuarioCrea);
		if(usuario== null) {
			throw new IWServiceException("El usuario que crea el cliente debe ser un usuario del sistema");
		}
		
		cliente = new Cliente();
		
		cliente.setCedula(cedula);
		cliente.setNombre(nombres);
		cliente.setApellidos(apellidos);
		cliente.setCorreoElectronico(correoElectronico);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean,FALSE);

		clienteDao.insertar(cliente);
  }
	
	public List<Cliente> obtener() throws IWDaoException, IWServiceException {
		return clienteDao.obtener();
		}	
	public Cliente obtener (String cedula) throws IWDaoException, IWServiceException{
		if(cedula == null && "".equals(cedula)) {
			throw new IWServiceException("la cedula del cliente a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		return clienteDao.obtener(cedula);
		}
	
	}
