package org.javaconfig.config;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.Environment;

public abstract class AbstractResourceConfigurationUnit extends
		AbstractConfigUnit {

	private ClassLoader classLoader;
	private AbstractResourceConfigurationUnit parentConfig;

	public AbstractResourceConfigurationUnit(ClassLoader classLoader,
			AbstractResourceConfigurationUnit parentConfig,
			String name, Set<String> sourceExpressions,
			long configReadDT, Map<String, String> entries,
			Map<String, Map<String, String>> metaInfo, Set<String> sources,
			List<Throwable> errors) {
		super(name);
		for (String source : sources) {
			if(!isSourceRead(source)){
				readSource(source);
			}
		}
		addSourceExpressions(sourceExpressions);
		for (Throwable err : errors) {
			addError(err);
		}
		Objects.requireNonNull(classLoader, "classLoader required.");
		this.classLoader = classLoader;
		this.parentConfig = parentConfig;
	}

	protected abstract void readSource(String source);

	public AbstractResourceConfigurationUnit(ClassLoader classLoader,
			AbstractResourceConfigurationUnit parentConfig,
			String name, String sourceExpression) {
		super(name);
		addSourceExpression(sourceExpression);
		Objects.requireNonNull(classLoader, "classLoader required.");
		this.classLoader = classLoader;
		this.parentConfig = parentConfig;
	}

	public boolean isSourceRead(String source) {
		if (super.isSourceRead(source)) {
			return true;
		}
		if (parentConfig != null) {
			return parentConfig.isSourceRead(source);
		}
		return false;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public AbstractResourceConfigurationUnit getParentConfig() {
		return this.parentConfig;
	}

	@Override
	public boolean isActive(Environment environment) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (cl == null) {
			return false;
		}
		ClassLoader currentCL = cl;
		while (currentCL != null) {
			if (currentCL == this.classLoader) {
				return true;
			}
			currentCL = currentCL.getParent();
		}
		return false;
	}

}
