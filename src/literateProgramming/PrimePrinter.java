package literateProgramming;


public class PrimePrinter {
    public static void main(String[] args) {
        final int numPrimes = 1000;
        NumberPrinter numberPrinter = new NumberPrinter(50, 4);
        PrimeGenerator primeGenerator = new PrimeGenerator(numPrimes);
        numberPrinter.print(numPrimes, primeGenerator.generate());
    }
}
