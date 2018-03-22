package com.xy.inc;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;

import com.xy.inc.business.BusinessException;
import com.xy.inc.business.IPontoInteresseBusiness;
import com.xy.inc.business.PontoInteresseBusiness;
import com.xy.inc.dao.DAOException;
import com.xy.inc.dao.PontoInteresseDAO;
import com.xy.inc.dto.DistanciaRequest;
import com.xy.inc.entity.PontoInteresse;

/**
 * Classe de Teste responsavel por garantir a cobertura de testes, referente aos
 * metodos presentes na classe {@link PontoInteresseBusiness}.
 *
 * @author bruno
 */
@RunWith(MockitoJUnitRunner.class)
public class PontoInteresseTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock(name = "pontoInteresseDao")
	private PontoInteresseDAO pontoInteresseDao;

	@Spy
	@InjectMocks
	private IPontoInteresseBusiness business = new PontoInteresseBusiness();

	@Before
	public void init() throws Exception {
	}

	// Evita repetição de codigo
	/**
	 * Metodo responsavel por instanciar um objeto do tipo PontoInteresse
	 * 
	 * @param codigo
	 * @return
	 */
	private PontoInteresse geraNewPontoInteresse(int codigo) {
		PontoInteresse pontoInteresse = new PontoInteresse();
		pontoInteresse.setCodigo(codigo);
		pontoInteresse.setNome("teste");
		pontoInteresse.setCoordenadaX(10);
		pontoInteresse.setCoordenadaY(10);
		return pontoInteresse;
	}

	/**
	 * Metodo responsavel por instancia um objeto do tipo DistanciaRequest
	 * 
	 * @return
	 */
	private DistanciaRequest geraNewDistanciaRequest() {
		DistanciaRequest distanciaRequest = new DistanciaRequest();
		distanciaRequest.setDistanciaMax(12);
		distanciaRequest.setDistanciaX(20);
		distanciaRequest.setDistanciaY(12);
		return distanciaRequest;
	}

	@Test
	public void stage01_readAllPontoInteresseSuccessTest() throws DAOException, BusinessException {
		// Prepara dados
		List<PontoInteresse> pontosInteresse = Arrays.asList(geraNewPontoInteresse(1));

		// Prepara Mock
		Mockito.doReturn(pontosInteresse).when(pontoInteresseDao).readAllPontoInteresse();

		// Executa teste
		List<PontoInteresse> result = business.readAllPontoInteresse();

		// Valida dados
		Assert.assertNotNull(result);
		Assert.assertTrue(!CollectionUtils.isEmpty(result));
	}

	@Test
	public void stage02_readAllPontoInteresseExceptionTest() throws DAOException, BusinessException {
		exception.expect(BusinessException.class);

		// Prepara Mock
		Mockito.doThrow(new DAOException()).when(pontoInteresseDao).readAllPontoInteresse();

		// Executa teste
		business.readAllPontoInteresse();
	}

	@Test
	public void stage03_readByDistanciaWhereDistanciaXNull() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("distanciaX invalida para pesquisa");

		// Prepara Dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaX(null);

		// Executa teste
		business.readByDistancia(request);
	}

	@Test
	public void stage04_readByDistanciaWhereDistanciaXNegativa() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("distanciaX invalida para pesquisa");

		// Prepara Dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaX(-1);

		// Executa teste
		business.readByDistancia(request);
	}

	@Test
	public void stage05_readByDistanciaWhereDistanciaYNull() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("distanciaY invalida para pesquisa");

		// Prepara Dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaY(null);

		// Executa teste
		business.readByDistancia(request);
	}

	@Test
	public void stage06_readByDistanciaWhereDistanciaYNegativa() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("distanciaY invalida para pesquisa");

		// Prepara Dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaY(-1);

		// Executa teste
		business.readByDistancia(request);
	}

	@Test
	public void stage07_readByDistanciaWhereDistanciaMaxNull() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("distanciaMax invalida para pesquisa");

		// Prepara Dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaMax(null);

		// Executa teste
		business.readByDistancia(request);
	}

	@Test
	public void stage08_readByDistanciaWhereDistanciaMaxNegativa() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("distanciaMax invalida para pesquisa");

		// Prepara Dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaMax(-1);

		// Executa teste
		business.readByDistancia(request);
	}

	@Test
	public void stage09_createSuccessTest() throws BusinessException, DAOException {
		// Prepara dados
		PontoInteresse pontosInteresse = geraNewPontoInteresse(1);

		// Prepara Mock
		Mockito.doReturn(pontosInteresse).when(pontoInteresseDao).create(pontosInteresse);

		// Executa teste
		PontoInteresse result = business.create(pontosInteresse);

		// Valida dados
		Assert.assertNotNull(result);
		Assert.assertEquals(pontosInteresse, result);
	}

	@Test
	public void stage10_createWhereCoordenadaXNegativa() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("coordenadaX invalida");

		// Prepara Dados
		PontoInteresse pontosInteresse = geraNewPontoInteresse(1);
		pontosInteresse.setCoordenadaX(-1);

		// Executa teste
		business.create(pontosInteresse);
	}

	@Test
	public void stage11_createWhereCoordenadaYNegativa() throws BusinessException {
		exception.expect(BusinessException.class);
		exception.expectMessage("coordenadaY invalida");

		// Prepara Dados
		PontoInteresse pontosInteresse = geraNewPontoInteresse(1);
		pontosInteresse.setCoordenadaY(-1);

		// Executa teste
		business.create(pontosInteresse);
	}

	@Test
	public void stage12_createExceptionTest() throws BusinessException, DAOException {
		exception.expect(BusinessException.class);

		// Prepara Dados
		PontoInteresse pontosInteresse = geraNewPontoInteresse(1);

		Mockito.doThrow(new DAOException()).when(pontoInteresseDao).create(pontosInteresse);

		// Executa teste
		business.create(pontosInteresse);
	}

	@Test
	public void stage13_readByDistanciaSuccesstest() throws DAOException, BusinessException {
		// Prepara dados
		List<PontoInteresse> pontosInteresse = Arrays.asList(geraNewPontoInteresse(1));

		// Prepara Mock
		Mockito.doReturn(pontosInteresse).when(pontoInteresseDao).readByDistancia(geraNewDistanciaRequest());

		// Executa teste
		List<PontoInteresse> result = business.readByDistancia(geraNewDistanciaRequest());

		// Valida dados
		Assert.assertNotNull(result);
	}

	@Test
	public void stage14_readByDistanciaWhereDistanciaMaxInvalida() throws DAOException, BusinessException {
		exception.expect(BusinessException.class);
		// Prepara dados
		DistanciaRequest request = geraNewDistanciaRequest();
		request.setDistanciaMax(22);
		// prepara mock
		Mockito.doThrow(new DAOException()).when(pontoInteresseDao).readByDistancia(geraNewDistanciaRequest());

		// Executa teste
		business.readByDistancia(request);
	}
}
