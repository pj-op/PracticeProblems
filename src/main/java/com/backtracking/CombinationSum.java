package com.backtracking;

import java.util.*;

public class CombinationSum {
    static Set<List<Integer>> ans1;
    static List<List<Integer>> ans;

    public static void main(String[] args) {
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        System.out.println(combinationSumWithoutDuplicates(candidates, target));
    }

    private static List<List<Integer>> combinationSumWithoutDuplicates(int[] candidates, int target) {
        ans1 = new HashSet<>();
        Arrays.sort(candidates);
        solveUsingBackTrackingWithoutDuplicateCombos(0, candidates, target, new ArrayList<>());
        return new ArrayList<>(ans1);
    }

    private static void solveUsingBackTrackingWithoutDuplicateCombos(int index, int[] candidates, int target, List<Integer> combination) {
        int n = candidates.length;
        if (target == 0) {
            ans1.add(new ArrayList<>(combination));
        }
        for (int i = index; i < n; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
//            if (candidates[i] > target) break;
            if (candidates[i] <= target) {
                combination.add(candidates[i]);
                solveUsingBackTrackingWithoutDuplicateCombos(i + 1, candidates, target - candidates[i], combination);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        solveUsingBackTracking(0, candidates, target, new ArrayList<>());
        return ans;
    }

    //When Duplicates are allowed
    private static void solveUsingBackTracking(int index, int[] candidates, int target, List<Integer> combination) {
        int n = candidates.length;
        if (index == n) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
            }
            return;
        }
        if (index < n && candidates[index] <= target) {
            combination.add(candidates[index]);
            solveUsingBackTracking(index, candidates, target - candidates[index], combination);
            combination.remove(combination.size() - 1);
        }
        solveUsingBackTracking(index + 1, candidates, target, combination);
    }
}
