package javax.config;

public interface ConfigurationBuilder {

	public ConfigurationBuilder withName(String name);

	public ConfigurationBuilder withModel(ConfigurationModel type);

	public ConfigurationBuilder withModel(String modelId);

	public ConfigurationBuilder withEnvironment(Environment environment);

	public ConfigurationBuilder withConfiguration(Configuration config);

	public ConfigurationBuilder withLocation(String location);

	public ConfigurationBuilder withQUeryPath(String queryPath);

	public ConfigurationBuilder withMetaInfo(PropertyValueMetaInfo metaInfo);

	public ConfigurationBuilder withProperty(String key, String value);

	public ConfigurationBuilder withProperty(String key, String value,
			PropertyValueMetaInfo metaInfo);

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

	public ConfigurationBuilder withQuery(ConfigurationQuery query);

	public Configuration build();

	public Configuration buildAndRegister();

}
