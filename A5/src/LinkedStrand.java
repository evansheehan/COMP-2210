/**
 * LinkedStrand.java
 * Provides a linked chunk list implementation of the DnaStrand interface.
 *
 * @author Evan Sheehan (you@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-17
 */
public class LinkedStrand implements DnaStrand {

   /**
    * Container for storing DNA information. A given DNA strand is
    * represented by a chain of nodes.
    * <p>
    * D O   N O T   M A K E   A N Y   C H A N G E S   T O
    * <p>
    * T H E   N O D E   C L A S S
    */
   class Node {
      String dnaInfo;
      Node next;

      public Node() {
         dnaInfo = "";
         next = null;
      }

      public Node(String s, Node n) {
         dnaInfo = s;
         next = n;
      }
   }

   /**
    * An empty strand.
    */
   public static final LinkedStrand EMPTY_STRAND = new LinkedStrand();

   /**
    * The first and last node in this LinkedStrand.
    */
   // D O   N O T   C H A N G E   T H E S E   F I E L D S 
   Node front;
   Node rear;


   /**
    * The number of nucleotides in this strand.
    */
   long size;

   /**
    * Create a strand representing an empty DNA strand, length of zero.
    * <p>
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    */
   public LinkedStrand() {
      front = null;
      rear = null;
      size = 0;
   }


   /**
    * Create a strand representing s. No error checking is done to see if s represents
    * valid genomic/DNA data.
    *
    * @param s is the source of cgat data for this strand
    */
   public LinkedStrand(String s) {

      if (s.length() > 0) {
         Node dnaInfo = new Node(s, null);
         front = dnaInfo;
         rear = front;
         size = s.length();
      }
   }


   /**
    * Appends the parameter to this strand changing this strand to represent
    * the addition of new characters/base-pairs, e.g., changing this strand's
    * size.
    * <p>
    * If possible implementations should take advantage of optimizations
    * possible if the parameter is of the same type as the strand to which data
    * is appended.
    *
    * @param dna is the strand being appended
    * @return this strand after the data has been added
    */
   @Override
   public DnaStrand append(DnaStrand dna) {
      if (dna == null || dna.size() == 0) {
         return this;
      }
      if (this.size() == 0) {
         LinkedStrand ls = new LinkedStrand(dna.toString());
         this.front = ls.front;
         this.rear = ls.rear;
         size = ls.size();
         return ls;
      }
      if (dna instanceof LinkedStrand) {
         LinkedStrand strand = (LinkedStrand) dna;
         this.rear.next = strand.front;
         this.rear = strand.rear;
         size += strand.size();
         return this;
      }
      String string = dna.toString();
      return append(string);
   }


   /**
    * Similar to append with a DnaStrand parameter in
    * functionality, but fewer optimizations are possible. Typically this
    * method will be called by the append method with an DNAStrand
    * parameter if the DnaStrand passed to that other append method isn't the same
    * class as the strand being appended to.
    *
    * @param dna is the string appended to this strand
    * @return this strand after the data has been added
    */
   @Override
   public DnaStrand append(String dna) {
      if (dna == null || dna.length() == 0) {
         return this;
      }
      if (this.size() == 0) {
         LinkedStrand ls = new LinkedStrand(dna);
         this.front = ls.front;
         this.rear = ls.rear;
         size = ls.size();
         return ls;
      }
      Node n = new Node(dna, null);
      this.rear.next = n;
      this.rear = n;
      size += dna.length();
      return this;
   }


   /**
    * Cut this strand at every occurrence of enzyme, replacing
    * every occurrence of enzyme with splice.
    *
    * @param enzyme is the pattern/strand searched for and replaced
    * @param splice is the pattern/strand replacing each occurrence of enzyme
    * @return the new strand leaving the original strand unchanged.
    */
   @Override
   public DnaStrand cutAndSplice(String enzyme, String splice) {
      LinkedStrand ls = new LinkedStrand();
      int enzymeIndex = 0;
      int pointer = 0;
      String dnaString = this.toString();

      while (enzymeIndex != -1) {
         enzymeIndex = dnaString.indexOf(enzyme, pointer);

            /*
            If the enzyme occurs and the first occurrence isn't the first index,
            append the string before the enzyme to the new LinkedStrand, and append
            the splice to the new LinkedStrand. Move the pointer past the end of
            the enzyme.
             */
         if (enzymeIndex != 0 && enzymeIndex != -1) {
            ls.append(dnaString.substring(pointer, enzymeIndex));
            ls.append(splice);
            pointer += (enzymeIndex - pointer) + enzyme.length();
         }

            /*
            Else if the first enzyme occurrence is at the beginning of the strand,
            append the splice to the new LinkedStrand and move the pointer past the
            size of the enzyme in the original strand.
             */
         else if (enzymeIndex == 0 && enzymeIndex != -1) {
            ls.append(splice);
            pointer += (enzymeIndex - pointer) + enzyme.length();
         }

            /*
            Else if there are no more enzyme occurrences, but we are not at the end
            of the original strand, append the rest.
            */
         else if (pointer != dnaString.length() && ls.size() != 0) {
            ls.append(dnaString.substring(pointer, dnaString.length()));
            pointer = dnaString.length();
         }
      }


      return ls;
   }


   /**
    * Simulate a restriction enzyme cut by finding the first occurrence of
    * enzyme in this strand and replacing this strand with what comes before
    * the enzyme while returning a new strand representing what comes after the
    * enzyme. If the enzyme isn't found, this strand is unaffected and an empty
    * strand with size equal to zero is returned.
    *
    * @param enzyme is the string being searched for
    * @return the part of the strand that comes after the enzyme
    */
   @Override
   public DnaStrand cutWith(String enzyme) {
      LinkedStrand ls = new LinkedStrand();
      String dnaString = this.toString();

      if (dnaString.compareTo(enzyme) == 0) {
         this.initializeFrom("");
         return ls;
      }

      int enzymeIndex = dnaString.indexOf(enzyme);
      if (enzymeIndex != -1) {
         this.initializeFrom(dnaString.substring(0, enzymeIndex));
         ls.append(dnaString.substring((enzymeIndex + enzyme.length()), dnaString.length()));
      }

      return ls;
   }


   /**
    * Initialize by copying DNA data from the string into this strand,
    * replacing any data that was stored. The parameter should contain only
    * valid DNA characters, no error checking is done by the this method.
    *
    * @param source is the string used to initialize this strand
    */
   @Override
   public void initializeFrom(String source) {
      LinkedStrand strand = new LinkedStrand(source);

      this.front = strand.front;
      this.rear = strand.rear;
      size = strand.size();
   }


   /**
    * Returns the number of elements/base-pairs/nucleotides in this strand.
    *
    * @return the number of base-pairs in this strand
    */
   @Override
   public long size() {
      return size;
   }


   /**
    * Returns a string representation of this LinkedStrand.
    */
   @Override
   public String toString() {
      Node n = front;
      String output = "";
      while (n != null) {
         output += n.dnaInfo;
         n = n.next;
      }
      return output;
   }


}

