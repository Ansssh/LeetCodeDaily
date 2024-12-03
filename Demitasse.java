
public class Demitasse {
    public static void main(String args[]) {
        Solution x = new Solution();
        int[] arr = {1,5};
        System.out.println(x.addSpaces("ILoveCoding", arr));
    }
}

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder x = new StringBuilder();
        int n = 0;

        for(int i:spaces){
            x.append(s.substring(n,i));
            n = i;
            x.append(" ");
        }
        x.append(s.substring(n));
        return x.toString();
    }
}