package interviewprep.faang;

import java.util.*;

/**
 * FAANG INTERVIEW PATTERNS & QUESTIONS
 *
 * This file contains:
 * 1. Common coding patterns used in FAANG interviews
 * 2. Company-specific interview focuses
 * 3. Advanced problems frequently asked
 * 4. Pattern recognition guide
 *
 * Companies covered: Facebook (Meta), Amazon, Apple, Netflix, Google
 *
 * Study approach:
 * 1. Learn the pattern
 * 2. Practice 3-5 problems per pattern
 * 3. Time yourself (45 minutes per problem)
 * 4. Practice explaining your thought process
 */
public class FAANGPatterns {

    /**
     * ===== PATTERN 1: SLIDING WINDOW =====
     *
     * Use when:
     * - Working with arrays/strings
     * - Finding subarrays/substrings
     * - Contiguous sequence problem
     *
     * Template:
     * int left = 0, right = 0;
     * while (right < array.length) {
     *     // Expand window
     *     right++;
     *
     *     while (condition_violated) {
     *         // Shrink window
     *         left++;
     *     }
     *
     *     // Update result
     * }
     */

    /**
     * Example: Longest Substring with At Most K Distinct Characters
     * Google, Amazon favorite
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Expand window - add right character
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

            // Shrink window if more than k distinct characters
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Example: Minimum Window Substring (Facebook, Amazon)
     * Find minimum window in s that contains all characters of t.
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> required = new HashMap<>();
        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0;  // Distinct characters in window with desired frequency
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (required.containsKey(c) &&
                window.get(c).intValue() == required.get(c).intValue()) {
                formed++;
            }

            // Try to contract window
            while (formed == required.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (required.containsKey(leftChar) &&
                    window.get(leftChar) < required.get(leftChar)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    /**
     * ===== PATTERN 2: TWO POINTERS =====
     *
     * Use when:
     * - Sorted array
     * - Need to find pair/triplet
     * - Comparing elements from both ends
     */

    /**
     * Example: 3Sum (Amazon, Facebook favorite)
     * Find all unique triplets that sum to zero.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Important for two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first number
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * Example: Container With Most Water (Amazon, Apple)
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * ===== PATTERN 3: FAST & SLOW POINTERS (FLOYD'S CYCLE) =====
     *
     * Use when:
     * - Detecting cycles
     * - Finding middle element
     * - Linked list problems
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    /**
     * Example: Find Middle of Linked List
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // When fast reaches end, slow is at middle
    }

    /**
     * Example: Happy Number (Google)
     * Number is happy if repeatedly summing squares of digits leads to 1.
     */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    /**
     * ===== PATTERN 4: MERGE INTERVALS =====
     *
     * Use when:
     * - Overlapping intervals
     * - Scheduling problems
     * - Time-based problems
     */

