package com.xy.inc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



/**
 * Classe responsavel pelo mapeamento do objeto PontoInteresse
 * 
 * @author bruno
 *
 */
@Entity
@Table(name = "TB_PONTO_INTERESSE", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_NOM_PONTO_INTERESSE", columnNames = { "NOM_PONTO_INTERESSE" }) })
@SequenceGenerator(name = "SQ_PONTO_INTERESSE", sequenceName = "SQ_PONTO_INTERESSE", allocationSize = 1, initialValue = 1)
public class PontoInteresse {

	@Column(name = "COD_PONTO_INTERESSE")
	@Id
	@GeneratedValue(generator = "SQ_PONTO_INTERESSE", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "NOM_PONTO_INTERESSE", length = 100, nullable = false)
	private String nome;

	@Column(name = "COORDENADA_X", length = 100, nullable = false)
	private Integer coordenadaX;
	
	@Column(name = "COORDENADA_Y", length = 100, nullable = false)
	private Integer coordenadaY;


	/**
	 * Metodo responsavel por recuperar a propriedade nome
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo responsavel por alterar a propriedade nome
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade codigo
	 * 
	 * @return codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * Metodo responsavel por alterar a propriedade codigo
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade coordenadaX
	 * 
	 * @return coordenadaX
	 */
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	/**
	 * Metodo responsavel por alterar a propriedade coordenadaX
	 * 
	 * @param coordenadaX
	 */
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade coordenadaY
	 * 
	 * @return coordenadaY
	 */
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	/**
	 * Metodo responsavel por alterar a propriedade coordenadaY
	 * 
	 * @param coordenadaY
	 */
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
}