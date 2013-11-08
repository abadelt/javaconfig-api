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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A non aggregated configuration part read based on a configuration expression.
 * The contained configuration entries may be read from single or several
 * sources.
 * 
 * @author Anatole Tresch
 */
public interface ConfigurationUnit {

	/**
	 * Access the unit's name.
	 * 
	 * @return the name, never {@code null}.
	 */
	public String getName();

	/**
	 * Get the sources read for this {@link ConfigurationUnit} instance.
	 * 
	 * @return the sources for the instance, never {@code null}.
	 */
	public Set<String> getSources();

	/**
	 * Get a list of exceptions occurred during creation of a
	 * {@link ConfigurationUnit}.
	 * 
	 * @return the ordered list of errors occurred.
	 */
	public List<Throwable> getErrors();

	/**
	 * Get the configuration's name (unique within a {@link ConfigurationModel}
	 * and {@link Environment}).
	 * 
	 * @return the configuration's name
	 */
	public Collection<String> getSourceExpressions();

	/**
	 * Get the {@link PropertyValueMetaInfo} for the given key.
	 * 
	 * @param key
	 *            the key, not {@code null}.
	 * @return the according meta-info, or {@code null}.
	 */
	public Map<String, String> getPropertyMetaInfo(String key);

	/**
	 * Get the property value as {@link String}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value, or {@code null}.
	 */
	public String getProperty(String key);

	/**
	 * Get all entries contained within a given {@link ConfigurationUnit}.
	 * 
	 * @return the entries contained as a unmodifiable {@link Map}, never
	 *         {@code null}.
	 */
	public Map<String, String> getEntries();

	/**
	 * Get all {@link PropertyValueMetaInfo} contained within a given
	 * {@link ConfigurationUnit}.
	 * 
	 * @return the {@link PropertyValueMetaInfo} entries contained as a
	 *         unmodifiable {@link Map}, never {@code null}.
	 */
	public Map<String, Map<String, String>> getMetaInfo();

	/**
	 * Allows to determine if the given {@link ConfigurationUnit} defines any
	 * properties in the given context( {@link Environment} ).
	 * 
	 * @param environment
	 *            the environment where the config is evaluated.
	 * @return true, if the {@link ConfigurationUnit} is defined.
	 */
	public boolean isActive(Environment environment);

}
