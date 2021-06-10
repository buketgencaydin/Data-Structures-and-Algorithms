package FurnitureCompany;
import java.util.Iterator;

public class HybridList <T> implements Iterable<T>
{
    private static final int MAX_NUMBER = 10;
    private Node<T> head;
    private Node<T> current;
    private int size;
    
    public static class Node<T>
    {
        private KWArrayList<T> data;
        private int nextPos;
        private Node<T> next;
        public Node(int MAX_NUMBER)
        {
            data =  new KWArrayList<T>(MAX_NUMBER);
            nextPos = 0;
            next = null;
        }
    }
    public HybridList()
    {
        head = null;
        current = null;
        size = 0;
    }
	public int size()
	{
		return size;
	}
    public void add(T element)
    {
        if(current == null || current.nextPos == MAX_NUMBER)
        {
            Node<T> newNode = new Node<T>(MAX_NUMBER);
            if(current != null)
            {
                current.next = newNode;
            }
            current = newNode;
        }
        current.data.add(current.nextPos, element);
        current.nextPos++;
        size++;
 
        if(head == null)
        {
            head = current;
        }
    }
    public T get(int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = head;
        int nodeIndex = (index / MAX_NUMBER);

        for(int i = 0; i < nodeIndex; i++)
        {
            node = node.next;
        }
        int dataIndex = index - ((nodeIndex) * MAX_NUMBER) ;

        return (T) node.data.get(dataIndex);
    }
    public T remove(int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        int nodeIndex = (index / MAX_NUMBER);

        for(int i = 0 ; i < nodeIndex ; i++)
        {
            node = node.next;
        }
        
        int dataIndex = index - ((nodeIndex) * MAX_NUMBER);
        T returnValue = (T) node.data.get(dataIndex);
        remove(node,dataIndex);
        return returnValue;
    }
    public String toString()
    {
    	Node<T> node = head;
    	StringBuilder result = new StringBuilder();
		  while (node != null)
		  {
		    result.append(node.data);
		    if (node.next != null)
		    {
		      result.append(" --> ");
		    }
		    node = node.next;
		  }
		  return result.toString();
    }
    private void remove(Node<T> node, int index)
    {
        int location = index, destination = index + 1;
        Node<T> locationNode = node;

        while(locationNode != null)
        {
            if(destination == MAX_NUMBER)
            {
                locationNode = node.next;
                destination = 0;
            }
            if(location == MAX_NUMBER)
            {
                node = node.next;
                location = 0;
            }
            if(locationNode == null)
            {
                node.nextPos--;
            }
            else
            {
                node.data.set(location, locationNode.data.get(destination));
                destination++;
                location++;
            }
        }
    }
    @Override
    public Iterator<T> iterator()
    {
        return new NodeIterator<>(head,MAX_NUMBER);
    }
    class NodeIterator<T> implements Iterator<T>
    {
        private Node<T> current;
        private int elementPos;
        private  int MAX_NUMBER;
        NodeIterator(Node<T> head, int MAX_NUMBER)
        {
            this.current = head;
            elementPos--;
            this.MAX_NUMBER = MAX_NUMBER;
        }
        @Override
        public boolean hasNext()
        {
            elementPos++;
            if(elementPos == MAX_NUMBER)
            {
                current = current.next;
                elementPos = 0;
            }
            return current != null && current.nextPos > elementPos;
        }
        @Override
        public T next()
        {
            return current.data.get(elementPos);
        }
    }
}


