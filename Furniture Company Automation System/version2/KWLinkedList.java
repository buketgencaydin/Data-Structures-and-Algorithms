package FurnitureCompany;
import java.util.*;


public class KWLinkedList < E >
{
    private Node < E > head = null;
    private Node < E > tail = null;
    private int size = 0;

    public void addFirst(E item)
    {
        add(0, item);
    }

    public void addLast(E item)
    {
        add(size, item);
    }

    public E getFirst()
    {
        return head.data;
    }
    
    public E getLast() {
      return tail.data;
    }
    public boolean isEmpty()
    {
        return (size == 0);
    } 
    public Iterator < E > iterator() {
      return new KWListIter(0);
    }

    public ListIterator < E > listIterator() {
      return new KWListIter(0);
    }

    public ListIterator < E > listIterator(int index) {
      return new KWListIter(index);
    }


    public void add(int index, E obj)
    {
      listIterator(index).add(obj);
    }

    public E get(int index)
    {
      return listIterator(index).next();
    }
    


    private static class Node < E >
    {

      private E data;
      private Node < E > next = null;
      private Node < E > prev = null;

      private Node(E dataItem) {
        data = dataItem;
      }
    } 

    private class KWListIter implements ListIterator < E > {

      private Node < E > nextItem;
      private Node < E > lastItemReturned;
      private int index = 0;

      public KWListIter(int i)
      {
        if (i < 0 || i > size) 
          throw new IndexOutOfBoundsException("Invalid index " + i);

        lastItemReturned = null; 
        if (i == size)
        {
          index = size;
          nextItem = null;
        }
        else
        { 
          nextItem = head;
          for (index = 0; index < i; index++) 
            nextItem = nextItem.next;
        }
      }

      public boolean hasNext()
      {
        return nextItem != null;
      }

      public E next()
      {
        if (!hasNext())
          throw new NoSuchElementException();
        
        lastItemReturned = nextItem;
        nextItem = nextItem.next;
        index++;
        return lastItemReturned.data;
      }

      public boolean hasPrevious()
      {
        return (nextItem == null && size != 0) || nextItem.prev != null;
      }

      public int nextIndex() {
        return index;
      }

      public int previousIndex() {
        return index - 1;
      }

      public E previous()
      {
        if (!hasPrevious()) {
          throw new NoSuchElementException();
        }
        if (nextItem == null) { 
          nextItem = tail;
        }
        else {
          nextItem = nextItem.prev;
        }
        lastItemReturned = nextItem;
        index--;
        return lastItemReturned.data;
      }

      public void add(E obj) {
        if (head == null)
        { 
          head = new Node < E > (obj);
          tail = head;
        }
        else if (nextItem == head)
        { 
          Node < E > newNode = new Node < E > (obj);
          newNode.next = nextItem; 
          nextItem.prev = newNode; 
          head = newNode; 
        }
        else if (nextItem == null)
        { 
          Node < E > newNode = new Node < E > (obj);
          tail.next = newNode; 
          newNode.prev = tail; 
          tail = newNode; 
        }
        else
        { 
          Node < E > newNode = new Node < E > (obj);
          newNode.prev = nextItem.prev; 
          nextItem.prev.next = newNode; 
          newNode.next = nextItem; 
          nextItem.prev = newNode; 
        }
        size++;
        index++;
        lastItemReturned = null;
      } 

      public void remove()
      {
        if (lastItemReturned == null) 
          throw new IllegalStateException();
        
        if (lastItemReturned.next != null) 
          lastItemReturned.next.prev = lastItemReturned.prev;
       
        else
        { 
          tail = lastItemReturned.prev;
          if (tail != null) 
            tail.next = null;
          else 
            head = null;
        }
        if (lastItemReturned.prev != null) 
          lastItemReturned.prev.next = lastItemReturned.next;
        else
        { 
          head = lastItemReturned.next;
          if (head != null) 
            head.prev = null;
          else
            tail = null;
        }
        lastItemReturned = null;
        size--;
        index--;
      }

      public void set(E item)
      {
        if (lastItemReturned == null) 
          throw new IllegalStateException();
      
        lastItemReturned.data = item;
      }
    }

	public int size()
	{
		return size;
	}

	public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }
	public String toString() {
		  Node<E> nodeRef = head;
		  StringBuilder result = new StringBuilder();
		  while (nodeRef != null) {
		    result.append(nodeRef.data);
		    if (nodeRef.next != null) {
		      result.append(" ==> ");
		    }
		    nodeRef = nodeRef.next;
		  }
		  return result.toString();
		}


}