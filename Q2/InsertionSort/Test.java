package InsertionSort;

public class Test {
    public static void main(String[] args){
        String[] id={"E101","E102","E103","E104","E105","E106","E107","E108","E109","E110"};
        String[] name={"John Smith","Mary Johnson","Michael Davis","Emily Wilson","David Brown","Sarah Miller","Robert Taylor","Jennifer Lee","William Clark","Laura Turner"};
        int[] age={33,28,35,32,33,29,33,31,36,26};
        int[] salary = {55000,60000,62000,58000,54000,61000,59000,57000,63000,55000};

        List list = new List(id.length);
        for(int i=0;i<id.length;i++){
            Employee emp = new Employee();
            emp.id=id[i];
            emp.name=name[i];
            emp.age=age[i];
            emp.salary=salary[i];
            list.InsertLast(emp);
        }

        for(int i=0;i<list.listSize();i++){
            System.out.println(list.RetrieveList(i).id+'\t'+list.RetrieveList(i).name+'\t'+'\t'+list.RetrieveList(i).age+'\t'+list.RetrieveList(i).salary);
        }
        System.out.println();
        System.out.println();

        list.sort();

        for(int i=0;i<list.listSize();i++){
            System.out.println(list.RetrieveList(i).id+'\t'+list.RetrieveList(i).name+'\t'+'\t'+list.RetrieveList(i).age+'\t'+list.RetrieveList(i).salary);
        }
        System.out.println();
        list.sortAge();

        for(int i=0;i<list.listSize();i++){
            System.out.println(list.RetrieveList(i).id+'\t'+list.RetrieveList(i).name+'\t'+'\t'+list.RetrieveList(i).age+'\t'+list.RetrieveList(i).salary);
        }

        int[] y = list.binarySearch(33);

        if(y[0]!=-1){
            System.out.println("Employees who 33 years old: ");
            for(int i=0;i<y.length;i++){
                System.out.println(list.RetrieveList(y[i]).id+"\t"+list.RetrieveList(occurrence[i]).name+"\t"+list.RetrieveList(occurrence[i]).age+"\t"+list.RetrieveList(occurrence[i]).salary+"\t");
            }
        }
        else{
            System.out.println("key not found");
        }
    }
}
