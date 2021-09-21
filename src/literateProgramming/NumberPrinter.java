package literateProgramming;

public class NumberPrinter {
    private final int rowsPerPage;
    private final int columnsPerPage;
    private int pageNumber;
    private int pageOffset;
    private int numberOfNumbers;
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
        pageOffset = 1;
        this.numbers = numbers;
        numberOfNumbers = this.numbers.length - 1;
    }

    private boolean needToPrintMorePages() {
        return pageOffset <= numberOfNumbers;
    }

    private void printHeader() {
        System.out.print("The First ");
        System.out.print(Integer.toString(numberOfNumbers));
        System.out.print(" Prime Numbers --- Page ");
        System.out.print(Integer.toString(pageNumber));
        System.out.println("\n");
    }

    private void printNumbersOnPage() {
        for (int row = 0; row < rowsPerPage; row++) {
            for (int col = 0; col < columnsPerPage; col++) {
                printNumberAt(pageOffset + row + col * rowsPerPage);
            }
            System.out.println();
        }
    }

    private void printNumberAt(int index) {
        if (index <= numberOfNumbers) {
            System.out.printf("%10d", numbers[index]);
        }
    }

    private void moveToNextPage() {
        System.out.println("\f");
        pageNumber++;
        pageOffset += rowsPerPage * columnsPerPage;
    }
}
