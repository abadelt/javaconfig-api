package org.javaconfig.config;

import java.util.Collection;

import javax.config.ConfigurationModel;
import javax.config.Environment;

public interface ConfigurationMetaModel {

	public Collection<String> getModelIds();

	public boolean isModelDefined(String modelId);

	public ConfigurationModel createConfigurationModel(Environment environment);

}
