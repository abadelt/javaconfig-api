package org.javaconfig.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.config.Configuration;
import javax.config.PropertyAdapter;
import javax.config.PropertyValueMetaInfo;

public abstract class AbstractConfiguration implements Configuration {

	private String name;
	private Configuration parent;
	private List<Configuration> children;

	@Override
	public abstract String getProperty(String key, String defaultValue);
	
	@Override
	public abstract PropertyValueMetaInfo getPropertyMetaInfo(String key);
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPath() {
		if (parent == null) {
			return "/";
		}
		return parent.getPath();
	}

	@Override
	public String getFullName() {
		if (parent == null) {
			return "/" + getName();
		}
		return parent.getPath() + '/' + getName();
	}

	@Override
	public Configuration getParent() {
		return parent;
	}

	@Override
	public List<Configuration> getChildConfigurations() {
		if (children == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(children);
	}

	@Override
	public Configuration getConfiguration(String key) {
		if (children == null) {
			throw new IllegalArgumentException("No such child: " + key);
		}
		Configuration cfg = getChildInternal(key);
		if (cfg == null) {
			throw new IllegalArgumentException("No such configuration: " + key);
		}
		return cfg;
	}

	private Configuration getChildInternal(String key) {
		for (Configuration cfg : children) {
			if (cfg.getName().equals(key)) {
				return cfg;
			}
		}
		Configuration current = this;
		String[] path = key.split("/");
		for (String subPath : path) {
			if (subPath.isEmpty()) {
				continue;
			}
			if (current instanceof AbstractConfiguration) {
				current = ((AbstractConfiguration) current)
						.getChildInternal(subPath);
			}
			else {
				try {
					current = current.getConfiguration(subPath);
				} catch (Exception e) {
					e.printStackTrace();
					current = null;
				}
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	@Override
	public boolean isConfigurationPresent(String key) {
		return getChildInternal(key) != null;
	}

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
