package org.javaconfig.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileConfigUnit extends AbstractResourceConfigurationUnit {

	private Map<String, String> props = new HashMap<String, String>();
	private Map<String, Map<String, String>> propMetaInfo = new HashMap<String, Map<String, String>>();

	public PropertyFileConfigUnit(
			String name,
			String resourcePath,
			ClassLoader classLoader,
			AbstractResourceConfigurationUnit parentConfig) {
		super(classLoader, parentConfig, name, resourcePath);
		readProperties();
	}

	public PropertyFileConfigUnit(
			String name,
			String resourcePath,
			AbstractResourceConfigurationUnit parentConfig) {
		super(getCurrentClassLoader(), parentConfig, name, resourcePath);
		readProperties();
	}

	public PropertyFileConfigUnit(String name,
			String resourcePath) {
		super(getCurrentClassLoader(), null, name, resourcePath);
		readProperties();
	}

	private void readProperties() {
		// TODO source expression may denote multiple resources
		for (String src : getSourceExpressions()) {
			if (!isSourceRead(src)) {
				readSource(src);
			}
		}
	}

	@Override
	protected void readSource(String src) {
		try (InputStream is = getClassLoader().getResource(
				src).openStream()) {
			Properties props = new Properties();
			URL resource = getClassLoader().getResource(
					src);
			if (isSourceRead(resource.toString())) {
				// continue;
				return;
			}
			addSource(resource.toString());
			Map<String, String> mi = new HashMap<String, String>();
			mi.put("source", resource.toString());
			if (Thread.currentThread().getContextClassLoader() != null) {
				mi.put("classloader", Thread.currentThread()
						.getContextClassLoader().toString());
			}
			props.load(is);
			for (Map.Entry<Object, Object> en : props.entrySet()) {
				props.put(en.getKey().toString(),
						en.getValue().toString());
				propMetaInfo.put(en.getKey().toString(),
						mi);
			}
		} catch (IOException e) {
			addError(e);
		}
	}

	protected Map<String, String> getMetaInfo(String key, String value) {
		Map<String, String> mi = propMetaInfo.get(key);
		if (mi != null) {
			return mi;
		}
		return Collections.emptyMap();
	}

	private static ClassLoader getCurrentClassLoader() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (cl == null) {
			return PropertyFileConfigUnit.class.getClassLoader();
		}
		return cl;
	}

	@Override
	public String getProperty(String key) {
		return props.get(key);
	}

	@Override
	public Map<String, String> getEntries() {
		return Collections.unmodifiableMap(props);
	}

}
