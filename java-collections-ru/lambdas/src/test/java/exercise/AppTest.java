package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testAppEmptyArrays() {
        String[][] emptyArray = new String[][]{};
        String[][] real = App.enlargeArrayImage(emptyArray);
        String[][] expected = new String[][]{};
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void testAppOneElement() {
        String[][] oneElementArray = new String[][]{
                {"*"}
        };
        String[][] real = App.enlargeArrayImage(oneElementArray);
        String[][] expected = new String[][]{
                {"*", "*"},
                {"*", "*"}
        };
        assertThat(real).isEqualTo(expected);
    }
}
// END
