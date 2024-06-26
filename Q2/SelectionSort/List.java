package SelectionSort;


import InsertionSort.Employee;

public class List {
    int maxSize;
    int position;
    EmployeeS[] listArray;

    public List(int size){
        maxSize=size;
        position=-1;
        listArray=new EmployeeS[maxSize];
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

    public void InsertLast(EmployeeS x){
        if(IsListFull()){
            System.out.println("List is full");
        }
        else{
            listArray[++position]=x;
        }
    }

    void InsertList(int p, EmployeeS x){
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

    EmployeeS deleteList(int p){
        if(IsListEmpty()){
            System.out.println("List is empty");
        }
        else if(p<0||p>listSize()){
            System.out.println("attempt to delete an entry at position not in the list");
        }
        else{
            EmployeeS element = listArray[p];
            for(int i=p;i<listSize();i++)
                listArray[i]=listArray[i+1];
            return element;
        }
        return null;
    }

    EmployeeS RetrieveList(int p){
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
        for(int i=listArray.length-1;i>=0;i--){
            int maxIndex=getMaxIndex(i);

            EmployeeS temp = listArray[maxIndex];
            listArray[maxIndex]=listArray[i];
            listArray[i]=temp;
        }
    }

    private int getMaxIndex(int maxIndex){
        int index=maxIndex;
        for(int i=maxIndex;i>=0;i--){
            if(listArray[index].salary<listArray[i].salary)
                index=i;
        }
        return index;
    }

    void sortAge(){
        for(int i=listArray.length-1;i>=0;i--){
            int maxIndex=getMaxIndexAge(i);

            EmployeeS temp = listArray[maxIndex];
            listArray[maxIndex]=listArray[i];
            listArray[i]=temp;
        }
    }

    private int getMaxIndexAge(int maxIndex){
        int index=maxIndex;
        for(int i=maxIndex;i>=0;i--){
            if(listArray[index].age<listArray[i].age)
                index=i;
        }
        return index;
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
