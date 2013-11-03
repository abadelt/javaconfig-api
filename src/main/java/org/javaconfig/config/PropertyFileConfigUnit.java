package org.javaconfig.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class PropertyFileConfigUnit extends ResourceConfigurationUnit {

	public PropertyFileConfigUnit(
			String name,
			String resourcePath,
			ClassLoader classLoader,
			ResourceConfigurationUnit parentConfig) {
		super(classLoader, parentConfig, name, resourcePath);
		readProperties();
	}

	public PropertyFileConfigUnit(
			String name,
			String resourcePath,
			ResourceConfigurationUnit parentConfig) {
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
		try (InputStream is = getClassLoader().getResource(
				getSourceExpression()).openStream()) {
			URL resource = getClassLoader().getResource(getSourceExpression());
			if(isSourceRead(resource.toString())){
//				continue;
				return;
			}
			addSource(resource.toString());
			Properties props = new Properties();
			props.load(is);
			for (Map.Entry<Object, Object> en : props.entrySet()) {
				addEntry(
						en.getKey().toString(),
						en.getValue().toString(),
						getMetaInfo(en.getKey().toString(), en.getValue()
								.toString()));
			}
		} catch (IOException e) {
			addError(e);
		}
	}

	protected Map<String, String> getMetaInfo(String key, String value) {
		return null;
	}

	private static ClassLoader getCurrentClassLoader() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (cl == null) {
			return PropertyFileConfigUnit.class.getClassLoader();
		}
		return cl;
	}

}
