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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.ConfigurationUnit;

/**
 * Result object returned by readers, that read configuration.
 * 
 * @author Anatole Tresch
 * 
 */
public class DefaultConfigurationUnit implements ConfigurationUnit {

	private String name;
	private String sourceExpression;
	private long configReadDT = System.currentTimeMillis();
	private Map<String, Map<String, String>> metaInfo = new HashMap<String, Map<String, String>>();
	private Map<String, String> entries = new HashMap<String, String>();
	private Set<String> sources;
	private List<Throwable> errors;

	protected DefaultConfigurationUnit(String name, String sourceExpression,
			Long configReadDT, Map<String, String> entries,
			Map<String, Map<String, String>> metaInfo, Set<String> sources,
			List<Throwable> errors) {
		Objects.requireNonNull(name, "name required.");
		Objects.requireNonNull(sourceExpression, "sourceExpression required.");
		Objects.requireNonNull(entries, "entries required.");
		Objects.requireNonNull(metaInfo, "metaInfo required.");
		this.name = name;
		this.sourceExpression = sourceExpression;
		this.entries = entries;
		this.metaInfo = metaInfo;
		this.sources = sources;
		this.errors = errors;
	}

	protected DefaultConfigurationUnit(String name, String sourceExpression) {
		Objects.requireNonNull(name, "name required.");
		Objects.requireNonNull(sourceExpression, "sourceExpression required.");
		this.name = name;
		this.sourceExpression = sourceExpression;
	}

	public String getSourceExpression() {
		return sourceExpression;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public long getConfigReadDT() {
		return this.configReadDT;
	}

	@Override
	public Set<String> getSources() {
		if (sources != null) {
			return Collections.unmodifiableSet(sources);
		}
		return Collections.emptySet();
	}

	@Override
	public List<Throwable> getErrors() {
		if (errors != null) {
			return Collections.unmodifiableList(errors);
		}
		return Collections.emptyList();
	}

	@Override
	public Map<String, String> getEntries() {
		return Collections.unmodifiableMap(this.entries);
	}

	@Override
	public String getProperty(String key) {
		return this.entries.get(key);
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		return this.metaInfo.get(key);
	}

	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		return Collections.unmodifiableMap(this.metaInfo);
	}

	protected void addEntry(String key, String value,
			Map<String, String> metaInfo) {
		Objects.requireNonNull(key, "key required.");
		Objects.requireNonNull(value, "value required.");
		this.entries.put(key, value);
		if(metaInfo!=null){
			this.metaInfo.put(key, metaInfo);
		}
	}

	protected void addSource(String source) {
		if (this.sources == null) {
			this.sources = new HashSet<String>();
		}
		this.sources.add(source);
	}

	protected void addError(Throwable error) {
		if (this.errors == null) {
			this.errors = new ArrayList<Throwable>();
		}
		this.errors.add(error);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefaultConfigurationUnit [name=" + name + ", sourceExpression="
				+ sourceExpression + ", configReadDT=" + configReadDT
				+ ", entries=" + entries + ", metaInfo=" + metaInfo
				+ ", sources=" + sources + ", errors=" + errors + "]";
	}

	public static class Builder {
		protected String name;
		protected String sourceExpression = "N/A";
		protected long configReadDT = System.currentTimeMillis();
		protected Map<String, Map<String, String>> metaInfo = new HashMap<String, Map<String, String>>();
		protected Map<String, String> entries = new HashMap<String, String>();
		protected Set<String> sources;
		protected List<Throwable> errors;

		public Builder() {
		}

		public Builder(String readerId) {
			Objects.requireNonNull(readerId);
			this.name = readerId;
		}

		public Builder withName(String name) {
			Objects.requireNonNull(name);
			this.name = name;
			return this;
		}

		public Builder withConfigReadDT(long readDT) {
			this.configReadDT = readDT;
			return this;
		}

		public Builder withSourceExpression(String sourceExpression) {
			Objects.requireNonNull(sourceExpression);
			this.sourceExpression = sourceExpression;
			return this;
		}

		public Builder withEntry(String key, String value,
				Map<String, String> metaInfo) {
			Objects.requireNonNull(key, "key required.");
			Objects.requireNonNull(value, "value required.");
			Objects.requireNonNull(metaInfo, "metaInfo required.");
			this.entries.put(key, value);
			this.metaInfo.put(key, metaInfo);
			return this;
		}

		public Builder withSource(String source) {
			if (this.sources == null) {
				this.sources = new HashSet<String>();
			}
			this.sources.add(source);
			return this;
		}

		public Builder withError(Throwable error) {
			if (this.errors == null) {
				this.errors = new ArrayList<Throwable>();
			}
			this.errors.add(error);
			return this;
		}

		public DefaultConfigurationUnit build() {
			return new DefaultConfigurationUnit(name, sourceExpression,
					configReadDT,
					entries, metaInfo, sources, errors);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "DefaultConfigurationUnit.Builder [name=" + name
					+ ", sourceExpression="
					+ sourceExpression + ", configReadDT=" + configReadDT
					+ ", metaInfo=" + metaInfo + ", entries=" + entries
					+ ", sources=" + sources + ", errors=" + errors + "]";
		}

	}
}