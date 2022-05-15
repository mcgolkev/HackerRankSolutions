package org.example;

import java.sql.SQLOutput;
import java.util.*;

import static java.lang.System.in;

/**
 * Hacker Rank Practice
 *
 * Purpose: Basic Java practice - these questions are easy and generally related to Strings
 *
 * @author Kevin McGoldrick
 * @version 1.0 5/13/22
 */
public class Main {
    public static void main(String[] args) {

        List<String> events = new ArrayList<>();
        events.add("1");
        events.add("ENTER");
        events.add("John");
        events.add("3.25");
        events.add("55");

        //Priorities.getStudents(events);
        //Solution1();

        //Solution2();
        //Solution3();
        //Solution4();
        Solution5();

    }

    public static class Student{

        private int id = 0;
        private String name = "";
        private double cgpa = 0.0;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public String toString(){
        String retString = "";
        retString = "name: " + this.name + ", CGPA: " + this.cgpa + ", ID: " + this.id;
        return  retString;
        }

    }

    public static class Priorities{  // takes formatted input string - limited value question not complete
        public static   List<Student> getStudents(List<String> events){
        List<Student> students = new ArrayList<>();

            int n = 0;
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < n; i++) {
                String keyword = scanner.next();
                String name = scanner.next();
                double cgpa = scanner.nextDouble();
                int id = scanner.nextInt();
                System.out.println("keyword: " + keyword + " name: " + name);
                System.out.println("cgpa: " + cgpa + " id: " + id);

                if(keyword.equals("ENTER")) {
                    Student student = new Student(id, name, cgpa);
                    System.out.println(student.toString());
                    students.add(student);
                }
                if(keyword.equals("SERVED")){
                    // if not empty, iterate through students
                    if(students.size() == 0)
                        System.out.println("Empty");
                }
            }
        return students;
        }


    }

    public static void Solution1(){  // prints a substring of a string given start and end indexes
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        String retString = S.substring(start,end);

        System.out.println(retString);
    }

    public static void Solution2(){  // break a string into chunks and sort, display first and last elements based on sorted chunks orderedset
        String smallest = "";
        String largest = "";

        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int k=scan.nextInt();

        SortedSet<String> sets=new TreeSet<String>();  // create a new SortedSet of type string
        for(int i=0;i<=str.length()-k;i++){  // iterate through the string until >>>> length - k <<< important, k being the size of string chunks (3 chars for eg)
            sets.add(str.substring(i,i+k));  // add to sorted set by using substring start is index i, end is index i plus the size of the chunk to be taken (ie 3)
        }
        System.out.println(sets);
        System.out.println(sets.first());
        System.out.println(sets.last());

    }

    public static void Solution3(){  // palindrome checker input is placed into two arrays, forward and backward and compared, prints 'yes' if palindrome
        String string = "madamm";  // test input
        String isPaln = "No";       // method variables
        int arraryLen = string.length();
        int revIndex = arraryLen -1;

//        System.out.println( string.equals( new StringBuilder(string).reverse().toString())
//                ? "Yes" : "No" );  // this was a copied solution... only two lines!!!  not my answer till I learn more.


        String [] arrayFwd = new String[arraryLen+1]; // create forward and reverse array variables based on the length of the input string
        String [] arrayRev = new String[arraryLen+1];

        for (int i = 0; i < arraryLen; i++) {  // iterate and load the forward array and the reverse array in the same loop
            arrayFwd[i] = string.substring(i,i+1);
            arrayRev[revIndex] = arrayFwd[i];
            revIndex --;
        }

        for (int i = 0; i < arraryLen / 2; i++) {  // since we now have parallel arrays, we check that each is equal at each index
            if(arrayFwd[i].equals(arrayRev[i])){   // the loop only tests half of the array length since contents are mirror images of each other
                isPaln = "Yes";
            }else {
                isPaln = "No";
                break;
            }
        }
        System.out.println(isPaln);
        }

    public static void Solution4(){ // Anagram checker
        String a = "";  // is string a an anagram of string b?
        String b = "";
        String isAnagram = "Not Anagrams";  // default output - Not Anagrams

//        Scanner sc = new Scanner(System.in);  // commented out stdin
//        a = sc.next();
//        b = sc.next();

       a = "anagramrmm";  // set variables for testing
        b = "marganarmm";

        a = a.toLowerCase(Locale.ROOT);  // checker is case-insensitive, so each input is converted to lower case
        b = b.toLowerCase(Locale.ROOT);

        if(a == "" || b == "" || a == null || b == null){  // short circuit if input is empty or null
            System.out.println(isAnagram);
            return;
        }

        if(a.length() != b.length()){  // short circuit if inputs are not equal length
            System.out.println(isAnagram);
            return;
        }

        Map<String, Integer> mapB = new HashMap<String, Integer>();  // create hashmap to load string B
        for (int i = 0; i < b.length(); i++) {  // iterate through string B
            if (! mapB.containsKey(b.substring(i,i+1))){
               mapB.put((b.substring(i,i+1)), 1); // if the current char in string B is not in the hashmap, add it with a key of the char and initial value of 1
            }else {
                int numOfLetter = mapB.get(b.substring(i,i+1));  // else char is already in hashmap, therefore increment the count of that char by 1
                numOfLetter ++;
                mapB.put((b.substring(i,i+1)), numOfLetter);
            }

        }

        for (int i = 0; i < a.length(); i++) {  // iterate through string A and remove chars from the hashmap "inventory"
            String letter = a.substring(i,i+1);  // get the first char from string A to test
            if(mapB.containsKey(letter)){  // is the char in string A
                int numOfLettersLeft = mapB.get(letter);  // check to see if there is anymore inventory for that char in the hashmap
                if (numOfLettersLeft == 0){  // if no more inventory for char being tested, return - Not Anagrams
                    System.out.println(isAnagram);
                    return;
                }else{
                    numOfLettersLeft --;  // if inventory of char being tested remain, decrement inventory by 1
                    mapB.put(letter,numOfLettersLeft);
                }
            }else{
                System.out.println(isAnagram);  // a char from string A does not exist in hashmap... Not Anagrams
                return;
            }

        }
        System.out.println("Anagrams"); // if we get to this line of code, strings A and B are anagrams.

    }

    public static void Solution5(){  // this method takes a string and splits it based on a REGEX format
       // String s = "He is a very very good boy, isn't he?";
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\Z");
        String s = scan.next();
        if (s.trim().length()==0 || s.trim().length()>400000)  // short circuit if the string input is zero length or larger than permitted 400,000
        {
            System.out.println(0);   // print zero if zero length or larger than permitted
            return;
        }
            String [] arrayS =  s.trim().split("[!,?._'@\\s]+");  // split the string into an array  based on the REGEX statement
            System.out.println(arrayS.length);
            for (int i = 0; i < arrayS.length; i++) {  // iterate through the array and print each element on a new line using printf
                System.out.printf("%s%n", arrayS[i]);
            }

    }

}