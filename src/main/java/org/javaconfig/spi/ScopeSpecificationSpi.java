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
package org.javaconfig.spi;

import java.util.Collection;

import org.javaconfig.api.SingleScope;

/**
 * This SPI interface allows to define the configuration sources, and formats
 * that must be evaluated by the configuration service. the sources are only
 * evaluated, if the corresponding {@link SingleScope} is available.
 * 
 * @author Anatole Tresch
 */
public interface ScopeSpecificationSpi {

	/**
	 * Returns the target scope, for which this definition provides
	 * configuration specifications.
	 * 
	 * @return the target scope, never {@code null}{.
	 */
	public SingleScope getScope();

	/**
	 * Return the configuration mechanisms and locations that should be read on
	 * the current context.
	 * 
	 * @return the sources, in the form {@code readerID:location}.
	 */
	public Collection<ConfigLocation> getSources(); // readerID:location
}
