package org.javaconfig.api;

public interface Converter {

	public <T> T convert(String key, Class<T> targetType, ConfigurationNode config);

}
