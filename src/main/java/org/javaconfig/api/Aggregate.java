package org.javaconfig.api;

import java.util.List;

/**
 * An aggregate is a ordered combination of {@link Scope} instances.
 * 
 * @author Anatole Tresch
 * 
 */
public interface Aggregate {

	/**
	 * Returns the unique name of a aggregate scope.
	 * 
	 * @return The aggregate scope's name, never {@code null}.
	 */
	public String getName();

	/**
	 * Return the scopes aggregated in this instance, in the order of precedence
	 * (the first are the weekest).
	 * 
	 * @return the ordered list of aggregated scopes, never {@code null}.
	 */
	public List<Scope> getScopes();
	
	/**
	 * Method allows to determine if a scope is contextual. Configuration of
	 * contextual scopes are accessed whenever they are needed.
	 * 
	 * @return true, if this scope is contextual.
	 */
	public boolean isContextual();

}
