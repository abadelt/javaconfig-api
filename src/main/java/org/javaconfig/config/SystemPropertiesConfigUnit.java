package org.javaconfig.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.config.Environment;

public class SystemPropertiesConfigUnit extends AbstractConfigUnit {

	private Map<String, String> props = new HashMap<String, String>();

	public SystemPropertiesConfigUnit() {
		super("sys-props");
		Properties sysProps = System.getProperties();
		for (Entry<String, String> en : props.entrySet()) {
			props.put(en.getKey(), en.getValue());
		}
		addSource("code:System.getProperties()");
		addSourceExpression("code:System.getProperties()");
	}


	@Override
	public String getProperty(String key) {
		String value = props.get(key);
		if (value == null) {
			value = System.getProperty(key);
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
	public boolean isActive(Environment environment) {
		return true;
	}

}
