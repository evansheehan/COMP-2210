import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by awubis on 11/8/17.
 */
public class DoubletsTest {

   @Test
   public void hammingTest1() throws FileNotFoundException {
      String str1 = "caterpillar";
      String str2 = "caterpillar";
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      int expected = 0;
      int actual = doublets.getHammingDistance(str1, str2);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void hammingTest2() throws FileNotFoundException {
      String str1 = "cat";
      String str2 = "dog";
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      int expected = 3;
      int actual = doublets.getHammingDistance(str1, str2);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void hammingTest3() throws FileNotFoundException {
      String str1 = "screen";
      String str2 = "greens";
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      int expected = 5;
      int actual = doublets.getHammingDistance(str1, str2);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void wordCountTest1() throws FileNotFoundException {
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      int expected = 267751;
      int actual = doublets.getWordCount();
      Assert.assertEquals(expected, actual);

   }

   @Test
   public void isWordTest1() throws FileNotFoundException {
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      String str = "BBBBBBB";
      boolean expected = true;
      boolean actual = doublets.isWord(str);
      /*Assert.assertEquals(expected, actual);*/
      str = "avocADo";
      actual = doublets.isWord(str);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void neighborsTest1() throws FileNotFoundException {
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      System.out.println(doublets.getNeighbors("car"));
   }

   @Test
   public void recursiveTest1() throws FileNotFoundException {
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
   }
}