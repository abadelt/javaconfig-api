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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.ConfigurationUnit;
import javax.config.Environment;

/**
 * Implementation for a {@link ConfigurationUnit} that is an aggregate of multiple child instances.
 * Controlled by an {@link AggregationPolicy} the following aggregations are supported:
 * <ul>
 * <li><b>IGNORE: </b>Ignore all overrides.</li>
 * <li><b>: </b></li>
 * <li><b>: </b></li>
 * <li><b>: </b></li>
 * </ul>
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
	 * Get the {@link AggregationPolicy} for this instance.
	 * 
	 * @return the {@link AggregationPolicy}, never {@code null}.
	 */
	public AggregationPolicy getAggregationPolicy() {
		return policy;
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
		switch (policy) {
		case IGNORE:
			for (ConfigurationUnit unit : units) {
				value = unit.getProperty(key);
				if (value != null) {
					return value;
				}
			}
			return value;
		case EXCEPTION:
			for (ConfigurationUnit unit : units) {
				String nvalue = unit.getProperty(key);
				if (value != null) {
					throw new IllegalStateException("Duplicate key: " + key
							+ " in " + this);
				}
				else {
					value = nvalue;
				}
			}
			return value;
		case OVERRIDE:
			for (ConfigurationUnit unit : units) {
				String nvalue = unit.getProperty(key);
				if (nvalue != null) {
					value = nvalue;
				}
			}
			return value;
		default:
			return null;
		}
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		Map<String, String> value = null;
		switch (policy) {
		case IGNORE:
			for (ConfigurationUnit unit : units) {
				value = unit.getPropertyMetaInfo(key);
				if (value != null) {
					return value;
				}
			}
			return value;
		case EXCEPTION:
			for (ConfigurationUnit unit : units) {
				Map<String, String> nvalue = unit.getPropertyMetaInfo(key);
				if (value != null) {
					throw new IllegalStateException("Duplicate key: " + key
							+ " in " + this);
				}
				else {
					value = nvalue;
				}
			}
			return value;
		case OVERRIDE:
			for (ConfigurationUnit unit : units) {
				Map<String, String> nvalue = unit.getPropertyMetaInfo(key);
				if (nvalue != null) {
					value = nvalue;
				}
			}
			return value;
		default:
			return Collections.emptyMap();
		}
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
	public Collection<String> getSourceExpressions() {
		Set<String> result = new HashSet<String>();
		for (ConfigurationUnit unit : units) {
			result.addAll(unit.getSourceExpressions());
		}
		return result;
	}

	@Override
	public Map<String, String> getEntries() {
		Map<String, String> value = new HashMap<String, String>();
		for (ConfigurationUnit unit : units) {
			for (Map.Entry<String, String> entry : unit.getEntries().entrySet()) {
				switch (policy) {
				case IGNORE:
					if (!value.containsKey(entry.getKey())) {
						value.put(entry.getKey(), entry.getValue());
					}
					break;
				case EXCEPTION:
					if (value.containsKey(entry.getKey())) {
						throw new IllegalStateException("Duplicate key: "
								+ entry.getKey()
								+ " in " + this);
					}
					else {
						value.put(entry.getKey(), entry.getValue());
					}
					break;
				case OVERRIDE:
					value.put(entry.getKey(), entry.getValue());
					break;
				default:
					break;
				}
			}
		}
		return value;
	}

	/**
	 * Get the aggregated meta information, aggregation hereby is defined by the
	 * AggregationPolicy.
	 * 
	 * @see #getAggregationPolicy
	 * @return the aggregated meta information.
	 */
	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		Map<String, Map<String, String>> value = new HashMap<String, Map<String, String>>();
		for (ConfigurationUnit unit : units) {
			for (Map.Entry<String, Map<String, String>> entry : unit
					.getMetaInfo().entrySet()) {
				switch (policy) {
				case IGNORE:
					if (!value.containsKey(entry.getKey())) {
						value.put(entry.getKey(), entry.getValue());
					}
					break;
				case EXCEPTION:
					if (value.containsKey(entry.getKey())) {
						throw new IllegalStateException("Duplicate key: "
								+ entry.getKey()
								+ " in " + this);
					}
					else {
						value.put(entry.getKey(), entry.getValue());
					}
					break;
				case OVERRIDE:
					value.put(entry.getKey(), entry.getValue());
					break;
				default:
					break;
				}
			}
		}
		return value;
	}

	/**
	 * Returns {@code true} if at least one of the aggregated
	 * {@link ConfigurationUnit} instances is active.
	 * 
	 * @param environment
	 *            The current environment
	 * @return {@code true} if at least one of the aggregated
	 *         {@link ConfigurationUnit} instances is active.
	 */
	@Override
	public boolean isActive(Environment environment) {
		for (ConfigurationUnit unit : units) {
			if (unit.isActive(environment)) {
				return true;
			}
		}
		return false;
	}

}
