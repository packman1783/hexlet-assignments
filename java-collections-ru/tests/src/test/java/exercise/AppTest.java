package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbersRight = new ArrayList<>();
        numbersRight.add(1);
        numbersRight.add(2);
        numbersRight.add(3);
        numbersRight.add(4);
        numbersRight.add(5);

        int count1 = 3;

        List<Integer> expected1 = Arrays.asList(1, 2, 3);
        List<Integer> real1 = App.take(numbersRight, count1);
        assertThat(expected1).isEqualTo(real1);

        List<Integer> numbersWrong1 = new ArrayList<>();
        numbersWrong1.add(1);
        numbersWrong1.add(2);
        numbersWrong1.add(3);
        numbersWrong1.add(4);
        numbersWrong1.add(5);

        int count2 = 6;

        List<Integer> expected2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> real2 = App.take(numbersWrong1, count2);
        assertThat(expected2).isEqualTo(real2);

        List<Integer> numbersWrong2 = new ArrayList<>();
        numbersWrong2.add(1);
        numbersWrong2.add(2);
        numbersWrong2.add(3);
        numbersWrong2.add(4);
        numbersWrong2.add(5);

        int count3 = 4;

        List<Integer> expected3 = Arrays.asList(1, 2, 3, 4);
        List<Integer> real3 = App.take(numbersWrong2, count3);
        assertThat(expected3).isEqualTo(real3);

        List<Integer> numbersWrong3 = new ArrayList<>();
        numbersWrong3.add(1);
        numbersWrong3.add(2);
        numbersWrong3.add(3);
        numbersWrong3.add(4);
        numbersWrong3.add(5);

        int count4 = 5;

        List<Integer> expected4 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> real4 = App.take(numbersWrong3, count4);
        assertThat(expected4).isEqualTo(real4);
        // END
    }
}
