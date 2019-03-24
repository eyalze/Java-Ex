public class IsSquare {
    int max = 0;

    public static void main(String[] args) {
        int[][] inArr = new int[][] {{1,1},{1,0}};
        IsSquare inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{1,1,0},{1,1,0},{1,0,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{0,0,0,1},{1,1,0,1},{1,1,1,1},{0,1,1,1},{0,1,1,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{1,1,0,1},{1,1,0,1},{1,1,1,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

        inArr = new int[][] {{0,1,1,0,0,1,0,1,0,1},{0,0,1,0,1,0,1,0,1,0},{1,0,0,0,0,1,0,1,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,1,1,1,1,1,1,1,0},{1,1,0,1,0,1,1,1,1,0},{0,0,0,1,1,0,0,0,1,0},{1,1,0,1,1,0,0,1,1,1},{0,1,0,1,1,0,1,0,1,1}};
        inst = new IsSquare();
        inst.max = inst.maximalSquareB(inArr);
        inst.print(inArr);

    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+",");

            }
            System.out.println(";");

        }
        System.out.println("result: " +max);
        System.out.println("----------------");
    }

    public int maximalSquareB(int[][] matrix) {
        int res = 0;
        int maxlen = 0;

        int ti, tj;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    maxlen = 1;
                    ti = i;
                    tj = j;
                    while (i+1 < matrix.length && j+1 < matrix[i].length &&
                            matrix[i+1][j+1] == 1 &&
                            isValid(matrix, ti, tj, maxlen+1)) {
                        maxlen++;
                        i++; j++;
                    }
                    i = ti;
                    j = tj;
                    res = Math.max(res, maxlen);
                }
            }
        }
        res = Math.max(res, maxlen);
        return res * res;
    }

    private boolean isValid(int[][] matrix, int x, int y, int size) {
        for (int i = x; i < matrix.length && i < size + x; i++) {
            for (int j = y; j < matrix[i].length && j < size + y; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
     }

    public int maximalSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxsqlen = 0;
        int[][] countMatrix = new int[rows+1][cols+1];
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < cols+1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    countMatrix[i][j] = Math.min(Math.min(
                            countMatrix[i][j - 1],
                            countMatrix[i - 1][j]),
                            countMatrix[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, countMatrix[i][j]);
                }
            }
        }
        return maxsqlen;
    }
}
