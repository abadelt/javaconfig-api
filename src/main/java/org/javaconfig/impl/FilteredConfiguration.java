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

import javax.config.Configuration;
import javax.config.ConfigurationAdjuster;
import javax.config.ConfigurationQuery;
import javax.config.ConfigurationModel;
import javax.config.Environment;
import javax.config.EnvironmentSelector;
import javax.config.PropertyAdapter;
import javax.config.PropertyValueMetaInfo;

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
	public String getProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProperty(String key, String defaultValue) {
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
	public <T> T getAdaptedProperty(String key, PropertyAdapter<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getAdaptedProperty(String key, PropertyAdapter<T> adapter,
			T defaultValue) {
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

	@Override
	public PropertyValueMetaInfo getPropertyMetaInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentSelector getTargetEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration with(ConfigurationAdjuster adjuster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T query(ConfigurationQuery<T> query) {
		// TODO Auto-generated method stub
		return null;
	}

}
