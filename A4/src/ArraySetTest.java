import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by awubis on 10/7/17.
 */
public class ArraySetTest {



   @Test
   public void addTest1() {
      ArraySet<Integer> set = new ArraySet<Integer>();
      set.add(1);
      set.add(2);
      set.add(5);
      set.add(4);
      set.add(4);
      set.add(0);
      set.add(3);
      set.remove(3);
      set.add(-1);
      set.remove(1);
      set.remove(2);
      set.remove(4);
      set.remove(5);
      set.remove(0);
   }

   @Test
   public void descendingIterator() {
      ArraySet<Integer> set = new ArraySet<>();
      set.add(5);
      set.add(4);
      set.add(3);
      set.add(2);
      set.add(1);
      Iterator itr = set.descendingIterator();
      while (itr.hasNext()) {
         System.out.println(itr.next());
      }
   }

   @Test
   public void powerSetTest() {
      ArraySet<Character> set = new ArraySet<Character>();
      set.add('A');
      set.add('B');
      set.add('C');
      Iterator powerIt = set.powerSetIterator();
      while (powerIt.hasNext()) {
         System.out.println(powerIt.next());
      }
   }

   @Test
   public void resizeAddTest() {
      ArraySet<Integer> set = new ArraySet<>();
      for (int i = 1; i < 64; i++) {
         set.add(i);
      }
      for (int i = 63; i > 0; i--) {
         set.remove(i);
      }
      System.out.println(set.size());
      System.out.println(set.elements.length);
      ArraySet<Integer> setAdd = new ArraySet<>();
      setAdd.add(1);
      System.out.println(setAdd.elements.length);
   }


   @Test
   public void justAnotherRemoveTest() {
      ArraySet<Integer> set = new ArraySet<>();
      set.add(1);
      set.add(2);
      set.add(3);
      set.add(4);
      set.remove(4);
      set.remove(3);
      set.remove(2);
   }
   @Test
   public void resizeTest2() {
      ArraySet<Integer> set = new ArraySet<>();
      set.add(1);
      set.add(1);
      System.out.println(set.size());
      //System.out.println(set.elements.length);
      set.add(2);
      System.out.println(set.size());
      System.out.println(set.elements.length);
   }

   @Test
   public void shrinkTests() {
      ArraySet<Integer> set1 = new ArraySet<>();
      for (int i = 1; i < 129; i++) {
         set1.add(i);
      }
      for (int i = 1; i < 129; i++) {
         set1.remove(i);
      }
      System.out.println(set1.size());
      ArraySet<Integer> set2 = new ArraySet<>();

      ArraySet<Integer> set3 = new ArraySet<>();

      ArraySet<Integer> set4 = new ArraySet<>();
   }
   @Test
   public void locateTest1() {
      ArraySet<Integer> set = new ArraySet<Integer>();

   }

}