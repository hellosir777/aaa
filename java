import java.util.*;
class Node{
    int info;
    Node link;
}
public class aaa {
    static Scanner sc = new Scanner(System.in);
    static Node start = null;
    public static void create(Node p) {
        p = new Node();
        System.out.println("enter info part");
        p.info = sc.nextInt();
        p.link = null;
        start = p;
        System.out.println("do you want to craete more node? y/n");
        char ch = sc.next().charAt(0);
        while (ch == 'y') {
            Node q = new Node();
            System.out.println("enter info part");
            q.info = sc.nextInt();
            p.link = q;
            q.link = null;
            p = q;
            System.out.println("do you want to craete more node? y/n");
            ch = sc.next().charAt(0);
        }
    }
    public static void display (Node p) {
        while (p != null) {
            System.out.print(p.info + " ---> ");
            p = p.link;
        }
        System.out.println();
    }
    public static void insBeg () {
        Node p = new Node();
        System.out.println("Enter info");
        p.info = sc.nextInt();
        p.link = start;
        start = p;
    }
    public static void insEnd () {
        Node p = new Node();
        System.out.println("enter info");
        p.info = sc.nextInt();
        p.link = null;
        if (start == null)
            start = p;
        else {
            Node q = start;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
    }
    public static void insAny () {
        Node p = new Node();
        Node q = start;
        System.out.println("enter info");
        p.info = sc.nextInt();
        System.out.println("enter location");
        int loc = sc.nextInt();
        for (int i = 1; i < loc-1 && q.link != null; i++) {
            q = q.link;
        }
        p.link = q.link;
        q.link = p;
    }
    public static void delBeg () {
        start = start.link;
    }
    public static void delEnd (Node temp) {
        Node p = temp;
        Node q = new Node();
        while (p != null) {
            q = p;
            p = p.link;
        }
        q.link = null;
    }

    public static void main(String[] args) {
        create(start);
        display(start);
        insBeg();
        display(start);
        insEnd();
        display(start);
        insAny();
        display(start);
        delBeg();
        display(start);
        delEnd(start);
        display(start);
    }
}
