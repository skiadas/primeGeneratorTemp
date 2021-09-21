package literateProgramming;

public class NumberPrinter {
    private final Page page;

    public NumberPrinter(int rowsPerPage, int columnsPerPage) {
        page = new Page(rowsPerPage, columnsPerPage);
    }

    void print(int[] numbers, String title) {
        page.setNumbers(numbers);
        while (page.hasNext()) {
            page.nextPage();
            printPage(title);
        }
    }

    private void printPage(String title) {
        printHeader(title);
        printNumbersOnPage();
        printFooter();
    }

    private void printFooter() {
        System.out.println("\f");
    }

    private void printHeader(String title) {
        System.out.printf("%s --- Page %d\n%n", title, page.getPageNumber());
    }

    private void printNumbersOnPage() {
        for (int row = 0; row < page.getRowsPerPage(); row++) {
            for (int col = 0; col < page.getColumnsPerPage(); col++) {
                if (page.hasEntry(row, col)) {
                    System.out.printf("%10d", page.getEntryAt(row, col));
                }
            }
            System.out.println();
        }
    }

}
