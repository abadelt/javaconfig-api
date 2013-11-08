package org.javaconfig.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.config.ConfigurationUnit;

public abstract class AbstractConfigUnit implements ConfigurationUnit {

	private String name;
	private Set<String> sources = new HashSet<String>();
	private Set<String> sourceExpressions = new HashSet<String>();
	private List<Throwable> errors = new ArrayList<Throwable>();

	public AbstractConfigUnit(String name) {
		Objects.requireNonNull(name, "name required.");
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	protected void addSource(String source) {
		Objects.requireNonNull(source);
		this.sources.add(source);
	}

	protected void addSourceExpression(String sourceExpression) {
		Objects.requireNonNull(sourceExpression);
		this.sourceExpressions.add(sourceExpression);
	}

	protected void addSourceExpressions(Collection<String> sourceExpressions) {
		Objects.requireNonNull(sourceExpressions);
		this.sourceExpressions.addAll(sourceExpressions);
	}

	protected void addError(Throwable error) {
		Objects.requireNonNull(error);
		this.errors.add(error);
	}

	@Override
	public Set<String> getSources() {
		return Collections.unmodifiableSet(sources);
	}

	public boolean isSourceRead(String source) {
		return getSources().contains(source);
	}

	@Override
	public List<Throwable> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	@Override
	public Set<String> getSourceExpressions() {
		return Collections.unmodifiableSet(sourceExpressions);
	}

	@Override
	public Map<String, String> getPropertyMetaInfo(String key) {
		return Collections.emptyMap();
	}

	@Override
	public Map<String, Map<String, String>> getMetaInfo() {
		return Collections.emptyMap();
	}

}
