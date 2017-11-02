/**
 * Created by awubis on 9/23/17.
 */
public class BigOhSolver {

   private static final double SECONDS = 1_000_000_000d;

   public static void main(String[] args) {

      ProvidedClass provClass = new ProvidedClass(903513873);
      int numIncrements = 10;
      int numRuns = 4;
      int n = 2;

      double ratio = 1;

      System.out.println("The average runtime given the sample size and the"
         + " number of run executions: " );
      for (int i = 0; i < numIncrements; i++) {
         double averageTime = 0;

         for (int j = 0; j < numRuns; j++) {
            long startTime = System.nanoTime();
            provClass.methodToTime(n);
            long endTime = System.nanoTime();
            averageTime += (endTime - startTime) / SECONDS;
         }
         averageTime = averageTime / numRuns;
         ratio = averageTime/ratio;
         System.out.println("Sample Size = " + n + "/ " + "Number of Runs Averaged = "
         + numRuns + "/ " + "Average Elapsed Time = " + averageTime + "/ "
         + "Ratio = " + ratio);
         ratio = averageTime;
         n = n * 3;
      }


   }


}
