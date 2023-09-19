 package Tree;
import java.util.*;
public class index {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }

                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int lt = height(root.left);
            int rt = height(root.right);

            return Math.max(lt, rt) + 1;

        }

        public static int countNode(Node root) {
            if (root == null) {
                return 0;
            }

            int lt = countNode(root.left);
            int rt = countNode(root.right);

            return lt + rt + 1;

        }

        public static int sumOfNode(Node root) {
            if (root == null) {
                return 0;
            }

            int lt = sumOfNode(root.left);
            int rt = sumOfNode(root.right);

            return lt + rt + root.data;

        }

        // public static int findDiameter(Node root) {

        // }
        public static Info diameter(Node root) {

            if (root == null) {
                return new Info(0, 0);
            }

            Info left = diameter(root.left);
            Info right = diameter(root.right);
            int ht = Math.max(left.ht, right.ht) + 1;
            int diam = Math.max(ht, Math.max(left.diam, right.diam));
            
            return new Info(diam, ht);
        }

        public static void kthLevel(Node root, int k, int i) {
            if(root == null) {
                return;
            }
            if(i == k) {
                System.out.print(root.data + " ");
                return;
            }
            kthLevel(root.left, k, i+1);
            kthLevel(root.right, k, i+1);
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree x = new BinaryTree();
        Node root = x.buildTree(nodes);
        // x.preOrder(root);
        // x.levelOrder(root);
//        System.out.println(x.diameter(root).diam);
//        System.out.println(x.diameter(root).ht);
//        System.out.println(x.hei(root));
        x.kthLevel(root, 3, 1);
    }
}
