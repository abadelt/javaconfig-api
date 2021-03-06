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
package javax.config;

/**
 * The selector is responsible for determining if a configuration should be
 * included into the current configuration aggregate for a given runtime
 * {@link Environment}.
 * 
 * @author Anatole Tresch
 */
// @FunctionalInterface
public interface EnvironmentSelector {

	/**
	 * Selectors that selects every environment.
	 */
	public static final EnvironmentSelector ANY = new EnvironmentSelector(){
		@Override
		public boolean isMatching(Environment environment) {
			return true;
		}};
	
	public boolean isMatching(Environment environment);

}
