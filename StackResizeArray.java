/**
 * Created with IntelliJ IDEA.
 * User: Gong Li
 * Date: 5/25/13
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackResizeArray <T> {
    T[] content;
    int size;

    public static void main(String[] args) {
        StackResizeArray stack = new StackResizeArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());
        try {
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(stack.toString());

    }

    public StackResizeArray(){
        this.content = (T[]) new Object[1];
        this.size = 0;
    }

    /*
    * This is a method which resizes the capacity of the array of the stack
    * @author Gong Li
    * @param capacity the expected size of the array in this stack
    * */
    private void resize(int capacity){
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i ++){
            copy[i] = this.content[i];
        }

        this.content = copy;
    }

    public void push(T item){
        if (this.size == content.length)
            resize(2*this.size);
        content[size ++] = item;
    }

    public T pop() throws Exception {
        if (size == 0) throw new Exception("This stack is empty!");

        T item = content[--size];
        content[size] = null;
        if (size > 0 && size == content.length / 4)
            resize(content.length / 2);
        return  item;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i ++){
            T t = content[i];
            sb.append(t.toString()+" ");
        }
        return  sb.toString();
    }

}
