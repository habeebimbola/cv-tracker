package cvtrackertask.info.guesword.controller;

import java.math.BigInteger;
import java.util.*;

class FourSumSolution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The 
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest 
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }

    public static int longestZeros(Integer n) {
        int longest = 0, sequence = 0, next = 0;
        List<Integer> zerosCount =  new ArrayList();
        boolean startCount = false;
        String binaryString = Integer.toBinaryString(n), currentChar = "";
        System.out.println(binaryString);

        for (int index = 0; index < binaryString.length(); index++) {
            next = index + 1;

            if (next < binaryString.length()) {
                currentChar = binaryString.substring(index, index + 1);
            }
            if (next == binaryString.length())
            {
                currentChar = binaryString.substring(next);
            }
            if (currentChar.startsWith("1")) {
                startCount = true;
                zerosCount.add(sequence);
                sequence = 0;
            }

            if (startCount && currentChar.startsWith("0")) {
                sequence++;
            }

        }

        longest = Collections.max(zerosCount);

        return longest;

    }

    public static int maxSubSum(int[] nums){
        int max = 0, thisSum = 0;
        int size = nums.length;

        for(int index = 0; index < size; index++)
        {
            thisSum = 0;
            for (int y = index; y < size; y++) {
                thisSum += nums[y];
                System.out.printf("%d ", thisSum);
                if( thisSum > max)
                {
                    max = thisSum;
                }
            }

            System.out.println();
        }

        return max;
    }


    public static int maxSub(int[] nums ){
        int maxSum = 0, thisSum = 0;

        for (int index = 0; index < nums.length; index++)
        {
            thisSum += nums[index];

            if( thisSum > maxSum)
            {
                maxSum = thisSum;
            }
            else
            {
                if(thisSum < 0 )
                {
                    thisSum = 0;
                }
            }
        }


        return maxSum;
    }

    public static void gpSeries(int n){
        long returnValue = 1l;

        long temp = 1;

        for(int i = 1; i <= n; i++)
        {
             returnValue =  2 * temp * temp;
             temp = returnValue;
             System.out.println(" "+returnValue );
        }
    }

    public static String reverseWords(String sentence){
        StringBuilder revStr = new StringBuilder();

        String[] strings = sentence.split("\\s+");

        StringBuilder stringBuilder;
        for (String s: strings) {

            stringBuilder = new StringBuilder(s).reverse();
            revStr.append(stringBuilder).append(" ");
        }
        System.out.println(revStr);

        return revStr.toString();
    }

    public static int mystery(int a, int b)
    {
        if( b == 1)
        {
            return a;
        }
        return a + mystery(a, b - 1);
    }

    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>();
        numList.add(300);
        numList.add(530);
        numList.add(432);
        numList.add(120);

        Iterator<Integer> integerIterator = numList.iterator();

        while ((integerIterator.hasNext()))
        {
            System.out.println( integerIterator.next());
        }

//        numList.remove(0);
//        numList.remove(1);
//        numList.remove(3);
//
//        System.out.println("List has been modified !!!");
//
//        while (integerIterator.hasNext())
//        {
//            System.out.println(integerIterator.next());
//        }

//        System.out.println(longestZeros(9));


        int[] numbers = {2, 3, 5, 1, 8, 9, 6}, A = {-2,11,-4,13,-5,-2};
        int target = 16;
//        System.out.printf("%s \n", fourSum(numbers, target));
//       System.out.printf(" Maximum Subsequence Sum %d\n", maxSubSum(A));
//       System.out.printf(" Maximum Subsequence Sum %d", maxSub(A));
        gpSeries(3);
// ==> "sihT si na !elpmaxe"
        String input = "This is an example!";

        reverseWords(input);
        System.out.printf("Mystery Result: %s", mystery(10,9));
       
    }

}