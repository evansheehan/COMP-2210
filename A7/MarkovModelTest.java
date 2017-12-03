import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by awubis on 12/3/17.
 */
public class MarkovModelTest {

   @Test
   public void mainTest1() throws FileNotFoundException {
      File file = new File("dickens.excerpt.txt");
      MarkovModel model = new MarkovModel(8, file);
      String kgram = model.getRandomKgram();
      model.getNextChar(kgram);
      System.out.println(model.toString());
   }

   @Test
   public void getRandomTest() throws FileNotFoundException {
      MarkovModel model = new MarkovModel(1, "ABCDE");
      ArrayList<String> randoms = new ArrayList<>();
      int A = 0;
      int B = 0;
      int C = 0;
      int D = 0;
      int E = 0;
      for (int i = 0; i < 10000; i++) {
         String toAdd = model.getRandomKgram();
         if (toAdd.compareTo("A") == 0) {A++;}
         if (toAdd.compareTo("B") == 0) {B++;}
         if (toAdd.compareTo("C") == 0) {C++;}
         if (toAdd.compareTo("D") == 0) {D++;}
         if (toAdd.compareTo("E") == 0) {E++;}
      }
      System.out.println(A + " " + B + " " + C + " " + D + " " + E);
   }


}