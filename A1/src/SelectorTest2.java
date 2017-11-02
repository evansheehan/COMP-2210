import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectorTest2 {

    @Test
    public void KminTypical1() {
        int[] a = {1, 2, 3, 4,};
        int k = 2;
        int expected = 2;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KminTypical2() {
        int[] a = {1, 4, 3, 2,};
        int k = 2;
        int expected = 2;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KminTypical3() {
        int[] a = {2, 3, 1, 4,};
        int k = 2;
        int expected = 2;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KminIllegal1() {
        int[] a = {};
        int k = 5;

        try {
            Selector.kmin(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KminDuplicate1() {
        int[] a = {2, 2, 2, 3, 1};
        int k = 1;
        int expected = 1;
        int actual = Selector.kmin(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KminIllegal2() {
        int[] a = null;
        int k = 3;

        try {
            Selector.kmin(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KminIllegal3() {
        int[] a = {2, 3};
        int k = 3;

        try {
            Selector.kmin(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KminIllegal4() {
        int[] a = {2, 3};
        int k = 0;

        try {
            Selector.kmin(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KminVocareum() {
        int[] a = {-4, -4};
        int k = 2;

        try {
            Selector.kmin(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KmaxTypical1() {
        int[] a = {1, 2, 3, 4,};
        int k = 2;
        int expected = 3;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KmaxTypical2() {
        int[] a = {1, 4, 3, 2,};
        int k = 2;
        int expected = 3;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KmaxTypical3() {
        int[] a = {2, 3, 1, 4,};
        int k = 2;
        int expected = 3;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KmaxIllegal1() {
        int[] a = {};
        int k = 5;

        try {
            Selector.kmax(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KmaxDuplicate1() {
        int[] a = {2, 2, 2, 3, 1};
        int k = 1;
        int expected = 3;
        int actual = Selector.kmax(a, k);
        assertEquals(expected, actual);
    }

    @Test
    public void KmaxIllegal2() {
        int[] a = null;
        int k = 3;

        try {
            Selector.kmax(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KmaxIllegal3() {
        int[] a = {2, 3};
        int k = 3;

        try {
            Selector.kmax(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

    @Test
    public void KmaxIllegal4() {
        int[] a = {2, 3};
        int k = 0;

        try {
            Selector.kmax(a, k);
            Assert.fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        catch (Exception e) {
            Assert.fail("Threw incorrect exception");
        }
    }

}