package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.ClienteDao;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;

public class ClienteDAOHibernate extends HibernateDaoSupport implements ClienteDao {

	@Override
	public Cliente insertar(Cliente cliente) throws IWDaoException {
		  
			Transaction tx = null;
			Session session = null;
			try {
			    session = getSession();
			    
			    tx = session.beginTransaction();
			    session.save(cliente);
			    tx.commit();
			    
			}catch(HibernateException e){
				throw new IWDaoException(e);
			}finally{
				session.close();
			}
			
			return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		    session = getSession();
		    
		    tx = session.beginTransaction();
		    session.update(cliente);
		    tx.commit();
		    
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}finally{
			session.close();
		}
		
		return cliente;
	}

	@Override
	public Cliente eliminar(Cliente cliente) throws IWDaoException {
		Transaction tx = null;
		Session session = null;
		try {
		    session = getSession();
		    
		    tx = session.beginTransaction();
		    cliente.setEliminado(true);
		    cliente.setFechaEliminacion(new Date());
		    session.update(cliente);
		    tx.commit();
		    
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}finally{
			session.close();
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> obtener() throws IWDaoException {
         List<Cliente> clientes = new ArrayList<Cliente>();
		
        Session session =null;
		try {
		session = getSession();
		
		Criteria  criteria = session.createCriteria(Cliente.class);
		
		clientes = criteria.list();
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}finally{
			session.close();
		}
		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws IWDaoException {
         Cliente cliente = null;
		
         Session session =null;
		try {
		    session = getSession();
		    
		    cliente = (Cliente)session.load(Cliente.class, cedula);
		
		    
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}finally{
			session.close();
		}
		return cliente;
	}

}
