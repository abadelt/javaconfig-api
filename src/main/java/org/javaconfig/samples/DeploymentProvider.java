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

import javax.config.ConfigService;
import javax.config.Configuration;
import javax.config.ConfigurationModel;
import javax.config.JavaConfig;

public class DeploymentProvider {

	public static void main(String[] args) {
		ConfigService service = JavaConfig.getConfigService();
		// Main configuration done by ServiceLoader based services and
		// custom implemented system or environment properties, mechanisms
		System.out.println(service.getCurrentEnvironment());
		// Access default configuration for current environment
		ConfigurationModel model = service.getConfiguration();
		Configuration deploymentConfig = model.getConfiguration("deployment");
		String startupName = deploymentConfig
				.getProperty("deploy.startupName", "N/A");
		int intProp = deploymentConfig.getIntProperty(
				"deploy.mainContainer.size");
		// ...
	}
}
