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
package javax.config;

import java.util.Collection;

import javax.config.annot.ConfigType;

/**
 * Service for accessing configuration.
 * 
 * @author Anatole Tresch
 */
public interface ConfigService {

	/**
	 * Evaluates the current {@link ConfigurationModel}, matching to the current
	 * {@link Environment}.
	 * 
	 * @see #getCurrentEnvironment()
	 * @return the current {@link Configuration} corresponding to the aggregate.
	 */
	ConfigurationModel getConfiguration();

	/**
	 * Access all defined {@link ConfigurationModel} ids.
	 * 
	 * @return all available configuration ids, never{@code null}.
	 */
	Collection<String> getConfigurationIds();

	/**
	 * Access a {@link ConfigurationModel} by name, matching to the current
	 * {@link Environment}.
	 * 
	 * @see #getCurrentEnvironment()
	 * @param configId
	 *            The identifier of the required {@link ConfigurationModel}, not
	 *            {@code null}.
	 * @return the current {@link ConfigurationModel} corresponding to the
	 *         {@code configId}.
	 */
	ConfigurationModel getConfiguration(String configId);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param configId
	 *            The {@link ConfigurationModel} configId, not {@code null}.
	 * @param environment
	 *            The target environment.
	 * @return the current {@link ConfigurationModel} corresponding to the
	 *         {@code configId} and {@code environment}.
	 * @throws IllegalArgumentException
	 *             if no corresponding {@link ConfigurationModel} exists.
	 */
	ConfigurationModel getConfiguration(String configId,
			Environment environment);

	/**
	 * Allows to check if a {@link ConfigurationModel} with the given id is
	 * defined.
	 * 
	 * @param configId
	 *            The {@link ConfigType} id to be looked up, not {@code null}.
	 * @return true, if the given {@link ConfigurationModel} is defined.
	 */
	boolean isConfigurationDefined(String configId);

	/**
	 * Allows to check if a {@link ConfigurationModel} with the given id is
	 * defined.
	 * 
	 * @param configId
	 *            The {@link ConfigType} id to be looked up, not {@code null}.
	 * @param environment
	 *            The target environment.
	 * @return true, if the given {@link ConfigurationModel} is defined.
	 */
	boolean isConfigurationDefined(String configId, Environment environment);

	/**
	 * Access the current active runtime {@link Environment}.
	 * 
	 * @return the current active runtime {@link Environment}, never
	 *         {@code null}.
	 */
	Environment getCurrentEnvironment();

	/**
	 * Create a {@link ConfigurationQuery} for querying arbitrary configuration.
	 * 
	 * @return a new {@link ConfigurationQuery} instance.
	 */
	ConfigurationQuery createConfigurationQuery();

	/**
	 * Create a new {@link ConfigurationBuilder} for adding new configuration
	 * programmatically.
	 * 
	 * @return a new {@link ConfigurationBuilder}
	 */
	ConfigurationBuilder createBuilder();

	/**
	 * Create a new {@link ConfigurationUpdater} for updating or deletion of
	 * configuration.
	 * 
	 * @return a new {@link ConfigurationUpdater}.
	 */
	ConfigurationUpdater createUpdater(Configuration configuration);

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
