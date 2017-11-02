import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArraySet.java.
 *
 * Provides an implementation of the Set interface using an
 * array as the underlying data structure. Values in the array
 * are kept in ascending natural order and, where possible,
 * methods take advantage of this. Many of the methods with parameters
 * of type ArraySet are specifically designed to take advantage
 * of the ordered array implementation.
 *
 * @author Evan Sheehan (res0038@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-02
 *
 */
public class ArraySet<T extends Comparable<? super T>> implements Set<T> {

   ////////////////////////////////////////////
   // DO NOT CHANGE THE FOLLOWING TWO FIELDS //
   ////////////////////////////////////////////
   T[] elements;
   int size;

   ////////////////////////////////////
   // DO NOT CHANGE THIS CONSTRUCTOR //
   ////////////////////////////////////
   /**
    * Instantiates an empty set.
    */
   @SuppressWarnings("unchecked")
   public ArraySet() {
      elements = (T[]) new Comparable[1];
      size = 0;
   }

   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   @Override
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements,
    *               false otherwise.
    */
   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this ArraySet.
    *
    * @return a string representation of this ArraySet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }

   private boolean isFull() {
      return size == elements.length;
   }

   private void resize(int capacity) {
      T[] a = (T[]) new Comparable[capacity];
      for (int i = 0; i < size; i++) {
         a[i] = elements[i];
      }
      elements = a;
   }

   /**
    * Ensures the collection contains the specified element. Elements are
    * maintained in ascending natural order at all times. Neither duplicate nor
    * null values are allowed.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   @Override
   public boolean add(T element) {
      if (element.equals(null)) {
         return false;
      }

      if (size == 0) {
         addThis(element);
         return true;
      }

      int index = 0;
      boolean insertMid = false;

      for (int i = 0; i < size; i++)  {
         if (elements[i].compareTo(element) == 0) {
            return false;
         }
         if (elements[i].compareTo(element) > 0) {
            index = i;
            insertMid = true;
            break;
         }
      }

      if (isFull()) {
         resize(size * 2);
      }

      if (insertMid) {
         for (int i = size - 1; i >= index; i--) {
            if (!elements[i].equals(null)) {
               elements[i + 1] = elements[i];
            }
         }
         elements[index] = element;
         size++;
         return true;
      }
      if (!insertMid) {
         addThis(element);
         return true;
      }

      return false;
   }

   private void addThis(T element) {
      elements[size] = element;
      size++;
   }

   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. Elements are maintained in ascending natural
    * order at all times.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   @Override
   public boolean remove(T element) {
      int index = locate(element);
      if (index != -1) {
         for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
         }
         size--;
         elements[size] = null;
         if (size < elements.length / 4 && size > 0) {
            resize(elements.length / 2);
         }
         return true;
      }
      return false;
   }

   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection
    *                   is to be tested.
    * @return  true if this collection contains the specified element,
    *               false otherwise.
    */
   @Override
   public boolean contains(T element) {
      return locate(element) >= 0;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   @Override
   public boolean equals(Set<T> s) {
      if (this.size != s.size()) {
         return false;
      }
      for (int i = 0; i < s.size(); i++) {
         if (!s.contains(elements[i])) {  //Time complexity for this may be too much
            return false;
         }
      }
      return true;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   public boolean equals(ArraySet<T> s) {
      if (this.size != s.size()) {
         return false;
      }
      for (int i = 0; i < this.size; i++) {
         if (elements[i].compareTo(s.elements[i]) != 0) {
            return false;
         }
      }
      return true;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   @Override
   public Set<T> union(Set<T> s) {
      Iterator itr = s.iterator();
      ArraySet<T> union = new ArraySet<T>();
      while (itr.hasNext()) {
         union.add((T)itr.next());
      }
      for (T t : this) {
         union.add(t);
      }
      return union;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   public Set<T> union(ArraySet<T> s) {
      ArraySet<T> union = new ArraySet<T>();
      int i = 0;
      while (i < this.size && i < s.size) {
         union.add(this.elements[i]);
         union.add(s.elements[i]);
         i++;
      }
      if (this.size < s.size) {
         while (i < s.size) {
            union.add(s.elements[i]);
            i++;
         }
      }
      else {
         while (i < this.size) {
            union.add(this.elements[i]);
            i++;
         }
      }
      return union;
   }


   /**
    * Returns a set that is the intersection of this set
    * and the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   @Override
   public Set<T> intersection(Set<T> s) {
      Iterator itr = s.iterator();
      Set<T> intersection = new ArraySet<T>();

      while (itr.hasNext()) {
         T element = (T) itr.next();
         if (this.contains(element)) {
            intersection.add(element);
         }
      }
      return intersection;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(ArraySet<T> s) {
      ArraySet<T> intersection = new ArraySet<>();

      for (T t : s) {
         if (this.contains(t)) {
            intersection.add(t);
         }
      }
      return intersection;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   @Override
   public Set<T> complement(Set<T> s) {
      ArraySet<T> complement = new ArraySet<>();

      for (T t : this) {
         if (!s.contains(t)) {
            complement.add(t);
         }
      }
      return complement;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(ArraySet<T> s) {
      ArraySet<T> complement = new ArraySet<>();

      for (T t : this) {
         if (!s.contains(t)) {
            complement.add(t);
         }
      }
      return complement;
   }


   /**
    * Returns an iterator over the elements in this ArraySet.
    * No specific order can be assumed.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   @Override
   public Iterator<T> iterator() {

      // ALMOST ALL THE TESTS DEPEND ON THIS METHOD WORKING CORRECTLY.
      // MAKE SURE YOU GET THIS ONE WORKING FIRST.
      // HINT: JUST USE THE SAME CODE/STRATEGY AS THE ARRAYBAG CLASS
      // FROM LECTURE. THE ONLY DIFFERENCE IS THAT YOU'LL NEED THE
      // ARRAYITERATOR CLASS TO BE NESTED, NOT TOP-LEVEL.

      class ArrayIterator<T> implements Iterator<T> {
         private T[] items;
         private int count;
         private int current;

         ArrayIterator(T[] elements, int size) {
            items = elements;
            count = size;
            current = 0;
         }

         public boolean hasNext() {
            return (current < count);
         }

         public T next() {
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            return items[current++];
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }

      }

      return new ArrayIterator<T>(elements, size);
   }

   /**
    * Returns an iterator over the elements in this ArraySet.
    * The elements are returned in descending order.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   public Iterator<T> descendingIterator() {
      class ArrayIterator<T> implements Iterator<T> {
         private T[] items;
         private int count;
         private int current;

         ArrayIterator(T[] elements, int size) {
            items = elements;
            count = size;
            current = count - 1;
         }

         public boolean hasNext() {
            return (current > -1);
         }

         public T next() {
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            return items[current--];
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      }

      return new ArrayIterator<T>(elements, size);
   }

   /**
    * Returns an iterator over the members of the power set
    * of this ArraySet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      class PowerSetIterator implements Iterator<Set<T>> {
         private T[] items;
         private int setSize;
         private int powerSetSize;
         private int current;

         PowerSetIterator(T[] elements, int size) {
            items = elements;
            setSize = size;
            powerSetSize = (int) Math.pow(2, size());
            current = 0;
         }

         public boolean hasNext() {
            return (current < powerSetSize);
         }

         public Set<T> next() {
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            ArraySet<T> set = new ArraySet<T>();
            char[] binaryChar = Integer.toBinaryString(current).toCharArray();
            for (int i = 0; i < binaryChar.length; i++) {
               if (binaryChar[i] == '1') {
                  set.add(items[binaryChar.length - (i + 1)]);
               }
            }
            current++;
            return set;
         }

         public void remove() {
            throw new UnsupportedOperationException();
         }
      }

      return new PowerSetIterator(elements, size()); //new ArrayIterator<T>(elements, size);
   }

   private int locate(T element) {
      int left = 0;
      int right = this.size - 1;
      while (left <= right) {
         int mid = (left + right) / 2;
         if (element.compareTo(elements[mid]) < 0) {
            right = mid - 1;
         }
         else if (element.compareTo(elements[mid]) > 0) {
            left = mid + 1;
         }
         else {
            return mid;
         }
      }
      return -1;
   }
}

