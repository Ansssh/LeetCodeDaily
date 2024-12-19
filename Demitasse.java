import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// ? code by me

class DSU{
    private int[] nums;
    private int[] indices;

    DSU(int n){
        nums = new int[n];
        indices = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
            indices[i] = 0;
        }
    }

    public int find(int x){
        if(nums[x] != x){
            nums[x] = find(nums[x]);
        }
        return nums[x];
    }

    public void union(int index1, int index2){
        int root1 = find(index1);
        int root2 = find(index2);

        if(root1 != root2){
            if (indices[root1] > indices[root2]) {
                nums[root2] = root1;
            }else if(indices[root1] < indices[root2]){
                nums[root1] = root2;
            }else{
                nums[root2] = root1;
                indices[root1]++;
            }
        }
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        DSU uf = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j] )<= limit) {
                    uf.union(i, j);
                }
            }
        }

        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = uf.find(i);
            if(adj.containsKey(key)){
                ArrayList<Integer> ol = adj.get(key);
                ol.add(nums[i]);
                adj.put(key, ol);
            }else{
                ArrayList<Integer> ol = new ArrayList<>();
                ol.add(nums[i]);
                adj.put(key, ol);
            }
        }

        for (int i : adj.keySet()) {
            adj.get(i).sort(null);
        }

        // System.out.println(adj);
        // System.out.println(Arrays.toString(nums));

        for (int i = 0; i < n; i++) {
            int father = uf.find(i);
            nums[i] = adj.get(father).get(0);
            adj.get(father).remove(0);
        }
        
        return nums;
    }
}

public class Demitasse{
    public static void main(String args[]){
        int[] nums = {1,5,3,9,8};
        Solution x = new Solution();
        int[] sol = x.lexicographicallySmallestArray(nums, 3);
        System.out.println(Arrays.toString(sol));
    }
}

// ? Code By GPT

// import java.util.*;

// class DSU {
//     private int[] parent;
//     private int[] rank;

//     DSU(int n) {
//         parent = new int[n];
//         rank = new int[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//             rank[i] = 0;
//         }
//     }

//     public int find(int x) {
//         if (parent[x] != x) {
//             parent[x] = find(parent[x]); // Path compression
//         }
//         return parent[x];
//     }

//     public void union(int x, int y) {
//         int rootX = find(x);
//         int rootY = find(y);

//         if (rootX != rootY) {
//             if (rank[rootX] > rank[rootY]) {
//                 parent[rootY] = rootX;
//             } else if (rank[rootX] < rank[rootY]) {
//                 parent[rootX] = rootY;
//             } else {
//                 parent[rootY] = rootX;
//                 rank[rootX]++;
//             }
//         }
//     }
// }

// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         int n = nums.length;
//         DSU dsu = new DSU(n);

//         // Pair the values with their indices and sort by value
//         int[][] pairs = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             pairs[i][0] = nums[i];
//             pairs[i][1] = i;
//         }
//         Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

//         // Perform unions only between adjacent elements in the sorted array
//         for (int i = 0; i < n - 1; i++) {
//             if (Math.abs(pairs[i][0] - pairs[i + 1][0]) <= limit) {
//                 dsu.union(pairs[i][1], pairs[i + 1][1]);
//             }
//         }

//         // Group indices by their root and sort the values within each group
//         Map<Integer, PriorityQueue<Integer>> groupedValues = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             int root = dsu.find(i);
//             groupedValues.computeIfAbsent(root, k -> new PriorityQueue<>()).offer(nums[i]);
//         }

//         // Reconstruct the array by assigning the smallest value from each group
//         for (int i = 0; i < n; i++) {
//             int root = dsu.find(i);
//             nums[i] = groupedValues.get(root).poll();
//         }

//         return nums;
//     }
// }

// public class Demitasse {
//     public static void main(String[] args) {
//         int[] nums = {1, 5, 3, 9, 8};
//         Solution solution = new Solution();
//         int[] result = solution.lexicographicallySmallestArray(nums, 2);
//         System.out.println("Lexicographically Smallest Array: " + Arrays.toString(result));
//     }
// }