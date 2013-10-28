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

import java.io.Serializable;

/**
 * Encapsulates a concrete configuration value.
 * 
 * @author Anatole Tresch
 * 
 */
public final class PropertyValueMetaInfo implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private String location;
	private String configPath;
	private long readDT;

	/**
	 * @return the location of the config source for this entry.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the underlying config path expression.
	 */
	public String getConfigPath() {
		return configPath;
	}

	/**
	 * @return the UTC timestamp, when this item was read.
	 */
	public long getReadDT() {
		return readDT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PropertyValueMetaInfo [location=" + location + ", configPath="
				+ configPath + ", readDT=" + readDT + "]";
	}

}
