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

/**
 * A builder for creating new configuration instances.
 * 
 * @author Anatole Tresch
 * 
 */
public interface ConfigurationBuilder {

	public ConfigurationBuilder withName(String name);

	public ConfigurationBuilder withEnvironmentSelector(
			EnvironmentSelector environment);

	public ConfigurationBuilder withConfiguration(Configuration config);

	public ConfigurationBuilder withLocation(String location);

	public ConfigurationBuilder withQueryPath(String queryPath);

	public ConfigurationBuilder withMetaInfo(PropertyValueMetaInfo metaInfo);

	public ConfigurationBuilder withProperty(String key, String value,
			PropertyValueMetaInfo metaInfo);

	public ConfigurationBuilder withProperty(String key,
			int value);

	public ConfigurationBuilder withProperty(String key,
			byte value);

	public ConfigurationBuilder withProperty(String key,
			short value);

	public ConfigurationBuilder withProperty(String key,
			boolean value);

	public ConfigurationBuilder withProperty(String key,
			char value);

	public ConfigurationBuilder withProperty(String key,
			float value);

	public ConfigurationBuilder withProperty(String key,
			double value);

	public ConfigurationBuilder withProperty(String key,
			long value);

	public ConfigurationBuilder withQuery(ConfigurationQuery<Boolean> query);

	public Configuration build();

}
