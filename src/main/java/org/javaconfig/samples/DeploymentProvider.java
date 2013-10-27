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
package org.javaconfig.samples;

import org.javaconfig.api.ConfigService;
import org.javaconfig.api.Configuration;
import org.javaconfig.api.JavaConfig;

public class DeploymentProvider {

	public static void main(String[] args) {
		ConfigService service = JavaConfig.getConfigService();
		// Main configuration done by ServiceLoader based services and
		// custom implemented system or environment properties, mechanisms
		System.out.println(service.getCurrentEnvironment());
		// Access default configuration for current environment
		Configuration config = service.getConfiguration();
		String startupName = config
				.getTextProperty("deploy.startupName", "N/A");
		Class implementationType = config.getClassProperty(
				"deploy.mainContainer.class", Appendable.class);
		// ...
	}
}