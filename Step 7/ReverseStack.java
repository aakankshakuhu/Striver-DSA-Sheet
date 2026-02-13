import java.util.Stack;
public class ReverseStack {

    
    public static void insertAtBottom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int topVal = stack.pop();
        insertAtBottom(stack, val);

        stack.push(topVal);
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int topVal = stack.pop();
        reverse(stack);

        insertAtBottom(stack, topVal);
    }


    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        reverse(stack);

        System.out.print("Reversed Stack: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
