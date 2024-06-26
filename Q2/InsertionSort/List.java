package InsertionSort;

public class List {
    int maxSize;
    int position;
    Employee[] listArray;

    public List(int size){
        maxSize=size;
        position=-1;
        listArray=new Employee[maxSize];
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

    public void InsertLast(Employee x){
        if(IsListFull()){
            System.out.println("List is full");
        }
        else{
            listArray[++position]=x;
        }
    }

    void InsertList(int p,Employee x){
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

    Employee deleteList(int p){
        if(IsListEmpty()){
            System.out.println("List is empty");
        }
        else if(p<0||p>listSize()){
                System.out.println("attempt to delete an entry at position not in the list");
        }
        else{
           Employee element = listArray[p];
           for(int i=p;i<listSize();i++)
               listArray[i]=listArray[i+1];
           return element;
        }
        return null;
    }

    Employee RetrieveList(int p){
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
        for(int i=0;i<listSize();i++){
            int j=i;
            while(j>0){
                if(listArray[j].salary<listArray[j-1].salary){
                    Employee temp = listArray[j];
                    listArray[j]=listArray[j-1];
                    listArray[j-1]=temp;
                }
                j--;
            }
        }
    }

    void sortAge(){
        for(int i=0;i<listSize();i++){
            int j=i;
            while(j>0){
                if(listArray[j].age<listArray[j-1].age){
                    Employee temp = listArray[j];
                    listArray[j]=listArray[j-1];
                    listArray[j-1]=temp;
                }
                j--;
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
