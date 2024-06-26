package Q1;

public class List {
    int position;
    int maxSize;
    Student[] listArray;

    public List(int size) {
        position = -1;
        maxSize = size;
        listArray = new Student[maxSize];
    }

    boolean IsListEmpty() {
        return position == 0;
    }

    boolean IsListFull() {
        return position == maxSize - 1;
    }

    int listSize() {
        return position + 1;
    }

    void InsertLast(Student x) {
        if (IsListFull()) {
            System.out.println("List is full");
        } else {
            listArray[++position] = x;
        }
    }

    void InsertList(int p, Student x) {
        if (IsListFull()) {
            System.out.println("list is full");
        } else if (p < 0 || p > listSize()) {
            System.out.println("attempt to insert a position not in the list");
        } else {
            for (int i = listSize(); i > p; i--)
                listArray[i] = listArray[i - 1];
            listArray[p] = x;
            position++;
        }
    }

    public Student DeleteList(int p) {
        if (IsListEmpty()) {
            System.out.println("list is empty");
        } else if (p < 0 || p > listSize()) {
            System.out.println("attempt to delete a position not in the list");
        } else {
            Student element = listArray[p];
            for (int i = p; i < listSize(); i++)
                listArray[i] = listArray[i + 1];
            return element;
        }
        return null;
    }

    public Student RetrieveList(int p){
        if (IsListEmpty()) {
            System.out.println("list is empty");
        } else if (p < 0 || p > listSize()) {
            System.out.println("attempt to retrieve a position not in the list");
        } else {
            return listArray[p];
        }
        return null;
    }

    void sort(){
        for(int i=0;i<listSize();i++){
            int j=i;
            while(j>0){
                if(listArray[j].grade<listArray[j-1].grade){
                    Student temp = listArray[j];
                    listArray[j]=listArray[j-1];
                    listArray[j-1]=temp;
                }
                j--;
            }
        }
    }

    int[] binarySearch(char key) {
        int low = 0;
        int high = listSize() - 1;
        int[] x = new int[10];
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (listArray[mid].grade < key) {
                low = mid + 1;
            } else if (listArray[mid].grade > key) {
                high = mid - 1;
            } else {
                x[count++] = mid;
                int left = mid - 1;
                while (left >= 0 && listArray[left].grade == key) {
                    x[count++] = left;
                    left--;
                }
                int right = mid + 1;
                while (right < listSize() && listArray[right].grade == key) {
                    x[count++] = right;
                    right++;
                }
                // Resize the array to contain only the actual indices found
                int[] result = new int[count];
                System.arraycopy(x, 0, result, 0, count);
                return result;
            }
        }

            return new int[]{-1}; // Return -1 if key is not found


    }

    /*void selectionSort(){
        for(int i=listArray.length-1;i>=0;i--){
            int maxIndex = getMaxIndex(i);
            int temp= listArray[maxIndex];
            listArray[maxIndex]=listArray[i];
            listArray[i]=temp;
        }
    }

    int getMaxIndex(int maxIndex){
        int index = maxIndex;
        for(int i=maxIndex;i<=0;i--){
            if(listArray[index]==listArray[i]);
                index = i;
        }
        return index;
    }

*/

}