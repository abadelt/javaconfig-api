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

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.config.ConfigurationUnit;

public class FilteredConfigurationUnit implements ConfigurationUnit {

	public FilteredConfigurationUnit(
			ConfigurationUnit configuration) {
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
	public Set<String> getSources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Throwable> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSourceExpression() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
