package org.javaconfig.config;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class ResourceConfigurationUnit extends
		DefaultConfigurationUnit {

	private ClassLoader classLoader;
	private ResourceConfigurationUnit parentConfig;

	public ResourceConfigurationUnit(ClassLoader classLoader,
			ResourceConfigurationUnit parentConfig,
			String name, String sourceExpression,
			long configReadDT, Map<String, String> entries,
			Map<String, Map<String, String>> metaInfo, Set<String> sources,
			List<Throwable> errors) {
		super(name, sourceExpression, configReadDT, entries, metaInfo, sources,
				errors);
		Objects.requireNonNull(classLoader, "classLoader required.");
		this.classLoader = classLoader;
		this.parentConfig = parentConfig;
	}

	public ResourceConfigurationUnit(ClassLoader classLoader,
			ResourceConfigurationUnit parentConfig,
			String name, String sourceExpression) {
		super(name, sourceExpression);
		Objects.requireNonNull(classLoader, "classLoader required.");
		this.classLoader = classLoader;
		this.parentConfig = parentConfig;
	}

	public boolean isSourceRead(String source) {
		if (getSources().contains(source)) {
			return true;
		}
		if (parentConfig != null) {
			return parentConfig.isSourceRead(source);
		}
		return false;
	}

	public ClassLoader getClassLoader(){
		return classLoader;
	}

	public ResourceConfigurationUnit getParentConfig() {
		return this.parentConfig;
	}

	public static final class Builder extends DefaultConfigurationUnit.Builder {

		private ClassLoader classLoader;
		private ResourceConfigurationUnit parentConfig;

		public Builder(String name, ClassLoader classLoader) {
			super(name);
			Objects.requireNonNull(classLoader);
		}

		public Builder withClassLoader(ClassLoader classLoader) {
			Objects.requireNonNull(classLoader);
			this.classLoader = classLoader;
			return this;
		}

		public Builder withParentConfig(ResourceConfigurationUnit parentConfig) {
			this.parentConfig = parentConfig;
			return this;
		}

		@Override
		public ResourceConfigurationUnit build() {
			return new ResourceConfigurationUnit(classLoader, parentConfig,
					name, sourceExpression, configReadDT, entries, metaInfo,
					sources, errors);
		}
	}

}
