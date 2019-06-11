/**
 * Created with IntelliJ IDEA.
 * User: Gong Li
 * Date: 5/25/13
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueueLinkedList<T> {

    public static void main(String[] args) {
        QueueLinkedList<Integer> q = new QueueLinkedList<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());
    }
    private class Node{
        T item;
        Node next;

        Node(T t){
            item = t;
            next = null;
        }

        public String toString()  {
            return  item.toString();
        }
    }


    private Node first, last;

    QueueLinkedList (){
        first = null;
        last = null;
    }


    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(T t){
        Node oldLast = last;
        last = new Node(t);
        if (isEmpty()) first = last;
        else   oldLast.next = last;
    }

    public T dequeue(){
        if (isEmpty())
            return  null;

        if (first == last){
            T t = (T) first.item;
            first = last = null;
            return  t;
        }

        T t = (T) first.item;
        first = first.next;
        return t;
    }

    public String toString(){
        if (first == null)
            return null;

        if (first == last)
            return first.item.toString();

        StringBuffer sb = new StringBuffer();
        Node cur = first;
        while(cur != last){
            sb.append(cur.item.toString()+" ");
            cur = cur.next;
        }
        sb.append(last.item.toString());
        return sb.toString();
    }

}
