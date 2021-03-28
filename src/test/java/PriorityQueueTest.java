import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                arguments(new int[]{-3, -1, -2, 5}, new int[]{-3, -2, -1, 5}),
                arguments(new int[]{3, -2, -5, -1, 2}, new int[]{-5, -2, -1, 2, 3}),
                arguments(new int[]{-3, 1, 11, 0, 9, 3}, new int[]{-3, 0, 1, 3, 9, 11}),
                arguments(new int[]{3, 7, 2, -1, -2}, new int[]{-2, -1, 2, 3, 7})
        );
    }
    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        for (s = 0; s < random_array.length; s++) {
            test.add(random_array[s]);
        }

        assertEquals(correct_array.length, test.size());
        while (!(test.isEmpty())) {
            result[index++] = test.poll();
        }

        assertArrayEquals(correct_array, result);
    }

    @Test
    public void add_argument() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> pQ = new PriorityQueue<>();
            pQ.add(null);
        });
    }

    @Test
    public void offer_null_pointer() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> pQ = new PriorityQueue<>();
            pQ.offer(null);
        });
    }

    @Test
    public void illegal_argument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> pQ = new PriorityQueue<>(0);
        });
    }
}
