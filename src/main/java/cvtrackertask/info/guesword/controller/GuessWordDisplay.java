package cvtrackertask.info.guesword.controller;

import cvtrackertask.info.guesword.domain.Word;
import cvtrackertask.info.guesword.service.GuessWordService;

import java.io.File;
import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.groupingBy;

public class GuessWordDisplay {

    private Random randomGenerator = new Random();
    private int[] searchElements = new int[20];


    public static void main(String args[]) {

        GuessWordDisplay guessWordController = new GuessWordDisplay();
        System.out.printf("\"deified\" is %b palindrome\n", guessWordController.isRecursivePalindrome("deified",0,6));
        guessWordController.fillArray();

       System.out.printf( "Search Key %d Found index %d\n",2, guessWordController.recursiveLinearSearch(2, 0));

        String word = "good";
        System.out.printf("%s %s %s %s %s",
                word.compareToIgnoreCase("good"),
                word.compareToIgnoreCase("giod"),
                word.compareToIgnoreCase("geod"),
                word.regionMatches(true, 0, "guid", 0, 4),
                word.compareTo("are")
        );

        int[] numbers = {94, 43, 72, 24, 90, 100, 203, 2, 8, 1, 2},
                nums = {94, 43, 72, 24, 90, 100, 203, 2, 8, 1, 2},
                cyclic = {3, 8, 9, 7, 6};

        // 2, 94, 43, 72, 24, 90, 100, 203, 2, 8, 1
        String[] a = {"coderbyte", "3"};
        zigZag(a);
        System.out.println(containsDuplicate(numbers));

//          sort(numbers);

        Word word1 = new Word();
        word1.setLength(1);
        word1.setContent("My Word");
        Word word2 = new Word();
        word2.setLength(2);
        word2.setContent("You are welcome");
        List<Word> wordList = Arrays.asList(word1, word2);

        Map<Word, List<Word>> wordListMap = wordList.stream().
                filter((w) -> {
                    return w.getContent().startsWith("My");
                }).
                collect(groupingBy(Word::new));

        wordListMap.forEach((k, v) -> {
            v.stream().forEach((l -> {
                System.out.println(l.getContent());
            }));
        });

        System.out.printf("Predicate Method: %b", isWord( (w)-> {return  true;} , word1));
        rotate(cyclic, 3);
        System.out.printf("GCD %d ", gcd(25,100));
        String reverse = "double spaces";

        String[] tokens = reverse.split("\\s+");

        for(int count = 0; count < tokens.length; count++)
        {
            StringBuilder tokenWord = new StringBuilder (tokens[count]).reverse();
            System.out.printf("%s ", tokenWord.toString());
        }


        GuessWordService username = ( ) -> "Nimat";

        System.out.println();
        printNum(12456);
        System.out.println( "String".charAt(2) == 'r');

        IntSupplier n = () ->  1;
        Predicate<Word> t = (b) -> true;
        HelloWorld helloWorld1 = new HelloWorld();
        HelloWorld helloWorld2 = new HelloWorld();
        MyClass helloWorld = new HelloWorld();
        helloWorld.show();
        System.out.println("This Predicate returns \"true\""+isWord(t, word1));

        Runnable runnable = ( ) -> System.out.println("You are welcome to Lambda Expression!");

        File[] files = new File(System.getProperty("user.dir")).listFiles((file)-> file.isHidden());

        List<HelloWorld> helloWorlds = List.of(helloWorld1,helloWorld2);
        start(runnable::run);

        BiPredicate<String, String> stringBiPredicate = (String x, String y) -> true;

        Function<String, String> stringFunction = (s) -> s.toLowerCase(Locale.ROOT);
        Function<Integer, String> localFunction = (l) -> String.valueOf( Math.pow(l, 2));
        BiFunction<String, Integer, String> biFunction;
        System.out.println("Factorial Method...");
        System.out.println(factorial(5));
        System.out.println("Summation");
        System.out.println(sumTotal(5));

        System.out.println("Valid Parentheses "+isVAlidBrackets("(((((((((())))))))))"));
        byte x = 127; int min = Integer.MIN_VALUE;
        x++;
        x++;
        System.out.println( "X :"+x );
        System.out.println( "Max :"+(--min) );

        System.out.printf("Function Call: %s", stringFunction.apply("NIMAT") );
        System.out.println(function(localFunction, 25));

    }

