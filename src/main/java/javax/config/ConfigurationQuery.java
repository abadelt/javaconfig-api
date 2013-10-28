package javax.config;

import java.util.Map;

public interface ConfigurationQuery {

	ConfigurationQuery withConfigTypes(ConfigurationModel... aggregates);

	ConfigurationQuery withConfigTypes(String... aggregates);

	ConfigurationQuery withConfigUnits(String... units);

	ConfigurationQuery withEntryAttribute(String key, String valueExpression);

	ConfigurationQuery withEntryAttributes(
			Map<String, String> keyValueExpressions);

	Configuration query();
}