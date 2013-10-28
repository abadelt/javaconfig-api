package javax.config;

import java.util.Map;

public interface ConfigurationQuery {

	ConfigurationQuery withConfigModels(ConfigurationModel... models);

	ConfigurationQuery withConfigModels(String... modelIds);

	ConfigurationQuery withConfigurations(String... configurations);
	
	ConfigurationQuery withSelections(String... selectionExpressions);
	
	ConfigurationQuery withEntryAttribute(String key, String valueExpression);

	ConfigurationQuery withEntryAttributes(
			Map<String, String> keyValueExpressions);

	Configuration query();
}