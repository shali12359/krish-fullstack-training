public class ReverseLinkedList {
    // FIRST NODE OF THE LIST
    static Node firstNode;

    static class Node{
        // VARIABLE FOR HOLD PASSED VALUES TO LIST
        int number;
        // NEXT NODE OF THE LIST
        Node nextNode;

        // SET LIST ITEM VALUE
        Node(int num){
            number = num;
            nextNode = null;
        }
    }

    // METHOD FOR REVERSE LIST
    Node reverse(Node node){
        // SET INITIAL NODES
        Node prevNode = null;
        Node currentNode = node;
        Node nextNode = null;

        // GO THROUGH THE LIST
        while(currentNode != null){
            nextNode = currentNode.nextNode;
            currentNode.nextNode = prevNode;
            prevNode = currentNode;
            currentNode = nextNode ;
        }

        node = prevNode;

        return node;
    }


    // METHOD FOR PRINT LISTS
    void printLinkedList(Node node){
        while(node != null){
            System.out.print(node.number + " ");
            node = node.nextNode;
        }
    }

    public static void main(String args[]){
        ReverseLinkedList list = new ReverseLinkedList();

        // SET VALUES FOR THE LIST
        list.firstNode = new Node(10);
        list.firstNode.nextNode = new Node(20);
        list.firstNode.nextNode.nextNode = new Node(30);
        list.firstNode.nextNode.nextNode.nextNode = new Node(40);
        list.firstNode.nextNode.nextNode.nextNode.nextNode = new Node(50);

        System.out.print("Linked List : ");
        // PRINT LIST
        list.printLinkedList(firstNode);

        // REVERSE LIST
        firstNode = list.reverse(firstNode);
        System.out.println("");

        System.out.print("Reversed Linked List : ");
        // PRINT LIST
        list.printLinkedList(firstNode);
    }
}
