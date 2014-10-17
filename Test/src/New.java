import java.io.IOException;
import java.util.ArrayList;

import static java.util.Arrays.asList;


public class New {

    public static final int CODE_LENGTH = 3;
    public static final int CHOICES_LENGTH = 8;

    public static final int[] Choices = {0, 1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) throws IOException {

        int[] Code = createCode();
        int[] Choices = createChoices();

        ArrayList<int[]> savedGuesses = new ArrayList<int[]>();
        ArrayList<int[]> savedResults = new ArrayList<int[]>();

        int constantSpots;



        int[] result = {1,1,1};
        int[] guess = initialGuess();
        int[] template = {-1, -1, -1};

        boolean correctNumbers;

//        int[] check = {2, 2, 2}; //TODO: better way of checking guesses






        printArray(guessingAI(guess, result, template));

//
//        int i=0;
//
//
//
//
//
//        while (true) {
//            i++;
//
//
//
//            while (savedGuesses.contains(guess)){
//                //guess again
//            }
//            result = guess(guess, Code);
//            savedGuesses.add(guess);
//            savedResults.add(result);
//
//
//            correctNumbers = isCorrectNumbers(result);
//
//            if (correctNumbers){
//                System.out.println(i);
//                break;
//            }
//
//
//            //AI algorithm for guessing
//
////            if (Arrays.equals(result, check)) {
////                System.out.println("YOU WON!");
////                System.out.println(Code);
////                break;
////            }
//
//
//        }
//
//        printArray(guess);
    }

    public static int[] createCode() {
        int[] Code = new int[CODE_LENGTH];
        int temp;
        for (int i = 0; i < CODE_LENGTH; ) {
            temp = (int) (Math.random() * CHOICES_LENGTH);
            if (!contains(Code, temp)) {
                Code[i] = temp;
                i++;
            }
        }
        return Code;
    }

    public static int[] createChoices(){
        int[] Choices = new int[CHOICES_LENGTH];
        for (int i = 0; i < CHOICES_LENGTH; i++) {
            Choices[i] = i;
        }
        return Choices;
    }

    public static int[] initialGuess(){
        int[] guess = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            guess[i] = i;
        }
        return guess;
    }

    public static boolean contains(int[] x, int t) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == t) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCorrectNumbers(int[] result) {
        if (!contains(result, 0)) return true;
        return false;
    }

    public static void printArray(int[] x) {
        for (int i=0; i<x.length; i++){
            System.out.print(" " + Integer.toString(x[i]));
        }
    }







    public static int[] guess(int[] x, int[] code) {
        int[] results = new int[CODE_LENGTH];
        int j = 0;
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (x[i] == code[i]) {
                results[j] = 2;
                j++;
            } else {
                if (asList(x).contains(code[i])) {
                    results[j] = 1;
                    j++;
                } else {
                    results[j] = 0;
                    j++;
                }
            }
        }
        int k;
        for (int i = 0; i < CODE_LENGTH; i++) {
            int value = results[i];
            k = i - 1;
            while (k >= 0 && results[k] < value) {
                results[k + 1] = results[k];
                k--;
            }
            results[k + 1] = value;
        }
        for (int i = 0; i < CODE_LENGTH; i++) {
            System.out.println(results[i]);
        }
        return results;
    }

    public static int[] guessingAI(int[] previousGuess, int[] previousResult, int[] certainTemplate){
        int i=0;
        int j=0;
        int[] newGuess = certainTemplate;
        while (previousResult[i]==2){
            if (certainTemplate[j]==-1){
                newGuess[j]=previousGuess[i];
                i++;

            }
            j++;
            if (j==CODE_LENGTH){
                j=0;
            }
        }
        int y=0;
        j=0;
        while ( i<CODE_LENGTH && previousResult[i]==1 && y<CODE_LENGTH){
            while (contains(newGuess, previousGuess[y])){
                y++;
//                if (y==CODE_LENGTH){
//                    y=0;
//                }
            }
            if (newGuess[j]==-1 && j!=y){
                newGuess[j]=previousGuess[y];
                y++;
                i++;
            }
            j++;
            if (j==CODE_LENGTH){
                j=0;
            }
        }
        int b=0;
        for (int a=0; a<CODE_LENGTH; a++){
            if (newGuess[a]==-1){
                while (contains(newGuess, Choices[b]) || contains(previousGuess, Choices[b])){
                    b++;
                }
                newGuess[a] = Choices[b];
            }
            b=0;
        }
        return newGuess;
    }


}

