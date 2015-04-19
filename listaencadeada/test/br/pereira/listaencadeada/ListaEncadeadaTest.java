package br.pereira.listaencadeada;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListaEncadeadaTest {

	private ListaEncadeada<String> lista;

	@Before
	public void iniciar() {
		lista = new ListaEncadeada<String>();
	}

	@Test
	public void quando_inserir_um_unico_elemento_na_lista_listar_unico_elemento() {
		lista.adicionar("elemento");
		String resultado = lista.listar();
		Assert.assertEquals("[elemento]", resultado);
	}

	@Test
	public void quando_lista_for_vazia_nao_listar_nada() {
		String resultado = lista.listar();
		Assert.assertEquals("", resultado);
	}

	@Test
	public void quando_inserir_varios_elementos_listar_elementos_separados_por_virgula_e_ordenados_em_ordem_alfabetica() {
		lista.adicionar("elemento2");
		lista.adicionar("elemento1");
		lista.adicionar("elemento3");

		String resultado = lista.listar();

		Assert.assertEquals("[elemento1][elemento2][elemento3]", resultado);
	}

}