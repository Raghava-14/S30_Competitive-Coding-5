//Time = O(1), as it is a fixed 9*9 board
//Space = O(1), Space used by sets is constant as well (9*9)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Sets to track the seen digits in rows, columns, and sub-boxes
        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> boxes = new HashSet<>();

        // Traverse each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Skip empty cells
                if (num == '.') continue;

                // Create unique identifiers for the current cell's row, column, and sub-box
                String rowKey = "row" + i + ":" + num;
                String colKey = "col" + j + ":" + num;
                String boxKey = "box" + (i / 3) + "-" + (j / 3) + ":" + num;

                // Check if the number is already in the row, column, or sub-box
                if (rows.contains(rowKey) || cols.contains(colKey) || boxes.contains(boxKey)) {
                    return false; // Found a duplicate
                }

                // Add the current number to the sets
                rows.add(rowKey);
                cols.add(colKey);
                boxes.add(boxKey);
            }
        }
        return true; // No duplicates found, the Sudoku is valid
    }
}