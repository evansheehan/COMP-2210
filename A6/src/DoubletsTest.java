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
      String str1 = "clown";
      String str2 = "blown";
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
      int expected = 1;
      int actual = doublets.getHammingDistance(str1, str2);
      Assert.assertEquals(expected, actual);
   }
}