//    public static String[] check(String[] word, int j, int m, int n, String[][] inputGrid, String[] result) {
//        if (j < word.length && result != null) {
//            result[j] = Integer.toString(m) + "," + Integer.toString(n);
//
//            if (m + 1 < inputGrid[0].length) {
//                if (inputGrid[m + 1][n].equals(word[j + 1])) {
//                    result = check(word, j + 1, m + 1, n, inputGrid, result);
//                }
//            }
//
//            if (n + 1 < inputGrid.length) {
//                if (inputGrid[m][n + 1].equals(word[j + 1])) {
//                    result = check(word, j + 1, m, n + 1, inputGrid, result);
//                }
//            }
//
//            if (m > 0) {
//                if (inputGrid[m - 1][n].equals(word[j + 1])) {
//                    result = check(word, j + 1, m - 1, n, inputGrid, result);
//                }
//            }
//
//            if (n > 0) {
//                if (inputGrid[m][n - 1].equals(word[j + 1])) {
//                    result = check(word, j + 1, m, n - 1, inputGrid, result);
//                }
//            }
//
//        } else {
//            result = null;
//        }
//        return result;
//    }
//
//    public static String[] trim(String[] word) {
//        String[] finalString = Arrays.copyOfRange(word, 1, word.length);
//        return finalString;
//    }
//
//    public static boolean isPermutation(String word1, String word2) {
//        if (word1.length() != word2.length()) {
//            return false;
//        }
//        String[] one = word1.split("");
//        String[] two = word2.split("");
//        sort(one);
//        sort(two);
//        if (Arrays.equals(one, two)) {
//            return true;
//        }
//        return false;
//    }
//
//    public static String compression(String word) {
//        StringBuffer s = new StringBuffer();
//        char letter = '\0';
//        int count = 1;
//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) == letter) {
//                count++;
//            } else {
//                if (count > 1) {
//                    s.append(count);
//                }
//                s.append(word.charAt(i));
//                letter = word.charAt(i);
//                count = 1;
//            }
//
//        }
//        if (count > 1) {
//            s.append(count);
//        }
//        return s.toString();
//    }






//          System.out.println(3*5 + "\t HI");

//        System.out.println(isPermutation(" batman", "manb at"));
//        System.out.println(compression("aabcccaaa"));
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//        String line = "";
//
//        String[] newWord = stdin.readLine().split("");
//        String[] word = Arrays.copyOfRange(newWord, 1, newWord.length);
//
//        int i = 0;
//        String[][] inputGrid = new String[word.length][word.length];
//
//        inputGrid[0] = trim(stdin.readLine().split(""));
//        inputGrid[1] = trim(stdin.readLine().split("")); //fix recursive line save input
//
////        while (line != null) {
////            line = (stdin.readLine() != null) ? stdin.readLine() : null;
////            if (line != null) {
////                inputGrid[i++] = line.split("");
////                i++;
////            } else {
////                break;
////            }
////        }
//
//        int j = 0, m = 0, n = 0;
//        String[] result = new String[word.length - 1];
//        result = check(word, j, m, n, inputGrid, result);
//
//
//        int a = 0;
//        while (a < result.length) {
//            System.out.println(result[a++]);
//        }

//CREATED grid and stored word