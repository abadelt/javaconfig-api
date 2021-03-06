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
package javax.config.spi;

import javax.config.Environment;

/**
 * This SPI allows to define the current runtime environment.
 * <p>
 * <h4>Implementation Requirements</h4>
 * Implementations of this interface must be:
 * <ul>
 * <li>thread safe</li>
 * <li>contextual, and</li>
 * <li>fast, since this may be called many times.</li>
 * </ul>
 * 
 * @author Anatole Tresch
 */
public interface EnvironmentContext {

	/**
	 * Defines the {@link Environment} for the current runtime context.
	 * 
	 * @return the {@link Environment} for the given runtime context.
	 */
	Environment getCurrentEnvironment();

	/**
	 * Defines the global {@link Environment} for this system.
	 * 
	 * @return the {@link Environment} for this system.
	 */
	Environment getSystemEnvironment();

}
