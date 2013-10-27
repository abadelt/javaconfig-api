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
import java.util.Map;

/**
 * Service for accessing configuration.
 * 
 * @author Anatole Tresch
 */
public interface ConfigMetaModel {

	/**
	 * Access all aggregates.
	 * 
	 * @return all aggregates, never {@code null}.
	 */
	Collection<Aggregate> getAggregates();

	/**
	 * Allows to check if a {@link Aggregate} with the given id is defined.
	 * 
	 * @param aggregateId
	 *            The aggregate id to be looked up, not {@code null}.
	 * @return true, if the given {@link Aggregate} is defined.
	 */
	boolean isAggregateDefined(String aggregateId);

	/**
	 * Access a configuration {@link Aggregate}, by its id.
	 * 
	 * @param aggregateId
	 *            The aggregate id, not {@code null}.
	 * @return the according {@link Aggregate}.
	 * @throws IllegalArgumentException
	 *             if the aggregate is not defined.
	 */
	Aggregate getAggregate(String aggregateId);


	/**
	 * Access all scopes.
	 * 
	 * @return all scopes, never {@code null}.
	 */
	Collection<ConfigurationUnit> getConfigUnits();

	/**
	 * Allows to check if a scope with the given id is defined.
	 * 
	 * @param unitId
	 *            The unit id to be looked up, not {@code null}.
	 * @return true, if the given {@link ConfigurationUnit} is defined.
	 */
	boolean isConfigUnitDefined(String unitId);

	/**
	 * Access a configuration scope, by its id.
	 * 
	 * @param unitId
	 *            The scope id, not {@code null}.
	 * @return the according scope.
	 * @throws IllegalArgumentException
	 *             if the scope is not defined.
	 */
	ConfigurationUnit getConfigUnit(String unitId);

}
