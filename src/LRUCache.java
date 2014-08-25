import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRUCache {
	
	private Map<Integer, CacheEntry> cache = null;
	int capacity = 1;
	
	private int youngestAge = 0;
    
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, CacheEntry>(capacity);
        this.capacity = capacity;
    }
    
    private int getOldest(){
    	int oldest = Integer.MIN_VALUE;
    	int oldestKey = 0;
    	Set<Entry<Integer, CacheEntry>> set = cache.entrySet();
    	Iterator<Entry<Integer, CacheEntry>> it = set.iterator();
    	while (it.hasNext()) {
			Entry<Integer, CacheEntry> entry = it.next();
			if(entry.getValue().age > oldest){
				oldest = entry.getValue().age;
				oldestKey = entry.getKey();
			}
		}
    	return oldestKey;
    }
    
    public int get(int key) {
    	CacheEntry item = cache.get(key);
    	if(item != null){
			item.age = --youngestAge;
			return item.value;
    	} else{
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	CacheEntry item = cache.get(key);
    	if(item != null){
    		item.age = --youngestAge; //renew
    		item.value = value;
    	}else{
    		int oldest = getOldest();
    		if(cache.size() == capacity){
    			cache.remove(oldest);
    		}
    		cache.put(key, new CacheEntry(value, --youngestAge));
    	}
    }
}

class CacheEntry{
	int value;
	int age;
	CacheEntry(int v){
		this(v, 0);
	}
	CacheEntry(int v, int age){
		this.value = v;
		this.age = age;
	}
}
