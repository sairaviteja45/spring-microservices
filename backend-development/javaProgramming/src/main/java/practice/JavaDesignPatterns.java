package practice;

public class JavaDesignPatterns {

    /**1.Program-1 Result
     * Program-1 Stated
     * A A A A A
     * A A A A
     * A A A
     * A A
     * A
     * === Program-1 Code Execution Successful ===**/
    public static void program1() {
        for (int line = 1; line <= 5; line++) {
            for (int symble = 5; symble >= line; symble--) {
                System.err.print("A ");
            }

            System.err.println();
        }

        System.err.println("=== Program-1 Code Execution Successful ===");

    }

    /**2.Program-2 Result
     * Program-2 Stated
     * A
     * A A
     * A A A
     * A A A A
     * A A A A A
     * === Program-2 Code Execution Successful ===**/
    public static void program2() {
        for (int line = 1; line <= 5; line++) {
            for (int symble = 1; symble <= line; symble++) {
                System.err.print("A ");
            }
            System.err.println();
        }
        System.err.println("=== Program-2 Code Execution Successful ===");
    }

    /**3.Program-3 Result
     * Program-3 Stated
     * A A A A A
     * A A A A
     * A A A
     * A A
     * A
     * A A
     * A A A
     * A A A A
     * A A A A A
     * === Program-3 Code Execution Successful ===**/
    public static void program3() {
        for (int line = 1; line <= 5; line++) {
            for (int symble = line; symble <= 5; symble++) {
                System.err.print("A ");
            }
            System.err.println();
        }
        for (int line = 2; line <= 5; line++) {
            for (int symble = 1; symble <= line; symble++) {
                System.err.print("A ");
            }
            System.err.println();
        }

        System.err.println("=== Program-3 Code Execution Successful ===");
    }
}
