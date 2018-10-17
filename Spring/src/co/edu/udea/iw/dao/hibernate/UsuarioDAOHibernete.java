package co.edu.udea.iw.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public class UsuarioDAOHibernete extends HibernateDaoSupport implements UsuarioDao {

	@Override
	public Usuario obtener(String login) throws IWDaoException {
		
		Session session = null;
	    Usuario usuario = null;
        
	    try {
	    	session = getSession();
	    	
	    	usuario = (Usuario)session.load(Usuario.class, login);
	    }catch(HibernateException e){
	    	throw new IWDaoException(e);
	    }
	    
	    return usuario;
	}

}
