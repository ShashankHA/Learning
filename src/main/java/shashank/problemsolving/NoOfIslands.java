package shashank.problemsolving;

public class NoOfIslands {

    public static void main(String[] args) {
        int a[][] = {{1, 1, 0, 1},
                     {1, 1, 0, 0},
                     {0, 0, 0, 0},
                     {1, 0, 1, 1},
                     {0, 0, 1, 1}
        };
        System.out.println(noOfIslands(a)); // answer should be 4
    }

    private static int noOfIslands(int[][] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] == 1) {
                    dfs(a,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(int[][] a, int i, int j) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] == 0) {
            return;
        }
        a[i][j] = 0;
        dfs(a, i + 1, j);
        dfs(a, i - 1, j);
        dfs(a, i, j + 1);
        dfs(a, i, j - 1);
    }
}
