import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   YOUR NAME (YOU@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2017-08-22
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int minNum = a[0];
      for (int num : a) {
         if (num < minNum) {
            minNum = num;
         }
      }
      return minNum;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int maxNum = a[0];
      for (int num : a) {
         if (num > maxNum) {
            maxNum = num;
         }
      }
      return maxNum;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }

      int uniqValues = 0;
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);

      for (int i = 0; i < b.length; i++) {
         if (i == 0) {
            uniqValues++;
         } else if (b[i] != b[i - 1]) {
            uniqValues++;
         }
         if (uniqValues == k) {
            return b[i];
         }
      }
      if (uniqValues < k) {
         throw new IllegalArgumentException("K is greater than the number of distinct values in the array");
      }
      throw new IllegalStateException("Don't know what went wrong!");
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }

      int uniqValues = 0;
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);

      for (int i = b.length - 1; i > -1; i--) {
         if (uniqValues == 0) {
            uniqValues++;
         }
         else if (b[i] != b[i + 1]) {
            uniqValues++;
         }
         if (uniqValues == k) {
            return b[i];
         }
      }
      if (uniqValues < k) {
         throw new IllegalArgumentException("K is greater than the number of distinct values in the array");
      }
      throw new IllegalStateException("Don't know what went wrong!");
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {

      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }

      int[] range = new int[a.length];
      int counter = 0;

      for (int num : a) {
         if (num <= high && num >= low) {
            range[counter] = num;
            counter++;
         }
      }

      if (counter == 0) {
         int[] empty = {};
         return empty;
      }

      int[] rangeFinal = new int[counter];
      for (int j = 0; j < counter; j++) {
         rangeFinal[j] = range[j];
      }

      return rangeFinal;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }

      int ceiling = -1;
      boolean qualifyingValue = false;

      for (int num : a) {
         if (ceiling == -1 && num >= key) {
            ceiling = num;
            qualifyingValue = true;
         }
         else if (num < ceiling && num >= key) {
            ceiling = num;
         }
      }

      if (!qualifyingValue) {
         throw new IllegalArgumentException();
      }
      return ceiling;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }

      int floor = -1;
      boolean qualifyingValue = false;

      for (int num : a) {
         if (floor == -1 && num <= key) {
            floor = num;
            qualifyingValue = true;
         }
         else if (num > floor && num <= key) {
            floor = num;
         }
      }

      if (!qualifyingValue) {
         throw new IllegalArgumentException();
      }
      return floor;
   }

}
