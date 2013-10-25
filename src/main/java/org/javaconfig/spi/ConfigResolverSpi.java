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

import javax.inject.Scope;

public interface ConfigResolverSpi {

	/**
	 * Read the configuration from the given source expression.
	 * 
	 * @param source
	 *            the source expression, not null.
	 * @return the configuration read, never {@code null}.
	 */
	String resolveConfig(String key, String value, Scope scope);
}
