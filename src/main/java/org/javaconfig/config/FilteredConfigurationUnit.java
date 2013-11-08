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
package org.javaconfig.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.ConfigurationUnit;
import javax.config.Environment;

public class FilteredConfigurationUnit implements ConfigurationUnit {

	private ConfigurationUnit unit;
	
	public FilteredConfigurationUnit(
			ConfigurationUnit configuration) {
		Objects.requireNonNull(configuration);
		this.unit = configuration;
		// , Predicate<Configuration> nodeFilter,
		// Predicate<PropertyValue> property) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return unit.getName();
	}

	@Override
	public String getProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSources() {
		return unit.getSources();
	}

	@Override
	public List<Throwable> getErrors() {
		return unit.getErrors();
	}

	@Override
	public Collection<String> getSourceExpressions() {
		return unit.getSourceExpressions();
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		return unit.getMetaInfo();
	}

	@Override
	public boolean isActive(Environment environment) {
		return unit.isActive(environment);
	}

}
