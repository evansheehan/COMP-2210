import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by awubis on 8/24/17.
 */
class SelectorTest {
   @org.junit.jupiter.api.Test
   void min() {
      int[] a = {1, 2, -1, 3, 5, 0, 0, -1};
      int[] empty = {};
      System.out.println(Selector.min(a));
   }

   @org.junit.jupiter.api.Test
   void max() {
      int[] a = {1, 2, -1, 3, 5, 0, 0, -1};
      int[] b = {0, 0, 999, 999, 999, 999, 0};
      int[] empty = {};
      System.out.println(Selector.max(b));
   }

   @org.junit.jupiter.api.Test
   void kmin() {
   }

   @org.junit.jupiter.api.Test
   void kmax() {
   }

   @org.junit.jupiter.api.Test
   void range() {
      int[] a = {1, 2, -1, 3, 5, 0, 0, -1};
      Selector.range(a, 0, 4);
   }

   @org.junit.jupiter.api.Test
   void range2() {
      int[] a = {7};
      Selector.range(a, 3, 4);
   }

   @org.junit.jupiter.api.Test
   void ceiling() {
   }

   @org.junit.jupiter.api.Test
   void floor() {
   }

}