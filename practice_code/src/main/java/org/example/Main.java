package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

/**
 * Hacker Rank Practice
 *
 * Purpose: Basic Java practice - these questions are easy and generally related to integers
 *
 * @author Kevin McGoldrick
 * @version 1.0 5/13/22
 */

public class Main {
    public static void main(String[] args) throws IOException {

        //Hacker Rank Java Basic questions

        //Solution();
        //Solution2(18);
        //Solution3();
        //Solution4();
        //Solution5();
        //Solution6();
        //Solution7();
        //Solution8();
        //Solution9();
        //Solution10();
        Solution11();
    }

    public static void Solution(){
        Scanner scanner = new Scanner(System.in);


        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void Solution2(int number){  // print weird/not weird based on odd even numbers
        if (number % 2 == 0){
            if (number >20){
                System.out.println("Not Weird");
            }else if (number >= 6){
                System.out.println("Weird");
            }else {
                System.out.println("Not Weird");
            }
        }else{
            System.out.println("Weird");
        }
    }

    public static void Solution3(){  // receive input from scanner, GOTCHA, need to do a nextline() on line 55 to clear crlf from line 54
        Scanner scanner = new Scanner(System.in);
        String s = "";
        double d = 0;
        int i = 0;

        i = scanner.nextInt();
        d = scanner.nextDouble();
        scanner.nextLine();
        s = scanner.nextLine();



        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

    public static void Solution4(){  // print a formatted string, double, int with left justified and leading zeros
        Scanner scanner=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=scanner.next();
            int x=scanner.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
    }

    public static void Solution5() throws IOException { // for loop print 2 multiplication table
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        try {
            int number = Integer.parseInt(bufferedReader.readLine().trim());
            for (int i = 1; i < 11; i++) {
                result = number * i;
                System.out.printf("%d x %d = %d%n", number, i, result);
            }
        }catch (IOException e){
            System.out.println("ERROR");
        }
        bufferedReader.close();
    }

    public static void Solution6(){  // double for loops to perform math calculation
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int cumm = (a + b);
            System.out.printf("%d",cumm);
            for (int j = 1; j < n; j++) {
                cumm += ((Math.pow(2,j)*b));
                System.out.printf(" %d",cumm);
            }
            System.out.printf("%n");
        }
        in.close();
    }

    public static void Solution7(){  // receive number input, print out what primitive types it fits into, byte, short, int, long
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=scanner.nextLong();
                System.out.println(x+" can be fitted in:");

                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>=-2147483648 && x<=2147483647)System.out.println("* int");
                if((x>=-Math.pow(2,63)) && (x<=Math.pow(2,63)-1))System.out.println("* long");

            }
            catch(Exception e)
            {
                System.out.println(scanner.next()+" can't be fitted anywhere.");
            }

        }
    }

    public static void Solution8(){ // receive undetermined input, print line numbers and input when EOF is read
        Scanner scanner = new Scanner(System.in);
        int lineNum = 1;

            while (scanner.hasNext()){
                String input = scanner.nextLine();
                System.out.printf("%d %s%n", lineNum, input);
                lineNum ++;
        }
            scanner.close();

    }

    public static void Solution9(){  // How to convert an int to a String using Integer.toString(n) wrapper
        int n = 55;
        String num = Integer.toString(n);
        System.out.println(num);
    }

    public static String Solution10(){  // Returns the day of the week when given a mm/dd/yyyy date format
        int month = 8;
        int day = 5;
        int year = 2017;
        String retValue = "";

        LocalDate date = LocalDate.of(year, month, day);
        retValue = (date.getDayOfWeek()).toString();
        return retValue;
    }

    public static void Solution11(){  // custom format for various country currencies
        double payment = 12324.134;

        NumberFormat u = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + u.format(payment));

        NumberFormat i = NumberFormat.getCurrencyInstance(new Locale("en","in"));
        System.out.println("India: " + i.format(payment));

        NumberFormat c = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + c.format(payment));

        NumberFormat f = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + f.format(payment));


    }
}

