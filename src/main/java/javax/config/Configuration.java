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

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A aggregate configuration identifies a a configuration set that is defined by
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
 * {@link ConfigurationUnit} instances can be added to existing aggregates.
 * <br/>
 * 
 * @author Anatole Tresch
 */
public interface Configuration extends ConfigurationUnit{

	/**
	 * Get the property value as {@link String}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public String getProperty(String key, String defaultValue);

	/**
	 * Get the property value as {@link Boolean}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Boolean getBooleanProperty(String key);

	/**
	 * Get the property value as {@link Boolean}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Boolean getBooleanProperty(String key, Boolean defaultValue);

	/**
	 * Get the property value as {@link Byte}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Byte getByteProperty(String key);

	/**
	 * Get the property value as {@link Byte}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Byte getByteProperty(String key, Byte defaultValue);

	/**
	 * Get the property value as {@link Short}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Short getShortProperty(String key);

	/**
	 * Get the property value as {@link Short}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Short getShortProperty(String key, Short defaultValue);

	/**
	 * Get the property value as {@link Integer}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Integer getIntProperty(String key);

	/**
	 * Get the property value as {@link Integer}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Integer getIntProperty(String key, Integer defaultValue);

	/**
	 * Get the property value as {@link Long}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Long getLongProperty(String key);

	/**
	 * Get the property value as {@link Long}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Long getLongProperty(String key, Long defaultValue);

	/**
	 * Get the property value as {@link Float}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Float getFloatProperty(String key);

	/**
	 * Get the property value as {@link Float}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Float getFloatProperty(String key, Float defaultValue);

	/**
	 * Get the property value as {@link Double}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if no such property exists.
	 */
	public Double getDoubleProperty(String key);

	/**
	 * Get the property value as {@link Double}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public Double getDouble(String key, Double defaultValue);

	/**
	 * Get the property value as type {@code Class<T>}.
	 * <p>
	 * If {@code Class<T>} is not one of
	 * {@code Boolean, Short, Integer, Long, Float, Double, BigInteger, BigDecimal, String}
	 * , an according {@link Converter} must be available to perform the
	 * conversion from {@link String} to {@code Class<T>}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param type
	 *            the required target type.
	 * @param converter
	 *            the {@link Converter} to perform the conversion from
	 *            {@link String} to {@code Class<T>}, not {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type, or no such property exists.
	 */
	public <T> T getAdaptedProperty(String key, PropertyAdapter<T> adapter);

	/**
	 * Get the property value as type {@code Class<T>}.
	 * 
	 * @param key
	 *            the property's absolute, or relative path, e.g. @code
	 *            a/b/c/d.myProperty}.
	 * @param type
	 *            the required target type.
	 * @param defaultValue
	 *            the default value, returned if no such property exists or the
	 *            property's value is {@code null}.
	 * @param converter
	 *            the {@link Converter} to perform the conversion from
	 *            {@link String} to {@code Class<T>}, not {@code null}.
	 * @return the property's value.
	 * @throws IllegalArgumentException
	 *             if the value could not be converted to the required target
	 *             type.
	 */
	public <T> T getAdaptedProperty(String key, PropertyAdapter<T> adapter,
			T defaultValue);

	/**
	 * Extension point for adjusting configuration.
	 * 
	 * @param adjuster
	 *            A configuration ajuster, e.g. a filter, or an adjuster
	 *            combining configurations.
	 * @return the new adjusted configuration, never {@code null}.
	 */
	public Configuration with(ConfigurationAdjuster adjuster);

	/**
	 * Query some value from a configuration.
	 * 
	 * @param query
	 *            the query, never {@code null}.
	 * @return the result
	 */
	public <T> T query(ConfigurationQuery<T> query);

}
