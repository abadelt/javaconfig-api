package org.javaconfig.impl.se;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.config.ConfigurationModel;
import javax.config.Environment;

class ConfigurationContainer {

	private Map<Environment, Map<String, ConfigurationModel>> models = new ConcurrentHashMap<>();

	public void addConfigModel(Environment env, ConfigurationModel model) {

	}

	public void removeConfigModel(Environment env, ConfigurationModel model) {

	}

	public ConfigurationModel getConfigModel(Environment env, String id) {
		Map<String, ConfigurationModel> map = models.get(env);
		if (map != null) {
			return map.get(id);
		}
		return null;
	}
}
