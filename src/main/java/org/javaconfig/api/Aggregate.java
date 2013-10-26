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
 * An aggregate is a ordered combination of {@link Scope} instances.
 * 
 * @author Anatole Tresch
 * 
 */
public interface Aggregate {

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
	 * Method allows to determine if a scope is contextual. Configuration of
	 * contextual scopes are accessed whenever they are needed.
	 * 
	 * @return true, if this scope is contextual.
	 */
	public boolean isContextual();

}
