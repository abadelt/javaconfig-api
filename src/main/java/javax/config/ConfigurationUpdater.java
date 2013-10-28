package javax.config;


public interface ConfigurationUpdater extends ConfigurationBuilder{

	public ConfigurationUpdater delete();
	
	public ConfigurationUpdater removeProperty(String key);

	public Configuration update();

}
