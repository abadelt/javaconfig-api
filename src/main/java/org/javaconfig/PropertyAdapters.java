package org.javaconfig;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.config.PropertyAdapter;

public final class PropertyAdapters {

	private PropertyAdapters() {
		// Singleton constructor
	}

	public PropertyAdapter<URL> getURLAdapter() {
		throw new UnsupportedOperationException();
	}

	public PropertyAdapter<InputStream> getClasspathResourceAdapter() {
		throw new UnsupportedOperationException();
	}

	public PropertyAdapter<File> getFileAdapter() {
		throw new UnsupportedOperationException();
	}

	public PropertyAdapter<Set<String>> getSetAdapter() {
		throw new UnsupportedOperationException();
	}

	public PropertyAdapter<Map<String, String>> getMapAdapter() {
		throw new UnsupportedOperationException();
	}

	public PropertyAdapter<List<String>> getListAdapter() {
		throw new UnsupportedOperationException();
	}

	public <T> PropertyAdapter<Class<T>> getClassAdapter(Class<T> requiredType,
			ClassLoader... classLoaders) {
		throw new UnsupportedOperationException();
	}

}
