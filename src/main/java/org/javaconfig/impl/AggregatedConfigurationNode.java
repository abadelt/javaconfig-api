package org.javaconfig.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaconfig.api.ConfigurationNode;
import org.javaconfig.api.PropertyAdapter;
import org.javaconfig.api.PropertyValue;

public class AggregatedConfigurationNode implements ConfigurationNode {

	public enum AggregationPolicy{
		/** Ignore overrides, only extend (additive). */
		IGNORE,
		/** Interpret later keys as override (additive and override), replacing the key loaded earlier. */
		OVERRIDE,
		/** Throw an exception, when keys are not disjunctive (strictly additive). */
		EXCEPTION
	}
	
	public AggregatedConfigurationNode(String name,
			ConfigurationNode... combinedNodes) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigurationNode> getChildNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigurationNode getNode(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigurationNode> findNodes(String expression) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNodePresent(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPropertyPresent(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PropertyValue> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyValue getPropertyEntry(String key) {
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
