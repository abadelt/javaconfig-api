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

import javax.config.spi.EnvironmentContext;

/**
 * Service for accessing configuration. A configuration service is always base
 * on the environment definition provided by one instance of
 * {@link EnvironmentContext}. It is possible to define multiple
 * {@link ConfigService} instances, if required.
 * 
 * @author Anatole Tresch
 */
public interface ConfigService {

	/**
	 * Access all defined {@link ConfigurationModel} ids.
	 * 
	 * @return all available configuration ids, never{@code null}.
	 */
	Collection<String> getConfigurationModelIds();

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
	ConfigurationModel getConfigurationModel(String configModelId);

	/**
	 * Access a {@link ConfigurationModel} by name, matching the given target
	 * {@link Environment}. This can be used e.g. for accessing deployment
	 * configuration for an application to be deployed.
	 * 
	 * @param configId
	 *            The identifier of the required {@link ConfigurationModel}, not
	 *            {@code null}.
	 * @param environment
	 *            the target enbvironment
	 * @return the current {@link ConfigurationModel} corresponding to the
	 *         {@code configId}.
	 */
	ConfigurationModel getConfigurationModel(String configModelId,
			Environment environment);

	/**
	 * Allows to check if a {@link ConfigurationModel} with the given id is
	 * defined.
	 * 
	 * @param configId
	 *            The model id to be looked up, not {@code null}.
	 * @return true, if the given {@link ConfigurationModel} is defined.
	 */
	boolean isConfigurationModelDefined(String configModelId);

	/**
	 * Access the current active runtime {@link Environment}.
	 * 
	 * @return the current active runtime {@link Environment}, never
	 *         {@code null}.
	 */
	Environment getCurrentEnvironment();
	
	Environment getSystemEnvironment();

	/**
	 * Create a {@link ConfigurationQuery} for querying arbitrary configuration.
	 * 
	 * @return a new {@link ConfigurationQuery} instance.
	 */
	ConfigurationQuery queryConfiguration();

	/**
	 * Create a new {@link ConfigurationUpdater} for updating or deletion of a
	 * configuration.
	 * 
	 * @return a new {@link ConfigurationUpdater}.
	 */
	public ConfigurationUpdater updateConfiguration(Configuration config);

	/**
	 * Creates a {@link ConfigurationUpdater} for creating a new
	 * {@link Configuration} instance.
	 * 
	 * @param configId
	 *            the new config identifier
	 * @return the new {@link ConfigurationUpdater}, never {@code null}.
	 * @throws UnsupportedOperationException
	 *             if no new Configuration can be added.
	 */
	public ConfigurationUpdater createConfiguration(String configId);

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

	/**
	 * Resolved the annotated configuration resources on the given instance.
	 * 
	 * @param instance
	 *            to POJO instance to be configured.
	 * @throws IllegalArgumentException
	 *             if configuration could not be resolved, or converted.
	 */
	void configure(Object instance);

}
