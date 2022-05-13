package org.example;

import java.sql.SQLOutput;
import java.util.*;

import static java.lang.System.in;

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
        Solution4();

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

    public static class Priorities{
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

    public static void Solution1(){
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

    public static void Solution3(){
        String string = "madam";
        String isPaln = "No";
        int arraryLen = string.length();
        int revIndex = arraryLen -1;

        System.out.println( string.equals( new StringBuilder(string).reverse().toString())
                ? "Yes" : "No" );


        String [] arrayFwd = new String[arraryLen+1];
        String [] arrayRev = new String[arraryLen+1];

        for (int i = 0; i < arraryLen; i++) {
            arrayFwd[i] = string.substring(i,i+1);
            arrayRev[revIndex] = arrayFwd[i];
            revIndex --;
        }

        for (int i = 0; i < arraryLen / 2; i++) {
            if(arrayFwd[i].equals(arrayRev[i])){
                isPaln = "Yes";
            }else {
                isPaln = "No";
                break;
            }
        }
        System.out.println(isPaln);
        }

    public static void Solution4(){
        String a = "";
        String b = "";
        String isAnagram = "Not Anagrams";

//        Scanner sc = new Scanner(System.in);
//        a = sc.next();
//        b = sc.next();

       a = "anagramrmm";
        b = "marganarmm";

        a = a.toLowerCase(Locale.ROOT);
        b = b.toLowerCase(Locale.ROOT);

        if(a == "" || b == "" || a == null || b == null){
            System.out.println(isAnagram);
            return;
        }

        if(a.length() != b.length()){
            System.out.println(isAnagram);
            return;
        }

        Map<String, Integer> mapB = new HashMap<String, Integer>();
        for (int i = 0; i < b.length(); i++) {
            if (! mapB.containsKey(b.substring(i,i+1))){
               mapB.put((b.substring(i,i+1)), 1);
            }else {
                int numOfLetter = mapB.get(b.substring(i,i+1));
                numOfLetter ++;
                mapB.put((b.substring(i,i+1)), numOfLetter);
            }

        }

        for (int i = 0; i < a.length(); i++) {
            String letter = a.substring(i,i+1);
            if(mapB.containsKey(letter)){
                int numOfLettersLeft = mapB.get(letter);
                if (numOfLettersLeft == 0){
                    System.out.println(isAnagram);
                    return;
                }else{
                    numOfLettersLeft --;
                    mapB.put(letter,numOfLettersLeft);
                }
            }else{
                System.out.println(isAnagram);
                return;
            }

        }
        System.out.println("Anagrams");

    }



}