package org.javaconfig.model;

import java.util.Map;

import javax.config.Configuration;
import javax.config.ConfigurationModel;
import javax.config.EnvironmentSelector;

public abstract class AbstractConfigurationModel implements ConfigurationModel {

	private String name;
	private EnvironmentSelector environment;
	private Map<String, Configuration> configurations;

}
