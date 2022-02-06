//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 538 👎 0


package leetcode.editor.cn;

//杨辉三角

import java.util.ArrayList;
import java.util.List;

/**
 * @author fabian
 * @date 2021-08-04 22:52:39
 */
public class P118_PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118_PascalsTriangle().new Solution();
        long start = System.currentTimeMillis();
        for (List<Integer> list : solution.generate(1000)) {
            System.out.println(list);
        }
        System.out.println(System.currentTimeMillis() - start + "s");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> list = new ArrayList<>(i);
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == i) {
                        list.add(1);
                    } else {
                        list.add(ans.get(i - 2).get(j - 2) + ans.get(i - 2).get(j - 1));
                    }
                }
                ans.add(list);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}