package javax.config;

import java.util.Map;

public interface ConfigurationUpdater {

	public boolean isDeleteable();

	public boolean isUpdateable();

	public boolean isCreateable();

	public ConfigurationUpdater delete();

	public ConfigurationUpdater removeProperty(String key);

	public ConfigurationUpdater withName(String name);

	public ConfigurationUpdater withEnvironmentSelector(
			EnvironmentSelector environment);

	public ConfigurationUpdater withConfiguration(Configuration config);

	public ConfigurationUpdater withLocation(String location);

	public ConfigurationUpdater withQueryPath(String queryPath);

	public ConfigurationUpdater withMetaInfo(String key,
			Map<String, String> metaInfo);

	public ConfigurationUpdater withMetaInfo(String key, String metaInfoKey,
			String metaInfoValue);

	public ConfigurationUpdater withProperty(String key, String value,
			Map<String, String> metaInfo);

	public ConfigurationUpdater withProperty(String key,
			int value);

	public ConfigurationUpdater withProperty(String key,
			byte value);

	public ConfigurationUpdater withProperty(String key,
			short value);

	public ConfigurationUpdater withProperty(String key,
			boolean value);

	public ConfigurationUpdater withProperty(String key,
			char value);

	public ConfigurationUpdater withProperty(String key,
			float value);

	public ConfigurationUpdater withProperty(String key,
			double value);

	public ConfigurationUpdater withProperty(String key,
			long value);

	public ConfigurationUpdater withQuery(ConfigurationQuery<Boolean> query);

	public Configuration commit();

}
