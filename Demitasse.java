import java.util.*;
class Solution {
    public static int[] spiralMatrix(int[][] mat) {
        int n = 0, s = mat.length, e = 0, w = mat[0].length;
        int[] res = new int[s * w];
        int index = 0;

        while (n < s && e < w) {
            
            for (int i = e; i < w; i++) {
                res[index] = mat[n][i];
                index++;
            }
            n++; 

            
            for (int i = n; i < s; i++) {
                res[index] = mat[i][w - 1];
                index++;
            }
            w--; 

            
            if (n < s) { 
                for (int i = w - 1; i >= e; i--) {
                    res[index] = mat[s - 1][i];
                    index++;
                }
                s--; 
            }

            
            if (e < w) { 
                for (int i = s - 1; i >= n; i--) {
                    res[index] = mat[i][e];
                    index++;
                }
                e++; 
            }
        }

        return res;
    }
}

public class Demitasse{
    public static void main(String args[]){
        int[][] matrix = 
        {{1,2,3,4},
        {1,2,3,4},
        {1,2,3,4}};
        int[] result = Solution.spiralMatrix(matrix);
        int[] res = Arrays.copyOfRange(result, 0, matrix.length * matrix[0].length);
        System.out.println(Arrays.toString(res));
        
    }
}
