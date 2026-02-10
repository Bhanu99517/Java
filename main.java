/*
================================================================================
                            COMPLETE JAVA COURSE
                       BASIC → INTERMEDIATE → ADVANCED
                     (LEARN BY READING COMMENTS + CODE)

 HOW TO USE THIS FILE:
 - Read comments carefully
 - Run the program
 - Modify values and experiment
 - This file is intentionally LONG (real learning)

 AUTHOR  : Bhanu
 LEVEL   : Beginner → Advanced
================================================================================
*/

import java.util.*;     // Scanner, ArrayList, HashMap, etc
import java.io.*;       // File handling

// =============================================================================
//                              MAIN CLASS
// =============================================================================
public class JavaFullCourse {

    /*
    ============================================================================
                                MAIN METHOD
    - Program execution starts here
    - JVM looks for public static void main(String[] args)
    ============================================================================
    */
    public static void main(String[] args) {

        System.out.println("========= JAVA FULL COURSE START =========\n");

        // ---------------------------------------------------------------------
        // 1️⃣ VARIABLES & DATA TYPES
        // ---------------------------------------------------------------------

        // Primitive data types
        int age = 20;                 // integer
        double marks = 88.75;         // decimal
        char grade = 'A';             // single character
        boolean isStudent = true;     // true / false

        // Non-primitive
        String name = "Bhanu";        // String is an object

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student: " + isStudent);

        // ---------------------------------------------------------------------
        // 2️⃣ OPERATORS
        // ---------------------------------------------------------------------
        int a = 10, b = 3;

        System.out.println("\n--- Operators ---");
        System.out.println(a + b);    // arithmetic
        System.out.println(a > b);    // relational
        System.out.println(a == b);   // equality
        System.out.println(a != b);

        // ---------------------------------------------------------------------
        // 3️⃣ CONDITIONAL STATEMENTS
        // ---------------------------------------------------------------------
        if (marks >= 90) {
            System.out.println("Excellent");
        } else if (marks >= 60) {
            System.out.println("Good");
        } else {
            System.out.println("Fail");
        }

        // Switch case
        switch (grade) {
            case 'A':
                System.out.println("Topper");
                break;
            case 'B':
                System.out.println("Average");
                break;
            default:
                System.out.println("Needs Improvement");
        }

        // ---------------------------------------------------------------------
        // 4️⃣ LOOPS
        // ---------------------------------------------------------------------
        System.out.println("\nFor Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nWhile Loop:");
        int i = 1;
        while (i <= 3) {
            System.out.println(i);
            i++;
        }

        System.out.println("\nDo-While Loop:");
        int j = 1;
        do {
            System.out.println(j);
            j++;
        } while (j <= 2);

        // ---------------------------------------------------------------------
        // 5️⃣ ARRAYS
        // ---------------------------------------------------------------------
        int[] numbers = {10, 20, 30, 40};

        System.out.println("\nArray:");
        for (int n : numbers) {
            System.out.println(n);
        }

        // ---------------------------------------------------------------------
        // 6️⃣ METHODS
        // ---------------------------------------------------------------------
        System.out.println("\nMethod Result: " + add(5, 10));
        System.out.println("Overloaded Method: " + add(1, 2, 3));

        // ---------------------------------------------------------------------
        // 7️⃣ OBJECT & CLASS
        // ---------------------------------------------------------------------
        Student s1 = new Student("Bhanu", 20);
        s1.display();

        // ---------------------------------------------------------------------
        // 8️⃣ INHERITANCE & POLYMORPHISM
        // ---------------------------------------------------------------------
        Person p = new CollegeStudent("Bhanu", 20, "GIOE");
        p.display();   // runtime polymorphism

        // ---------------------------------------------------------------------
        // 9️⃣ ENCAPSULATION
        // ---------------------------------------------------------------------
        BankAccount account = new BankAccount();
        account.setBalance(5000);
        System.out.println("Balance: " + account.getBalance());

        // ---------------------------------------------------------------------
        // 🔟 INTERFACES
        // ---------------------------------------------------------------------
        Payment pay;
        pay = new UPI();
        pay.pay(1000);

        pay = new Card();
        pay.pay(2000);

        // ---------------------------------------------------------------------
        // 1️⃣1️⃣ COLLECTIONS
        // ---------------------------------------------------------------------
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println("\nArrayList: " + list);
        System.out.println("HashMap: " + map);

        // ---------------------------------------------------------------------
        // 1️⃣2️⃣ EXCEPTION HANDLING
        // ---------------------------------------------------------------------
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            System.out.println("Finally block executed");
        }

        // ---------------------------------------------------------------------
        // 1️⃣3️⃣ FILE HANDLING
        // ---------------------------------------------------------------------
        try {
            FileWriter fw = new FileWriter("demo.txt");
            fw.write("Hello Java File");
            fw.close();

            FileReader fr = new FileReader("demo.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        // ---------------------------------------------------------------------
        // 1️⃣4️⃣ MULTITHREADING
        // ---------------------------------------------------------------------
        MyThread t1 = new MyThread();
        t1.start();

        Runnable r = new MyRunnable();
        Thread t2 = new Thread(r);
        t2.start();

        // ---------------------------------------------------------------------
        // 1️⃣5️⃣ LAMBDA & STREAM (ADVANCED JAVA)
        // ---------------------------------------------------------------------
        list.forEach(item -> System.out.println("Lambda: " + item));

        list.stream()
            .filter(item -> item.startsWith("J"))
            .forEach(System.out::println);

        System.out.println("\n========= JAVA FULL COURSE END =========");
    }

    // Method
    static int add(int a, int b) {
        return a + b;
    }

    // Method Overloading
    static int add(int a, int b, int c) {
        return a + b + c;
    }
}

// =============================================================================
//                              CLASSES & OOP
// =============================================================================
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Student: " + name + ", " + age);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Person: " + name);
    }
}

class CollegeStudent extends Person {
    String college;

    CollegeStudent(String name, int age, String college) {
        super(name, age);
        this.college = college;
    }

    @Override
    void display() {
        System.out.println(name + " studies at " + college);
    }
}

// =============================================================================
//                              ENCAPSULATION
// =============================================================================
class BankAccount {
    private int balance;

    void setBalance(int amount) {
        balance = amount;
    }

    int getBalance() {
        return balance;
    }
}

// =============================================================================
//                              INTERFACES
// =============================================================================
interface Payment {
    void pay(int amount);
}

class UPI implements Payment {
    public void pay(int amount) {
        System.out.println("Paid via UPI: " + amount);
    }
}

class Card implements Payment {
    public void pay(int amount) {
        System.out.println("Paid via Card: " + amount);
    }
}

// =============================================================================
//                              MULTITHREADING
// =============================================================================
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running");
    }
}
