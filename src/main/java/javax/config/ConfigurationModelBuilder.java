package javax.config;

public interface ConfigurationModelBuilder {

	public ConfigurationModelBuilder withName(String name);
	
	public ConfigurationModelBuilder withModel(ConfigurationModel type);

	public ConfigurationModelBuilder withModel(String modelId);

	public ConfigurationModelBuilder withConfiguration(Configuration config);

	public ConfigurationModelBuilder withQuery(ConfigurationQuery query);

	public ConfigurationModel build();

}
