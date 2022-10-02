package ArrayStack;

import java.util.Scanner;

public class Arraystack {
    public static void main(String[] args){

        ArrayStack1 stack = new ArrayStack1(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            System.out.println("chose");

            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    int value =scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("pop:%d",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("EXIT~~~");
    }

}
class ArrayStack1 {
    private int maxsize;
    private int[] stack;
    private int top = -1;

    public ArrayStack1(int maxsize){
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    public boolean isfull(){
        return top == maxsize - 1;
    }

    public boolean isempty(){
        return top == -1;
    }

    public void push(int value){
        if (isfull()){
            System.out.println("full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isempty()){
            throw new RuntimeException("empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if (isempty()){
            System.out.println("full");
            return;
        }
        for (int i = top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
