package com.github.geub.kv.converter.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

public class KeyValuePatternLayoutEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {

	@Override
	public void start() {
		PatternLayout patternLayout = new KeyValuePatternLayout();
		patternLayout.setContext(this.context);
		patternLayout.setPattern(getPattern());
		patternLayout.setOutputPatternAsHeader(this.outputPatternAsHeader);
		patternLayout.start();
		this.layout = patternLayout;
		super.start();
	}

}
