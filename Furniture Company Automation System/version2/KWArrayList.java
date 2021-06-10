package FurnitureCompany;

public class KWArrayList<E>
{
    private static final int INITIAL_CAPACITY = 10;
    private E[] theData;
    private int size = 0;
    private int capacity = 0;
    
    public KWArrayList()
    {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }
    public KWArrayList(int MAX_NUMBER)
    {
        capacity = MAX_NUMBER;
        theData = (E[]) new Object[capacity];
    }
    
    public int size()
    {
        return size;
    }
        
    public boolean add(E anEntry)
    {
        if(size == capacity)
            reallocate(); 
 
        theData[size] = anEntry;
        size++;
        return true;
    }
    
    public void add(int index, E anEntry)
    {
        if(index<0 || index>size)
        {
        	 throw new ArrayIndexOutOfBoundsException(index);
        }
        
        if(size == capacity) 
            reallocate();
        
        for(int i=size ; i>index ; i--) 
            theData[i] = theData[i-1];
        
        theData[index] = anEntry;
        size++;
    }
    
    public E get(int index)
    {

        if(index<0 || index>=size) 
            throw new ArrayIndexOutOfBoundsException(index);
        
        return theData[index];
    }
    
    public E set(int index, E newValue)
    {
        if(index<0 || index>=size) 
            throw new ArrayIndexOutOfBoundsException(index);
        
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }
    
    public E remove(int index)
    {
        if(index<0 || index>=size) 
            throw new ArrayIndexOutOfBoundsException(index);
        
        E returnValue = theData[index];
        for(int i=index+1 ; i<size ; i++) 
            theData[i-1] = theData[i];
        
        size--;
        return returnValue;
    }
    
    private void reallocate()
    {
        capacity = 2 * capacity;
		E[] newData = (E[])new Object[capacity];
        System.arraycopy(theData, 0, newData, 0, size);
        theData = newData;
    }
    public String toString()
    {
        StringBuilder s = new StringBuilder("[");
        for (int i=0; i<size-1; i++){
            s.append(theData[i]+", \n");
        }
        if (size>0)
            s.append(theData[size-1]);
        s.append("]");
        return s.toString();
    }

}