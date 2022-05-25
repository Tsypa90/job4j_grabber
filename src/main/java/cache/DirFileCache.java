package cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }
    
    private String getContent() {
        String value = null;
        try (BufferedReader br = new BufferedReader(new FileReader(cachingDir))) {
            value = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
    @Override
    protected String load(String key) {
        if (cache.get(key) == null) {
            put(key, getContent());
        }
        return get(key);
    }
}