    public void fillArray()
    {
        for(int count = 0; count < 10; count +=1 )
        {
            searchElements[count] = 1 + randomGenerator.nextInt(9);
        }
        for (int count = 0; count < 10; count+=1)
        {
            System.out.printf("%d ", searchElements[count]);
        }
        System.out.println();
    }
    public static <T> T function(Function<Integer, T> trFunction, Integer t)
    {
        T t1 = trFunction.apply(t);

        return t1;
    }

    public static  boolean isWord(Predicate<Word> wordPredicate, Word word){

        return wordPredicate.test(word);
    }

    public static void start(Runnable runnable){
        runnable.run();
    }

    public static void sort(int[] N) {
        int size = N.length;
        int currentIndex = 0, nextElement = 0, next, temp = 0;
        System.out.println();

        for (int index = 0; index < size; index++) {
            for (int inner = 0; inner < size; inner++) {
                next = inner + 1;

                if ((next < size) && (N[inner] > N[next])) {
                    temp = N[next];
                    N[next] = N[inner];
                    N[inner] = temp;
                }
            }

        }

        System.out.println();
        for (int n : N) {
            System.out.printf("%d ", n);
        }
    }


    public static String swap(String str1) {
        int size = str1.length();
        int endIndex = size - 1;

        if (size < 3) {
            return "Incompatible";
        }

        String start = str1.substring(0, 1);
        String end = str1.substring(endIndex);

        String sub = (String) str1.subSequence(0, endIndex);

        StringBuilder newWord = new StringBuilder(str1);
        newWord.deleteCharAt(0).insert(0, end).deleteCharAt(endIndex).insert(endIndex, start);
        return newWord.toString();
    }

