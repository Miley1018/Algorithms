package com.company;

import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mileygao on 5/23/17.
 */
public class Solution {
    public int getSum(int a, int b) {
        int up = a&b;
        int result = a^b;

        while (up != 0) {
            up <<= 1;
            result = getSum(result,up);
        }
        return result;
    }
    public int majorityElement(int[] nums) {
        if (nums.length==1||nums.length==2){
            return nums[0];
        }
        Arrays.sort(nums);
        int mid = (0+nums.length)/2;
        if (nums.length%2==0){
            if (nums[mid]==nums[nums.length-1]){
                return nums[mid];
            }
            return nums[mid-1];
        }else{
            return nums[mid];
        }

    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean ok =false;
        boolean pre = false;
        int cnt = 0;
        if (flowerbed[0]==0){
            pre = true;
            ok = true;
        }
        for (int i = 1; i<flowerbed.length;i++){
            if (flowerbed[i] == 0){
                if (pre == false){
                    pre  = true;
                }else {
                    if(ok == false){
                        ok = true;
                    }else {
                        cnt++;
                        ok = false;
                    }
                }
            }else {
                pre = false;
                ok = false;
            }
        }
        if (ok==true){
            cnt++;
        }
        if (cnt>=n){
            return true;
        }
        return false;
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int minIndex=0;
        int maxIndex=0;
        Integer min = Integer.MAX_VALUE;
        Integer minSec=Integer.MAX_VALUE;
        Integer max=Integer.MIN_VALUE;
        Integer maxSec=Integer.MIN_VALUE;
        for (int i = 0; i<arrays.size();i++){
            minSec = Math.min(arrays.get(i).get(0),minSec);
            maxSec = Math.max(arrays.get(i).get(arrays.get(i).size()-1),maxSec);
            if(arrays.get(i).get(0)<min){
                minSec = min;
                min = arrays.get(i).get(0);
                minIndex = i;
            }
            if (arrays.get(i).get(arrays.get(i).size()-1)>max){
                maxSec = max;
                max = arrays.get(i).get(arrays.get(i).size()-1);
                maxIndex = i;
            }
        }
        int dis ;
        System.out.println(max+"--"+maxSec+"--"+maxIndex+"--"+min+"--"+minSec+"--"+minIndex);
        if (minIndex == maxIndex){
            dis = Math.max(Math.abs(max-minSec),Math.abs(maxSec-min));
        }else{
            dis = Math.abs(max-min);
        }
        return dis;
    }
   // List<List<Integer>> lists;
    public List<List<Integer>> generate(int numRows) {
        lists= new ArrayList<>();
        for (int i = 0; i<numRows;i++) {
            generateOne(i);
        }
        return lists;
    }
    private void generateOne(int n){
        if (n == 0){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            lists.add(list);
            return;
        }
        if (n == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            lists.add(list);
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int i = 1; i < n; i++) {
                list.add(lists.get(n - 1).get(i - 1) + lists.get(n - 1).get(i));
            }
            list.add(1);
            lists.add(list);
        }
    }
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size()==1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
               if (o1.start>o2.start){
                   return 1;
               }else if (o1.start<o2.start){
                   return -1;
               }else {
                   return 0;
               }
            }
        });
        List<Interval> list = new ArrayList<>();
        Interval pre = null;
        for (Interval i:intervals){
            if (pre ==null||i.start>pre.end){
                list.add(i);
                pre = i;
            }else if (i.end>pre.end){
                pre.end = i.end;
            }
        }
        return list;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        res = new ArrayList<>();
        if  (root==null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        levelup(root,list);
        list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        return res;
    }
    private void levelup(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        List<Integer> list2 = new ArrayList<>();
        levelup(root.left,list2);
        levelup(root.right,list2);
        if (list2.size()==0){
            return;
        }
        res.add(list2);
    }
    public boolean checkRecord(String s) {
        if (s.indexOf('A')!=s.lastIndexOf('A')||s.contains("LLL")){
            return false;
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null||helper(root.left,root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if (left==null||right == null){
            return left==right;
        }
        if (left.val!=right.val){
            return false;
        }
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }
    public int lengthOfLastWord(String s) {
        int k = 0;
        while(k<s.length()&&s.charAt(s.length()-1-k)==' '){
            k++;
        }
        int res = 0;
      for (int i = k; i<s.length();i++){
            if (s.charAt(s.length()-1-i)==' '){
                break;
            }
            res++;
      }
      return res;
    }
    public void rotate(int[] nums, int k) {
        if (nums.length==0||nums.length==1){
            return;
        }
        k = k%nums.length;
        int[] a = new int[k];
        int t = 0;
        for (int i=nums.length-k; i<nums.length;i++){
            a[t++] = nums[i];
        }
        int tt = nums.length-1;
        for (int i = nums.length-k-1; i>=0;i--){
            nums[tt--] = nums[i];
        }
        for (int i = 0;i<k;i++){
            nums[i] = a[i];
        }

    }
    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        for (int i = 1; i<=num/2;i++){
            if (num%i==0&&num/i==i){
                return true;
            }
        }
        return false;
    }
    public int countBattleships(char[][] board) {
        int cnt =0;
        boolean before = false;
        for (int i = 0; i<board.length;i++){
            for (int j = 0; j<board[i].length;j++){
                if (board[i][j]=='X'){
                    if (before == true&&j==board[i].length-1){
                        before = false;
                        continue;
                    }
                    if (before == true&&j!=board[i].length-1){
                        continue;
                    }
                    if (i>0&&board[i-1][j]=='X'){
                        continue;
                    }
                    cnt++;
                    before = true;
                }else {
                    before = false;
                }
                if (j == board[i].length-1){
                    before = false;
                }
            }
        }
        return cnt;
    }
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if (num==1){
            res[1] = 1;
        }
        int before;
        int tmp = 0;
        int now = 1;
        while (now<=num) {
            before = now;
            now = now*2;
            tmp = before;
            for (int t = before; t <(now>num?num:now); t++) {
                tmp = t;
                if (res[t] == 0) {
                    if (t == before) {
                        res[t] = 1;
                    } else {
                        int gap = t - before;
                        res[t] = res[before] + res[gap];
                    }
                }
            }
            if (tmp==num-1&&num!=now){
                int gap = num-before;
                res[num]=res[before]+res[gap];
            }else if(num==now){
                res[num] = 1;
                break;
            }
        }
        return res;
    }
    public int subarraySum(int[] nums, int k) {
       int cnt = 0;
       Map<Integer,Integer> map = new HashMap<>();
       Map<Integer,Integer> help;
       map.put(0,1);
       for (int i = 0; i<nums.length;i++){
           if (map.containsKey(k-nums[i])){
               cnt+=map.get(k-nums[i]);
           }
           help = new HashMap<>();
           for (Integer in:map.keySet()){
               help.put(in+nums[i],map.getOrDefault(in,0)+1);
           }
           help.put(nums[i],map.getOrDefault(nums[i],0)+1);
           map = new HashMap<>(help);
       }
       return cnt;
    }
    public int[][] reconstructQueue(int[][] people) {
        sort(people);
        List<int[]> list = new ArrayList();

        for (int i = people.length-1;i>=0;i--){

                int index = people[i][1];
                list.add(index,people[i]);
        }
        list.toArray(people);
        return people;
    }
    private void sort(int[][] a){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    if (o1[0]>o2[0]){
                        return 1;
                    }else if(o1[0]<o2[0]){
                        return -1;
                    }else {
                        if(o1[1]>o2[1]){
                            return -1;
                        }else {
                            return 1;
                        }
                    }
            }
        });
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode one = new ListNode(0);
        ListNode fast = one;
        ListNode slow = one;
        one.next = head;
        for (int i = 0; i<n;i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next.next;
        slow.next = next;
        return one.next;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> lists = new ArrayList<>();
        int[] numset = new int[map.size()];
        int k = 0;
        for (Integer i:map.keySet()){
            numset[k++] = i;
        }
        for (int i = 0; i<numset.length;i++){
            lists.add(new ArrayList<>(numset[i]));
            List list = new ArrayList();
            list.add(numset[i]);
            for (int j = i+1;j<numset.length;j++){
                list.add(numset[j]);
                lists.add(new ArrayList<>(list));
            }
        }
        return lists;
    }
    public int rob(int[] nums) {
       int i = 0;
       int e = 0;
       for (int k = 0; k<nums.length;k++){
           int tmp = i;
           i  = e + nums[k];
           e = Math.max(tmp,e);
       }
       return Math.max(i,e);
    }
    public int trailingZeroes(int n) {
        return n==0?0:n/5+trailingZeroes(n/5);
    }
    public boolean isPalindrome(String s) {
        if (s==null||s.length()==0){
            return true;
        }
        int t = Math.abs('a'-'A');
        int j = s.length()-1;
        for (int i = 0; i<j;i++){
            if ((s.charAt(i) >='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                if((s.charAt(j) >='A'&&s.charAt(j)<='Z')||(s.charAt(j)>='a'&&s.charAt(j)<='z')){
                    //System.out.println(Math.abs(s.charAt(i)-s.charAt(j)));
                    if (Math.abs(s.charAt(i)-s.charAt(j))!=t&&s.charAt(i)!=s.charAt(j)){
                      //  System.out.println(s.charAt(i)+"    "+s.charAt(j)+"----"+i+"----"+j+"hg"+Math.abs(s.charAt(i)-s.charAt(j)));
                        return false;
                    }else {
                        j--;
                    }
                }else if ((s.charAt(j) >='0'&&s.charAt(j)<='9')){
                    return false;
                }else {
                    j--;
                    i=i-1;
                }
            }
            else if ((s.charAt(i) >='0'&&s.charAt(i)<='9')){
                if((s.charAt(j) >='0'&&s.charAt(j)<='9')){
                    //System.out.println(Math.abs(s.charAt(i)-s.charAt(j)));
                    if (s.charAt(i)!=s.charAt(j)){
                        //  System.out.println(s.charAt(i)+"    "+s.charAt(j)+"----"+i+"----"+j+"hg"+Math.abs(s.charAt(i)-s.charAt(j)));
                        return false;
                    }else {
                        j--;
                    }
                }else if ((s.charAt(j) >='A'&&s.charAt(j)<='Z')||(s.charAt(j)>='a'&&s.charAt(j)<='z')){
                    return false;
                }else {
                    j--;
                    i=i-1;
                }
            }
        }
        return true;
    }
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
         helper1(root);
        return root;
    }
    private void helper1(TreeNode x){
        if (x==null){
            return;
        }
        helper1(x.right);
        x.val+=sum;
        sum=x.val;
        helper1(x.left);
    }
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0;i<M.length;i++){
            for (int j = i+1;j<M.length;j++){
               if (M[i][j]==1){
                   uf.union(i,j);
               }
            }
        }
        return uf.count();
    }
    private class UF{
        private int N;
        private int[] id;
        private int[] size;
        private UF(int n){
            this.N = n;
            id = new int[n];
            for (int i = 0; i<n;i++){
                id[i] = i;
            }
            size = new int[n];
        }
        private void union(int i, int j){
            int p = find(i);
            int q = find(j);
            if (p==q){
                return;
            }
            N--;
            if (size[p]<size[q]){
                id[p] = q;
                size[q]+=size[p];
            }else {
                id[q] = p;
                size[p]+=size[q];
            }
        }
        private int find(int i){
            int p = i;
            while (id[i]!=i){
                i = id[i];
            }
            int res= i;
            i = p;
            int tmp;
            while (id[i]!=i){
                tmp = id[i];
                id[i] = res;
                i = id[i];
            }
            return res;
        }
        private int count(){
            return N;
        }
        private boolean connected(int i, int j){
            int p = find(i);
            int q = find(j);
            if (p==q){
                return true;
            }
            return false;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        for (int i = 0; i<nums.length;i++){
            System.out.println(nums[i]);
        }
        return find(nums,nums.length-k+1,0,nums.length-1);
    }
    private int find(int[] nums,int k, int lo, int hi){
        if (lo>=hi){
            return nums[lo];
        }
        int i =partition(nums,lo,hi);
        if (i+1==k){
            System.out.println("www"+nums[i]);
            return nums[i];
        }else if (i+1<k){
            return find(nums,k,i+1,hi);
        }else {
            return find(nums,k,lo,i-1);
        }
    }
    private int partition(int[] nums,int lo, int hi){
        int lt = lo;
        int gt = hi+1;
        int v = nums[lo];
        while (lt<=gt) {
            while (nums[++lt] < v) {
                if (lt >= hi) {
                    break;
                }
            }
            while (nums[--gt] > v) {
            }
            if (lt>=gt){
                break;
            }
            swap(nums, lt, gt);
        }
        swap(nums,lo,gt);
        return gt;
    }
    private void shuffle(int[] a){
        Random ran = new Random();
        int r;
        for (int i = 0; i<a.length;i++){
            r = ran.nextInt(i+1);
            swap(a,r,i);
        }
    }
    private void swap(int[] a, int i, int j){
        int b = a[i];
        a[i] = a[j];
        a[j] = b;
    }
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i<nums.length;i++){
            sub(nums,i);
        }
        lists.add(new ArrayList<>());
        return lists;
    }
    private void sub(int[] nums,int i){
        int v = nums[i];
        if (lists.size()==0){
            List<Integer> list = new ArrayList<>();
            list.add(v);
            lists.add(list);
            return;
        }
        List<List<Integer>> second = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(v);
        second.add(list0);
        for (int k = 0; k<lists.size();k++){
            List<Integer> list = new ArrayList<>(lists.get(k));
            list.add(v);
            second.add(list);
        }
        lists.addAll(second);
    }
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        if (n>0) {
            res[1] = 1;
            for (int i = 2; i<n+1;i++){
                for (int j = 0;j<i;j++){
                    res[i] += (res[j]==0?1:res[j])*(res[i-j-1]==0?1:res[i-j-1]);
                }
            }

        }
        return res[n];
    }
    public int arrayNesting(int[] nums) {
        Set<Integer> set ;
        int max = 0;
        int left = nums.length;
        for (int i = 0; i<nums.length;i++){
            set = new HashSet();
            int t = i;
            if (nums[t]!=-1) {
                while (t!=-1&&nums[t]!=-1&&set.add(nums[t])) {
                    int x = nums[t];
                    nums[t] = -1;
                    t = x;
                }
                    max = Math.max(set.size(), max);
                    if (max > nums.length / 2) {
                        break;
                    }
                    left -= set.size();
                    //  System.out.println(left + " www" + set.size());
                    if (left <= max) {
                        //  System.out.println(left + " " + max);
                        break;
                    }
            }
        }
        return max;
    }
    public ListNode detectCycle(ListNode head) {
       ListNode i = head;
       ListNode j = head;
       while (j!=null&&j.next!=null){
           i = i.next;
           j = j.next.next;
           if (i==j){
               ListNode t = head;
               while (t!=j){
                   t = t.next;
                   j = j.next;
               }
               return t;
           }
       }
       return null;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n){
            return head;
        }
        ListNode pass;
        ListNode s = new ListNode(0);
        s.next = head;
        pass = s;
        int cnt = 1;
        while (cnt<m-1){
            pass = pass.next;
            cnt++;
        }
        ListNode head1 = pass;
        ListNode tail  = pass.next;
        ListNode h = head1;
        ListNode t = tail;

        ListNode x ;
        ListNode ii;
        ListNode beforeX = t;
        while (cnt<=n-1) {
            x = t.next;
            ii = x.next;
            h.next = x;
            x.next = beforeX;
            beforeX = x;
            t.next=ii;
            cnt++;
        }
        return s.next;
    }
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        return ser(nums,target,0,nums.length-1);
    }
    private int ser(int[] nums,int target, int lo, int hi){
        if (lo>hi){
            return -1;
        }
        int mid = lo+(hi-lo)/2;
        if (target==nums[mid]){
            return mid;
        }else if (target>nums[mid]){
           if (nums[mid]<=nums[hi]){
               if (target>nums[hi]){
                   return ser(nums, target, lo, mid-1);
               }
           }
            return ser(nums,target,mid+1,hi);
        }else {
            if (nums[lo]<=nums[mid]){
                if (target<nums[lo]){
                    return ser(nums,target,mid+1,hi);
                }
            }
            return ser(nums, target, lo, mid-1);
        }
    }
    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        if (nums.length==0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        int[] copy = new int[nums.length];
        for (int i = 0; i<nums.length;i++){
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        for (int i = 0; i<copy.length;i++){
            int now = nums.length-i;
            if (now==1){
                res[map.get(copy[i])] = "Gold Medal";
            }else if (now==2){
                res[map.get(copy[i])] = "Silver Medal";
            }else if (now==3){
                res[map.get(copy[i])] = "Bronze Medal";
            }else {
                res[map.get(copy[i])] = "" + now;
            }
        }
        return res;
    }
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int cnt = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i<n;i++){
            for (int j = 0; j<m;j++){
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid,int i, int j){
        if (i<0||j<0||i>=n||j>=m||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        add(list,"",0,0,n);
        return list;
    }
    private void add(List list, String str,int open, int close, int n){
        if (str.length() == n*2){
            list.add(str);
            return;
        }
        if (open<n){
            add(list,str+"(",open+1,close,n);
        }
        if (close<open){
            add(list,str+")",open,close+1,n);
        }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode a = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (a!=null){
            map.put(a,new RandomListNode(a.label));
            a=a.next;
        }
        a = head;
        while (a!=null){
            map.get(a).next = map.get(a.next);
            map.get(a).random = map.get(a.random);
            a = a.next;
        }
        return map.get(0);
    }
    private String s = "";
    public String tree2str(TreeNode t) {
        T(t);
        return s;
    }
    private void T(TreeNode t){
        if (t == null){
            return;
        }
        s+=t.val;
        if (t.left==null&&t.right==null){
            return;
        }else if (t.left == null){
            s+="()"+"(";
            T(t.right);
            s+=")";
        }else if (t.right==null){
            s+="(";
            T(t.left);
            s+=")";
        }else {
            s+="(";
            T(t.left);
            s+=")";
            s+="(";
            T(t.right);
            s+=")";
        }
    }
    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size()!=0){
            int cnt = 0;
            double sum = 0.0;
            cnt = nodes.size();
            for (int i = 0; i<cnt;i++) {
                TreeNode x = nodes.get(0);
                nodes.remove(x);
                sum += x.val;
                if (x.left != null) {
                    nodes.add(x.left);
                }
                if (x.right != null) {
                    nodes.add(x.right);
                }
            }
            list.add(sum/cnt);
        }
        return list;
    }
       /*Map<Integer, Integer> cnt ;
        Map<Integer, Double> sum ;
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> list = new ArrayList<>();
            cnt = new HashMap<>();
            sum = new HashMap<>();
            TT(root,0);
            for (int i = 0; i<=sum.size();i++){
               list.add(sum.get(i)/cnt.get(i));
            }
            return list;
        }
        private void TT(TreeNode x, int level){
            if (x == null){
                return;
            }
            double sum1 = sum.getOrDefault(level,0.0);
            sum.put(level,sum1+x.val);
            int cnt1 = cnt.getOrDefault(level,0);
           cnt.put(level,cnt1+1);
            TT(x.left,level+1);
            TT(x.right,level+1);
        }*/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists  = new ArrayList<>();
        if (root==null){
            return lists;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size()!=0){
            System.out.println("11");
            List<Integer>  list = new ArrayList<>();
            int n = nodes.size();
            for (int i = 0; i<n;i++) {
                TreeNode x = nodes.get(0);
                nodes.remove(x);
                list.add(x.val);
                if (x.left!=null){
                    nodes.add(x.left);
                }
                if (x.right!=null){
                    nodes.add(x.right);
                }
            }
            lists.add(list);
        }
        System.out.println("ww");
        for (int i = 0; i<lists.size()/2;i++){
            System.out.println("22");
            List<Integer> tmp = lists.get(i);
            List<Integer> tmp1 = lists.get(lists.size()-1-i);
            lists.remove(0);
            lists.add(i,tmp1);
            lists.remove(lists.size()-1-i);
            lists.add(lists.size()-1-i,tmp);
        }
        return lists;
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size()!=0){
            TreeNode x = nodes.get(nodes.size()-1);
            if (x.left!=null&&x.left.val!= Integer.MAX_VALUE){
                nodes.add(x.left);
            }else {
                list.add(x.val);
                if (x.right!=null){
                    nodes.add(x.right);
                }
                nodes.remove(x);
                x.val = Integer.MAX_VALUE;
            }
        }
        return list;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode scopy = s;
        int n = 0;
        while (s.next!=null){
            s= s.next;
            n++;
        }
        int cnt = n/k;
        int j = 1;
        s = scopy;
        ListNode x= head;
        ListNode t;
        for (int i = 0;i<cnt;i++){
            j = 1;
            while (j<k){
                t = x.next;
                x.next = t.next;
                t.next = s.next;
                s.next = t;
                j++;
            }
            s = x;
            x = s.next;
        }
        return scopy.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode scopy = s;
        ListNode before = s;
        if (head==null){
            return head;
        }
        boolean hasDu = false;
        int num = 0;
        s = s.next;
        while (s!=null&&s.next!=null){
            if (s.next.val==s.val){
                before.next = s.next.next;
                hasDu = true;
                num = s.val;
                s = s.next.next;
            }else {
                if (hasDu==false){
                    before = s;
                    s = s.next;
                }else {
                    if (s.val==num){
                        before.next = s.next;
                        s = s.next;
                    }else {
                        before = s;
                        s=s.next;
                        hasDu=false;
                    }
                }
            }
        }
        if (s!=null&&hasDu==true&&s.val==num){
            before.next = null;
        }
        return scopy.next;
    }
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null){
            return;
        }
        int n = 0;
        ListNode s = head;
        while (s!=null){
            s=s.next;
            n++;
        }
        s= head;
        int pass = n/2;
        for (int i = 0; i<pass;i++){
            s = s.next;
        }
        ListNode x = s.next;
        ListNode t ;
        while (x.next!=null) {
            t = x.next;
            x.next = t.next;
            t.next = s.next;
            s.next = t;
        }
        s = head;
        t = head;
        x = head;
        for (int i = 0; i<pass;i++){
            t = t.next;
        }
        while (s!=null||x!=t) {
            x = t.next;
            t.next = x.next;
            x.next = s.next;
            s.next = x;
            s=x.next;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode s = head;
        while (s!=null){
            s = s.next;
            n++;
        }
        s=head;
        TreeNode res = mid(s,0,n-1);
        return res;
    }
    private TreeNode mid(ListNode x, int lo,int hi){
        if (lo>hi||x==null){
            return null;
        }
        if (lo==hi){
            return new TreeNode(x.val);
        }
        ListNode s = x;
        int n = 0;
        int mid =lo+ (hi-lo)/2;
        while (n<mid){
            s=s.next;
            n++;
        }
        TreeNode root = new TreeNode(s.val);
        root.left = mid(x,lo,mid-1);
        root.right= mid(s.next,mid+1,hi);
        return root;
    }
    public ListNode partition1(ListNode head, int x) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            ListNode t = head;
            while (t!=null){
                if (t.val<x){
                    a.add(t.val);
                }else {
                    b.add(t.val);
                }
                t=t.next;
            }
            ListNode res = new ListNode(0);
            ListNode A = res;
            for (int i = 0; i<a.size();i++){
                res.next = new ListNode(a.get(i));
                res = res.next;
            }
            for (int i = 0; i<b.size();i++){
                res.next = new ListNode(b.get(i));
                res = res.next;
            }
            return A.next;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode i=s;
        ListNode t = s;
        ListNode before = t;
        t = t.next;
        while (t!=null&&t.val<x){
            before = t;
            i = t;
            t = t.next;
        }
        while (t!=null){
            while (t!=null&&t.val>=x){
                before = t;
                t = t.next;
            }
            if (t==null){
                break;
            }
            before.next = t.next;
            t.next = i.next;
            i.next  = t;
            i = t;
            t = before.next;
        }
        return s.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2  = new ArrayList<>();
        while (a!=null){
            list1.add(a.val);
            a = a.next;
        }
        while (b!=null){
            list2.add(b.val);
            b = b.next;
        }
        int n = list1.size();
        int m = list2.size();
        if (n<m){
            List list3 = list2;
            list2 = list1;
            list1 = list3;
        }
            for (int t = 0; t<m;t++){
                list1.set(n-1-t,list1.get(n-1-t)+list2.get(m-1-t));
            }
            boolean isbreak = false;
            for (int t = 0;t<n;t++){
                int now = list1.get(n-1-t);
                if (now>=10){
                    list1.set(n-1-t,now%10);
                    if (n-1-t==0){
                        isbreak = true;
                        break;
                    }
                    list1.set(n-1-t-1,list1.get(n-1-t-1)+1);
                }
            }
        ListNode s = new ListNode(1);
        for (int t = 0; t<n;t++){
            s.next = new ListNode(list1.get(t));
        }
        return isbreak?s:s.next;

        /*while (a!=null){
            i++;
            a = a.next;
        }
        while (b!=null){
            j++;
            b = b.next;
        }
        a = l1;
        b = l2;
        ListNode mid = s;
        List<Integer> list = new ArrayList<>();
        if (i>j) {
            s.next = a;
            while (i > j) {
                mid = a;
                a = a.next;
                i--;
            }

        }else if (i<j){
            s.next = b;
            while (i < j) {
                mid = b;
                b = b.next;
                j--;
            }
        }
        for (int t = 0; t<i;t++){
            list.add(a.val+b.val);
            a = a.next;
            b = b.next;
        }
        int n = list.size();
        boolean isbreak = false;
        for (int t = 0;t<n;t++){
            int now = list.get(n-1-t);
            if (now>=10){
                list.set(n-1-t,now%10);
            }
            if (n-1-t==0){
                isbreak = true;
                break;
            }
            list.set(n-1-t-1,list.get(n-1-t-1)+1);
        }
        boolean add1 = false;
        if (isbreak){
            if (mid==s){
                add1 = true;
            }else {
                mid.val+=1;
            }
        }
        for (int t = 0; t<n;t++){
            mid.next = new ListNode(list.get(t));
            mid = mid.next;
        }
        return */
    }
    public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondmax= Integer.MIN_VALUE;
        int thirdmax= Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int secondlowest=Integer.MAX_VALUE;
        for (int i = 0; i<nums.length;i++){
            if (nums[i]>max){
                thirdmax = secondmax;
                secondmax = max;
                max = nums[i];
            }else if (nums[i]>secondmax){
                thirdmax = secondmax;
                secondmax = nums[i];
            }else if(nums[i]>thirdmax){
                thirdmax = nums[i];
            }
            if (nums[i]<lowest){
                secondlowest = lowest;
                lowest = nums[i];
            }else if (nums[i]<secondlowest){
                secondlowest = nums[i];
            }
        }
        int p1 = max*secondmax*thirdmax;
        int p2 = lowest*secondlowest*max;
        return p1>p2?p1:p2;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnts = new int[26];
        for (int i = 0; i<magazine.length();i++){
            char now = magazine.charAt(i);
            cnts[now-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++){
            char now = ransomNote.charAt(i);
            cnts[now-'a']--;
            if (cnts[now-'a']<0){
                return false;
            }
        }
        return true;
    }
    public String reverseVowels(String s) {
        int j = s.length()-1;
        StringBuffer a = new StringBuffer(s);
        for (int i = 0; i<s.length()&&i<j;i++){
            if (isVowel(s.charAt(i))&&isVowel(s.charAt(j))){
                System.out.println("sss"+s.charAt(i));
                System.out.println("sss"+s.charAt(j));
                a.setCharAt(i,s.charAt(j));
                a.setCharAt(j,s.charAt(i));
                j--;
            }else if (!isVowel(s.charAt(j))){
                j--;
                i--;
            }
        }
        return a.toString();
    }
    private boolean isVowel(char a){
        if (a=='a'||a=='e'||a=='i'||a=='o'||a=='u'||a=='A'||a=='E'||a=='I'||a=='O'||a=='U'){
            return true;
        }
        return false;
    }
    public int longestPalindrome(String s) {
        boolean hasOne = false;
        int[] cnts = new int[52];
        for (int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if (now>='a'&&now<='z'){
                cnts[now-'a']++;
            }else{
                cnts[now-'A'+26]++;
            }
        }
        int num = 0;
        for (int i = 0; i<52; i++){
            num+=cnts[i];
            if (num==s.length()){
                break;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 52; i++){
            if (cnts[i]%2==0){
                cnt+=cnts[i];
            }else {
                if (!hasOne){
                    hasOne=true;
                    cnt+=cnts[i];
                }else {
                    cnt+=cnts[i]-1;
                }
            }
        }
        return cnt;
    }
    public String convertToBase7(int num) {
        if (num==0){
            return "0";
        }
        StringBuffer s = new StringBuffer();
        int tmp = num;
        if (num<0) {
            tmp = -tmp;
        }
        while (tmp!=0){
            String i = tmp%7+"";
            s.insert(0,i.charAt(0));
            tmp = tmp/7;
        }
        if (num<0){
            s.insert(0,'-');
        }
        return s.toString();
    }
    public int leastInterval(char[] tasks, int n) {
        int[] cnts = new int[26];
        for (int i = 0; i<tasks.length;i++){
            cnts[tasks[i]-'A']++;
        }
        Arrays.sort(cnts);
        int x = 0;
        for (int i=25;i>=0;i--){
            if (cnts[i]==cnts[25]){
                x++;
            }
            if (cnts[i]!=cnts[25]){
                break;
            }
        }
        return Math.max((cnts[25]-1)*n+cnts[25]+x-1,tasks.length);
    }
    public boolean isPerfectSquare1(int num) {
        for (int i = 0; i<=num/2||i<=1;i++){
            if (i*i==num){
                return true;
            }
        }
        return false;
    }
    public boolean isPowerOfFour(int num) {
        return (num>0)&&((num&(num-1))==0)&&((num&0x55555555)!=0);
    }
    public double findMaxAverage(int[] nums, int k) {
        double max = 0.0;
        for (int i =0; i<k;i++){
            max += nums[i];
            System.out.println("ww"+max);
        }
        int s = 0;
        double before = max;
        for (int i = k; i<nums.length;i++){
            max= Math.max(max,before-nums[s]+nums[i]);

            before =before-nums[s++]+nums[i];
            System.out.println("ww"+max+"ww"+before);
        }
        return max/k;
    }
    public String toHex(int num) {
        if (num==0){
            return "0";
        }
        StringBuffer s = new StringBuffer();
        int tmp = num;
        char[] a = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if (tmp<0){
            tmp = -tmp;
        }
        boolean last = true;
        boolean hasOne = false;
        while (tmp!=0){
            int now = tmp%16;
            if (num<0){
                if (last==true){
                    s.insert(0,a[(15-now+1)%16]);
                    if (15-now+1>15){
                        hasOne=true;
                    }
                    last= false;
                }else {
                    if (hasOne) {
                        s.insert(0, a[(15 - now+1)%16]);
                        if (15-now+1>15){
                            hasOne=true;
                        }else {
                            hasOne=false;
                        }
                    }else {
                        s.insert(0, a[(15 - now)]);
                    }
                }
            }else {
                s.insert(0, a[now]);
            }
            tmp = tmp/16;
        }
        if (num<0){
            if (hasOne){
            }else {
                int bu = 8-s.length();
                for (int i = 0; i<bu;i++){
                    s.insert(0,'f');
                }
            }
        }
        return s.toString();
    }
    public String reverseStr(String s, int k) {
        if (s.length() == 0||s.length()==1){
            return s;
        }
        int t = 0;
        StringBuffer scopy = new StringBuffer(s);
        for (int i = 0; i<s.length();i=i+2*k){
            t = i+k-1>s.length()-1?s.length()-1:i+k-1;
            for (int j = i; j<t;j++){
                scopy.setCharAt(j,s.charAt(t));
                System.out.println(scopy);
                scopy.setCharAt(t--,s.charAt(j));
                System.out.println(scopy);
            }
        }
        return scopy.toString();
    }
    public boolean judgeSquareSum(int c) {
        if (c<0){
            return false;
        }
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left<=right){
            int d = left*left+right*right;
            if (d==c){
                return true;
            }else if (d<c){
                left++;
            }else {
                right --;
            }
        }
        return false;
    }
  /* public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i<s.length();i++){
            int now = map1.getOrDefault(s.charAt(i),0);
            map1.put(s.charAt(i),now++);
        }
        for (int i = 0; i<t.length();i++){
            int now = map2.getOrDefault(t.charAt(i),0);
            map2.put(t.charAt(i),now++);
        }
        List<Integer> a = Collections.asList(map1.values());
        Collections.as
        List2
        return true;
    }
    */
  public boolean isAnagram(String s, String t) {
      Map<Character, Integer> map1 = new HashMap<>();
      Map<Character, Integer> map2 = new HashMap<>();
      for (int i = 0; i<s.length();i++){
          map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
      }
      for (int i = 0; i<t.length();i++){
          map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
      }
      if (map1.size()!=map2.size()){
          return false;
      }
      for (Character a: map1.keySet()){
          //int i =
          if (!map1.get(a).equals(map2.getOrDefault(a,-1))){
              System.out.println("1:"+a);
              System.out.println("2:"+map1.get(a));
              System.out.println("3:"+(map2.getOrDefault(a,-1)));
              return false;
          }
      }
      return true;
  }
  public int triangleNumber(int[] nums) {
      Arrays.sort(nums);
        int cnt = 0;
        int n = nums.length-1;
        for (int i = n;i>=2;i--){
            int l = 0;
            int r = i-1;
            while (l<r) {
                if (nums[l] + nums[r] > nums[i]) {
                    cnt += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return cnt;
  }
   /* public int[][] generateMatrix(int n) {
        for (int i = 0; i<n;i++){

        }
        return
    }
    */
   public List<String> readBinaryWatch(int num) {
       List<String> times = new ArrayList<>();
       for (int h=0; h<12; h++)
           for (int m=0; m<60; m++)
               if (Integer.bitCount(h * 64 + m) == num)
                   times.add(String.format("%d:%02d", h, m));//m 格式化为至少两位的十进制数
       return times;
   }
    public int numberOfBoomerangs(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               if (o1[0]>o2[0]){
                   return 1;
               }else if (o1[0]<o2[0]){
                   return -1;
               }else {
                   return 0;
               }
            }
        });
        int num = 0;
        for (int i = points.length-1;i >=2;i--){
            for (int ii = i-1; ii>=1;ii--) {

                int z = points[i][0];
                int y = points[ii][0];
                int k = erfen(points, (2*y-z), 0,  ii-1);
                if (points[k][0] ==2*y-z) {
                   // System.out.println("K:"+k+"v:"+v+"j:"+j);
                    num += 2;
                }
            }
        }
        return num;
    }
    private int erfen(int[][] points, int num, int lo, int hi){
       if (lo>=hi){
           return lo;
       }
       while (lo<hi){
           int mid = (lo+hi)/2;
            if (points[mid][0]==num){
                return mid;
            }else if (points[mid][0]>num){
                hi = mid-1;
            }else {
                lo = mid+1;
            }
       }
       return lo;
    }
    public int[] findErrorNums(int[] nums) {//两个方法，可看提交记录
        int[] res = new int[2];
       for (int i:nums){
           if (nums[Math.abs(i)-1]<0){
               res[0] = Math.abs(i);
           }else {
               nums[Math.abs(i)-1] *= -1;
           }
       }
       for (int i = 0; i < nums.length; i++){
           if (nums[i]>0){
               res[1] = i+1;
           }
       }
       return res;
    }
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
    public int firstMissingPositive(int[] nums) {
        if (nums.length==1){
            if (nums[0]==1){
                return 2;
            }else {
                return 1;
            }
        }
        int max = 0;
        boolean revise = false;
        for (int i = 0; i<nums.length;i++){
            if (nums[i]>max){
                if (nums[i]>nums.length){

                }else {
                    max = nums[i];
                }
            }
        }
        int copy = -1;
        for (int i :nums){
            if (i>0&&i!=Integer.MAX_VALUE&&i<nums.length){
                copy = nums[i];
                nums[i] = Integer.MAX_VALUE;
                revise = true;
                i = copy;
                while (i > 0 && i != Integer.MAX_VALUE && i < nums.length) {
                    copy = nums[i];
                    nums[i] = Integer.MAX_VALUE;
                    i = copy;
                }
            }else {
                continue;
            }
        }
        if (revise==false){
            return 1;
        }
        for (int i = 0; i<nums.length;i++){
            if (i==0||nums[i]==Integer.MAX_VALUE){
                continue;
            }else {
                return i;
            }
        }
        if (max==0) {
            return 1;
        }else {
            return max+1;
        }
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n%2==1){
            if (n/2-1<0){
                return false;
            }
            String c =null;
            char char1 = s.charAt(n/2);
            c = s.substring(0, n / 2 );
            String d = s.substring(n / 2 + 1, n );
            if (!c.equals(d)){
                return false;
            }
            n = n/2;
            while (n!=0) {
                if (n/2-1<0){
                    if (s.charAt(n-1)!=char1){
                        return false;
                    }else {
                        return true;
                    }
                }
                c = s.substring(0, n / 2 );
                d = s.substring(n / 2, n );
                if (!c.equals(d)) {
                    return false;
                }
                n = n/2;
            }
        }else {
            String a = s.substring(0, n/2);
            String b = s.substring(n/2,n);
            System.out.println(a+"---"+b);
            if (!a.equals(b)){
                return false;
            }
        }
        return true;
    }
    public boolean canCross1(int[] stones) {
        if (stones.length==0||stones.length==1||(stones.length==2&&stones[1]==1)){
            return true;
        }
        int gap = 0;
        int gap1 = 0;
        int n = stones.length;
        Stack<Integer> numsIndex = new Stack<>();
        Stack<Integer> gaps = new Stack<>();
        List<Integer> cnts = new ArrayList<>();
        for (int i = 0; i<stones.length-1   ;i++) {
            gap = stones[n - 1] - stones[n - 2-i];
            numsIndex.push(n - 2-i);
            cnts.add(1);
            gaps.push(gap - 1);
            gaps.push(gap);
            gaps.push(gap + 1);
            int cnt = 0;
            int v = 0;
            int index = 0;
            //System.out.println("www");
            while (numsIndex.size() != 0) {
                index = numsIndex.peek();
                v = stones[index];
                //System.out.println("sss");
                while (cnt <= 3 && !gaps.isEmpty()) {
                    //System.out.println(cnt);
                    cnts.set(numsIndex.size() - 1, cnts.get(numsIndex.size() - 1) + 1);
                    cnt = cnts.get(numsIndex.size() - 1);
                    if (cnt > 4) {
                        break;
                    }
                    gap1 = gaps.pop();
                    int find = findnum(0, index - 1, v - gap1, stones);
                    if (find != -1 && stones[find] == v - gap1) {
                        if (find == 0) {
                            if (gap1 == 1) {
                                return true;
                            } else {
                                continue;
                            }
                        }
                        numsIndex.push(find);
                        cnts.add(1);
                        cnt = 1;
                        gaps.push(gap1 - 1);
                        gaps.push(gap1);
                        gaps.push(gap1 + 1);
                        break;
                    } else {
                        continue;
                    }

                }
                if (cnt >= 4) {
                    numsIndex.pop();
                    cnts.remove(cnts.size() - 1);
                    if (cnts.size()==0){
                        continue;
                    }else {
                        cnt = cnts.get(cnts.size() - 1);
                    }
                }
            }
        }
        return false;
    }
    public boolean canCross(int[] stones) {
        if (stones.length==0||stones.length==1||(stones.length==2&&stones[1]==1)){
            return true;
        }
        if (stones[1]!=1){
            return false;
        }
        int gap = 0;
        int n = stones.length;
        Stack<Integer> numsIndex = new Stack<>();
        Stack<Integer> gaps = new Stack<>();
        List<Integer> cnts = new ArrayList<>();
        int cnt = 0;
        int v = 0;
        int index = 0;
        gap = 1;
        numsIndex.push(1);
        cnts.add(1);
        gaps.push(gap - 1);
        gaps.push(gap);
        gaps.push(gap + 1);
        while (numsIndex.size() != 0) {
            index = numsIndex.peek();
            v = stones[index];
            //System.out.println("sss");
            while (cnt <= 3 && !gaps.isEmpty()) {
                //System.out.println(cnt);
                cnts.set(numsIndex.size() - 1, cnts.get(numsIndex.size() - 1) + 1);
                cnt = cnts.get(numsIndex.size() - 1);
                if (cnt > 4) {
                    break;
                }
                gap = gaps.pop();
                int find = findnum(index+1, n-1, v + gap, stones);
                if (find != -1 && stones[find] == v + gap) {
                    if (find == stones.length-1) {
                        return true;
                    }
                    numsIndex.push(find);
                    cnts.add(1);
                    cnt = 1;
                    gaps.push(gap - 1);
                    gaps.push(gap);
                    gaps.push(gap + 1);
                    break;
                } else {
                    continue;
                }

            }
            if (cnt >= 4) {
                numsIndex.pop();
                cnts.remove(cnts.size() - 1);
                if (cnts.size()==0){
                    continue;
                }else {
                    cnt = cnts.get(cnts.size() - 1);
                }
            }
        }
        return false;
    }
    private  int findnum(int lo, int hi, int num, int[] stones){
        if (num<0){
            return -1;
        }
        if (lo>=hi){
            return lo;
        }
        int mid = (lo+hi)/2;
        if (stones[mid]==num){
            return mid;
        }else if (stones[mid]>num){
            return findnum(lo,mid-1,num,stones);
        }else {
            return findnum(mid+1,hi,num,stones);
        }
    }
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)!=' '&&(i==0||s.charAt(i-1)==' ')){
                res++;
            }
        }
        return res;
    }
    public class MyQueue {
        Stack<Integer> stack ;
        Stack<Integer> stack1 ;
        /** Initialize your data structure here. */
        public MyQueue() {
         stack = new Stack<>();
         stack1 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack1.isEmpty()){
                peek();
            }
            return stack1.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!stack1.isEmpty()){
                return stack1.peek();
            }
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
            return stack1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty()&&stack1.isEmpty();
        }
    }
    String sss;
    public String countAndSay(int n) {
        sss = "1";
        if (n==1){
            return sss;
        }
        for (int i = 1; i<n; i++){
           sss = count1(sss);
        }
        return sss;
    }
    private String count1(String tt){
        int cnt = 1;
        char now = ' ';
        String news = "";
        for (int i = 0; i<tt.length();i++){
            now = tt.charAt(i);
            if (i==tt.length()-1||now!=tt.charAt(i+1)){
                news+= cnt+""+now;
                cnt=1;
            }else {
                cnt++;
                continue;
            }
        }
        return news;
    }
    public boolean isIsomorphic(String s, String t) {
       int[] a = new int[256];
       int[] b = new int[256];
       for (int i = 0; i<s.length();i++){
           if (a[s.charAt(i)]!=b[t.charAt(i)]){
               return false;
           }
           a[s.charAt(i)]=b[t.charAt(i)]=i;
       }
       return true;
    }
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length==0||heaters.length==0){
            return 0;
        }
        int gap = 0;
        int f = 0;
        int[] finds = new int[heaters.length+1];
        finds[0] = 0;
        for (int i = 1; i<=heaters.length;i++){
            f = finddd(houses,finds[i-1],heaters.length,heaters[i-1]);
            finds[i] = f;
            if (i==heaters.length){
                if (f>=houses.length-1){
                    gap = Math.max(gap,(f-finds[i-1])/2+1);
                }
                if (houses[f]==heaters[i-1]){
                        int gap1 = houses.length-1-f;
                        gap = Math.max(gap,gap1);

                }else {

                        int gap1 = houses.length-1-f+1;
                        gap1 = Math.max(gap1,(f-finds[i-1])/2+1);
                        gap = Math.max(gap,gap1);

                }
            }
            gap = Math.max(gap,(f-finds[i-1])/2+1);
        }
        return gap;
    }
    private int finddd(int[] houses, int lo, int hi,int heater){
        if (lo>=hi){
            return lo;
        }
        int mid = (lo+hi)/2;
        if (houses[mid]==heater){
            return mid;
        }else if (houses[mid]<heater){
            return finddd(houses,mid+1,hi,heater);
        }else {
            return finddd(houses,lo, mid-1,heater);
        }
    }
    int cnt = 0;
    int value = 0;
    int level = 0;
    Stack<TreeNode> stack;
    public int findBottomLeftValue(TreeNode root) {
        stack = new Stack<>();
        ee(root);
        return value;
    }
    private void ee(TreeNode x){
        if (x==null){
            return;
        }
        cnt++;
        if (x.left==null){
            if (cnt>level){
                level = cnt;
                value = x.val;
            }
        }else {
            ee(x.left);
        }
        ee(x.right);
        cnt--;
    }
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int t = findsingle(nums,0,nums.length-1);
        return t;
    }
    private int findsingle(int[] nums, int lo, int hi){
        if (lo>=hi){
            return nums[lo];
        }
        int mid = (lo+hi)/2;
        System.out.println("mid:"+mid);
        if (nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]){
            return nums[mid];
        }
        if (((mid+1)%2==1&&nums[mid]==nums[mid-1])){
            return findsingle(nums,lo,mid-2);
        }else if ((mid+1)%2==1&&nums[mid]==nums[mid+1]){
            return findsingle(nums,mid+2,hi);
        }
        else if (((mid+1)%2==0)&&nums[mid]==nums[mid+1]){
            return findsingle(nums,lo,mid-1);
        }else {
            return findsingle(nums,mid+1,hi);
        }
    }
    public void sortColors(int[] nums) {
        int cn0= 0;
        int cn1 = 0;
        int cn2 = 0;
        for (int i = 0; i<nums.length;i++){
            if (nums[i]==0){
                cn0++;
            }else if (nums[i]==1){
                cn1++;
            }
        }
        for (int i = 0; i<cn0;i++){
            nums[i]=0;
        }
        for (int i = cn0; i<cn0+cn1; i++){
            nums[i] = 1;
        }
        for (int i = cn0+cn1;i<nums.length;i++){
            nums[i] = 2;
        }
    }
    public int findPeakElement(int[] nums) {
        if (nums.length==0||nums.length == 1){
            return 0;
        }
        if (nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        for (int i = 0; i<nums.length-1;i++){
            if (nums[i]>nums[i+1]){
                return i;
            }
        }
        return 0;
    }
    public void rotate(int[][] matrix) {
        if (matrix.length==0||matrix.length==1){
            return;
        }
        int now = 0;
        for (int j = 0; j<matrix.length;j++){
            for (int k = j; k<(matrix.length-j-1);k++){
                int t =matrix[j][k];
                matrix[j][k]= matrix[matrix.length-1-k][j];
                matrix[matrix.length-1-k][j] = matrix[matrix.length-1-j][matrix.length-1-k];
                matrix[matrix.length-1-j][matrix.length-1-k] = matrix[k][matrix.length-1-j];
                matrix[k][matrix.length-1-j] = t;
                now+=4;
                if (now ==matrix.length*matrix.length){
                    //System.out.println("ww");
                    return;
                }
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i<n;i++){
            for (int j = 0; j<m; j++){
                if (matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        if (rows.size()>columns.size()){
            for (Integer i : rows){
                for (int j = 0; j<m; j++){
                    matrix[i][j] = 0;
                }
            }
            for (int i = 0; i<n; i++){
                if (!rows.contains(i)){
                    for (Integer j:columns){
                        matrix[i][j] = 0;
                    }
                }
            }
        }else {
            for (Integer i : columns){
                for (int j = 0; j<n; j++){
                    matrix[j][i] = 0;
                }
            }
            for (int i = 0; i<m; i++){
                if (!columns.contains(i)){
                    for (Integer j:rows){
                        matrix[j][i] = 0;
                    }
                }
            }
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        int min;
        for (int i = 0; i<triangle.size();i++){
            min = Integer.MAX_VALUE;
            for (int j = 0; j<triangle.get(i).size();j++){
                min = Math.min(min,triangle.get(i).get(j));
            }
            sum+=min;
        }
        return sum;
    }
    public int removeDuplicates(int[] nums) {
            if (nums.length==0){
                return 0;
            }
            int cnt = 0;
            int i = 0;
            boolean imoved = false;
            int v =nums[0];
            for (int j = 1; j<nums.length;j++){
                if (nums[j] == v){
                    cnt++;
                    if (cnt>1){
                        if (imoved == false){
                            i = j;
                            imoved = true;
                        }
                    }else if (imoved&&i<j){
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                        i++;
                    }
                }else {
                    v = nums[j];
                    cnt=0;
                    if (imoved&&i<j){
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                        i++;
                    }
                }
            }


            return imoved?i:nums.length;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root =null;
        return maxBuilder(root,0,nums.length-1,nums);
    }
    private TreeNode maxBuilder(TreeNode x, int lo, int hi, int[] nums){
        if (lo>hi){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = lo;
        for (int i = lo; i<=hi; i++){
           if (max>=nums[i]){
               continue;
           }else {
               max = nums[i];
               index = i;
           }
        }
        x = new TreeNode(max);
        x.left = maxBuilder(x.left,lo,index-1,nums);
        x.right = maxBuilder(x.right,index+1,hi,nums);
        return x;
    }
    boolean isValidBST = true;
    int lt;
    int gt;
    int rt;
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return isValidBST;
        }
        lt = root.val;
        gt = root.val;
        rt = root.val;
        TreeNode x = root;
        while (root.left!=null){
            root = root.left;
            lt = root.val;
        }
        root= x;
        while (root.right!=null){
            root = root.right;
            gt = root.val;
        }
        check(x.left,lt,x.val);
        check(x.right,x.val,gt);
        return isValidBST;
    }
    private void check(TreeNode x, int lo, int hi){
        if (x == null){
            return;
        }
        if (lo==hi){
            isValidBST = false;
            return;
        }
        if (x.val>lo&&x.val<hi){
            check(x.left,lo,x.val);
            check(x.right,x.val,hi);
        }else {
            if ((x.val==gt&&x.val>lo&&gt==hi&&x.val!=rt)){
                if (x.right==null){
                    System.out.println("ee"+lt+" "+ gt+" "+lo+" "+hi);
                    check(x.left,lo,x.val);
                    return;
                }
            }
            if ((x.val==lt&&lt==lo&&x.val<hi&&x.val!=rt)){
                if (x.left==null){
                    check(x.right,x.val,hi);
                    System.out.println("ww"+lt+" "+ gt+" "+lo+" "+hi);
                    return;
                }
            }
            System.out.println("qq");
            isValidBST= false;
            return;
        }
    }
    List<List<Integer>> listsTreeOrder;
    public List<List<Integer>> levelOrder(TreeNode root) {
        listsTreeOrder = new ArrayList<>();
        help(root,1);
        return listsTreeOrder;
    }
    private void help(TreeNode x, int level){
        if (x==null){
            return;
        }
        if (level>listsTreeOrder.size()){
            listsTreeOrder.add(new ArrayList<>());
        }
        listsTreeOrder.get(level-1).add(x.val);
        help(x.left,level+1);
        help(x.right,level+1);
    }
    List<List<Integer>> listsTreeOrder1;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        listsTreeOrder1 = new ArrayList<>();
        help1(root,1);
        return listsTreeOrder1;
    }
    private void help1(TreeNode x, int level){
        if (x==null){
            return;
        }
        if (level>listsTreeOrder1.size()){
            listsTreeOrder1.add(new ArrayList<>());
        }
        if ((level-1)%2==0) {
            listsTreeOrder1.get(level - 1).add(x.val);
        }else {
            listsTreeOrder1.get(level - 1).add(0,x.val);
        }
        help1(x.left,level+1);
        help1(x.right,level+1);
    }
    public void flatten(TreeNode root) {
        root = flat(root);
    }
    private TreeNode flat(TreeNode x){
        if (x==null){
            return null;
        }
        if (x.left==null){
            x.right = flat(x.right);
        }else if (x.right==null){
            x.right = flat(x.left);
            x.left = null;
        }else {
            TreeNode l = flat(x.left);
            x.left=null;
            TreeNode lc = l;
            while (l.right!=null){
                l = l.right;
            }
            l.right = flat(x.right);
            x.right = lc;
        }
        return x;
    }
    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
    Stack<TreeLinkNode> sta ;
    public void connect(TreeLinkNode root) {
        sta = new Stack<>();
        sta.push(root);
        while (!sta.isEmpty()){
            TreeLinkNode xx = sta.pop();
            c(xx);
        }
        c(root);
    }
    private void c(TreeLinkNode x){
        if (x==null||(x.left==null&&x.right==null)){
            return;
        }
        if (x.left!=null&&x.right!=null){
            x.left.next = x.right;
            x.right.next = cc(x.next);
        }else if (x.left==null){
            x.right.next = cc(x.next);
        }else {
            x.left.next = cc(x.next);
        }
        sta.push(x.left);
        sta.push(x.right);
    }
    private TreeLinkNode cc(TreeLinkNode x){
        while (true){
            if (x==null){
                return null;
            }
            if (x.left==null&&x.right==null){
                x = x.next;
            }else if (x.left==null){
                return x.right;
            }else {
                return x.left;
            }
        }
    }
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int cnt = 0;
        int level = 0;
        TreeNode rootcopy = root;
        while (root.left!=null){
            root=root.left;
            cnt+=Math.pow(2,level);
            level++;
        }
        root= rootcopy;
        int hi =(int)Math.pow(2,level);
        cnt+=count(root,level,0,1,hi);
        return cnt;
    }
    private int count(TreeNode x,int level,int n,int lo, int hi){
        if (lo>=hi){
            return lo;
        }
        if (x==null){
            return 0;
        }

        TreeNode xCopy = x;
        if (x.right==null&&n!=level){
            return count(x.left,level-1,n,lo,(int)(Math.pow(2,level)/2)+lo-1);
        }
        xCopy = xCopy.right;
        n++;
        while (xCopy.left!=null){
            xCopy = xCopy.left;
            n++;
        }
        if (n!=level){
            return count(x.left,level-1,0,lo,lo+(int)(Math.pow(2,level)/2)-1);
        }
        return count(x.right,level-1,0,lo+(int)(Math.pow(2,level)/2),hi);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findMax(root,list,1);
        return list;
    }
    private void findMax(TreeNode x, List<Integer> list, int level){
        if (x==null){
            return;
        }
        if (list.size()<level){
            list.add(x.val);
        }else {
            list.set(level,Math.max(list.get(level),x.val));
        }
        findMax(x.left,list,level+1);
        findMax(x.right,list,level+1);
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d==1){
            TreeNode t = new TreeNode(v);
            t.left = root;
            return t;
        }
        root = add1(root,v,d,1);
        return root;
    }
    private TreeNode add1(TreeNode x, int v, int d, int now){
        if (x==null){
            return null;
        }
        if (now == d-1){
            TreeNode t = new TreeNode(v);
            TreeNode tt = new TreeNode(v);
            t.left = x.left;
            tt.right = x.right;
            x.left = t;
            x.right=tt;
        }else {
            add1(x.left,v,d,now+1);
            add1(x.right,v,d,now+1);
        }
        return x;
    }
    Map<Integer,Map<TreeNode,Boolean>> mappp = new HashMap<>();
    List<TreeNode> listttt = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root==null){
            return listttt;
        }
        finddu(root);
        return listttt;
    }
    private void finddu(TreeNode x){
        if (x==null){
            return;
        }
        if (mappp.containsKey(x.val)){
            boolean b = false;
            Map<TreeNode,Boolean> t = mappp.get(x.val);
            for (TreeNode i:t.keySet()){
                b = check(x,i);
                if (b){
                    if (t.get(i)){
                        break;
                    }
                    listttt.add(x);
                    t.put(i,true);
                    break;
                }
            }
            if (b==false) {
                mappp.get(x.val).put(x,false);
            }
        }else {
            Map<TreeNode,Boolean> l = new HashMap<>();
            l.put(x,false);
            mappp.put(x.val,l);
        }
        finddu(x.left);
        finddu(x.right);
    }
    private boolean check(TreeNode x,TreeNode already){
       if (x==null&&already==null){
           return true;
       }
       if (x==null||already==null){
           return false;
       }
       if (x.val!=already.val){
           return false;
       }else {
           return check(x.left,already.left)&&check(x.right,already.right);
       }
    }
    TreeNode min = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        root = dele(root,key);
        return root;
    }
    private TreeNode dele(TreeNode x, int key){
        if ( x==null){
            return null;
        }
        if (x.val==key){
            if (x.left==null){
                return x.right;
            }else if (x.right==null){
                return x.left;
            }else {
                TreeNode delmin = deleMin(x.right);
                min.left = x.left;
                min.right=delmin;
                x= min;
            }
        }else if (x.val>key){
            x.left = dele(x.left,key);
        }else {
            x.right =  dele(x.right,key);
        }
        return x;
    }
    private TreeNode deleMin(TreeNode x){
        if (x==null){
            return null;
        }
        if (x.left==null){
            min = x;
            return x.right;
        }
        x.left = deleMin(x.left);
        return x;
    }
    private TreeNode min(TreeNode x){
        if (x==null){
            return null;
        }
        while (x.left!=null){
            x = x.left;
        }
        return x;
    }
    private Map<Integer, Integer> mappppp;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        mappppp = new HashMap<>();
        int max = 0;
        for (Integer i:mappppp.keySet()){
            max = Math.max(mappppp.get(i),max);
        }
        for (Integer i:mappppp.keySet()){
            if (mappppp.get(i)==max){
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private int sumT(TreeNode x){
        if (x==null){
            return 0;
        }
        int sum = 0;
        sum+=x.val;
        sum+=sumT(x.left);
        sum+=sumT(x.right);
        mappppp.put(sum,mappppp.getOrDefault(sum,0)+1);
        return sum;
    }
    public int kthSmallest(TreeNode root, int k) {
       if (root==null){
           return 0;
       }
       int i = countl(root.left);
       if (k==i+1){
           return root.val;
       }else if (k>i+1){
           return kthSmallest(root.right,k-i-1);
       }else {
           return kthSmallest(root.left,k);
       }
    }
    private int countl(TreeNode x){
        if (x==null){
            return 0;
        }
        return countl(x.left)+countl(x.right)+1;
    }
    List<Integer> listtttt;
    public List<Integer> rightSideView(TreeNode root) {
        listtttt= new ArrayList<>();
        right(root,1);
        return listtttt;
    }
    private void right(TreeNode x, int level){
        if (x==null){
            return;
        }
        if (level>listtttt.size()){
            listtttt.add(x.val);
        }else {
            listtttt.set(level-1,x.val);
        }
        right(x.left,level+1);
        right(x.right,level+1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left==null?right:right==null?left:root;
    }
    TreeNode x = null;
    TreeNode y =null;
    public void recoverTree(TreeNode root) {
        if (root==null){
            return;
        }
        int min = 0;
        int max = 0;
        TreeNode a  = root;
        TreeNode b = root;
        while (a.left!=null){
            a = a.left;
        }
        min = a.val;
        while (b.right!=null){
            b = b.right;
        }
        max = b.val;
        if (max<min){
            a.val = max;
            b.val =min;
            return;
        }
        findwrong(root,a,b);
        System.out.println(x.val+"ss "+y.val);
        int i = x.val;
        x.val = y.val;
        y.val = i;
        System.out.println(x.val+"dd "+y.val);
    }
    private void findwrong(TreeNode t, TreeNode lo, TreeNode hi){
        if(t==null){
            return;
        }
        if (t.val<lo.val){
            if (x==null||x.val>t.val){
                x = t;
            }
            if (y == null||y.val<lo.val){
                y = lo;
            }
            findwrong(t.left,t,hi);
            findwrong(t.right,t,hi);
            return;
        }else if (t.val>hi.val){
            if (y == null||y.val<t.val){
                y = t;
            }
            if (x==null||x.val>hi.val){
                x = hi;
            }
            findwrong(t.left,lo,t);
            findwrong(t.right,lo,t);
            return;
        }
        findwrong(t.left,lo,t);
        findwrong(t.right,t,hi);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack  = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Map<TreeNode,Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode x = stack.peek();
            if (x==null){
                stack.pop();
                TreeNode t = stack.pop();
                list.add(t.val);
                continue;
            }
            map.put(x,map.getOrDefault(x,0)+1);
            if (map.get(x)==3){
                list.add(stack.pop().val);
                continue;
            }
            if (map.get(x)==1) {
                while (x.left != null) {
                    x = x.left;
                    stack.push(x);
                    map.put(x,map.getOrDefault(x,0)+1);
                }
                if (x.right==null){
                    list.add(stack.pop().val);
                }else {
                    stack.push(x.right);
                    map.put(x,map.getOrDefault(x,0)+1);
                }
            }else {
                stack.push(x.right);
            }
        }
        return list;
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Comparator<Map.Entry<Integer,Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(k,cmp);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry);
            if (pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()){
            list.add(0,pq.poll().getKey());
        }
        return list;
    }
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] index = new int[wall.size()];
        for (int i = 0; i<wall.size();i++){
            int t = index[i]++;
            if (map.get(wall.get(i).get(t))==null){
                List l = new ArrayList();
                l.add(i);
                map.put(wall.get(i).get(t),l);
                pq.add(wall.get(i).get(t));
            }else {
                List l = map.get(wall.get(i).get(t));
                l.add(i);
                map.put(wall.get(i).get(0),l);
            }
        }
        int min = Integer.MAX_VALUE;

        while (pq.size()!=1){
            int i = pq.poll();
            List<Integer> t = map.get(i);
            min = Math.min(min,wall.size()-t.size());
            map.remove(i);
            for (int j = 0;j<t.size();j++){
                int in = index[t.get(j)]++;
                int now = i+wall.get(t.get(j)).get(in);
                if (map.get(now)==null){
                    List l = new ArrayList();
                    l.add(t.get(j));
                    map.put(now,l);
                    pq.add(now);
                }else {
                    List l = map.get(now);
                    l.add(t.get(j));
                    map.put(now,l);
                }
            }
        }
        if (pq.size()==1&&index[0]<wall.get(0).size()){
            return 0;
        }
        if (min==Integer.MAX_VALUE){
            min = wall.size();
        }
        return min;
    }
    public int findMaxLength(int[] nums) {
      for (int i = 0; i<nums.length;i++) {
          if (nums[i] == 0) {
              nums[i] = -1;
          }
      }
      int max = 0;
      Map<Integer,Integer> map = new HashMap<>();
      int sum = 0;
      map.put(0,-1);
      for (int i = 0; i<nums.length;i++){
          sum+=nums[i];
          if (map.containsKey(sum)){
              max = Math.max(max,i-map.get(sum));
          }else {
              map.put(sum,i);
          }
      }
      return max;
    }
    public int findLongestChain(int[][] pairs) {
        if (pairs.length==0||pairs[0].length==0){
            return 0;
        }
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        };
        int res = 0;
        Arrays.sort(pairs,cmp);
        int[] before = pairs[0];
        res++;
        for (int i = 1; i<pairs.length;i++){
            if (pairs[i][0]==before[0]){
                continue;
            }
            if (pairs[i][1]<before[1]){
                before = pairs[i];
                continue;
            }
            if (pairs[i][0]>before[1]){
                before = pairs[i];
                res++;
            }
        }
        return res;
    }
    public int findMinArrowShots(int[][] points) {
        if (points.length==0||points[0].length==0){
            return 0;
        }
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               if (o1[0]==o2[0]){
                   return o1[1]-o2[1];
               }
               return o1[0]-o2[0];
            }
        };
        Arrays.sort(points,cmp);
        int res = 0;
        int[] before = points[0];
        res++;
        for (int i = 1; i<points.length;i++){
            if (points[i][0]==before[0]){
                if (points[i][1]==before[1]){
                    continue;
                }
            }
            if (points[i][0]>before[1]){
                before = points[i];
                res++;
            }else {
                if (points[i][1]<before[1]){
                    before = points[i];
                }else {
                    int[] t = new int[2];
                    t[0]= points[i][0];
                    t[1] = before[1];
                    before = t;
                }
            }
        }
        return res;
    }
    public int rob(TreeNode root) {
        int i = helperr(root,0,false);
        int j = helperr(root,0,true);
        return Math.max(i,j);
    }
    private int helperr(TreeNode x, int sum, boolean before){
        if (x==null){
            return 0;
        }
        return before==false?(x.val+ helperr(x.left,sum,!before)+ helperr(x.right,sum,!before)):(helperr(x.left,sum,!before)+ helperr(x.right,sum,!before));
    }
    public int bulbSwitch(int n) {
       return (int)Math.sqrt(n);
    }
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i<nums.length;i++){
            s[i] = nums[i]+"";
        }
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return b.compareTo(a);
            }
        };
        Arrays.sort(s,com);
        if (s[0].charAt(0)==0){
            return "0";
        }
        String res = String.join("",s);
        return res;
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i<equations.length;i++){
            if (!map.containsKey(equations[i][0])){
                map.put(equations[i][0],cnt++);
            }
            if (!map.containsKey(equations[i][1])){
                map.put(equations[i][1],cnt++);
            }
        }
        double[][] disTo = new double[cnt][cnt];
        Integer[][] pathTo= new Integer[cnt][cnt];
        double[] res =new double[queries.length];
        for (int i = 0; i<cnt;i++){
            for (int j = 0; j<cnt;j++){
                disTo[i][j] = -1;
                pathTo[i][j] = -1;
            }
        }
        return res;
    }
    boolean[] onStack ;
    boolean[] marked ;
    boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        myGraph g = new myGraph(numCourses,prerequisites);
        onStack = new boolean[numCourses];
        marked = new boolean[numCourses];
        for (int i = 0; i<numCourses;i++){
            if (!marked[i]){
                dd(g,i);
            }
        }
       return !hasCycle;
    }
    void dd(myGraph g, int v){
        marked[v] = true;
        onStack[v] = true;
        for (int i:g.adj(v)){
            if (onStack[i]){
                hasCycle = true;
                return;
            }
            if (!marked[i]) {
                dd(g, i);
            }
        }
        onStack[v] = false;
    }
    class myGraph{
        int E;
        int V;
        List<Integer>[] adj;
        myGraph(int num, int[][] pres){
            V = num;
            int E = pres.length;
            adj = new ArrayList[num];
            for (int i = 0; i<num;i++){
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i<pres.length;i++){
                int v = pres[i][1];
                int w = pres[i][0];
                addEdge(v,w);
            }
        }
        void addEdge(int i, int j){
            adj[i].add(j);
            E++;
        }
        int V(){
            return V;
        }
        int E(){
            return E;
        }
        List<Integer> adj(int v){
            return adj[v];
        }
    }
    public int newInteger(int n) {
        int ans = 0;
        int base = 1;

        while (n > 0){
            ans += n % 9 * base;
            n /= 9;
            base *= 10;
        }
        return ans;
    }
    public static void main(String [] args){
        Solution s = new Solution();
        int[] nums={3,39,34,5,9,18};
        int[] nums2  = {1,4};
        int[][] bb = {{7, 1, 1, 1}, {1, 4, 2, 3}, {7, 3}};
        List<Integer> l1 = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i<bb.length;i++){
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j<bb[i].length;j++){
                l.add(bb[i][j]);
            }
            ll.add(l);
        }
        System.out.println("ss"+s.newInteger(119));
        char[][] chrs1 = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        char[][] chrs = {{'1','0','1'},{'1','0','1'},{'1','1','1'}};
        System.out.println(s.leastBricks(ll));
       int num = -7;
       char[] aa = {'A','A','A','B','B','B'};
       int [][] points = {{0,0},{1,0},{2,0}};
       String ss = "ababab";
       //s.rotate(bb);
       /*for (int  i = 0; i<bb.length;i++){
           for (int j = 0; j<bb.length;j++){
           System.out.println(bb[i][j]);
       }
     //   System.out.println(nums);
        //s.reconstructQueue(bb);
        List<List<Integer>> lists = new ArrayList<>();

        String saa = "a   ";
        s.rotate(nums,3);
        int bit = 999;
        char[][] aaa = {{'X','.','.','.','X'},{'.','.','X','.','X'},{'.','.','X','.','X'},{'X','X','.','X','.'},{'.','.','X','.','X'}};

    }*/

}}