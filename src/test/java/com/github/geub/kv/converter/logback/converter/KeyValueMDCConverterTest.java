package com.github.geub.kv.converter.logback.converter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KeyValueMDCConverterTest {

	private KeyValueMDCConverter converter;

	@Before
	public void setUp() {
		this.converter = new KeyValueMDCConverter();
	}

	/**
	 * Existe valor padr�o e o valor está nulo. Deve usar o valor padrão.
	 */
	@Test
	public void testChavePossuiValorPadraoEValorEstaNulo_DeveUsarValorPadrao() {
		String valor = null;
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		lista.add("anonymous");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"anonymous\"", chaveValor);

	}

	/**
	 * Existe valor padrão e o valor está vazio. Deve usar o valor padrão.
	 */
	@Test
	public void testChavePossuiValorPadraoEValorEstaVazio_DeveUsarValorPadrao() {
		String valor = "";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		lista.add("anonymous");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"anonymous\"", chaveValor);

	}

	/**
	 * Não existe valor padrão e o valor está vazio. Deve usar valor vazio.
	 */
	@Test
	public void testChaveNãoPossuiValorPadraoEValorEstaVazio_DeveUsarValorVazio() {
		String valor = "";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"\"", chaveValor);

	}

	/**
	 * Não existe valor padrão e o valor está preenchido. Deve usar valor preenchido.
	 */
	@Test
	public void testChaveNãoPossuiValorPadraoEValorEstaPreenchido_DeveUsarValorPreenchido() {
		String valor = "usu�rio";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"usu�rio\"", chaveValor);

	}

	/**
	 * Existe valor padrão e o valor está preenchido. Deve usar valor preenchido.
	 */
	@Test
	public void testChavePossuiValorPadraoEValorEstaPreenchido_DeveUsarValorPreenchido() {
		String valor = "usu�rio";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		lista.add("anonymous");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"usu�rio\"", chaveValor);

	}

}
