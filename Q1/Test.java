package Q1;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        String[] stno = {"PS/2017/280","PS/2017/149","PS/2017/045","PS/2017/273","PS/2017/301","PS/2017/312","PS/2017/105","PS/2017/016","PS/2017/198","PS/2017/151"};
        String[] name = {"Kamal","Nirmala","Sarath","Kasuni","Chanaka","Akila","Dasuni","Amal","Binura","Sithara"};
        char[] gender = {'M','F','M','F','M','F','F','M','M','F'};
        char[] grade ={'B','B','C','A','C','D','A','A','B','A'};

        List list = new List(stno.length);
        for(int i=0;i<stno.length;i++){
            Student st = new Student();
            st.stNo=stno[i];
            st.name=name[i];
            st.gender=gender[i];
            st.grade=grade[i];
            list.InsertLast(st);
        }
        /*
        System.out.println("Student Number      Name       Gender      Grade");
        for(int i=0;i<list.listSize();i++){
            System.out.println(list.RetrieveList(i).stNo+'\t'+'\t'+'\t'+list.RetrieveList(i).name+'\t'+'\t'+list.RetrieveList(i).gender+'\t'+'\t'+'\t'+list.RetrieveList(i).grade);
        }*/

        list.sort();

        System.out.println("Student Number      Name       Gender      Grade");
        for(int i=0;i<list.listSize();i++){
            System.out.println(list.RetrieveList(i).stNo+'\t'+'\t'+'\t'+list.RetrieveList(i).name+'\t'+'\t'+list.RetrieveList(i).gender+'\t'+'\t'+'\t'+list.RetrieveList(i).grade);
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the grade: ");
        char key = input.next().charAt(0);

        int[] occurrences = list.binarySearch(key);

        if (occurrences[0] != -1) {
            System.out.println("Students who got "+key+" : ");
            for (int i = 0; i < occurrences.length; i++) {
                System.out.println(list.RetrieveList(occurrences[i]).stNo);
            }
            System.out.println();
        } else {
            System.out.println("No students found");
        }
    }
}
