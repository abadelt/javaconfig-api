package org.javaconfig.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.Configuration;
import javax.config.ConfigurationModel;
import javax.config.ConfigurationModelAdjuster;
import javax.config.ConfigurationModelQuery;

public class SimpleConfigurationModel implements ConfigurationModel {

	private String name;
	private Map<String, Configuration> configurations = new HashMap<String, Configuration>();
	private Object LOCK = new Object();

	public SimpleConfigurationModel(String name) {
		Objects.requireNonNull(name);
		this.name = name;
	}

	public void addConfiguration(Configuration config, String path) {
		synchronized (LOCK) {
			Map<String, Configuration> newMap = new HashMap<String, Configuration>(
					configurations);
			newMap.put(path, config);
			this.configurations = newMap;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<String> getConfigurations() {
		return configurations.keySet();
	}

	@Override
	public Set<Configuration> getConfigurations(String path) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Configuration getConfiguration(String name) {
		return configurations.get(name);
	}

	@Override
	public boolean containsConfiguration(String key) {
		return configurations.containsKey(key);
	}

	@Override
	public ConfigurationModel with(ConfigurationModelAdjuster adjuster) {
		return adjuster.adjustInto(this);
	}

	@Override
	public <T> T query(ConfigurationModelQuery<T> query) {
		return query.queryFrom(this);
	}

}
