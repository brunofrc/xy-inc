package com.xy.inc.dto;
/**
 * DTO responsavel por instanciar um objeto json de request do metodo ReadbyDistancia
 * @author bruno
 *
 */
public class DistanciaRequest {
	/**
	 * coordenada de referencia x
	 */
	private Integer distanciaX;
	/**
	 * coordenada de referencia y
	 */
	private Integer distanciaY;
	/**
	 * distancia maxima
	 */
	private Integer distanciaMax;

	/**
	 * Metodo responsavel por recuperar a propriedade distanciaX
	 * 
	 * @return distanciaX
	 */
	public Integer getDistanciaX() {
		return distanciaX;
	}

	/**
	 * Metodo responsavel por alterar a propriedade distanciaX
	 * 
	 * @param distanciaX
	 */
	public void setDistanciaX(Integer distanciaX) {
		this.distanciaX = distanciaX;
	}

	/**
	 * Metodo responsavel por recuperar a propriedade distanciaY
	 * 
	 * @return distanciaY
	 */
	public Integer getDistanciaY() {
		return distanciaY;
	}

	/**
	 * Metodo responsavel por alterar a propriedade distanciaY
	 * 
	 * @param distanciaY
	 */
	public void setDistanciaY(Integer distanciaY) {
		this.distanciaY = distanciaY;
	}

	/**
	 * Metodo responsavel por recuperar a propriedade distanciaMax
	 * 
	 * @return distanciaMax
	 */
	public Integer getDistanciaMax() {
		return distanciaMax;
	}

	/**
	 * Metodo responsavel por alterar a propriedade distanciaMax
	 * 
	 * @param distanciaMax
	 */
	public void setDistanciaMax(Integer distanciaMax) {
		this.distanciaMax = distanciaMax;
	}
}
