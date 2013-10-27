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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaconfig.api.AggregateInstance;
import org.javaconfig.api.ConfigService.ConfigurationQuery;
import org.javaconfig.api.Configuration;
import org.javaconfig.api.PropertyAdapter;

public class FilteredConfiguration implements Configuration {

	public FilteredConfiguration(
			Configuration configuration) {
		// , Predicate<Configuration> nodeFilter,
		// Predicate<PropertyValue> property) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AggregateInstance getAggregateInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Configuration getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuration> getChildConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration getConfiguration(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConfigurationPresent(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ConfigurationQuery createConfigurationQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getPropertyType(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextProperty(String key, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getBooleanProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getBooleanProperty(String key, Boolean defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Byte getByteProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Byte getByteProperty(String key, Byte defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Short getShortProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Short getShortProperty(String key, Short defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getIntProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getIntProperty(String key, Integer defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getLongProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getLongProperty(String key, Long defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getFloatProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getFloatProperty(String key, Float defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getDoubleProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getDouble(String key, Double defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getProperty(String key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getProperty(String key, Class<T> type, T defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getProperty(String key, Class<T> type, PropertyAdapter adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getProperty(String key, Class<T> type, T defaultValue,
			PropertyAdapter adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMapProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getMapProperty(String key,
			Map<String, String> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Map<String, T> getMapProperty(String key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Map<String, T> getMapProperty(String key, Class<T> type,
			Map<String, T> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListProperty(String key, List<String> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getListProperty(String key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getListProperty(String key, Class<T> type,
			List<T> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSetProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSetProperty(String key, Set<String> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<T> getSetProperty(String key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<T> getSetProperty(String key, Class<T> type,
			Set<T> defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

}