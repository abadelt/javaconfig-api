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

/**
 * A configuration scope identifies a subset of configuration available. A scope
 * is identified by a unique name and provides accessor to determine if a scope
 * is availale in a certain runtime context.
 * <p>
 * By default the following scopes are defined, in order of priority:
 * <ul>
 * <li>{@code domain_defaults} (VM)
 * <li>{@code domain} entries (VM)
 * <li>{@code domain_test} entries (VM)
 * <li>{@code application_defaults} (ear)
 * <li>{@code application} entries (ear)
 * <li>{@code application_test} entries (ear)
 * <li>{@code web_defaults} (war)
 * <li>{@code web} entries (war)
 * <li>{@code web_test} entries (war)
 * </ul>
 * <p>
 * Scopes allow to independently model the levels of overrides required by the
 * an application, or application landscape. Additional scopes can be added that
 * may override or extend the existing flavors.<br/>
 * With ConfigurationQuery completely independent configurations can be created,
 * that define different scope ordering as required.
 * 
 * @author Anatole Tresch
 */
public interface Scope {
	/**
	 * Returns the unique name of a scope.
	 * 
	 * @return The scope's name, never {@code null}.
	 */
	public String getName();

	/**
	 * Accessor called to determine if a scope is available within the current
	 * context.
	 * 
	 * @return true, if the scope is available in the current context.
	 */
	public boolean isActive();

	/**
	 * Method allows to determine if a scope is contextual. Configuration of
	 * contextual scopes are accessed whenever they are needed.
	 * 
	 * @return true, if this scope is contextual.
	 */
	public boolean isContextual();

	/**
	 * Reads/evaluates the configuration for this scope. Hereby configuration
	 * for non contextual scopes, is read only once.
	 * 
	 * @return the scope's configuration, never {@code null}.
	 */
	public ConfigurationNode readConfiguration();
	
}
