package com.github.geub.kv.mdc.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import com.github.geub.kv.mdc.logback.converter.KeyValueMDCConverter;

public class KeyValuePatternLayout extends PatternLayout {

	static {
		PatternLayout.defaultConverterMap.put("KV", KeyValueMDCConverter.class.getName());
	}

	private static final String EMPTY = "";
	private static final String PATTERN_EMPTY_VALUE = "[\\w\\d]+=\"\"";
	private static final String NEW_LINE = "\n";

	@Override
	public String doLayout(ILoggingEvent event) {
		return removeKeysWithBlankValues(super.doLayout(event));
	}

	protected String removeKeysWithBlankValues(String log) {
		String s = log.replaceAll(KeyValuePatternLayout.PATTERN_EMPTY_VALUE, KeyValuePatternLayout.EMPTY);
		return s.trim().replaceAll("[ ]+", " ") + KeyValuePatternLayout.NEW_LINE;

	}

}
