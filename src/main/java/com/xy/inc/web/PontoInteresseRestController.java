package com.xy.inc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xy.inc.business.BusinessException;
import com.xy.inc.business.IPontoInteresseBusiness;
import com.xy.inc.dto.DistanciaRequest;
import com.xy.inc.entity.PontoInteresse;


/**
 * RestController 
 * @author bruno
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class PontoInteresseRestController {
	
	@Autowired
	private IPontoInteresseBusiness business;
	 
	@RequestMapping(value = "/api/pontointeresse/readByDistancia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readByDistancia(@RequestBody DistanciaRequest distanciaRequest)
			throws BusinessException {

		try {
			List<PontoInteresse> pontosInteresse = business.readByDistancia(distanciaRequest);

			return new ResponseEntity<List<PontoInteresse>>(pontosInteresse,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	
	@RequestMapping(value = "/api/pontointeresse/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createRestaurante(@RequestBody PontoInteresse pontoInteresse)
			throws BusinessException {

		try {
			business.create(pontoInteresse);

			return new ResponseEntity<Object[]>(new Object[] { pontoInteresse, "registro salvo com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/pontointeresse/readAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readAllPontosInteresse()
			throws BusinessException {
		
		try {
			List<PontoInteresse> pontoInteresse = business.readAllPontoInteresse();
			
			return new ResponseEntity<List<PontoInteresse>>(pontoInteresse,
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/pontointeresse/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePontoInteresse(@RequestBody PontoInteresse pontoInteresse)
			throws BusinessException {

		try {
			business.update(pontoInteresse);

			return new ResponseEntity<Object[]>(new Object[] { pontoInteresse, "registro atualizado com sucesso!" },
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
	@RequestMapping(value = "/api/pontointeresse/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePontoInteresse(@RequestBody PontoInteresse pontoInteresse)
			throws BusinessException {

		try {
			business.delete(pontoInteresse);

			return new ResponseEntity<String>("registro excluído com sucesso!",
					HttpStatus.OK);
		} catch (Exception ex) {
			throw new BusinessException(ex);
		}
	}
}
