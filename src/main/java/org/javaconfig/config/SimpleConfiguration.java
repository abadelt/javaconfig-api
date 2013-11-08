package org.javaconfig.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.ConfigurationUnit;
import javax.config.Environment;
import javax.config.EnvironmentSelector;

public class SimpleConfiguration extends AbstractConfiguration {

	private ConfigurationUnit unit;

	public SimpleConfiguration(String name, ConfigurationUnit unit,
			EnvironmentSelector environmentSelector) {
		super(name, environmentSelector);
		Objects.requireNonNull(unit);
		this.unit = unit;
	}

	public SimpleConfiguration(String name, ConfigurationUnit unit) {
		this(name, unit, EnvironmentSelector.ANY);
	}

	@Override
	public String getProperty(String key, String defaultValue) {
		String val = this.unit.getProperty(key);
		if (val == null) {
			val = defaultValue;
		}
		return val;
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		return this.unit.getPropertyMetaInfo(key);
	}

	@Override
	public Set<String> getSources() {
		return unit.getSources();
	}

	@Override
	public List<Throwable> getErrors() {
		return unit.getErrors();
	}

	@Override
	public Collection<String> getSourceExpressions() {
		return unit.getSourceExpressions();
	}

	@Override
	public Map<String, String> getEntries() {
		return unit.getEntries();
	}

	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		return unit.getMetaInfo();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimpleConfiguration [unit=" + unit + "]";
	}

	@Override
	public boolean isActive(Environment environment) {
		return unit.isActive(environment);
	}

}
