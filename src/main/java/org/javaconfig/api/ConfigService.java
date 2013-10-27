/*
 * Copyright (c) 2013, Anatole Tresch.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.javaconfig.api;

import java.util.Map;

/**
 * Service for accessing configuration.
 * 
 * @author Anatole Tresch
 */
public interface ConfigService {

	/**
	 * Access the meta model.
	 * 
	 * @return the meta model.
	 */
	public ConfigMetaModel getConfigMetaModel();

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregate
	 *            The aggregate, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 */
	Configuration getConfiguration(Aggregate aggregate);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregate
	 *            The aggregate, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 */
	Configuration getConfiguration(AggregateInstance aggregateInstance);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 * @throws IllegalArgumentException
	 *             if no corresponding {@link Aggregate} exists.
	 */
	Configuration getConfiguration(String aggregateId);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 * @throws IllegalArgumentException
	 *             if no corresponding {@link Aggregate} exists.
	 */
	Configuration getConfiguration(String aggregateId,
			Environment environment);

	/**
	 * Allows to check if a defined {@link AggregateInstance} is available,
	 * meaning corresponding configuration can be accessed.
	 * 
	 * @param aggregate
	 *            The {@link Aggregate} to be checked for availability, not
	 *            {@code null}.
	 * @return true, if the given {@link AggregateInstance} is available.
	 */
	boolean isAggregateAvailable(Aggregate aggregate);

	/**
	 * Allows to check if a defined {@link ConfigUnitInstance} is available,
	 * meaning corresponding configuration can be accessed.
	 * 
	 * @param configUnit
	 *            The {@link ConfigUnit} to be checked for availability, not
	 *            {@code null}.
	 * @return true, if a given {@link ConfigUnitInstance} is available.
	 */
	boolean isConfigUnitAvailable(ConfigurationUnit configUnit);

	/**
	 * Allows to check if a defined {@link AggregateInstance} is available,
	 * meaning corresponding configuration can be accessed.
	 * 
	 * @param aggregate
	 *            The {@link Aggregate} to be checked for availability, not
	 *            {@code null}.
	 * @param environment
	 *            the target {@link Environment}
	 * @return true, if the given {@link AggregateInstance} is available.
	 */
	boolean isAggregateAvailable(Aggregate aggregate, Environment environment);

	/**
	 * Allows to check if a defined {@link ConfigUnitInstance} is available,
	 * meaning corresponding configuration can be accessed.
	 * 
	 * @param configUnit
	 *            The {@link ConfigUnit} to be checked for availability, not
	 *            {@code null}.
	 * @param environment
	 *            the target {@link Environment}
	 * @return true, if a given {@link ConfigUnitInstance} is available.
	 */
	boolean isConfigUnitAvailable(ConfigurationUnit configUnit,
			Environment environment);

	/**
	 * Access a configuration {@link Aggregate}, by its id.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the according {@link AggregateInstance}.
	 * @throws IllegalArgumentException
	 *             if the aggregate is not defined.
	 */
	AggregateInstance getAggregateInstance(Aggregate aggregate);

	/**
	 * Access a configuration {@link Aggregate}, by its id.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the according {@link AggregateInstance}.
	 * @throws IllegalArgumentException
	 *             if the aggregate is not defined.
	 */
	AggregateInstance getAggregateInstance(Aggregate aggregate,
			Environment environment);

	/**
	 * Evaluates a {@link ConfigurationNode} ({@link ConfigurationUnit}
	 * sub-configuration tree).
	 * 
	 * @param unit
	 *            The unit, not {@code null}.
	 * @return the current {@link ConfigurationUnitInstance} corresponding to
	 *         the {@link ConfigurationUnit}.
	 */
	ConfigurationUnitInstance getConfigurationUnitInstance(
			ConfigurationUnit unit);

	/**
	 * Evaluates a {@link ConfigurationNode} ({@link ConfigurationUnit}
	 * sub-configuration tree).
	 * 
	 * @param unit
	 *            The unit, not {@code null}.
	 * @return the current {@link ConfigurationUnitInstance} corresponding to
	 *         the {@link ConfigurationUnit}.
	 */
	ConfigurationUnitInstance getConfigurationUnitInstance(
			ConfigurationUnit unit, Environment environment);

	/**
	 * Access the current active runtime {@link Environment}.
	 * 
	 * @return the current active runtime {@link Environment}, never
	 *         {@code null}.
	 */
	Environment getCurrentEnvironment();

	/**
	 * Create a {@link ConfigurationQuery} for quering arbitrary configuration.
	 * 
	 * @return
	 */
	ConfigurationQuery createConfigurationQuery();
	
	/**
	 * Create a new ConfigurationBuilder for adding new configuration programmatically.
	 * @return
	 */
	Configuration.Builder createBuilder();
	
	/**
	 * Adds a listener for configuration changes, duplicates must be ignored.
	 * 
	 * @param l
	 *            the listener to be added.
	 */
	void addConfigChangeListener(ConfigChangeListener l);

	/**
	 * Removes a listener for configuration changes.
	 * 
	 * @param l
	 *            the listener to be removed.
	 */
	void removeConfigChangeListener(ConfigChangeListener l);

	public static interface ConfigurationQuery {

		ConfigurationQuery withAggregates(Aggregate... aggregates);

		ConfigurationQuery withAggregates(String... aggregates);

		ConfigurationQuery withScopes(ConfigurationUnit... scopes);

		ConfigurationQuery withScopes(String... scopes);

		ConfigurationQuery withEntryAttribute(String key, String valueExpression);

		ConfigurationQuery withEntryAttributes(
				Map<String, String> keyValueExpressions);

		// ConfigurationQuery withNodeFilter(Predicate<ConfigurationNode>
		// nodePredicate);
		// ConfigurationQuery withValueFilter(Predicate<PropertyValue>
		// valueFilter);
		Configuration query();
	}
}
