package org.javaconfig.impl.se;

import java.util.Collection;

import javax.config.ConfigChangeListener;
import javax.config.ConfigService;
import javax.config.Configuration;
import javax.config.ConfigurationModel;
import javax.config.ConfigurationQuery;
import javax.config.ConfigurationUpdater;
import javax.config.Environment;
import javax.config.spi.EnvironmentContext;

import org.javaconfig.config.ConfigurationMetaModel;
import org.javaconfig.config.EnvironmentPropertiesConfigUnit;
import org.javaconfig.config.SimpleConfiguration;
import org.javaconfig.config.SimpleConfigurationModel;
import org.javaconfig.config.SystemPropertiesConfigUnit;

public class SEConfigurationService implements ConfigService {

	private ConfigurationContainer configurationModels = new ConfigurationContainer();
	private EnvironmentContext environmentProvider = loadEnvironmentProvider();
	private ConfigurationMetaModel metaModel = loadMetaModel();

	public SEConfigurationService() {
		ConfigurationModel systemModel = createSystemModel();
		Environment env = environmentProvider.getSystemEnvironment();
		configurationModels.addConfigModel(env, systemModel);
	}

	private ConfigurationMetaModel loadMetaModel() {
		// TODO Auto-generated method stub
		return null;
	}

	protected ConfigurationModel createSystemModel() {
		// TODO read meta config
		SimpleConfigurationModel model = new SimpleConfigurationModel(
				"instance");
		Configuration config = new SimpleConfiguration("properties",
				new SystemPropertiesConfigUnit());
		model.addConfiguration(config, "system");
		config = new SimpleConfiguration("env",
				new EnvironmentPropertiesConfigUnit());
		model.addConfiguration(config, "env");
		// TODO implement network config...
		// config = new NetworkConfig(config, "net");
		// model.addConfiguration(config, "net");
		return model;
	}

	private EnvironmentContext loadEnvironmentProvider() {
		// TODO Auto-generated method stub, use ServiceLoader here...
		return new SEEnvironmentProvider();
	}

	@Override
	public Collection<String> getConfigurationModelIds() {
		return metaModel.getModelIds();
	}

	@Override
	public ConfigurationModel getConfigurationModel(String configId) {
		ConfigurationModel model = configurationModels
				.getConfigModel(getSystemEnvironment(), configId);
		if (model == null) {
			throw new IllegalArgumentException("No such configuration model: "
					+ configId);
		}
		return model;
	}

	@Override
	public ConfigurationModel getConfigurationModel(String configId,
			Environment environment) {
		ConfigurationModel container = configurationModels
				.getConfigModel(environment, configId);
		if (container == null) {
			throw new IllegalArgumentException("No such configuration model: "
					+ configId);
		}
		return container;
	}

	@Override
	public boolean isConfigurationModelDefined(String modelId) {
		return metaModel.isModelDefined(modelId);
	}

	@Override
	public Environment getCurrentEnvironment() {
		return environmentProvider.getCurrentEnvironment();
	}

	@Override
	public Environment getSystemEnvironment() {
		return environmentProvider.getSystemEnvironment();
	}

	@Override
	public ConfigurationQuery queryConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigurationUpdater createConfiguration(String configId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigurationUpdater updateConfiguration(Configuration config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addConfigChangeListener(ConfigChangeListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeConfigChangeListener(ConfigChangeListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Object instance) {
		// TODO Auto-generated method stub

	}

}
