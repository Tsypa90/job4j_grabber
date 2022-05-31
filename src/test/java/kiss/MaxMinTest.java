package kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MaxMinTest {
    @Test
    public void testIntMax() {
        MaxMin test = new MaxMin();
        List<Integer> value = List.of(1, 3, 6, 7, 7, 3, 8, 16);
        Comparator<Integer> comparator = Integer::compare;
        Assert.assertThat(16, is(test.max(value, comparator)));
    }

    @Test
    public void testIntMin() {
        MaxMin test = new MaxMin();
        List<Integer> value = List.of(3, 6, 7, 1, 7, 3, 8, 16);
        Comparator<Integer> comparator = Integer::compare;
        Assert.assertThat(1, is(test.min(value, comparator)));
    }

    @Test
    public void testStringMin() {
        MaxMin test = new MaxMin();
        var value = List.of("Pavel", "Olga", "Andrey", "Zena");
        Comparator<String> comparator = String::compareTo;
        Assert.assertThat("Andrey", is(test.min(value, comparator)));
    }

    @Test
    public void testStringMax() {
        MaxMin test = new MaxMin();
        var value = List.of("Pavel", "Olga", "Andrey", "Zena");
        Comparator<String> comparator = String::compareTo;
        Assert.assertThat("Zena", is(test.max(value, comparator)));
    }
}