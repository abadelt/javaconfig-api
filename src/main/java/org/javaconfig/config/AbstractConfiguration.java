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

import java.util.Map;
import java.util.Objects;

import javax.config.Configuration;
import javax.config.ConfigurationAdjuster;
import javax.config.ConfigurationQuery;
import javax.config.EnvironmentSelector;
import javax.config.PropertyAdapter;

public abstract class AbstractConfiguration implements Configuration {

	private String name;

	private EnvironmentSelector environmentSelector;

	public AbstractConfiguration(String name, EnvironmentSelector environmentSelector) {
		Objects.requireNonNull(environmentSelector,
				"environmentSelector required.");
		this.environmentSelector = environmentSelector;
	}

	@Override
	public abstract String getProperty(String key, String defaultValue);

	@Override
	public abstract Map<String, String> getPropertyMetaInfo(String key);

	@Override
	public String getName() {
		return name;
	}

	@Override
	public EnvironmentSelector getTargetEnvironment() {
		return environmentSelector;
	}

	//
	// private Configuration getChildInternal(String key) {
	// for (Configuration cfg : children) {
	// if (cfg.getName().equals(key)) {
	// return cfg;
	// }
	// }
	// Configuration current = this;
	// String[] path = key.split("/");
	// for (String subPath : path) {
	// if (subPath.isEmpty()) {
	// continue;
	// }
	// if (current instanceof AbstractConfiguration) {
	// current = ((AbstractConfiguration) current)
	// .getChildInternal(subPath);
	// }
	// else {
	// try {
	// current = current.getConfiguration(subPath);
	// } catch (Exception e) {
	// e.printStackTrace();
	// current = null;
	// }
	// }
	// if (current == null) {
	// return null;
	// }
	// }
	// return current;
	// }
	//
	// @Override
	// public boolean isConfigurationPresent(String key) {
	// return getChildInternal(key) != null;
	// }

	@Override
	public String getProperty(String key) {
		String value = getProperty(key, null);
		if (value == null) {
			throw new IllegalArgumentException("No such property: " + key);
		}
		return value;
	}

	@Override
	public Boolean getBooleanProperty(String key) {
		String val = getProperty(key);
		if (Boolean.parseBoolean(val) || "yes".equalsIgnoreCase(val)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean getBooleanProperty(String key, Boolean defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		if (Boolean.parseBoolean(val) || "yes".equalsIgnoreCase(val)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Byte getByteProperty(String key) {
		return Byte.valueOf(getProperty(key));
	}

	@Override
	public Byte getByteProperty(String key, Byte defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return Byte.valueOf(val);
	}

	@Override
	public Short getShortProperty(String key) {
		return Short.valueOf(getProperty(key));
	}

	@Override
	public Short getShortProperty(String key, Short defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return Short.valueOf(val);
	}

	@Override
	public Integer getIntProperty(String key) {
		return Integer.valueOf(getProperty(key));
	}

	@Override
	public Integer getIntProperty(String key, Integer defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return Integer.valueOf(val);
	}

	@Override
	public Long getLongProperty(String key) {
		return Long.valueOf(getProperty(key));
	}

	@Override
	public Long getLongProperty(String key, Long defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return Long.valueOf(val);
	}

	@Override
	public Float getFloatProperty(String key) {
		return Float.valueOf(getProperty(key));
	}

	@Override
	public Float getFloatProperty(String key, Float defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return Float.valueOf(val);
	}

	@Override
	public Double getDoubleProperty(String key) {
		return Double.valueOf(getProperty(key));
	}

	@Override
	public Double getDouble(String key, Double defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return Double.valueOf(val);
	}

	@Override
	public <T> T getAdaptedProperty(String key, PropertyAdapter<T> adapter) {
		return (T) adapter.adapt(getProperty(key));
	}

	@Override
	public <T> T getAdaptedProperty(String key, PropertyAdapter<T> adapter,
			T defaultValue) {
		String val = getProperty(key, null);
		if (val == null) {
			return defaultValue;
		}
		return (T) adapter.adapt(val);
	}

	@Override
	public Configuration with(ConfigurationAdjuster adjuster) {
		return adjuster.adjustInto(this);
	}

	@Override
	public <T> T query(ConfigurationQuery<T> query) {
		return query.queryFrom(this);
	}

}
