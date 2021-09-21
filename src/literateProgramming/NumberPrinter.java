package literateProgramming;

public class NumberPrinter {
    private final int rowsPerPage;
    private final int columnsPerPage;

    public NumberPrinter(int rowsPerPage, int columnsPerPage) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
    }

    void print(int numPrimes, int[] primes) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numPrimes));
            System.out.print(" Prime Numbers --- Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");
            for (int rowOffset = pageOffset; rowOffset <= pageOffset + rowsPerPage - 1; rowOffset++) {
                for (int col = 0; col <= columnsPerPage - 1; col++) {
                    if (rowOffset + col * rowsPerPage <= numPrimes) {
                        System.out.printf("%10d", primes[rowOffset + col * rowsPerPage]);
                    }
                }
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += rowsPerPage * columnsPerPage;
        }
    }
}
