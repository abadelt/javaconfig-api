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

import java.util.List;

/**
 * A aggregate scope identifies a a configuration set that is defined by
 * default. A aggregate scope is identified by a unique name. An aggregate scope
 * is only available when all containing scopes are available. Additionally the
 * ordering of scopes also models the override relatoinships between the config
 * entries, provided for the different scopes within the aggregate.
 * <p>
 * By default the following aggregate scopes are defined, in order of priority:
 * <ul>
 * <li>{@code DOMAIN} scope
 * <li>{@code APPLICATION} scope (ear)
 * <li>{@code WEB} web application scope (war)
 * </ul>
 * <p>
 * Aggregate Scopes model the levels of overrides required by the a
 * configuration type. New aggregate scopes can be defined, or additional
 * {@link Scope} instances can be added to existing aggregates.
 * <br/>
 * 
 * @author Anatole Tresch
 */
public interface AggregatedConfiguration {
	/**
	 * Returns the unique name of a aggregate scope.
	 * 
	 * @return The aggregate scope's name, never {@code null}.
	 */
	public String getName();

	/**
	 * Return the scopes aggregated in this instance, in the order of precedence
	 * (the first are the weekest).
	 * 
	 * @return the ordered list of aggregated scopes, never {@code null}.
	 */
	public List<Scope> getScopes();

	/**
	 * Accessor called to determine if an aggregated scope is available within
	 * the current context. Aggregated scopes are only available, when all
	 * contained scopes are available in the current context.
	 * 
	 * @return true, if the scope is available in the current context.
	 */
	public boolean isActive();
}
