package HashTabDemo;

import java.util.Scanner;

public class hashtabdemo {
    public static void main(String[] args){

        HashTab hashtab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("find");
            System.out.println("exit");

            key = scanner.next();
            switch (key){
                case "add":
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashtab.add(emp);
                    break;
                case "list":
                    hashtab.list();
                    break;
                case "find":
                    id = scanner.nextInt();
                    hashtab.findEmpId(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class HashTab{
    private EmpLinkList[] empLinkListsArray;
    private int size;

    public HashTab(int size){
        this.size = size;
        empLinkListsArray = new EmpLinkList[size];
        //分别初始化每一条链表
        for (int i = 0;i<size;i++){
            empLinkListsArray[i] = new EmpLinkList();
        }
    }

    public void add(Emp emp){
        int empLinkedListNO = hashFun(emp.id);
        empLinkListsArray[empLinkedListNO].add(emp);

    }

    public void list(){
        for (int i = 0;i < size;i++){
            empLinkListsArray[i].list(i);
        }
    }

    public void findEmpId(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkListsArray[empLinkedListNO].findEmpId(id);
        if (emp != null){
            System.out.printf("list%d id:%d\n",empLinkedListNO+1,id);
        }else {
            System.out.println("not found");
        }
    }

    public int hashFun(int id){
        return id % size;
    }

}



class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id,String name) {
        super();
        this.name = name;
        this.id = id;
    }
}

class EmpLinkList{
    private Emp head;
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no){
        if (head == null){
            System.out.println(no+1+"null");
            return;
        }
        System.out.print(no+1+"information=>");
        Emp curEmp = head;
        while (true){
            System.out.printf("id:%d name:%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpId(int id){
        if (head == null){
            System.out.println("null");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}