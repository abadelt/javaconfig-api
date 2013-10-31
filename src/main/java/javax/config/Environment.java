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

import java.util.Collections;
import java.util.Map;

/**
 * Models the current runtime environment. Instances of this class are selected
 * by {@link EnvironmentSelector} to evaluate if configuration artifacts are to
 * be included (selected) into the current configuration aggregate.
 * 
 * @author Anatole Tresch
 */
public interface Environment {

//	// Which properties hould be explicit?
//	// Stage
//	// Development Mode?
//	// Global Log Level?
//	// Tier?
//	// AppId?
//	// EarID?
//	// RuntimeID?
//	// Timezone?
//	// Country?
//	// Language?
//	// User?
//
//	public static final Environment ANY = new Environment() {
//
//		@Override
//		public String getStage() {
//			return "<ANY>";
//		}
//
//		@Override
//		public Map<String, String> getProperties() {
//			return Collections.emptyMap();
//		}
//	};

	public Stage getStage();

	public Map<String, String> getProperties();

}
