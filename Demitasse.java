import java.util.ArrayList;

class Solution {
    ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m){
        boolean[] rowsWithZero = new boolean[n];
        boolean[] colsWithZero = new boolean[m];

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(matrix.get(i).get(j)==0){
                    rowsWithZero[i] = true;
                    colsWithZero[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(colsWithZero[j] || rowsWithZero[i]){
                    matrix.get(i).set(j, 0);
                }
            }
        }
        

        return matrix;

    }

}

public class Demitasse {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(0);
        a2.add(1);
        a2.add(7);
        // a2.add(0);

        arr.add(a1);
        arr.add(a2);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }

        Solution x = new Solution();
        ArrayList<ArrayList<Integer>> sol = x.zeroMatrix(arr, 2, 3);
        ;
        for (int i = 0; i < sol.size(); i++) {
            for (int j = 0; j < sol.get(i).size(); j++) {
                System.out.print(sol.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}