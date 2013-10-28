package org.javaconfig.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaconfig.api.Configuration;
import org.javaconfig.api.ConfigurationQuery;
import org.javaconfig.api.ConfigurationType;
import org.javaconfig.api.Environment;
import org.javaconfig.api.PropertyAdapter;

public abstract class AbstractConfiguration implements Configuration{

	private String name;
	private Configuration parent;
	private ConfigurationType configType;
	private Environment environment;
	private List<Configuration> children;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPath() {
		if(parent==null){
			return "/";
		}
		return parent.getPath();
	}

	@Override
	public String getFullName() {
		if(parent==null){
			return "/" + getName();
		}
		return parent.getPath() + '/' + getName();
	}

	@Override
	public ConfigurationType getAggregate() {
		return configType;
	}

	@Override
	public Environment getEnvironment() {
		if(environment!=null){
			return environment;
		}
		if(parent!=null){
			return parent.getEnvironment();
		}
		return Environment.ANY;
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public Configuration getParent() {
		return parent;
	}

	@Override
	public List<Configuration> getChildConfigurations() {
		if(children==null){
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(children);
	}

	@Override
	public Configuration getConfiguration(String key) {
		if(children==null){
			throw new IllegalArgumentException("No such child: " + key);
		}
		Configuration cfg = getChildInternal(key);
		if(cfg==null){
			throw new IllegalArgumentException("No such configuration: " + key);
		}
		return cfg;
	}

	private Configuration getChildInternal(String key) {
		for(Configuration cfg: children){
			if(cfg.getName().equals(key)){
				return cfg;
			}
		}
		Configuration current = this;
		String[] path = key.split("/");
		for(String subPath:path){
			if(subPath.isEmpty()){
				continue;
			}
			if(current instanceof AbstractConfiguration){
				current = ((AbstractConfiguration)current).getChildInternal(subPath);
			}
			else{
				try {
					current = current.getConfiguration(subPath); 
				} catch (Exception e) {
					e.printStackTrace();
					current = null;
				}
			}
			if(current==null){
				return null;
			}
		}
		return current;
	}

	@Override
	public boolean isConfigurationPresent(String key) {
		return getChildInternal(key)!=null;
	}

	@Override
	public ConfigurationQuery createConfigurationQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProperty(String key){
		String value = getProperty(key, null);
		if(value==null){
			throw new IllegalArgumentException("No such property: " + key);
		}
		return value;
	}

	@Override
	public abstract String getProperty(String key, String defaultValue);


	@Override
	public Boolean getBooleanProperty(String key) {
		String val = getProperty(key);
		if(Boolean.parseBoolean(val) || "yes".equalsIgnoreCase(val)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
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
	public <T> T getPropertyAdapted(String key, PropertyAdapter<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getPropertyAdapted(String key, PropertyAdapter<T> adapter, T defaultValue) {
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
