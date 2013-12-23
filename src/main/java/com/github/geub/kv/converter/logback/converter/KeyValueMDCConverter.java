package com.github.geub.kv.converter.logback.converter;

import java.util.List;

import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import com.github.geub.kv.converter.logback.utils.StringUtils;

public class KeyValueMDCConverter extends MDCConverter {

	private static final int INDEX_MDC_KEY = 0;
	private static final int INDEX_DEFAULT_VALUE = 1;

	@Override
	public String convert(ILoggingEvent event) {
		String valor = super.convert(event);
		return getValueKey(getOptionList(), valor);
	}

	protected String getValueKey(List<String> list, String value) {
		boolean haveDefaultValue = list.size() > 1;
		if (!haveDefaultValue || StringUtils.isNotEmpty(value)) {
			return outputFormat(list, value);
		}
		return outputFormat(list, list.get(KeyValueMDCConverter.INDEX_DEFAULT_VALUE));
	}

	private String outputFormat(List<String> list, String value) {
		return String.format("%s=\"%s\"", list.get(KeyValueMDCConverter.INDEX_MDC_KEY), value);
	}

}
