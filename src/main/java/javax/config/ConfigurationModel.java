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

/**
 * An configuration model is a aggregate combination of {@link Configuration} instances.
 * 
 * @author Anatole Tresch
 */
public interface ConfigurationModel extends Configuration {

	/**
	 * Return the {@link Environment} of this instance.
	 * 
	 * @return the {@link Environment}, never {@code null}.
	 */
	Environment getEnvironment();

	/**
	 * Accessor called to determine if an aggregated scope is available within
	 * the current context. Aggregated scopes are only available, when all
	 * contained scopes are available in the current context.
	 * 
	 * @return true, if the scope is available in the current context.
	 */
	boolean isActive();

	/**
	 * Create a {@link ConfigurationQuery} for quering arbitrary
	 * sub-configuration for this configuration.
	 * 
	 * @return a new ConfigurationQuery instance, never {@code null}.
	 */
	ConfigurationQuery createConfigurationQuery();

}
