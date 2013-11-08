package org.javaconfig.impl.se;

import javax.config.Environment;
import javax.config.spi.EnvironmentContext;

public class SEEnvironmentProvider implements EnvironmentContext {

	private SEEnvironment seEnvironment = new SEEnvironment();

	@Override
	public Environment getCurrentEnvironment() {
		return seEnvironment;
	}

	@Override
	public Environment getSystemEnvironment() {
		return seEnvironment;
	}

}
