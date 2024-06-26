package BubbleSort;


import InsertionSort.Employee;

public class List {
    int maxSize;
    int position;
    EmployeeB[] listArray;

    public List(int size){
        maxSize=size;
        position=-1;
        listArray=new EmployeeB[maxSize];
    }

    boolean IsListEmpty(){
        return position==-1;
    }

    boolean IsListFull(){
        return position==maxSize-1;
    }

    public int listSize(){
        return position+1;
    }

    public void InsertLast(EmployeeB x){
        if(IsListFull()){
            System.out.println("List is full");
        }
        else{
            listArray[++position]=x;
        }
    }

    void InsertList(int p,EmployeeB x){
        if(IsListFull()){
            System.out.println("List is full");
        }
        else if(p<0||p>listSize()){
            System.out.println("attempt to insert an entry at position not in the list");
        }
        else{
            for(int i=listSize();i>p;i--)
                listArray[i]=listArray[i-1];
            listArray[p]=x;
        }
    }

    EmployeeB deleteList(int p){
        if(IsListEmpty()){
            System.out.println("List is empty");
        }
        else if(p<0||p>listSize()){
            System.out.println("attempt to delete an entry at position not in the list");
        }
        else{
            EmployeeB element = listArray[p];
            for(int i=p;i<listSize();i++)
                listArray[i]=listArray[i+1];
            return element;
        }
        return null;
    }

    EmployeeB RetrieveList(int p){
        if(IsListEmpty()){
            System.out.println("List is empty");
        }
        else if(p<0||p>listSize()){
            System.out.println("attempt to retrieve an entry at position not in the list");
        }
        else{
            return listArray[p];
        }
        return null;
    }

    void sort(){
        int n = listArray.length;
        for(int i=0;i<n;i++){
            for(int j=1;j<(n-1);j++){
                if(listArray[j-1].salary>listArray[j].salary){
                    EmployeeB temp = listArray[j-1];
                    listArray[j-1]=listArray[j];
                    listArray[j]=temp;
                }
            }
        }
    }

    void sortAge(){
        int n= listArray.length;
        for(int i=0;i<n;i++){
            for(int j=1;j<(n-i);j++){
                if(listArray[j-1].age>listArray[j].age){
                    EmployeeB temp = listArray[j-1];
                    listArray[j-1]=listArray[j];
                    listArray[j]=temp;
                }
            }
        }
    }
    public int[] binarySearch(int key){
        int low=0;
        int high = listSize()-1;
        int[] x = new int[listSize()];
        int count=0;

        while(low<=high){
            int mid=(low+high)/2;
            if(listArray[mid].age<key){
                low = mid+1;
            }
            else if(listArray[mid].age>key){
                high=mid-1;
            }
            else{
                x[count++]=mid;
                int left=mid-1;
                while(left>=0&&listArray[left].age==key){
                    x[count++]=left;
                    left--;
                }
                int right=mid+1;
                while(right<listSize()&&listArray[left].age==key) {
                    x[count++] = right;
                    right++;
                }
                int[] result = new int[count];
                System.arraycopy(x,0,result,0,count);
                return result;
            }

        }
        return new int[]{-1};
    }
}
