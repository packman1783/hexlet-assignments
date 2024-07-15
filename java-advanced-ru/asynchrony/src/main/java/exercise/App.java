package exercise;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathName1, String pathName2, String pathNameResult) {
        CompletableFuture<String> read1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(pathName1));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("NoSuchFileException");
                return null;
            }
        });

        CompletableFuture<String> read2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(pathName2));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("NoSuchFileException");
                return null;
            }
        });

        CompletableFuture<String> write1 = read1.thenCombine(read2, (content1, content2) -> {
            String combined = content1 + content2;
            try {
                Files.writeString(Path.of(pathNameResult), combined, StandardOpenOption.CREATE);
                return combined;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
        write1.join();
        return write1;
    }

    private static Path getPath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    private static Long getSizeFiles(File path) {
        long size = 0L;
        for (File file: Objects.requireNonNull(path.listFiles())) {
            if (file.isFile()) {
                size += file.length();
            }
        }
        return size;
    }

    public static CompletableFuture<Long> getDirectorySize(String dir) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            return getSizeFiles(new File(dir));
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/unionFile.txt"
        );
        System.out.println(result);

        CompletableFuture<Long> size = getDirectorySize("src/main/resources");
        result.get();
        System.out.println(size.get());
        // END
    }
}

