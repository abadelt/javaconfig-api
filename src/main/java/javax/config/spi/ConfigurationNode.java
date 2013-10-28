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

import java.util.Map;

import javax.config.PropertyValueMetaInfo;
//
//
///**
// * Models a node within the current configuration tree.
// * 
// * @author Anatole Tresch
// */
//public interface ConfigurationNode {
//
//	/**
//	 * The name of the node, never {@code null}.
//	 * 
//	 * @return the node's name.
//	 */
//	String getName();
//
//	/**
//	 * The absolute path of the node, never {@code null}.
//	 * 
//	 * @return the node's path.
//	 */
//	String getPath();
//
//	/**
//	 * Allows to evaluate if a property exists.
//	 * 
//	 * @param key
//	 *            the property's absolute, or relative path, e.g. @code
//	 *            a/b/c/d.myProperty}.
//	 * @return {@code true}, if such a node exists.
//	 */
//	boolean isPropertyPresent(String key);
//
//	/**
//	 * Access all property entries attached to this configuration instance.
//	 * 
//	 * @return all entries, never {@code null}.
//	 */
//	Map<String, PropertyValueMetaInfo> getProperties();
//
//	/**
//	 * Access a property entry.
//	 * 
//	 * @param key
//	 *            the property's absolute, or relative path, e.g. @code
//	 *            a/b/c/d.myProperty}.
//	 * @return the property entry, or {@code null}.
//	 */
//	PropertyValueMetaInfo getProperty(String key);
//
//}
