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

import java.util.Collection;

/**
 * Service for accessing configuration.
 * 
 * @author Anatole Tresch
 */
public interface ConfigService {

	/**
	 * Evaluates the current {@link Configuration}, matching to the current
	 * {@link Environment}.
	 * 
	 * @see #getCurrentEnvironment()
	 * @param aggregate
	 *            The aggregate, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 */
	Configuration getConfiguration();

	/**
	 * Evaluates the explicit {@link Configuration}, matching to the current
	 * {@link Environment}.
	 * 
	 * @see #getCurrentEnvironment()
	 * @param aggregate
	 *            The aggregate, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 */
	Configuration getConfiguration(ConfigurationType aggregate);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 * @throws IllegalArgumentException
	 *             if no corresponding {@link ConfigurationType} exists.
	 */
	Configuration getConfiguration(String aggregateId);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 * @throws IllegalArgumentException
	 *             if no corresponding {@link ConfigurationType} exists.
	 */
	Configuration getConfiguration(String aggregateId,
			Environment environment);

	/**
	 * Allows to check if a defined {@link AggregateInstance} is available,
	 * meaning corresponding configuration can be accessed.
	 * 
	 * @param aggregate
	 *            The {@link ConfigurationType} to be checked for availability, not
	 *            {@code null}.
	 * @return true, if the given {@link AggregateInstance} is available.
	 */
	boolean isConfigTypeAvailable(ConfigurationType aggregate);

	/**
	 * Allows to check if a defined {@link AggregateInstance} is available,
	 * meaning corresponding configuration can be accessed.
	 * 
	 * @param aggregate
	 *            The {@link ConfigurationType} to be checked for availability, not
	 *            {@code null}.
	 * @param environment
	 *            the target {@link Environment}
	 * @return true, if the given {@link AggregateInstance} is available.
	 */
	boolean isConfigTypeAvailable(ConfigurationType aggregate, Environment environment);

	/**
	 * Access all aggregates.
	 * 
	 * @return all aggregates, never {@code null}.
	 */
	Collection<ConfigurationType> getConfigTypes();

	/**
	 * Allows to check if a {@link ConfigurationType} with the given id is defined.
	 * 
	 * @param aggregateId
	 *            The aggregate id to be looked up, not {@code null}.
	 * @return true, if the given {@link ConfigurationType} is defined.
	 */
	boolean isConfigTypeDefined(String aggregateId);

	/**
	 * Access a configuration {@link ConfigurationType}, by its id.
	 * 
	 * @param typeId
	 *            The type id, not {@code null}.
	 * @return the according {@link ConfigurationType}.
	 * @throws IllegalArgumentException
	 *             if the aggregate is not defined.
	 */
	ConfigurationType getConfigType(String typeId);

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
	 * Create a new ConfigurationBuilder for adding new configuration
	 * programmatically.
	 * 
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
}
