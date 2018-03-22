package com.xy.inc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xy.inc.dto.DistanciaRequest;
import com.xy.inc.entity.PontoInteresse;
/**
 * Classe de acesso a Base de dados, onde estao implementados metodos
 * especificos para manipulacao de objetos do tipo {@link PontoInteresse}.
 *
 * @author bruno
 */
@Repository
@Transactional
public class PontoInteresseDAO extends GenericDAO<PontoInteresse> implements IPontoInteresseDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.dao.IPontoInteresseDAO#readAllPontoInteresse()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PontoInteresse> readAllPontoInteresse() throws DAOException {
		try {
			Criteria criteria = getCurrentSession().createCriteria(PontoInteresse.class);
			return criteria.list();
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.dao.IPontoInteresseDAO#readByDistancia(com.xy.inc.dto.
	 * DistanciaRequest)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PontoInteresse> readByDistancia(DistanciaRequest request) throws DAOException {
		try {
			Criteria criteria = getCurrentSession().createCriteria(PontoInteresse.class);
			criteria.add(Restrictions.and(
					Restrictions.and(Restrictions.le("coordenadaX", request.getDistanciaX() + request.getDistanciaMax()),
							Restrictions.ge("coordenadaX", request.getDistanciaX() - request.getDistanciaMax())),
					Restrictions.and(Restrictions.le("coordenadaY", request.getDistanciaY() + request.getDistanciaMax()),
							Restrictions.ge("coordenadaY", request.getDistanciaY() - request.getDistanciaMax()))));
			return criteria.list();
		} catch (HibernateException ex) {
			throw new DAOException(ex);
		} catch (Exception ex) {
			throw new DAOException(ex);
		}
	}

}
