import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Long> init = new ArrayList<>();
            init.add((long) 1);
            for (int j = 1; j < i; j++) {
                init.add(sol.get(i - 1).get(j - 1) + sol.get(i - 1).get(j));
            }
            if (i > 0) {
                init.add((long) 1);
            }
            sol.add(init);
        }
        return sol;
    }
}

public class Demitasse {
    public static void main(String args[]) {
        ArrayList<ArrayList<Long>> x = new ArrayList<>();
        Solution bankai = new Solution();
        x = bankai.printPascal(6);
        System.out.println(x);
    }
}