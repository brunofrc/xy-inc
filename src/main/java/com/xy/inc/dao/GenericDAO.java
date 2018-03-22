package com.xy.inc.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Classe generica de acesso a Base de dados, onde estao implementados metodos
 * genericos para manipulacao de objetos.
 *
 * @author bruno
 */
public class GenericDAO<E> implements IGenericDAO<E> {

	/**
	 * Session factory
	 */
	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * Metodo responsavel por recuperar o atributo sessionFactory
	 * 
	 * @return sessionFactory
	 */
	protected Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.dao.IGenericDAO#create(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E create(E entity) throws DAOException {

		try {

			getCurrentSession().save(entity);
			getCurrentSession().flush();

			return entity;
		} catch (ConstraintViolationException ex) {
			throw new DAOException(ex);
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.dao.IGenericDAO#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DAOException.class })
	public E update(E entity) throws DAOException {
		try {
			getCurrentSession().update(entity);
			getCurrentSession().flush();

			return entity;
		} catch (ConstraintViolationException ex) {
			throw new DAOException(ex);
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.dao.IGenericDAO#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DAOException.class })
	public void delete(E entity) throws DAOException {
		try {
			getCurrentSession().delete(entity);
			getCurrentSession().flush();
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}

	}
}
