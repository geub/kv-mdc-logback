package com.github.geub.kv.mdc.logback.converter;

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
	 * There default value and the value is null. Should use the default value.
	 */
	@Test
	public void testThereDefaultValueAndTheValueIsNull_ShouldUseTheDefaultValue() {
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		lista.add("anonymous");
		String chaveValor = this.converter.getValueKey(lista, null);
		Assert.assertEquals("login=\"anonymous\"", chaveValor);

	}

	/**
	 * There default value and the value is empty. Should use the default value.
	 */
	@Test
	public void testThereDefaultValueAndTheValueIsEmpty_ShouldUseTheDefaultValue() {
		String valor = "";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		lista.add("anonymous");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"anonymous\"", chaveValor);

	}

	/**
	 * No default value exists and the value is empty. Must use empty value.
	 */
	@Test
	public void testNoDefaultValueExistsAndTheValueIsEmpty_MustUseEmptyValue() {
		String valor = "";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"\"", chaveValor);

	}

	/**
	 * No default value exists and the value is filled. Must use value filled.
	 */
	@Test
	public void testNoDefaultValueExistsAndTheValueIsFilled_MustUseValueFilled() {
		String valor = "user";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"user\"", chaveValor);

	}

	/**
	 * There default value and the value is filled. Must use value filled.
	 */
	@Test
	public void testThereDefaultValueAndTheValueIsFilled_MustUseValueFilled() {
		String valor = "user";
		List<String> lista = new ArrayList<String>();
		lista.add("login");
		lista.add("anonymous");
		String chaveValor = this.converter.getValueKey(lista, valor);
		Assert.assertEquals("login=\"user\"", chaveValor);

	}

}
