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
	 * Must remove all fields in which the values ​​are empty.
	 */
	@Test
	public void testMustRemoveAllFieldsInWhichTheValuesAreEmpty() {
		String log = "datetime=\"10/12/13 14:39:12.255\" appName=\"\" version=\"\" thread=\"pool-2-thread-1\" login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR";
		String logEsperado = "datetime=\"10/12/13 14:39:12.255\" thread=\"pool-2-thread-1\" login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR\n";
		String logRemovido = this.KeyValuePatternLayout.removeKeysWithBlankValues(log);
		Assert.assertEquals(logEsperado, logRemovido);
	}

	/**
	 * Should replace all double spaces with single spaces.
	 */
	@Test
	public void testShouldReplaceAllDoubleSpacesWithSingleSpaces() {
		String log = "datetime=\"10/12/13 14:39:12.255\"       appName=\"\"            version=\"\"           thread=\"pool-2-thread-1\"           login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR";
		String logEsperado = "datetime=\"10/12/13 14:39:12.255\" thread=\"pool-2-thread-1\" login=\"anonymous\" level=\"INFO\" logger=\"c.q.l.c.s.OnPrintStreamStatusListenerBase\" logline=\"62\" - 14:39:12,255 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [] to ERROR\n";
		String logRemovido = this.KeyValuePatternLayout.removeKeysWithBlankValues(log);
		Assert.assertEquals(logEsperado, logRemovido);
	}

}
