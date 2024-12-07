
class Solution {
    public int numberOfInversions(int []arr, int n) {
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(arr[i]>arr[j] && i < j){
                    res++;
                }
            }
        }
        return res;
    }
}

public class Demitasse {
    public static void main(String args[]) {
        int[] sol = {5,4,2,1,3};
        Solution x = new Solution();
        System.out.println(x.numberOfInversions(sol, 5));
    }
}