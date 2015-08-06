package nju.software.xfgl.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



public class CacheFactory 
{
    private static CacheFactory cacheFactory;
    
    private Map<String, Object> cache = new ConcurrentHashMap<String, Object>();
    
    private CacheFactory()
    {
    }
    
    public static CacheFactory getInstance()
    {
    	if(cacheFactory==null)
    	{
    		cacheFactory = new CacheFactory();
    	}
    	return cacheFactory;
    }
    
    public void flush() 
	{
		cache.clear();
	}
    
    public void putObject(String key, Object value) 
	{
		cache.put(key, value);
	}

    
    public Object getObject(String key) 
	{
		return cache.get(key);
	}
    
    public Object removeObject(String key) 
	{
		Object value = cache.remove(key);
		return value;
	}
    
    public boolean containKey(String key)
    {
    	return cache.containsKey(key);
    }
}
