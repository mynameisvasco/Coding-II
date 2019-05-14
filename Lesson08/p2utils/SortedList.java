package p2utils;

public class SortedList<E extends Comparable<E>>
{
  // private attributes
  private Node<E> first = null;
  private int size = 0;

  public SortedList() { }

  /**
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";
      return first.elem;
  }

  /** Inserts a new element in the list.
   * @param e the element to be inserted
   */
  public void insert(E e) {
    first = insert(first,e);
    size++;
  }
  private Node<E> insert(Node<E> n,E e) {
    if (n==null || e.compareTo(n.elem) == -1) 
      return new Node(e,n);
    n.next = insert(n.next,e);
    return n;
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
  }

  /** Checks if the list is sorted.
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    if (size < 2)
      return true;
    return isSorted(first,first.next); 
  }
  private boolean isSorted(Node<E> prev,Node<E> n) {
    if (n == null) return true;
    if (n.elem.compareTo(prev.elem) == -1) return false;
    return isSorted(n,n.next);
  }

  public boolean contains(E e) 
  {
    if(this.isEmpty()) return false;
    return contains(this.first, e, this.size());
  }

  private boolean contains(Node<E> n, E e, int pos)
  { 
    if(n.elem.equals(e) && pos > 0)
    {
      return true;
    }
    else if(pos == 0)
    {
      return false;
    }
    --pos;
    return contains(n.next, e, pos);
  }

  public String toString()
  {
    String s = "[";
    Node<E> n = this.first;
    for(int i = 0; i < this.size(); i++)
    {
      s += n.elem + (i != this.size() - 1 ? "," : "");
      n = n.next;
    }
    s += "]";
    return s;
  }

  public SortedList<E> merge(SortedList<E> list2)
  {
    Node<E> n = this.first;
    SortedList<E> merged = new SortedList<E>();

    for(int i = 0; i < this.size(); i++)
    {
      merged.insert(n.elem);
      n = n.next;
    }

    n = list2.first;

    for(int i = 0; i < list2.size(); i++)
    {
      merged.insert(n.elem);
      n = n.next;
    }

    return merged;
  }
}
