package literateProgramming;

public class NumberPrinter {
    private final int rowsPerPage;
    private final int columnsPerPage;
    private int pageNumber;
    private int[] numbers;

    public NumberPrinter(int rowsPerPage, int columnsPerPage) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
    }

    void print(int[] numbers) {
        initialize(numbers);
        while (needToPrintMorePages()) {
            printHeader();
            printNumbersOnPage();
            moveToNextPage();
        }
    }

    private void initialize(int[] numbers) {
        pageNumber = 1;
        this.numbers = numbers;
    }

    private boolean needToPrintMorePages() {
        return getPageOffset() <= getNumberOfNumbers();
    }

    private void printHeader() {
        System.out.print("The First ");
        System.out.print(Integer.toString(getNumberOfNumbers()));
        System.out.print(" Prime Numbers --- Page ");
        System.out.print(Integer.toString(pageNumber));
        System.out.println("\n");
    }

    private void printNumbersOnPage() {
        for (int row = 0; row < rowsPerPage; row++) {
            for (int col = 0; col < columnsPerPage; col++) {
                printNumberAt(getPageOffset() + row + col * rowsPerPage);
            }
            System.out.println();
        }
    }

    private void printNumberAt(int index) {
        if (index <= getNumberOfNumbers()) {
            System.out.printf("%10d", numbers[index]);
        }
    }

    private void moveToNextPage() {
        System.out.println("\f");
        pageNumber++;
    }

    public int getPageOffset() {
        return (pageNumber - 1) * rowsPerPage * columnsPerPage + 1;
    }

    public int getNumberOfNumbers() {
        return numbers.length - 1;
    }
}
