package org.javaconfig.api;

import java.util.Collections;
import java.util.Map;

public interface Environment {

	public static final Environment ANY = new Environment(){

		@Override
		public String getStage() {
			return "<ANY>";
		}

		@Override
		public Map<String, String> getProperties() {
			return Collections.emptyMap();
		}};

	public String getStage();

	public Map<String, String> getProperties();

}
