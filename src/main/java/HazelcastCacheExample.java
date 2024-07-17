import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastCacheExample {
    public static void main(String[] args) {
        // creating a Hazelcast using Hazelcast.newHazelcastInstance()
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        // access to distributed map
        IMap<String, String> cache = hazelcastInstance.getMap("my-cache");

        // add data to cache
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        // reading from cache
        String value1 = cache.get("key1");
        String value2 = cache.get("key2");

        // print the data
        System.out.println("key1: " + value1);
        System.out.println("key2: " + value2);

        // removing data from cache
        cache.remove("key1");

        // checking if there is data in cache
        boolean exists = cache.containsKey("key1");
        System.out.println("Does key1 exist? " + exists);

        // shutting Hazelcast down
        hazelcastInstance.shutdown();
    }
}