package com.xy.inc.dao;

/**
 * Interface generica de acesso a Base de dados, onde estao definidos metodos
 * genericos para manipulacao de objetos.
 *
 * @author bruno
 */
public interface IGenericDAO<E> {
	/**
	 * Metodo generico responsável por persistir uma entidade na base de dados
	 * @param entity
	 * @return entity
	 * @throws DAOException
	 */
	 public E create(E entity) throws DAOException;
	 /**
	  * Metodo generico responsavel por atualizar uma entidade na base de dados
	  * @param entity
	  * @return entity
	  * @throws DAOException
	  */
	 public E update(E entity) throws DAOException;
	 /**
	  * Metodo generico responsavel por excluir uma entidade na base de dados
	  * @param entity
	  * @throws DAOException
	  */
	 public void delete(E entity) throws DAOException;
}