    /**
     * Example: Merge Intervals (Facebook, Amazon, Google)
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Overlapping - merge
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping - add new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Example: Meeting Rooms II (Facebook, Amazon)
     * Find minimum number of conference rooms required.
     */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endIndex = 0;

        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endIndex]) {
                rooms++;  // Need new room
            } else {
                endIndex++;  // Room freed up
            }
        }

        return rooms;
    }

    /**
     * ===== PATTERN 5: TOP K ELEMENTS (HEAP) =====
     *
     * Use when:
     * - Finding top/smallest K elements
     * - K closest/farthest elements
     * - Frequency problems
     */

    /**
     * Example: Top K Frequent Elements (Amazon, Facebook)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Min heap of size k (keep k most frequent)
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Extract elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }

        return result;
    }

    /**
     * Example: Kth Largest Element (Amazon)
     */
    public static int findKthLargest(int[] nums, int k) {
        // Min heap of size k
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();  // Remove smallest
            }
        }

        return heap.peek();  // Kth largest
    }

    /**
     * ===== PATTERN 6: MODIFIED BINARY SEARCH =====
     *
     * Use when:
     * - Sorted or rotated sorted array
     * - Finding boundary/peak
     * - Time complexity must be O(log n)
     */

    /**
     * Example: Find Peak Element (Google, Microsoft)
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on left side (including mid)
                right = mid;
            } else {
                // Peak is on right side
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * ===== PATTERN 7: TREE DFS & BFS =====
     */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    /**
     * Example: Binary Tree Right Side View (Facebook)
     * Return values of nodes visible from right side.
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Last node of this level
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }

    /**
     * Example: Serialize and Deserialize Binary Tree (Amazon, Facebook)
     */
    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "null";

            return root.val + "," +
                   serialize(root.left) + "," +
                   serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Queue<String> nodes) {
            String val = nodes.poll();
            if (val.equals("null")) return null;

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    /**
     * ===== PATTERN 8: GRAPH BFS & DFS =====
     */

    /**
     * Example: Number of Islands (Amazon, Facebook, Google)
     * Count connected components in 2D grid.
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';  // Mark as visited

        // Visit all 4 directions
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    /**
     * Example: Word Ladder (Amazon, Facebook)
     * Find shortest transformation sequence from beginWord to endWord.
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return level;
                }

                // Try all possible one-letter changes
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[j] = c;
                        String newWord = new String(chars);

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);  // Mark as visited
                        }
                    }

                    chars[j] = original;  // Restore
                }
            }

            level++;
        }

        return 0;
    }

    /**
     * ===== PATTERN 9: DYNAMIC PROGRAMMING =====
     */

    /**
     * Example: Longest Increasing Subsequence (Amazon, Google)
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);  // Each element is a subsequence of length 1

        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    /**
     * Example: Word Break (Google, Facebook)
     * Determine if string can be segmented into dictionary words.
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // Empty string

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * ===== PATTERN 10: BACKTRACKING =====
     */

    /**
     * Example: Letter Combinations of Phone Number (Amazon)
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrackPhone(result, digits, "", 0, mapping);
        return result;
    }

    private static void backtrackPhone(List<String> result, String digits,
                                      String current, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            backtrackPhone(result, digits, current + c, index + 1, mapping);
        }
    }

    /**
     * ===== COMPANY-SPECIFIC FOCUSES =====
     */

    public static final String COMPANY_FOCUSES = """
            GOOGLE:
            - Focus: Algorithms, data structures, system design
            - Favorite topics: Graphs, trees, dynamic programming
            - Bar: Very high - expect optimal solutions
            - Tip: Explain your thought process clearly

            FACEBOOK (META):
            - Focus: Product sense + technical skills
            - Favorite topics: Graphs (social network), BFS/DFS, hashmaps
            - Common: "Design Facebook feature X"
            - Tip: Think about scale and tradeoffs

            AMAZON:
            - Focus: Leadership principles + coding
            - Favorite topics: Trees, sorting, OOP design
            - Behavioral: Heavy focus on STAR stories
            - Tip: Relate everything to leadership principles

            APPLE:
            - Focus: System design, attention to detail
            - Favorite topics: Memory management, performance optimization
            - Common: Low-level design questions
            - Tip: Show passion for products

            NETFLIX:
            - Focus: Senior-level thinking, autonomy
            - Favorite topics: System design, architecture
            - Bar: Very high (small team)
            - Tip: Demonstrate independent problem-solving

            MICROSOFT:
            - Focus: Fundamentals, problem-solving
            - Favorite topics: Arrays, strings, linked lists
            - Similar difficulty to Amazon
            - Tip: Clear communication

            Preparation time recommended: 8-12 weeks
            Problems to solve: 150-200 LeetCode (Easy: 30%, Medium: 60%, Hard: 10%)
            """;

    /**
     * ===== PROBLEM DIFFICULTY PROGRESSION =====
     */

    public static final String STUDY_PLAN = """
            WEEK 1-2: FUNDAMENTALS
            - Arrays & Hashing (20 problems)
            - Two Pointers (15 problems)
            - Stack (10 problems)

            WEEK 3-4: INTERMEDIATE
            - Binary Search (15 problems)
            - Sliding Window (15 problems)
            - Linked Lists (15 problems)

            WEEK 5-6: TREES & GRAPHS
            - Binary Trees (20 problems)
            - Binary Search Trees (10 problems)
            - Graphs (20 problems)

            WEEK 7-8: ADVANCED
            - Dynamic Programming (25 problems)
            - Backtracking (15 problems)
            - Heaps (10 problems)

            WEEK 9-10: COMPANY-SPECIFIC
            - Practice problems from target companies
            - System design fundamentals
            - Mock interviews

            WEEK 11-12: REVIEW & MOCK
            - Review mistakes
            - Timed practice
            - Mock interviews with peers
            - Polish STAR stories

            Daily schedule:
            - Morning: 1-2 new problems
            - Afternoon: Review previous problems
            - Evening: Read solutions, study patterns
            - Weekend: Mock interviews, system design
            """;
}
