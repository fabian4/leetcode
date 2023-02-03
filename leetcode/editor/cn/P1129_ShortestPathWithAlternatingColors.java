//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 169 👎 0


package leetcode.editor.cn;

//颜色交替的最短路径

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fabian
 * @date 2023-02-02 11:58:32
 */
public class P1129_ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        Solution solution = new P1129_ShortestPathWithAlternatingColors().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            // 初始化结果数组
            int[] ans = new int[n];
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[0] = 0;

            /*
             * 初始化邻接表数组
             *  list[0] 为红边所在邻接表
             *  list[1] 为蓝边所在邻接表
             */
            ArrayList<Integer>[][] list = new ArrayList[2][n];
            for (int i = 0; i < n; i++) {
                list[0][i] = new ArrayList<>();
                list[1][i] = new ArrayList<>();
            }
            for (int[] redEdge : redEdges) {
                list[0][redEdge[0]].add(redEdge[1]);
            }
            for (int[] blueEdge : blueEdges) {
                list[1][blueEdge[0]].add(blueEdge[1]);
            }

            // 初始化队列（元素以{到该点的边颜色（0红，1蓝），节点}的数组存储）、访问标记数组，由于是红蓝交替、因此是双源BFS
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0});
            q.offer(new int[]{1, 0});
            boolean[][] vis = new boolean[2][n];
            vis[0][0] = vis[1][0] = true;

            int step = 1;
            while (!q.isEmpty()) {
                for (int i = q.size(); i > 0; i--) {
                    int[] poll = q.poll();
                    int color = poll[0] ^ 1; // 变换颜色
                    int point = poll[1];
                    for (int next : list[color][point]) {
                        if (!vis[color][next]) {
                            ans[next] = Math.min(ans[next], step);
                            q.offer(new int[]{color, next});
                            vis[color][next] = true;
                        }
                    }
                }
                step++;
            }

            // 对于不存在路径的点，特殊处理为 -1
            for (int i = 0; i < n; i++) {
                if (ans[i] == Integer.MAX_VALUE) {
                    ans[i] = -1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}