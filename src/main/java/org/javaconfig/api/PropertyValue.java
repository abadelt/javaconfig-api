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

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Encapsulates a concrete configuration value.
 * 
 * @author Anatole Tresch
 * 
 */
public interface PropertyValue {
	
	/**
	 * @return the key
	 */
	public String getKey();

	/**
	 * Return the base String value.
	 * 
	 * @return the value, not {@code null}.
	 */
	public String getValue();

	/**
	 * Return the adapted value.
	 * 
	 * @param type
	 *            The target type.
	 * @return the value
	 * @throws IllegalArgumentException
	 *             if not corresponding {@link PropertyAdapter} is present.
	 */
	public <T> T getValue(Class<T> type);

	/**
	 * Adapt the property value, with the given adapter type.
	 * 
	 * @param type
	 *            The additional return type to be enabled for this instance.
	 * @param adapterType
	 *            The adapter class to be used.
	 * @return the adapted value
	 * @throws IllegalArgumentException
	 *             if the adapter cannot be instantiated, or such an adapter is
	 *             already registered.
	 */
	public <T> T adapt(Class<PropertyAdapter<T>> adapterType);
	
	/**
	 * Adapt the property value, with the given adapter type.
	 * 
	 * @param type
	 *            The additional return type to be enabled for this instance.
	 * @param adapterType
	 *            The adapter class to be used.
	 * @return the adapted value
	 * @throws IllegalArgumentException
	 *             if the adapter cannot be instantiated, or such an adapter is
	 *             already registered.
	 * 
	 */
	public <T> T adapt(Class<T> type,
			Class<PropertyAdapter<? extends T>> adapterType);

	/**
	 * Access a registered adapter for a type.
	 * 
	 * @param type
	 *            the target type.
	 * @return the {@link PropertyAdapter} registered, or {@code null}.
	 */
	public <T> PropertyAdapter<T> getAdapter(Class<T> type);

	/**
	 * Returns the list of non String value types, currently available on this
	 * item.
	 * 
	 * @return the adapted types, never {@code null}.
	 */
	public Set<Class> getAdaptedTypes();

	/**
	 * @return the location
	 */
	public String getLocation();

	/**
	 * @return the readDT
	 */
	public long getReadDT();

	/**
	 * @return the attributes
	 */
	public Map<String, Object> getAttributes();

}
