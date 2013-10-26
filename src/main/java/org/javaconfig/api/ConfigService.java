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
	 * Evaluates a scope.
	 * 
	 * @param scope
	 * @return
	 */
	ConfigurationNode getConfiguration(Scope scope);

	/**
	 * Evaluates a {@link Configuration}.
	 * 
	 * @param aggregate
	 *            The aggregate, not {@code null}.
	 * @return
	 */
	Configuration getConfiguration(Aggregate aggregate);

	/**
	 * Access all currently active scopes.
	 * 
	 * @return all active scopes, never {@code null}.
	 */
	Collection<Scope> getAvailableScopes();

	/**
	 * Access all currently active aggregates.
	 * 
	 * @return all active aggregates, never {@code null}.
	 */
	Collection<Aggregate> getAvailableAggregates();

	/**
	 * Access all scopes.
	 * 
	 * @return all scopes, never {@code null}.
	 */
	Collection<Scope> getDefinedScopes();

	/**
	 * Access all aggregates.
	 * 
	 * @return all aggregates, never {@code null}.
	 */
	Collection<Aggregate> getDefinedAggregates();

	/**
	 * Create a freezed configuration, which is serializable and immutable.
	 * 
	 * @param config
	 *            The {@link Configuration} to be fixed.
	 * @return the freezed configuration, never {@code null}.
	 */
	FreezedConfiguration freezeConfiguration(Configuration config);

	/**
	 * Create a freezed tree, which is serializable and immutable.
	 * 
	 * @param config
	 *            The {@link ConfigurationNode} to be fixed.
	 * @return the freezed configuration tree, never {@code null}.
	 */
	FreezedConfigurationNode freezeConfigurationNode(ConfigurationNode config);

}
