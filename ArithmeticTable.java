
/**
 * <p>Automated multiplication and addition.</p>
 * @author Yuheng Song(Hugh)
 * @version 1.0
 */
public class ArithmeticTable {
    /**The first number.*/
    private int start;
    /**The last number.*/
    private int end;
    /**The options of the operation.*/
    private enum TableType { MULT, ADD }
    /**Type of this operation.*/
    private TableType tableType;   
    /**Making a table.*/
    private float[][] myTable;
    /**Maximum of end number.*/
    private final int maxEnd = 100;
    /**We need three input in this program.*/
    private final int numInput = 3;
    /**
    * AgumentCheck.
    * @param args Letting user enter first number, last number and the type of operation.
    * @return Does the user enter correctly.
    */
    public boolean argumentCheck(String[] args) {
        if (args.length != numInput) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }        
        if (args[0].charAt(0) == '+') {
            tableType = TableType.ADD;
        } else {
            tableType = TableType.MULT;
        }
        int sta;
        int sto;
        try {
            sta = Integer.parseInt(args[1]);
            sto = Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
        if ((sta < 1 || sta > maxEnd) || ((sto < 1 || sto > maxEnd))) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
        if (sta >= sto) {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
        start = sta;
        end = sto;
        return true;
    }
    /**
     * creat a table.
     * @param begin first number
     * @param finish last number
     * @param tableType whith kind of operation
     */
    public void createTable(int begin, int finish, TableType tableType) {
        int col = 1;
        int row = 1;
        myTable = new float[finish - begin + 2][finish - begin + 2];
        myTable[0][0] = 0;
        for (int i = begin; i <= finish; i++) {
            myTable[0][col] = i;
            col++;
        }
        for (int i = begin; i <= finish; i++) {
            myTable[row][0] = i;
            row++;
        }
        col = 1;
        row = 1;
        if (tableType == TableType.ADD) {
            for (int i = begin; i <= finish; i++) {
                for (int j = begin; j <= finish; j++) {
                    myTable[row][col] = i + j;
                    col++;
                }
                col = 1;
                row++;
            }
        } 
        col = 1;
        row = 1;
        if (tableType == TableType.MULT) {
            for (int i = begin; i <= finish; i++) {
                for (int j = begin; j <= finish; j++) {
                    myTable[row][col] = i * j;
                    col++;
                }
                col = 1;
                row++;
            }
        }   
    }
    /**
     * Print out of the table.
     */
    public void printTable() {
        for (int row = 0; row < myTable.length; row++) {
            for (int col = 0; col < myTable.length; col++) {
                
                if (myTable[row][col] == 0) {
                    if (tableType == TableType.ADD) {
                        System.out.printf(" " + " " + " " + " " + " " 
                                + " " + '+');
                    } else {
                        System.out.printf(" " + " " + " " + " " 
                                    + " " + " " +  '*');
                    }
                } else {
                    System.out.printf("%5.0f", myTable[row][col]);
                    if (col == 0) {
                        System.out.printf(" " + "|");
                    }
                }        
            }
            System.out.printf("\n");
            if (row == 0) {
                System.out.printf(" " + " " + " " + " " 
                        + " " + " " + " " + " ");
                for (int i = 0; i < myTable.length - 1; i++) {
                    System.out.printf("-----");
                }
                System.out.printf("\n");
            }           
        }        
    }
    /**
     * Testing.
     * @param args inputs
     */
    public static void main(String[] args) {
        ArithmeticTable table = new ArithmeticTable();
        if (table.argumentCheck(args)) {
            table.createTable(table.start, table.end, table.tableType);
            table.printTable();
        }
    }
}
