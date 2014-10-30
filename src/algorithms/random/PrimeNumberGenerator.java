package algorithms.random;

import java.util.ArrayList;

/**
 * Created by nanagarajan on 9/29/2014.
 */
public class PrimeNumberGenerator {

    private ArrayList<Integer> allNumbers;
    private ArrayList<Boolean> crossOut;


    public PrimeNumberGenerator(int size) {
        allNumbers = new ArrayList<Integer>(size);
        crossOut = new ArrayList<Boolean>(size);

        for (int i = 0; i < size; i++) {

            allNumbers.add(i, i + 1);
            crossOut.add(i, true);
        }

    }

    public static void main(String[] args) {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator(100000000);
        long startTime = System.currentTimeMillis();
        primeNumberGenerator.generate();
        long endTime = System.currentTimeMillis();

        System.out.println("\n" + startTime + "\t" + endTime + "\t" + ((endTime - startTime)));

    }

    public ArrayList<Integer> getAllNumbers() {
        return allNumbers;
    }

    public void setAllNumbers(ArrayList<Integer> allNumbers) {
        this.allNumbers = allNumbers;
    }

    public ArrayList<Boolean> getCrossOut() {
        return crossOut;
    }

    public void setCrossOut(ArrayList<Boolean> crossOut) {
        this.crossOut = crossOut;
    }

    public void generate() {

        for (int iCount = 2; iCount <= allNumbers.size(); iCount++) {

            for (int jCount = 2; (jCount * iCount) <= allNumbers.size(); jCount++) {
                int index = (iCount * jCount) - 1;

                if (!crossOut.get(iCount - 1) || !crossOut.get(index)) {
                    continue;
                }


                crossOut.set(index, false);
            }

        }

        for (int i = 0; i < allNumbers.size(); i++) {
            if (crossOut.get(i)) {
                System.out.print(allNumbers.get(i) + " ");
            }
        }
    }
}