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
public interface ConfigurationUnitInstance {
	/**
	 * Returns the {@link ConfigurationUnit} of this instance.
	 * 
	 * @return The scope's name, never {@code null}.
	 */
	public ConfigurationUnit getConfigurationUnit();

	/**
	 * Access the properties of this {@link ConfigurationUnitInstance}.
	 * 
	 * @return
	 */
	public Environment getEnvironment();

	/**
	 * Return the items contained in this unit.
	 * 
	 * @return the items contained.
	 */
	public Collection<ConfigurationNode> getConfigurationNodes();

}