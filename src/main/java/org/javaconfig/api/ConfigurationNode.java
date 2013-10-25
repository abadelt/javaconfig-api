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

public interface ConfigurationNode {

	public List<Scope> getScopes();
	
	public String getName();

	public List<ConfigurationNode> getChildNodes();

	public ConfigurationNode getNode(String key);

	public Collection<ConfigurationNode> findNodes(String expression);

	public boolean isNodePresent(String key);

	public boolean isKeyPresent(String key);

	public List<ConfigEntry> getAttributes();

	public ConfigEntry getDetailed(String key);

	public String getText(String key);

	public String getText(String key, String defaultValue);

	public Boolean getBoolean(String key);

	public Boolean getBoolean(String key, Boolean defaultValue);

	public Byte getByte(String key);

	public Byte getByte(String key, Byte defaultValue);

	public Short getShort(String key);

	public Short getShort(String key, Short defaultValue);

	public Integer getInt(String key);

	public Integer getInt(String key, Integer defaultValue);

	public Long getLong(String key);

	public Long getLong(String key, Long defaultValue);

	public Float getFloat(String key);

	public Float getFloat(String key, Float defaultValue);

	public Double getDouble(String key);

	public Double getDouble(String key, Double defaultValue);

	public <T> T get(String key, Class<T> type);

	public <T> T get(String key, Class<T> type, T defaultValue);

	public <T> T get(String key, Class<T> type, Converter converter);

	public <T> T get(String key, Class<T> type, T defaultValue,
			Converter converter);

	public Map<String, String> getMap(String key);

	public Map<String, String> getMap(String key,
			Map<String, String> defaultValue);

	public <T> Map<String, T> getMap(String key, Class<T> type);

	public <T> Map<String, T> getMap(String key, Class<T> type,
			Map<String, T> defaultValue);
}
