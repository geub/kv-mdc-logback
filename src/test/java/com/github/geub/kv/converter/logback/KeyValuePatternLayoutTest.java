package com.github.geub.kv.converter.logback;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KeyValuePatternLayoutTest {

	private KeyValuePatternLayout KeyValuePatternLayout;

	@Before
	public void setUp() {
		this.KeyValuePatternLayout = new KeyValuePatternLayout();
	}

	/**
	 * Deve remover todos os campos em que os valores sejam vazios.
	 */
	@Test
	public void testDeveRemoverChaveComValorVazio() {
		String log = "datetime=\"10/12/13 14:39:12.255\" appName=\"\" version=\"\" thread=\"pool-2-thread-1\" login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR";
		String logEsperado = "datetime=\"10/12/13 14:39:12.255\" thread=\"pool-2-thread-1\" login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR\n";
		String logRemovido = this.KeyValuePatternLayout.removeKeysWithBlankValues(log);
		Assert.assertEquals(logEsperado, logRemovido);
	}

	/**
	 * Deve substituir todos os espaços duplos por espaços simples.
	 */
	@Test
	public void testDeveSubstituirEspacosDuplosPorSimpes() {
		String log = "datetime=\"10/12/13 14:39:12.255\"       appName=\"\"            version=\"\"           thread=\"pool-2-thread-1\"           login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR";
		String logEsperado = "datetime=\"10/12/13 14:39:12.255\" thread=\"pool-2-thread-1\" login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR\n";
		String logRemovido = this.KeyValuePatternLayout.removeKeysWithBlankValues(log);
		Assert.assertEquals(logEsperado, logRemovido);
	}

}