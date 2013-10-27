package org.javaconfig.api;

import org.javaconfig.spi.ConfigurationNode;

public interface ConfigurationBuilder {

	public ConfigurationBuilder withName(String name);
	
	public ConfigurationBuilder withType(ConfigurationType type);

	public ConfigurationBuilder withType(String type);

	public ConfigurationBuilder withEnvironment(Environment environment);

	public ConfigurationBuilder withConfiguration(Configuration config);

	public ConfigurationBuilder withConfigurationUnit(
			ConfigurationUnit configUnit);

	public ConfigurationBuilder withNode(ConfigurationNode config);

	public ConfigurationBuilder withNode(String node);

	public ConfigurationBuilder withLocation(String location);

	public ConfigurationBuilder withProperty(String node,
			PropertyValue value);

	public ConfigurationBuilder withProperty(String key,
			int value);

	public ConfigurationBuilder withProperty(String key,
			byte value);

	public ConfigurationBuilder withProperty(String key,
			short value);

	public ConfigurationBuilder withProperty(String key,
			boolean value);

	public ConfigurationBuilder withProperty(String key,
			char value);

	public ConfigurationBuilder withProperty(String key,
			float value);

	public ConfigurationBuilder withProperty(String key,
			double value);

	public ConfigurationBuilder withProperty(String key,
			long value);

	public ConfigurationBuilder withProperty(String key,
			String value);

	public ConfigurationBuilder withQuery(ConfigurationQuery query);

	public Configuration build();

	public Configuration buildAndRegister();

}
