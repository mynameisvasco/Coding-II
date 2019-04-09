package p2utils;

class Node<E> {

  final E elem;
  Node<E> next;

  Node(E e, Node<E> n) {
    elem = e;
    next = n;
  }

  Node(E e) {
    elem = e;
    next = null;
  }

  public Node<E> next()
  {
    return this.next;
  }

  public E elem()
  {
    return this.elem;
  }
}


