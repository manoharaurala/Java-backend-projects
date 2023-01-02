import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class BFS {
    static ArrayList<Integer> levelOrder(Node node){
        ArrayList<Integer>output=new ArrayList<>();
        if(node==null){
            return output;
        }

        Queue <Node> q1=new ArrayDeque();
        q1.add(node);

        while(!(q1.isEmpty())){
            Node tempNode=q1.poll();
            output.add(tempNode.data);
            if(tempNode.left!=null){
                q1.add(tempNode.left);
            }
            if(tempNode.right!=null){
                q1.add(tempNode.right);
            }

        }
        return output;

    }
    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        ArrayList<Integer> a;
        a = levelOrder(node);
        Iterator i1 = a.iterator();
        while (i1.hasNext()) {
            System.out.print(i1.next() + " ");
        }
    }

}

class Node{
    int data;
    Node left,right;
    Node(int item){
        data=item;
        left=right=null;
    }
}
