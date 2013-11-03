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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.ConfigurationUnit;

/**
 * Base implementation for a {@link ConfigurationUnit}.
 * 
 * @author Anatole Tresch
 */
public class AggregatedConfigurationUnit implements ConfigurationUnit {

	private String name;
	private AggregationPolicy policy;
	private List<ConfigurationUnit> units = new ArrayList<ConfigurationUnit>();

	/**
	 * Policy that defines how the different aggregates should be combined.
	 * 
	 * @author Anatole Tresch
	 */
	public enum AggregationPolicy {
		/** Ignore overrides, only extend (additive). */
		IGNORE,
		/**
		 * Interpret later keys as override (additive and override), replacing
		 * the key loaded earlier/from previous contained
		 * {@link ConfigurationUnit}.
		 */
		OVERRIDE,
		/**
		 * Throw an exception, when keys are not disjunctive (strictly
		 * additive).
		 */
		EXCEPTION
	}

	/**
	 * Creates a mew instance, with aggregation polilcy
	 * {@code AggregationPolicy.OVERRIDE}.
	 * 
	 * @param name
	 *            The configuration unit's name.
	 * @param policy
	 *            The aggregation policy to be used.
	 * @param configs
	 *            The units to be included.
	 */
	public AggregatedConfigurationUnit(String name,
			ConfigurationUnit... configs) {
		this(name, AggregationPolicy.OVERRIDE, configs);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param name
	 *            The configuration unit's name.
	 * @param policy
	 *            The aggregation policy to be used.
	 * @param configs
	 *            The units to be included.
	 */
	public AggregatedConfigurationUnit(String name, AggregationPolicy policy,
			ConfigurationUnit... configUnits) {
		Objects.requireNonNull(name);
		this.name = name;
		units.addAll(Arrays.asList(configUnits));
	}

	/**
	 * Return the names of the {@link ConfigurationUnit} instances to be
	 * aggregated in this instance, in the order of precedence (the first are
	 * the weakest).
	 * 
	 * @return the ordered list of aggregated scope identifiers, never
	 *         {@code null}.
	 */
	public List<ConfigurationUnit> getConfigurationUnits() {
		return Collections.unmodifiableList(units);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getProperty(String key) {
		String value = null;
		for (ConfigurationUnit unit : units) {

		}
		return null;
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getSources() {
		Set<String> result = new HashSet<String>();
		for (ConfigurationUnit unit : units) {
			result.addAll(unit.getSources());
		}
		return result;
	}

	@Override
	public List<Throwable> getErrors() {
		List<Throwable> result = new ArrayList<Throwable>();
		for (ConfigurationUnit unit : units) {
			result.addAll(unit.getErrors());
		}
		return result;
	}

	@Override
	public String getSourceExpression() {
		StringBuilder b = new StringBuilder();
		for (ConfigurationUnit unit : units) {
			b.append(unit.getSourceExpression()).append(";");
		}
		return b.toString();
	}

	@Override
	public Map<String, String> getEntries() {
		Map<String, String> result = new HashMap<String, String>();
		// TODO implement this method...
		switch (policy) {
		case IGNORE:
		case EXCEPTION:
		case OVERRIDE:
		default:
			break;
		}
		return result;
	}

	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		// TODO implement this method...
		switch (policy) {
		case IGNORE:
		case EXCEPTION:
		case OVERRIDE:
		default:
			break;
		}
		return result;
	}

}
