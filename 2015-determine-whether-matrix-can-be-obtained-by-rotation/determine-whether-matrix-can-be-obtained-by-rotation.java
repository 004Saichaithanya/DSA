class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int c = 0; c < 4; c++) {
            if (!equalMat(mat, target)) {
                mat = rotate90(mat);
            } else {
                return true;
            }

        }

        // for(int[] arr : mat){
        // for(int x : arr)
        // System.out.print(x+" ");
        // System.out.println();
        // }

        // return true;
        return false;
    }

    boolean equalMat(int[][] mat, int[][] tar) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != tar[i][j])
                    return false;
            }
        }
        return true;
    }

    int[][] rotate90(int[][] mat) {

        int n = mat.length;
        //transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
        // reverse 
        for (int[] arr : mat) {
            int i = 0, j = arr.length - 1;
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return mat;
    }
}