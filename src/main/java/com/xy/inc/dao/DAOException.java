package com.xy.inc.dao;
/**
 * Excecao a ser disparada sempre que ocorrer um erro na camada DAO
 * @author bruno
 *
 */
public class DAOException extends Exception {
	/**
	 * Construtor padrao
	 */
	public DAOException(){

		super();
	}

	/**
	 * Exception com tres parametros e um Throwable
	 * 
	 * @param arg0
	 *            String
	 * @param arg1
	 *            Throwable
	 * @param arg2
	 *            boolean
	 * @param arg3
	 *            boolean
	 */
	public DAOException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3){

		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * Exception com um parametro e um Throwable
	 * 
	 * @param arg0
	 *            String
	 * @param arg1
	 *            Throwable
	 */
	public DAOException(String arg0, Throwable arg1){

		super(arg0, arg1);
	}

	/**
	 * Exception com um parametro
	 * 
	 * @param arg0
	 *            String
	 */
	public DAOException(String arg0){

		super(arg0);
	}

	/**
	 * Exception com um Throwable
	 * 
	 * @param arg0
	 *            Throwable
	 */
	public DAOException(Throwable arg0){

		super(arg0);
	}

}
