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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Models a node within the current configuration tree.
 * 
 * @author Anatole Tresch
 */
public interface ConfigurationNode {
	/**
	 * Access the scopes, that are represented by this given node.
	 * 
	 * @return the current nodes, which are currently working for.
	 */
	public List<Scope> getScopes();

	/**
	 * The (partial) path name of the node, never {@code null}.
	 * 
	 * @return the path name.
	 */
	public String getName();

	public List<ConfigurationNode> getChildNodes();

	public ConfigurationNode getNode(String key);

	public Collection<ConfigurationNode> findNodes(String expression);

	public boolean isNodePresent(String key);

	public boolean isPropertyPresent(String key);

	public List<ConfigEntry> getProperties();

	public ConfigEntry getPropertyEntry(String key);

	public Class getPropertyType(String key);

	public String getTextProperty(String key);

	public String getTextProperty(String key, String defaultValue);

	public Boolean getBooleanProperty(String key);

	public Boolean getBooleanProperty(String key, Boolean defaultValue);

	public Byte getByteProperty(String key);

	public Byte getByteProperty(String key, Byte defaultValue);

	public Short getShortProperty(String key);

	public Short getShortProperty(String key, Short defaultValue);

	public Integer getIntProperty(String key);

	public Integer getIntProperty(String key, Integer defaultValue);

	public Long getLongProperty(String key);

	public Long getLongProperty(String key, Long defaultValue);

	public Float getFloatProperty(String key);

	public Float getFloatProperty(String key, Float defaultValue);

	public Double getDoubleProperty(String key);

	public Double getDouble(String key, Double defaultValue);

	public <T> T getProperty(String key, Class<T> type);

	public <T> T getProperty(String key, Class<T> type, T defaultValue);

	public <T> T getProperty(String key, Class<T> type, Converter converter);

	public <T> T getProperty(String key, Class<T> type, T defaultValue,
			Converter converter);

	public Map<String, String> getMapProperty(String key);

	public Map<String, String> getMapProperty(String key,
			Map<String, String> defaultValue);

	public <T> Map<String, T> getMapProperty(String key, Class<T> type);

	public <T> Map<String, T> getMapProperty(String key, Class<T> type,
			Map<String, T> defaultValue);

	public List<String> getListProperty(String key);

	public List<String> getListProperty(String key,
			List<String> defaultValue);

	public <T> List<T> getListProperty(String key, Class<T> type);

	public <T> List<T> getListProperty(String key, Class<T> type,
			List<T> defaultValue);

	public Set<String> getSetProperty(String key);

	public Set<String> getSetProperty(String key,
			Set<String> defaultValue);

	public <T> Set<T> getSetProperty(String key, Class<T> type);

	public <T> Set<T> getSetProperty(String key, Class<T> type,
			Set<T> defaultValue);
}
