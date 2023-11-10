package exercise;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private File file;
    private Map<String, String> map;

    public FileKV(String filePath, Map<String, String> map) {
        this.file = new File(filePath);
        this.map = map;
        readFile();
    }

    public void readFile() {
        String content = Utils.readFile(file.getPath());
        map = Utils.unserialize(content);
    }

    public void writeFile() {
        Utils.writeFile(file.getPath(), Utils.serialize(map));
    }


    @Override
    public void set(String key, String value) {
        map.put(key, value);
        writeFile();
    }

    @Override
    public void unset(String key) {
        map.remove(key);
        writeFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
