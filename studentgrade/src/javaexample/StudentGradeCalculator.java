package javaexample;

import java.util.Scanner;



class Student

{



    private String name;

    private int id;

    private final int[] grades = new int[3];




    public Student(String aName, int aID)

    {

        name = aName;

        id = aID;

        grades[0] = -1;

        grades[1] = -1;

        grades[2] = -1;

    }





    public String getName()

    {

        return name;

    }





    public int getID()

    {

        return id;

    }





    public int getGrade(int index)

    {

        return grades[index];

    }




    public int[] getGrades()

    {

        return grades;

    }





    public double getAverage()

    {

        return (grades[0] + grades[1] + grades[2]) / 3.0;

    }





    public char getLetterGrade()

    {

        double avgGrd = getAverage();



        if(avgGrd >= 90)

            return 'A';

        else if(avgGrd >= 80)

            return 'B';

        else if(avgGrd >= 70)

            return 'C';

        else if(avgGrd >= 60)

            return 'D';

        else

            return 'F';

    }





    public void setName(String aName)

    {

        name = aName;

    }





    public void setID(int aID)

    {

        id = aID;

    }





    public void setGrade(int index, int grade)

    {

        grades[index] = grade;

    }





    public void setGrades(int[] aGrades)

    {

        grades[0] = aGrades[0];

        grades[1] = aGrades[1];

        grades[2] = aGrades[2];

    }

}



public class StudentGradeCalculator

{

    public static void main(String[] args)

    {



        Scanner input = new Scanner(System.in);



        Student[] students = new Student[20];



        int count = 0;

        char option;

        String sname;

        int sid;

        int grade;

        int index;



        do

        {



            System.out.println("---MENU---");

            System.out.println("Enter A to Add Students");

            System.out.println("Enter B to Enter Test Grades");

            System.out.println("Enter C to Display Results");

            System.out.println("Enter D to Exit Program");

            System.out.print("Please select A, B, C, or D : ");

            option = input.next().charAt(0);



            switch(option)

            {

                case 'A':



                    System.out.print("\nEnter the name of a student: ");

                    sname = input.next();



                    System.out.print("Enter the id of the student: ");

                    sid = input.nextInt();

                    students[count] = new Student(sname, sid);

                    count++;

                    break;



                case 'B':

                    if(count == 0)

                    {

                        System.out.println("No students are in the list.");

                        break;

                    }



                    do

                    {

                        System.out.print("\nEnter the test number : ");

                        index = input.nextInt();

                        index--;

                        if (index<0||index>2)

                            System.out.println("Invalid test number!!! "+

                                    "Try again...");

                    }while(index<0||index>2);



                    for(int i=0; i<count; i++)

                    {

                        if(students[i].getGrade(index)>0)

                            System.out.print("The current score of the "

                                    +students[i].getName() +" is "

                                    +students[i].getGrade(index) +".");

                        System.out.print("Enter the grade to update or "

                                +"a value <0 to keep current value : ");

                        grade = input.nextInt();

                        if(grade > 0)

                            students[i].setGrade(index, grade);

                    }

                    break;

                case 'C':



                    System.out.println("\nDetails of all students:");



                    if(count == 0)

                    {

                        System.out.println("No students are in the list.");

                        break;

                    }



                    for (int i = 0; i < count-1; i++)

                    {

                        int idx = i;

                        for (int j = i + 1; j < count; j++)

                            if (students[j].getName().compareTo(students[idx].getName())<0)

                                idx = j;



                        String small = students[idx].getName();

                        students[idx].setName(students[i].getName());

                        students[i].setName(small);



                        int temp;



                        temp = students[idx].getID();

                        students[idx].setID(students[i].getID());

                        students[i].setID(temp);



                        temp = students[idx].getGrade(0);

                        students[idx].setGrade(0, students[i].getGrade(0));

                        students[i].setGrade(0, temp);



                        temp = students[idx].getGrade(1);

                        students[idx].setGrade(1, students[i].getGrade(1));

                        students[i].setGrade(1, temp);



                        temp = students[idx].getGrade(2);

                        students[idx].setGrade(2, students[i].getGrade(2));

                        students[i].setGrade(2, temp);

                    }





                    for(int i = 0; i < count; i++)

                    {

                        System.out.println("\nStudent #" + (i + 1));

                        System.out.println("Name: " + students[i].getName());

                        System.out.println("ID:   " + students[i].getID());

                        System.out.println("Grade1: " + students[i].getGrade(0));

                        System.out.println("Grade2: " + students[i].getGrade(1));

                        System.out.println("Grade3: " + students[i].getGrade(2));

                        System.out.println("Average grade: " + students[i].getAverage());

                        System.out.println("Letter grade: " + students[i].getLetterGrade());

                    }



                    break;



                case 'D':

                    System.out.println("Thank you.");

                    break;



                default:

                    System.out.println("Invalid Option!");

            }

            System.out.println();

        }while(option != 'D');

        input.close();

    }

}
