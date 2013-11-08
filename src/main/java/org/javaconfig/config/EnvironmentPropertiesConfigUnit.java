package org.javaconfig.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.config.ConfigurationUnit;
import javax.config.Environment;

public class EnvironmentPropertiesConfigUnit implements ConfigurationUnit {

	private Map<String, String> props = new HashMap<String, String>();

	public EnvironmentPropertiesConfigUnit() {
		props.putAll(System.getenv());
	}

	@Override
	public String getName() {
		return "env";
	}

	@Override
	public Set<String> getSources() {
		return Collections.emptySet();
	}

	@Override
	public List<Throwable> getErrors() {
		return Collections.emptyList();
	}

	@Override
	public Set<String> getSourceExpressions() {
		Set<String> result = new HashSet<String>();
		result.add("<environment properties>");
		return result;
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		return Collections.emptyMap();
	}

	@Override
	public String getProperty(String key) {
		String value = props.get(key);
		if (value == null) {
			value = System.getenv().get(key);
			if (value != null) {
				props.put(key, value);
			}
		}
		return value;
	}

	@Override
	public Map<String, String> getEntries() {
		return Collections.unmodifiableMap(props);
	}

	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		return Collections.emptyMap();
	}

	@Override
	public boolean isActive(Environment environment) {
		return true;
	}

}
