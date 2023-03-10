package com.xiaoma.code_77;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
 * @author xiaoma
 * @date 2023/2/11 15:35
 */
class Solution {
    private final List<List<Integer>> result = new ArrayList<>();
    private final LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
         combineHelper(n , k , 1);
         return result;
    }

    public void combineHelper(int n , int k , int startIndex) {
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 这里进行了剪枝操作
        // 这里 i <= n - (k - path.size()) + 1 不是很清楚什么意思
        // k - path.size() ==> 还剩下需要排列的个数
        // i + (k - path.size()) - 1 ==> 当前进行的数加上还需要排列的数 - 1 如果小于等于n则说明可以进行下面操作
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i ++ ) {
            path.add(i);
            combineHelper(n , k , i + 1);
            // 进行回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        result.forEach(item -> {
            item.forEach(k -> {
                System.out.print(k + " ");
            });
            System.out.println();
        });
    }

    @Test
    public void test01() {
        new Solution().combine(4 , 4).forEach(item -> {
            item.forEach(k -> {
                System.out.print(k + " ");
            });
            System.out.println();
        });
    }
}