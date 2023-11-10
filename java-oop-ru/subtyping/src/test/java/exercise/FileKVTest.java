package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

// BEGIN

// END

class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testSetGet() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        storage.set("key2", "value2");

        assertThat(storage.get("key1", "")).isEqualTo("value1");
        assertThat(storage.get("key2", "")).isEqualTo("value2");
    }

    @Test
    public void testUnset() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        storage.unset("key1");

        assertNull(storage.get("key1", null));
    }

    @Test
    public void testDefault() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());

        assertThat("default").isEqualTo(storage.get("noKey", "default"));
    }

    @Test
    public void testFileAfterSet() {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key1", "value1");
        storage.set("key2", "value2");

        String fileContent = Utils.readFile(filepath.toString());
        assertThat(fileContent).isEqualTo("{\"key1\":\"value1\",\"key2\":\"value2\"}");
    }
    // END
}
