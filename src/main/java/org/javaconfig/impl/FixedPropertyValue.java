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
package org.javaconfig.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.javaconfig.api.PropertyAdapter;
import org.javaconfig.api.PropertyValue;

/**
 * Encapsulates a concrete configuration value.
 * 
 * @author Anatole Tresch
 * 
 */
public final class FixedPropertyValue implements PropertyValue, Serializable,
		Comparable<FixedPropertyValue> {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	private Map<Class, PropertyAdapter> adaptedValues;
	private String location;
	private long readDT = System.currentTimeMillis();
	private Map<String, Object> attributes;

	public FixedPropertyValue(String key, String value,
			String location, long readDT, Map<String, Object> attributes) {
		Objects.requireNonNull(key, "key required.");
		Objects.requireNonNull(value, "value required.");
		Objects.requireNonNull(location, "location required.");
		Objects.requireNonNull(attributes, "attributes required.");
		this.key = key;
		this.value = value;
		this.location = location;
		this.attributes = attributes;
		if (readDT > 0) {
			this.readDT = readDT;
		}
	}

	/**
	 * @return the key
	 */
	public final String getKey() {
		return key;
	}

	/**
	 * Return the base String value.
	 * 
	 * @return the value, not {@code null}.
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * Return the adapted value.
	 * 
	 * @param type
	 *            The target type.
	 * @return the value
	 * @throws IllegalArgumentException
	 *             if not corresponding {@link PropertyAdapter} is present.
	 */
	public final <T> T getValue(Class<T> type) {
		PropertyAdapter adapter = this.adaptedValues.get(type);
		if (adapter == null) {
			throw new IllegalArgumentException("No adapter for type: "
					+ type.getName());
		}
		return (T) adapter.getAdapted();
	}

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
	public final <T> T adapt(Class<PropertyAdapter<T>> adapterType) {
		PropertyAdapter<T> adapter;
		try {
			adapter = adapterType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Invalid adapter: "
					+ adapterType, e);
		}
		adapter.init(this);
		Class<T> type = adapter.getTargetType();
		if (this.adaptedValues.containsKey(type)) {
			throw new IllegalArgumentException("Adapter for " + type
					+ " already registered.");
		}
		this.adaptedValues.put(type, adapter);
		return (T) adapter.getAdapted();
	}

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
	public final <T> T adapt(Class<T> type,
			Class<PropertyAdapter<? extends T>> adapterType) {
		if (this.adaptedValues.containsKey(type)) {
			throw new IllegalArgumentException("Adapter for " + type
					+ " already registered.");
		}
		PropertyAdapter<? extends T> adapter;
		try {
			adapter = adapterType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Invalid adapter: "
					+ adapterType, e);
		}
		adapter.init(this);
		this.adaptedValues.put(type, adapter);
		return (T) adapter.getAdapted();
	}

	/**
	 * Access a registered adapter for a type.
	 * 
	 * @param type
	 *            the target type.
	 * @return the {@link PropertyAdapter} registered, or {@code null}.
	 */
	public <T> PropertyAdapter<T> getAdapter(Class<T> type) {
		return this.adaptedValues.get(type);
	}

	/**
	 * Returns the list of non String value types, currently available on this
	 * item.
	 * 
	 * @return the adapted types, never {@code null}.
	 */
	public final Set<Class> getAdaptedTypes() {
		return Collections.unmodifiableSet(adaptedValues.keySet());
	}

	/**
	 * @return the location
	 */
	public final String getLocation() {
		return location;
	}

	/**
	 * @return the readDT
	 */
	public final long getReadDT() {
		return readDT;
	}

	/**
	 * @return the attributes
	 */
	public final Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public int compareTo(FixedPropertyValue o) {
		return this.key.compareTo(o.key);
	}

	public static final class Builder {
		private String key;
		private String value;
		private String location;
		private long readDT = System.currentTimeMillis();
		private Map<String, Object> attributes = new HashMap<String, Object>();

		public Builder withKey(String key) {
			Objects.requireNonNull(key, "key required.");
			this.key = key;
			return this;
		}

		public Builder withValue(String value) {
			Objects.requireNonNull(value, "value required.");
			this.value = value;
			return this;
		}

		public Builder withLocation(String location) {
			Objects.requireNonNull(location, "location required.");
			this.location = location;
			return this;
		}

		public Builder withAttributes(Map<String, Object> attributes) {
			Objects.requireNonNull(attributes, "attributes required.");
			this.attributes.putAll(attributes);
			return this;
		}

		public Builder withAttribute(String key, Object value) {
			Objects.requireNonNull(key, "attribute key required.");
			Objects.requireNonNull(value, "attribute value required.");
			this.attributes.put(key, value);
			return this;
		}

		public FixedPropertyValue build() {
			return new FixedPropertyValue(key, value, location, readDT,
					attributes);
		}
	}

}
