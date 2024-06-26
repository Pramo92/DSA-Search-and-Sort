package Q1;

import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        List list = new List(10);

        for(int i=0;i<10;i++){
            Student st = new Student();
            System.out.print("Enter your Student No: ");
            st.stNo=  input.nextLine();
            System.out.print("Enter your garde for COSC12063: ");
            st.COSC12063=  input.nextLine();
            System.out.print("Enter your garde for COSC11052: ");
            st.COSC11052=  input.nextLine();
            System.out.print("Enter your garde for PMAT11553: ");
            st.PMAT11553=  input.nextLine();
            System.out.print("Enter your garde for PMAT11562: ");
            st.PMAT11562=  input.nextLine();

            list.InsertLast(st);
        }

        for(int i=0;i< list.ListSize();i++){
            double totGPA=getGPA(list.RetrieveList(i).COSC12063)*3+getGPA(list.RetrieveList(i).COSC11052)*2+getGPA(list.RetrieveList(i).PMAT11553)*3+getGPA(list.RetrieveList(i).PMAT11562)*2/(3+2+3+2);

            Student st = list.RetrieveList(i);
            st.GPA = totGPA;
        }

        list.sort();


    }

    static double getGPA(String grade){
        double gpa;
        switch (grade){
            case "A+":
                gpa = 4.0;
                break;
            case "A":
                gpa = 4.0;
                break;
            case "A-":
                gpa = 3.7;
                break;
            case "B+":
                gpa = 3.3;
                break;
            case "B":
                gpa = 3.0;
                break;
            case "B-":
                gpa = 2.7;
                break;
            case "C+":
                gpa = 2.3;
                break;
            case "C":
                gpa = 2.0;
                break;
            case "C-":
                gpa = 1.7;
                break;
            case "D+":
                gpa = 1.3;
                break;
            case "D":
                gpa = 1.0;
                break;
            default:
                gpa = 0.0;
                break;
        }
        return gpa;
    }
}
