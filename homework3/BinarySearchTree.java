package homework3;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    /**
     * Wenhan Cai
     * CS 5006 homework 3-1
     * Build a Binary Search Tree that allows duplicates
     */

    //BSTNode class
    static class BSTNode {
        int data;
        int count;
        BSTNode left, right;
    };

    BSTNode root;

    /**
     * BST constructor
     */
    public BinarySearchTree(){
        root = null;
    }

    /**
     * convert an integer to a BSTNode type
     * @param data
     * @return BSTNode
     */
    //create a new BST node
    static BSTNode createNode(int data) {
        BSTNode nodePtr = new BSTNode();
        nodePtr.data = data;
        nodePtr.left = null;
        nodePtr.right = null;
        nodePtr.count = 1;
        return nodePtr;
    }

    /**
     * check is the BST with root is empty
     * @param root
     * @return boolean
     */
    static boolean isEmpty(BSTNode root){
        return root == null;
    }

    /**
     * returns true if data is found in tree pointed to by root, else false
     * @param root
     * @param data
     * @return boolean
     */
    static boolean find(BSTNode root, int data){
        while(root != null){
            if(root.data > data){
                root = root.left;
            }
            else if(root.data < data){
                root = root.right;
            } else{ return true;}
        }
        return false;
    }

    /**
     * returns true if data is found in tree pointed to by root, else false
     * if found, delete (first) node containing data
     * @param root
     * @param data
     * @return
     */
    static boolean findAndDelete(BSTNode root, int data){
        if (find(root, data)){
            deleteNodeFirst(root, data);
            return true;
        }
        return false;
    }

    //pre-order traversal of BST
    static void walkPreOrder(BSTNode root){
        if(root == null) return;
        System.out.print(root.data + "(" + root.count + ") ");
        walkPreOrder(root.left);
        walkPreOrder(root.right);
    }

    //inorder traversal of BST
    static void walkInOrder(BSTNode root){
        if(root == null) return;
        walkInOrder(root.left);
        System.out.print(root.data + "(" + root.count + ") ");
        walkInOrder(root.right);
    }

    //post-order traversal of BST
    static void walkPostOrder(BSTNode root){
        if(root == null) return;
        walkPreOrder(root.left);
        walkPreOrder(root.right);
        System.out.print(root.data + "(" + root.count + ") ");
    }

    /**
     * walk tree pointed to by root using BFS traversal
     * @param root
     */
    public static void walkBreadthFirst(BSTNode root){
        Queue<BinarySearchTree.BSTNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            BinarySearchTree.BSTNode node = queue.remove();
            System.out.print(" " + node.data);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    /**
     * insert node pointed to by nodePtr into tree pointed to by root, returns true if successful, false otherwise
     * @param root
     * @param nodePtr
     * @return
     */
    static BSTNode insert(BSTNode root, BSTNode nodePtr){
        if (root == null) return nodePtr;

        if (nodePtr.data == root.data){
            (root.count)++;
            return root;
        }

        if (nodePtr.data < root.data)
            root.left = insert(root.left, nodePtr);
        else
            root.right = insert(root.right, nodePtr);
        return root;
    }

    /**
     * utility method: find the node with minimum value in the BST with given node
     * @param node
     * @return node
     */
    static BSTNode minValueNode(BSTNode node) {
        BSTNode current = node;

        while (current.left != null)
            current = current.left;
        return current;
    }

    /**
     * utility method: delete the first node found in the BST with given root and value
     * @param root
     * @param value
     * @return node
     */
    static BSTNode deleteNodeFirst(BSTNode root, int value) {
        if (root == null) return null;

        if (value < root.data)
            root.left = deleteNodeFirst(root.left, value);

        else if (value > root.data)
            root.right = deleteNodeFirst(root.right, value);

        else {
            if (root.count > 1) {
                (root.count)--;
                return root;
            }

            // node with only one child or no child
            if (root.left == null) {
                BSTNode temp = root.right;
                root=null;
                return temp;
            }
            else if (root.right == null) {
                BSTNode temp = root.left;
                root = null;
                return temp;
            }
            // node with two children: Get the inorder successor (smallest in the right subtree)
            BSTNode temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = deleteNodeFirst(root.right, temp.data);
        }
        return root;
    }

    /**
     * utility method: delete the node(and all its duplicates) with given root and value
     * @param root
     * @param value
     * @return
     */
    static BSTNode deleteNodeAll(BSTNode root, int value) {
        if (root == null) return null;

        if (value < root.data)
            root.left = deleteNodeAll(root.left, value);

        else if (value > root.data)
            root.right = deleteNodeAll(root.right, value);

        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValueNode(root.right).data;
            root.right = deleteNodeAll(root.right, root.data);
        }
        return root;
    }

    /**
     * returns true if data is found in tree pointed to by root and, else false
     * delete all nodes containing data
     * @param root
     * @param data
     * @return boolean
     */
    static boolean findAndDeleteAll(BSTNode root, int data){
        if(find(root, data)){
            deleteNodeAll(root, data);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {


        int[] a = new int[]{15, 8, 53, 101, 4, 22, 3, 27, 1, 0, -3, 7, 12, 10, 5, 1, 8};

        // Test Empty Tree
        BSTNode root = null;
        System.out.println("Test isEmpty? " + isEmpty(root));
        // Walk and delete empty tree
        walkInOrder(root);

        // create root node
        root = createNode(11);

        // build tree
        for (int anA : a) {
            BSTNode newNode = createNode(anA);
            insert(root, newNode);
        }

        // check traversal methods
        System.out.println("\n************** InOrder *****************");
        walkInOrder(root);
        System.out.println("\n************** PreOrder *****************");
        walkPreOrder(root);
        System.out.println("\n************** PostOrder *****************");
        walkPostOrder(root);
        System.out.println("\n************** BreadthFirst *****************");
        walkBreadthFirst(root);
        System.out.println("\n********** Test Other Methods *************");

        // check find and findAndDeleteAll
        System.out.println("Number 22 in tree?  " + find(root, 22) );
        System.out.println("Number 1 in tree?  " + find(root, 1));
        System.out.println("Deleting number 1");
        findAndDeleteAll(root, 1);
        System.out.println("Number 1 in tree?  " + find(root, 1));
        System.out.println("************** InOrder (No 1's)*****************");
        walkInOrder(root);
    }
}
