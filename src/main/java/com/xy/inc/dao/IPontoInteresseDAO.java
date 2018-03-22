package com.xy.inc.dao;

import java.util.List;

import com.xy.inc.dto.DistanciaRequest;
import com.xy.inc.entity.PontoInteresse;
/**
 * Interface de acesso a Base de dados, onde estao definidos metodos especificos
 * para manipulacao de objetos do tipo {@link PontoInteresse}.
 *
 * @author bruno
 */
public interface IPontoInteresseDAO extends IGenericDAO<PontoInteresse> {
	/**
	 * Metodo responsavel por recuperar todos os objetos do tipo PontoInteresse da
	 * camada DAO
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<PontoInteresse> readAllPontoInteresse() throws DAOException;

	/**
	 * Metodo responsavel por recuperar todos os objetos do tipo PontoInteresse da
	 * camda DAO com base nas coordenadas de referencia e distancia maxima
	 * 
	 * @param request
	 * @return
	 * @throws DAOException
	 */
	public List<PontoInteresse> readByDistancia(DistanciaRequest request) throws DAOException;
}
