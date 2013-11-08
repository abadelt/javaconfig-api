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
 * instances. Hereby the effective properties visible are dependent on the
 * current {@link Environment}. It is possible that whole {@link Configuration}
 * instances can be not active, or that some {@link ConfigurationUnit} instances
 * may not be available.
 * 
 * @author Anatole Tresch
 */
public interface ConfigurationModel {

	/**
	 * Get the model's name.
	 * 
	 * @return the model name, never {@code null}.
	 */
	public String getName();

	/**
	 * Get the names of the contained {@link Configuration} entries.
	 * 
	 * @return the names of the contained {@link Configuration} entries, never
	 *         {@code null}.
	 */
	public Set<String> getConfigurations();

	/**
	 * Get the contained {@link Configuration} entries.
	 * 
	 * @param path
	 *            The regular expression path expression for selecting, never
	 *            {@code null}.
	 * @return the contained {@link Configuration} entries, never {@code null}.
	 */
	public Set<Configuration> getConfigurations(String path);

	/**
	 * Get the {@link Configuration} with the given name.
	 * 
	 * @ses {@link #isAvailable()}
	 * @param name
	 *            the config name, not {@code null}.
	 * @return the according {@link Configuration}
	 * @throws IllegalArgumentException
	 *             if no such config exists.
	 * @throws IllegalStateException
	 *             if the required configuration is not available in the current
	 *             runtime context.
	 */
	public Configuration getConfiguration(String name);

	/**
	 * Allows to evaluate if a node exists.
	 * 
	 * @param key
	 *            the configuration path.
	 * @return {@code true}, if such a node exists.
	 */
	public boolean containsConfiguration(String key);

	/**
	 * Extension point for adjusting configuration.
	 * 
	 * @param adjuster
	 *            A configuration ajuster, e.g. a filter, or an adjuster
	 *            combining configurations.
	 * @return the new adjusted configuration, never {@code null}.
	 */
	public ConfigurationModel with(ConfigurationModelAdjuster adjuster);

	/**
	 * Query some value from a configuration.
	 * 
	 * @param query
	 *            the query, never {@code null}.
	 * @return the result
	 */
	public <T> T query(ConfigurationModelQuery<T> query);

}
