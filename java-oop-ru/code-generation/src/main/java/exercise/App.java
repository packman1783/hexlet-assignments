package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        String serializeCar = car.serialize();
        Files.writeString(path, serializeCar, StandardOpenOption.WRITE);
    }

    public static Car extract(Path path) throws IOException {
        String unserializeCar = Files.readString(path);
        return Car.unserialize(unserializeCar);
    }
}
// END
