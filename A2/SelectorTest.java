import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SelectorTest {
    @org.junit.Test
    public void min1() throws Exception {
        Integer[] a = {2147483647, 2147483646};
        List<Integer> list = Arrays.<Integer>asList(a);
        Comparator<Integer> comp = HandoutExamples.ascendingInteger;
        System.out.println(Selector.min(list, comp));
    }

    @org.junit.Test
    public void max() throws Exception {
    }

    @org.junit.Test
    public void kmin() throws Exception {
        Integer[] a = {-4,-4,-4,-4,-4};
        List<Integer> list = Arrays.asList(a);
        Integer k = 2;
        Comparator<Integer> comp = HandoutExamples.ascendingInteger;
        System.out.println(Selector.kmin(list, k, comp));
    }

    @org.junit.Test
    public void kmax() throws Exception {
        Integer[] a = {1, 3, 5, 7, 9};
        List<Integer> list = Arrays.asList(a);
        Comparator<Integer> comp = HandoutExamples.ascendingInteger;
        Integer k = 1;
        System.out.println(Selector.kmax(list, k, comp));
    }

    @org.junit.Test
    public void range() throws Exception {
        Integer[] a = {7};
        List<Integer> list = Arrays.asList(a);
        Integer low = 7;
        Integer high = 7;
        Comparator<Integer> comp = HandoutExamples.ascendingInteger;
        System.out.println(Selector.range(list, low, high, comp));
    }

    @org.junit.Test
    public void ceiling() throws Exception {
    }

    @org.junit.Test
    public void floor() throws Exception {
        Integer[] a = {9,7};
        List<Integer> list = Arrays.asList(a);
        Integer key = 7;
        Comparator<Integer> comp = HandoutExamples.ascendingInteger;
        System.out.println(Selector.floor(list, key, comp));
    }

}