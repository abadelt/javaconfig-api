package org.javaconfig.api;

import java.util.Map;

public interface ConfigurationQuery {

	ConfigurationQuery withConfigTypes(ConfigurationType... aggregates);

	ConfigurationQuery withConfigTypes(String... aggregates);

	ConfigurationQuery withConfigUnits(String... units);

	ConfigurationQuery withEntryAttribute(String key, String valueExpression);

	ConfigurationQuery withEntryAttributes(
			Map<String, String> keyValueExpressions);

	Configuration query();
}