package com.xy.inc.business;

import com.xy.inc.dao.IGenericDAO;

/**
 * Interface de Negocio generica, onde estao definidos metodos genericos para
 * manipulacao de objetos.
 *
 * @author bruno
 */
public interface IGenericBusiness<E, DAO extends IGenericDAO> {
	/**
	 * Metodo responsavel por solicitar a camada de acesso a dados a persistencia de
	 * um objeto na base de dados
	 *
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	public E create(E entity) throws BusinessException;

	/**
	 * Metodo responsavel por solicitar a camada de acesso a dados a atualização de
	 * um objeto na base de dados
	 *
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	public E update(E entity) throws BusinessException;

	/**
	 * Metodo responsavel por solicitar a camada de acesso a dados a exclusão de um
	 * objeto na base de dados
	 *
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	public void delete(E entity) throws BusinessException;
}
