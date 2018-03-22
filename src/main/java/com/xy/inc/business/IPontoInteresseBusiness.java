package com.xy.inc.business;

import java.util.List;

import com.xy.inc.dao.PontoInteresseDAO;
import com.xy.inc.dto.DistanciaRequest;
import com.xy.inc.entity.PontoInteresse;
/**
 * Interface de Negocio, onde estao definidos metodos especificos para
 * manipulacao de objetos do tipo @Link{PontoInteresse}.
 *
 * @author bruno
 */
public interface IPontoInteresseBusiness extends IGenericBusiness<PontoInteresse,PontoInteresseDAO>{
	/**
	 * Metodo responsavel por garantir os parametros obrigatorio e suas validações, bem como solicitar
	 * a camada de acesso a dados que recupere os pontos de interesse com base nas coordenadas de referencia e distancia maxima
	 *
	 * @param request
	 * @return 
	 * @throws BusinessException
	 */
	public List<PontoInteresse> readByDistancia(DistanciaRequest request) throws BusinessException;
	
	/**
	 * Metodo responsavel por solicitar
	 * a camada de acesso a dados que recupere todos os pontos de interesse
	 * 
	 * @return 
	 * @throws BusinessException
	 */
	public List<PontoInteresse> readAllPontoInteresse() throws BusinessException;
}