    public static void zigZag(String[] strArr) {
        int size = strArr.length;
        String str = strArr[0], row = strArr[1];

        int rowSize = Integer.parseInt(row), currentRow = 0;
        boolean increment = false;

        char[][] strChars = new char[rowSize][str.length()];
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < str.length(); index++) {
            strChars[currentRow][index] = str.charAt(index);

            if (currentRow == 0) {
                increment = true;
            }
            if (currentRow == (rowSize - 1)) {
                increment = false;
            }
            if (increment) {
                currentRow++;
            }
            if (!increment) {
                currentRow--;
            }
            System.out.println(str.charAt(index));
        }
        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int col = 0; col < strChars[rowIndex].length; col++) {
                if (Character.isLetter(strChars[rowIndex][col])) {
                    System.out.printf(" %c ", strChars[rowIndex][col]);
                    stringBuilder.append(strChars[rowIndex][col]);
                }

            }
            System.out.println();
        }
        System.out.printf("%s", stringBuilder.toString());
    }

    public static int sum(int x, int y, char operand) {
        int sum = 0;

        switch (operand) {
            case '+':
                sum = x + y;
                break;
            case '-':
                sum = x - y;
                break;
            case '*':
                sum = x * y;
                break;
            case '/':
                sum = x / y;
                break;
        }
        return sum;
    }

    public static boolean containsDuplicate(int[] N) {
        boolean result = false;

        Arrays.sort(N);

        for (int index = 1; index < N.length; index++) {
            if (N[index] == N[index - 1]) {
                result = true;
            }
        }

        return result;
    }

    public static int[] rotate(int[] a, int k) {

        int[] result = new int[a.length], srcArray = a;

        int size = a.length, next = 0, temp = 0;
        while (k > 0) {
            for (int index = 0; index < size; index++) {
                next = index + 1;

                if (index == 0) {
                    result[next] = a[index]; //1st element moves to 2nd position
                    result[index] = a[size - 1]; //last element moves 1st position
                    temp = a[next]; //track 2nd element
                }

                if (index > 1) {
                    result[index] = temp;
                    temp = a[index];
                }
            }

            System.arraycopy(result, 0, a, 0, result.length);
            k--;
        }
        System.out.printf("Contents:  %s\n %s", Arrays.toString(result), Arrays.toString(a));
        return a;
    }

    public static int gcd(int x, int y){
        int gcd = 1;

        for(int divisor = 1;divisor <= Math.min(x,y) ; divisor++)
        {
            if(( x % divisor == 0) && (y % divisor == 0))
            {
                gcd =  divisor;

            }
            divisor++;

        }

        return gcd;
    }

    public static void printNum(int n){
        if( n > 10)
        {
            printNum(n / 10);
        }
        System.out.print(" "+(n%10));
     }

     public static int factorial(int number)
     {
         if(number == 1 )
         {
             return 1;
         }
         return factorial(number - 1 ) * number;
     }

     public static int sumTotal(int number)
     {
         if(number == 1)
         {
             return 1;
         }
         return sumTotal(number - 1 ) + number;
     }

     public static boolean isVAlidBrackets(String input)
     {
         boolean valid = false;
         Stack<Character> stack = new Stack<>();
         for( char c : input.toCharArray())
         {
             if(c == '(' || c == '{' || c == '[')
             {
                stack.push(c);
             }
             else
             {
//                 if(stack.isEmpty()){
//                     return false;
//                 }

                 char top = stack.peek();

                 if((  c == ')' && top == '(') ||((c == '}') &&(top == '(')))
                 {
                     stack.pop();
                 }
             }
         }

         if(stack.isEmpty())
         {
             return true;
         }

         return valid;
     }

     private static long exponent(long number, long power)
     {
         if( power == 1 )
         {
             return number;
         }
         return number * exponent(number, power - 1);
     }

     public  int recursiveLinearSearch(int searchKey,int index)
     {

         if( index < searchElements.length && searchKey != searchElements[index])
         {
             return recursiveLinearSearch(searchKey, ++index);
         }
         else
         {
             if( index >= searchElements.length)
                 return -1;
             if(searchKey == searchElements[index])
               return index;
         }
         return -1;
     }

     public int recurseLinear(int searchKey, int index)
     {
         if(index == searchElements.length)
         {
             return -1;
         }
         if(searchElements[index] == searchKey)
         {
             return index;
         }
        return recurseLinear(searchKey, ++index);
     }

     public boolean isRecursivePalindrome(String word, int left, int right)
     {
         Character leftChar = word.toLowerCase(Locale.ROOT).charAt(left), rightChar = word.toLowerCase(Locale.ROOT).charAt(right);

         if(left >= right )
         {
             return true;
         }
         if(leftChar != rightChar)
         {
             return false;
         }
         left++; right--;
         return isRecursivePalindrome(word, left, right);
     }

     public String swapCase(String input)
     {
         String swapResult = "";
         StringBuilder stringBuilder = new StringBuilder(swapResult);

         for(int index = 0 ; index < input.length(); index++)
         {
             char ch = input.charAt(index);

             if( Character.isUpperCase( ch ))
             {
                 stringBuilder.append( Character.toLowerCase(ch));
             }
             else
             {
                 stringBuilder.append( Character.toUpperCase(ch));
             }
         }
         swapResult = stringBuilder.toString();

         return swapResult;
     }

    public boolean isAnagram(String str1, String str2) {
        boolean result = false;
        int length1 = str1.length(), length2 = str2.length(), charCount = 0;

        if( length1 != length2 )
        {
            return result;
        }
        Map<Character, Integer> charsMap = new HashMap<>();

        for( int index = 0; index < str1.length(); index++ )
        {
            Character ch1 =  str1.charAt(index),  ch2 = str2.charAt(index);

            if(!charsMap.containsKey(ch1))
            {
                charsMap.put(ch1, 1);
            }
            else
            {
                 charCount = charsMap.get(ch1);
                 charsMap.put(ch1, ++charCount);
            }
        }

        for(int index = 0; index < length2; index++)
        {
            char ch2 = str2.charAt(index);

            if(charsMap.containsKey(ch2))
            {
                int count =  charsMap.get(ch2);
                count--;
                charsMap.put(ch2, count);
            }
        }


        for(Character character : charsMap.keySet())
        {
            if( charsMap.get(character) != 0 )
            {
                return false;
            }
        }

        return true;
    }
}
