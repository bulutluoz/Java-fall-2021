package interviewprep.whiteboard;

import java.util.*;

/**
 * WHITEBOARD CODING PROBLEMS
 *
 * Common patterns and problems asked in FAANG interviews.
 * Each problem includes:
 * - Problem statement
 * - Multiple approaches
 * - Time and space complexity
 * - Test cases
 *
 * Study Guide:
 * 1. Understand the problem (ask clarifying questions)
 * 2. Think of test cases (including edge cases)
 * 3. Discuss approach before coding
 * 4. Code while explaining
 * 5. Test your solution
 * 6. Analyze complexity
 * 7. Discuss optimizations
 */
public class WhiteboardProblems {

    /**
     * ===== ARRAYS & STRINGS =====
     */

    /**
     * PROBLEM 1: Two Sum
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers that add up to target.
     *
     * Example:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1] (because nums[0] + nums[1] = 9)
     */

    // Approach 1: Brute Force - O(n²) time, O(1) space
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};  // Not found
    }

    // Approach 2: HashMap - O(n) time, O(n) space (OPTIMAL)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};  // Not found
    }

    /**
     * PROBLEM 2: Best Time to Buy and Sell Stock
     * Find maximum profit from one buy and one sell.
     *
     * Example:
     * Input: [7,1,5,3,6,4]
     * Output: 5 (buy at 1, sell at 6)
     */

    // One pass - O(n) time, O(1) space
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    /**
     * PROBLEM 3: Contains Duplicate
     * Return true if any value appears at least twice in the array.
     *
     * Example:
     * Input: [1,2,3,1]
     * Output: true
     */

    // Approach 1: HashSet - O(n) time, O(n) space
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {  // add returns false if element exists
                return true;
            }
        }

        return false;
    }

    // Approach 2: Sorting - O(n log n) time, O(1) space
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * PROBLEM 4: Valid Anagram
     * Determine if two strings are anagrams of each other.
     *
     * Example:
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */

    // Approach 1: Sorting - O(n log n) time, O(1) space
    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    // Approach 2: Character Count - O(n) time, O(1) space (BETTER)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26];  // For lowercase a-z

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }

    /**
     * PROBLEM 5: Group Anagrams
     * Group strings that are anagrams of each other.
     *
     * Example:
     * Input: ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    // O(n * k log k) time where n = number of strings, k = max length
    // O(n * k) space
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * PROBLEM 6: Longest Substring Without Repeating Characters
     * Find length of longest substring without repeating characters.
     *
     * Example:
     * Input: "abcabcbb"
     * Output: 3 (substring "abc")
     */

    // Sliding Window - O(n) time, O(min(m,n)) space where m = charset size
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();  // char -> last seen index
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                // Move start to right of last occurrence
                start = Math.max(start, map.get(c) + 1);
            }

            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    /**
     * ===== LINKED LISTS =====
     */

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * PROBLEM 7: Reverse Linked List
     * Reverse a singly linked list.
     *
     * Example:
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     */

    // Iterative - O(n) time, O(1) space
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    // Recursive - O(n) time, O(n) space (call stack)
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * PROBLEM 8: Detect Cycle in Linked List
     * Determine if linked list has a cycle.
     */

    // Floyd's Cycle Detection (Two Pointers) - O(n) time, O(1) space
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;  // Cycle detected
            }
        }

        return false;
    }

    /**
     * PROBLEM 9: Merge Two Sorted Lists
     * Merge two sorted linked lists into one sorted list.
     */

    // Iterative - O(n+m) time, O(1) space
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    /**
     * ===== TREES & GRAPHS =====
     */

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * PROBLEM 10: Maximum Depth of Binary Tree
     * Find the maximum depth (height) of a binary tree.
     */

    // Recursive DFS - O(n) time, O(h) space where h = height
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Iterative BFS - O(n) time, O(w) space where w = max width
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return depth;
    }

    /**
     * PROBLEM 11: Validate Binary Search Tree
     * Determine if a binary tree is a valid BST.
     */

    // Recursive with bounds - O(n) time, O(h) space
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBSTHelper(node.left, min, node.val) &&
               isValidBSTHelper(node.right, node.val, max);
    }

    /**
     * PROBLEM 12: Lowest Common Ancestor of BST
     * Find the lowest common ancestor of two nodes in a BST.
     */

    // O(h) time, O(1) space iterative
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;  // Both in left subtree
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;  // Both in right subtree
            } else {
                return root;  // Split point or one is ancestor
            }
        }
        return null;
    }

    /**
     * PROBLEM 13: Binary Tree Level Order Traversal
     * Return level order traversal (BFS) of tree.
     */

    // BFS - O(n) time, O(w) space
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    /**
     * ===== DYNAMIC PROGRAMMING =====
     */

    /**
     * PROBLEM 14: Climbing Stairs
     * You can climb 1 or 2 steps at a time.
     * How many ways to climb n stairs?
     */

    // Fibonacci - O(n) time, O(1) space
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1;  // Ways to reach step 1
        int prev1 = 2;  // Ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    /**
     * PROBLEM 15: House Robber
     * Can't rob adjacent houses. Maximize amount robbed.
     *
     * Example:
     * Input: [2,7,9,3,1]
     * Output: 12 (rob houses 0, 2, 4)
     */

    // DP - O(n) time, O(1) space
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    /**
     * PROBLEM 16: Coin Change
     * Find minimum coins needed to make amount.
     *
     * Example:
     * coins = [1,2,5], amount = 11
     * Output: 3 (5+5+1)
     */

    // DP - O(n*m) time, O(n) space where n=amount, m=coins
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // Impossible value
        dp[0] = 0;  // 0 coins needed for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * ===== BINARY SEARCH =====
     */

    /**
     * PROBLEM 17: Binary Search
     * Search for target in sorted array.
     */

    // O(log n) time, O(1) space
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;  // Not found
    }

    /**
     * PROBLEM 18: Search in Rotated Sorted Array
     * Array was sorted then rotated. Find target.
     *
     * Example:
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */

    // Modified Binary Search - O(log n) time, O(1) space
    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {  // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {  // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * ===== BACKTRACKING =====
     */

    /**
     * PROBLEM 19: Generate Parentheses
     * Generate all valid combinations of n pairs of parentheses.
     *
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     */

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current,
                                  int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    /**
     * PROBLEM 20: Permutations
     * Generate all permutations of an array.
     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackPermute(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrackPermute(List<List<Integer>> result,
                                        List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue;  // Skip used elements

            current.add(num);
            backtrackPermute(result, current, nums);
            current.remove(current.size() - 1);  // Backtrack
        }
    }

    /**
     * ===== TEST CASES FOR COMMON PROBLEMS =====
     */

    public static void main(String[] args) {
        System.out.println("=== TESTING WHITEBOARD PROBLEMS ===\n");

        // Test Two Sum
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("Two Sum [2,7,11,15], target=9: " +
                          Arrays.toString(twoSum(nums1, 9)));  // [0, 1]

        // Test Max Profit
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit [7,1,5,3,6,4]: " + maxProfit(prices));  // 5

        // Test Anagram
        System.out.println("Is 'anagram' anagram of 'nagaram'? " +
                          isAnagram("anagram", "nagaram"));  // true

        // Test Longest Substring
        System.out.println("Longest substring without repeating chars in 'abcabcbb': " +
                          lengthOfLongestSubstring("abcabcbb"));  // 3

        // Test Climbing Stairs
        System.out.println("Ways to climb 5 stairs: " + climbStairs(5));  // 8

        // Test Binary Search
        int[] sorted = {1, 3, 5, 7, 9, 11};
        System.out.println("Binary search for 7 in [1,3,5,7,9,11]: " +
                          binarySearch(sorted, 7));  // 3

        System.out.println("\n=== All tests completed ===");
    }
}
