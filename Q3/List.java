package Q1;

public class List {
    private int maxSize ;
    private int position;
    private Student[] ListEntry;
    List(int size)
    {
        maxSize = size;
        ListEntry = new Student[maxSize];
        position= -1;
    }

    boolean IsListEmpty()
    {
        return (position==-1);
    }

    boolean IsListFull()
    {
        return (position== maxSize-1);
    }

    int ListSize()
    {
        return (position+1);
    }

    void InsertLast(Student x)
    {
        if (IsListFull())
            System.out.println("Attempt to insert at the end of a full list");
        else
            ListEntry[++position] = x;
    }

    void InsertList(int p, Student element)
    { int i;
        if (IsListFull())
            System.out.println("Attempt to insert an entry into a full list");
        else if (p < 0 || p > ListSize())
            System.out.println("attempt to insert a position not in the list");
        else
        {
            for( i = ListSize(); i >p; i--)
                ListEntry[i] = ListEntry[i-1];
            ListEntry[p] = element;
            position++;
        }
    }

    Student DeleteList( int p) {
        int i;
        if (IsListEmpty())
            System.out.println("Attempt to delete an entry from an empty list");
        else if (p < 0 || p >= ListSize())
            System.out.println("attempt to delete a position not in the list");
        else {
            Student element = ListEntry[p];
            for( i = p; i < ListSize()-1; i++)
                ListEntry[i] = ListEntry[i+1];
            position--;
            return element;
        }
        return null; }

    Student RetrieveList(int p ){
        int i;
        if (IsListEmpty()){
            System.out.println("Attempt to retrieve an entry from an empty list");
            return null;}
        else if (p < 0 || p >= ListSize()){
            System.out.println("attempt to retrieve an entry at a position not in the list");
            return null; }
        else{
            Student element = ListEntry[p];
            return element;}
    }

    void ReplaceList (int p, Student x){
        int i;
        if (IsListEmpty())
            System.out.println("Attempt to replace an entry of an empty list");
        else if (p < 0 || p >= ListSize())
            System.out.println("attempt to replace an entry at a position not in the list");
        else
            ListEntry[p] = x;
    }

    void TraverselList()
    {
        int i;
        for (i=0; i<position+1; i++)
            System.out.println(ListEntry[i]);
    }

    void sort() {
        for (int i = ListEntry.length-1 ; i >= 0; i--) {
            int maxIndex = getMaxIndex(i);
            Student temp = ListEntry[maxIndex];
            ListEntry[maxIndex] = ListEntry[i];
            ListEntry[i] = temp;
        }
    }

    int getMaxIndex(int maxIndex)
    {
        int Index = maxIndex ;
        for (int i = maxIndex; i >=0 ; i--)
        {
            if(ListEntry[Index].GPA<ListEntry[i].GPA)
                Index = i;
        }
        return Index;
    }




}

