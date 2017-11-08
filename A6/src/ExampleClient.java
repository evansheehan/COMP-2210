import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * ExampleClient.java
 * Provides example calls to WordLadderGame methods in an instance of
 * the Doublets class.
 *
 * The word list files must be extracted into the current directory
 * before running this class.
 *
 *      jar xf WordLists.jar
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-11-06
 */
public class ExampleClient {

    /** Drives execution. */
    public static void main(String[] args) throws FileNotFoundException {
        WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));

        System.out.println(doublets.getHammingDistance("tiger", "tiger"));
        System.out.println(doublets.getHammingDistance("tiger", "eagle"));
        System.out.println(doublets.getHammingDistance("war", "eagle"));
        System.out.println(doublets.getHammingDistance("barner", "bammer"));

        System.out.println(doublets.isWord("tiger"));
        System.out.println(doublets.isWord("eagle"));
        System.out.println(doublets.isWord("aubie"));
        for (String str : Arrays.asList("cat", "cot", "cag", "dot", "dag", "cog", "dog")) {
            System.out.println(str + " " + doublets.isWord(str));
        }

        System.out.println(doublets.getWordCount());

        System.out.println(doublets.isWordLadder(Arrays.asList("cat", "cot", "cag", "dot", "dag", "cog", "dog")));
        System.out.println(doublets.isWordLadder(Arrays.asList("cat", "cot", "zot", "dot")));
        System.out.println(doublets.isWordLadder(Arrays.asList("cat", "cot", "pot", "dot")));
        System.out.println(doublets.isWordLadder(Arrays.asList("cat")));

        System.out.println(doublets.getNeighbors("tiger"));
        System.out.println(doublets.getNeighbors("aloof"));

        System.out.println(doublets.getLadder("cat", "hat"));
        System.out.println(doublets.getLadder("aloof", "tiger"));

        System.out.println(doublets.getMinLadder("cat", "hat"));
        System.out.println(doublets.getMinLadder("aloof", "tiger"));
    }
}

/*

RUNTIME OUTPUT

0
4
-1
2
true
true
false
267751
false
true
[liger, niger, tiler, timer, titer, tiges]
[kloof]
[cat, bat, eat, fat, gat, hat]
[]
[cat, hat]
[]


 */

