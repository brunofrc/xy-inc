package com.xy.inc.business;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xy.inc.dao.DAOException;
import com.xy.inc.dao.PontoInteresseDAO;
import com.xy.inc.dto.DistanciaRequest;
import com.xy.inc.entity.PontoInteresse;
/**
 * Classe onde estao implementados metodos especificos disponibilizados pela
 * camada de negocio, para manipulacao de objetos {@link PontoInteresse}.
 *
 * @author bruno
 */
@Component
@Transactional
public class PontoInteresseBusiness extends GenericBusiness<PontoInteresse, PontoInteresseDAO>
		implements IPontoInteresseBusiness {
	
	//Aplicacao das regras de negocio para criacao de um PontoInteresse sobre o metodo generico
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PontoInteresse create(PontoInteresse entity) throws BusinessException {
		if (entity.getCoordenadaX() < 0 ) {
			throw new BusinessException("coordenadaX invalida");
		}
		if (entity.getCoordenadaY() < 0) {
			throw new BusinessException("coordenadaY invalida");
		}
		return super.create(entity);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xy.inc.business.IPontoInteresseBusiness#readAllPontoInteresse()
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<PontoInteresse> readAllPontoInteresse() throws BusinessException {
		try {
			return getDAO().readAllPontoInteresse();
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xy.inc.business.IPontoInteresseBusiness#readByDistancia(com.xy.inc.dto.
	 * DistanciaRequest)
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<PontoInteresse> readByDistancia(DistanciaRequest request) throws BusinessException {
		try {
			if (request.getDistanciaX() == null||request.getDistanciaX() < 0 ) {
				throw new BusinessException("distanciaX invalida para pesquisa");
			}
			if (request.getDistanciaY() == null||request.getDistanciaY() < 0) {
				throw new BusinessException("distanciaY invalida para pesquisa");
			}
			if (request.getDistanciaMax()== null||request.getDistanciaMax() < 0) {
				throw new BusinessException("distanciaMax invalida para pesquisa");
			}
			// Como a coordenadaX e coordenadaY são inteiros não negativos, não podemos ter
			// uma distancia
			// maxima maior que as coordenadas de referencia,
			// pois poderia resultar em uma coordenada negativa
			if (request.getDistanciaMax() > request.getDistanciaX()
					&& request.getDistanciaMax() > request.getDistanciaY()) {
				throw new BusinessException("distanciaMax inválida");
			}
			return getDAO().readByDistancia(request);
		} catch (DAOException ex) {
			throw new BusinessException(ex);
		}
	}

}
