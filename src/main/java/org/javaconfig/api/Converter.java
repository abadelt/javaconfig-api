package org.javaconfig.api;

/**
 * SPI for converting configuration into the a given target type.
 * 
 * @author Anatole Tresch
 */
public interface Converter {

	/**
	 * Converts a value to the given target type.
	 * 
	 * @param key
	 *            the parameter key originally requested.
	 * @param targetType
	 *            The target type class, never {@code null}.
	 * @param config
	 *            the configuration node already identifed.
	 * @return the converted type, or {@code null}.
	 */
	public <T> T convert(String key, Class<T> targetType,
			ConfigurationNode config);

}
