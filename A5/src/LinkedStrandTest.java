import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import static org.junit.Assert.*;

/**
 * Created by awubis on 10/28/17.
 */
public class LinkedStrandTest {

   @Test
   public void test1() {
      LinkedStrand strand = new LinkedStrand("ATGACGACTG");
      strand.append("");
      DnaStrand strand2 = new LinkedStrand("ZZZZZZZ");
      DnaStrand strand3 = new LinkedStrand("AAAAAAA");
      strand.append(strand2);
      strand.append(strand3);
      String string1 = "EEEEEEE";
      //DnaStrand strand4 = new LinkedStrand(null);
     //strand.append(strand4);
      strand.append(string1);
      strand.append("aggtccg");
      System.out.println(strand.toString());
      strand.initializeFrom("ABCDEFG");
      System.out.println(strand);
   }

   @Test
   public void test2() {
      LinkedStrand strand = new LinkedStrand("");
      strand.append("ABCDEFG");
      System.out.println(strand.toString());
   }

   @Test
   public void test3() {
      LinkedStrand ls = new LinkedStrand();
      ls.append("");
      System.out.println(ls);
      System.out.println(ls.size());
      ls.append("aggtccgttccggttaaggagagagagagagttt");
      System.out.println(ls);
      System.out.println(ls.size());
      ls.append("aggtccg");
      System.out.println(ls);
      System.out.println(ls.size());
      ls.append("ZZZZ");
      System.out.println(ls);
      System.out.println(ls.size());
      ls.append("");
      System.out.println(ls);
      System.out.println(ls.size());

      ArrayStrand as = new ArrayStrand();
      as.append("");
      System.out.println(as);
      System.out.println(as.size());
      as.append("aggtccgttccggttaaggagagagagagagttt");
      System.out.println(as);
      System.out.println(as.size());
      as.append("aggtccg");
      System.out.println(as);
      System.out.println(as.size());
      as.append("ZZZZ");
      System.out.println(as);
      System.out.println(as.size());
      as.append("");
      System.out.println(as);
      System.out.println(as.size());
   }
   @Test
   public void test4() {
      LinkedStrand ls = new LinkedStrand("");
      ls.append("abcdefg");
      String nullString = null;
      ls.append(nullString);
      System.out.println(ls);
   }

   @Test
   public void test5() {
      LinkedStrand ls = new LinkedStrand("AABBCCDDEECCFFGG");
      ls.cutAndSplice("CC", "XX");
      System.out.println(ls);
      System.out.println(ls.cutAndSplice("CC", "XX"));
   }

   @Test
   public void test6() {
      LinkedStrand ls = new LinkedStrand("CCBBCCDDEECCFFCC");
      System.out.println(ls);
      System.out.println(ls.cutAndSplice("CC", "X1X2X"));
   }

   @Test
   public void test7() {
      LinkedStrand ls = new LinkedStrand("AABBDDCC");
      System.out.println(ls.cutWith("CC"));
      System.out.println(ls);
   }

   @Test public void test8() {
      LinkedStrand ls = new LinkedStrand("gaattc");
      System.out.println(ls.cutWith("gaattc"));
      System.out.println(ls);
   }

   @Test
   public void test9() {
      LinkedStrand ls = new LinkedStrand();
      ls.initializeFrom("aaggttc");
      System.out.println(ls);
   }

   @Test
   public void test10() {
      LinkedStrand ls = new LinkedStrand();
      ls.initializeFrom("");
   }
}