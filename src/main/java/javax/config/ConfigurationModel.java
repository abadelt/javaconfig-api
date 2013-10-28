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

import java.util.Set;

/**
 * An configuration model is a aggregate combination of {@link Configuration}
 * instances.
 * 
 * @author Anatole Tresch
 */
public interface ConfigurationModel {

	/**
	 * Return the {@link Environment} of this instance.
	 * 
	 * @return the {@link Environment}, never {@code null}.
	 */
	Environment getEnvironment();

	/**
	 * Accessor called to determine if an {@link Configuration} is available
	 * within the current context. Aggregated scopes are only available, when
	 * all contained scopes are available in the current context.
	 * 
	 * @return true, if the scope is available in the current context.
	 */
	boolean isConfigurationAvailable();

	/**
	 * Create a {@link ConfigurationQuery} for quering arbitrary
	 * sub-configuration for this configuration.
	 * 
	 * @return a new ConfigurationQuery instance, never {@code null}.
	 */
	ConfigurationQuery createConfigurationQuery();

	/**
	 * Get the names of the contained {@link Configuration} entries.
	 * 
	 * @return the names of the contained {@link Configuration} entries, never
	 *         {@code null}.
	 */
	Set<String> getConfigurations();

	/**
	 * Get the {@link Configuration} with the given name.
	 * 
	 * @ses {@link #isConfigurationAvailable()}
	 * @param name
	 *            the config name, not {@code null}.
	 * @return the according {@link Configuration}
	 * @throws IllegalArgumentException
	 *             if no such config exists.
	 * @throws IllegalStateException
	 *             if the required configuration is not available in the current
	 *             runtime context.
	 */
	Configuration getConfiguration(String name);

}
