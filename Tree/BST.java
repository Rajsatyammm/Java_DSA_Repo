package Tree;
import java.util.*;
import java.util.LinkedList;

public class BST {
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

    // public static Node root = null;
    static class BinaryTree {
        // static int i;
        public static Node addInBST(Node root, int data) {

            Node newNode = new Node(data);
            if (root == null) {
                root = newNode;
                return root;
            }

            if (data <= root.data) {
                root.left = addInBST(root.left, data);
            } else {
                root.right = addInBST(root.right, data);
            }
            return root;
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        static Queue<Node> q = new LinkedList<>();

        public static void levelOrder(Node root) {
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (!q.isEmpty()) {
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

        public boolean search(Node root, int data) {
            if (root == null) {
                return false;
            }
            if (root.data == data) {
                return true;
            }
            // boolean left, right;
            if (data > root.data) {
                return search(root.right, data);
            } else {
                return search(root.left, data);
            }

        }

        public static Node delete(Node root, int data) {
            if (root == null) {
                return null;
            }
            if (root.data > data) {
                root.left = delete(root.left, data);
            } else if (root.data < data) {
                root.right = delete(root.right, data);
            } else {
                // root.data == data
                // case 1 : no child
                if (root.left == null && root.right == null) {
                    return null;
                }

                // case 2 : one child
                if (root.left == null) {
                    return root.right;
                }

                if (root.right == null) {
                    return root.left;
                }

                // case 3 : two child
                Node IS = findInorderSuccesor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
            return root;
        }

        public static Node findInorderSuccesor(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public static void printInRange(Node root, int k1, int k2) {
            if (root == null) {
                return;
            }
            if (root.data >= k1 && root.data <= k2) {
                printInRange(root.left, k1, k2);
                System.out.print(root.data + " ");
                printInRange(root.right, k1, k2);
            } else if (root.data < k1) {
                printInRange(root.right, k1, k2);
            } else {
                printInRange(root.left, k1, k2);
            }
        }

        public static void path() {
            for (int i = 0; i < path.size(); i++) {
                // Node pth = path.get
                System.out.print((path.get(i)).data + " -> ");
            }
            System.out.println("Null");
        }

        static ArrayList<Node> path = new ArrayList<>();

        public static void printPath(Node root) {
            if (root == null) {
                return;
            }

            path.add(root);
            if (root.left == null && root.right == null) {
                path();
            }
            if (root.left != null) {
                printPath(root.left);
            }
            if (root.right != null) {
                printPath(root.right);
            }
            path.remove(path.size() - 1);
        }

        // Validate BST
        // Approach : 1
        public static ArrayList<Integer> list = new ArrayList<>();

        public static void storeInorder(Node root) {
            if (root == null) {
                return;
            }
            storeInorder(root.left);
            list.add(root.data);
            storeInorder(root.right);
        }

        public static boolean cheakBST() {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        // Approach : 2
        public static boolean isValidBST(Node root, Node min, Node max) {
            // initially min && max == null
            if (root == null) {
                return true;
            }

            if (min != null && root.data <= min.data) {
                return false;
            } else if (max != null && root.data >= max.data) {
                return false;
            }

            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }

        public static Node mirrorBST(Node root) {
            if (root == null) {
                return null;
            }

            Node leftMirror = mirrorBST(root.left);
            Node rightMirror = mirrorBST(root.right);
            root.left = rightMirror;
            root.right = leftMirror;

            return root;
        }

        public static Node  buildBSTFromSA(Node root, int[] arr, int si, int ei) {
            if (si > ei) {
                return null;
            }
            int mid = si + (ei - si) / 2;

            root = new Node(arr[mid]);
            root.left = buildBSTFromSA(root, arr, si, mid - 1);
            root.right = buildBSTFromSA(root, arr, mid + 1, ei);

            return root;
        }

        public static Node buildBST_Sa(Node root, int[] arr, int si, int ei) {
            if(si > ei) {
                return null;
            }
            int mid = si + (ei - si) / 2;

            root = new Node(arr[mid]);
            root.left = buildBST_Sa(root, arr, si, mid-1);
            root.right = buildBST_Sa(root, arr, mid+1, ei);
            return root;
        }

        public static ArrayList<Integer> l = new ArrayList<>();

        public static void inOrderr(Node root) {
            if (root == null) {
                return;
            }
            inOrderr(root.left);
            l.add(root.data);
            inOrderr(root.right);
        }

        public static Node balancedBST(Node root, int si, int ei) {
            if (si > ei) {
                return null;
            }
            int mid = (si + ei) / 2;
            root = new Node(l.get(mid));
            root.left = balancedBST(root, si, mid - 1);
            root.right = balancedBST(root, mid + 1, ei);
            return root;
        }

        public static class Info {
            boolean isValid;
            int size;
            int min;
            int max;

            public Info(boolean isValid, int size, int min, int max) {
                this.isValid = isValid;
                this.size = size;
                this.min = min;
                this.max = max;
            }
        }

        public static int maxBSTSize = 0;

        public static Info largestBST(Node root) {
            if (root == null) {
                return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            Info leftInfo = largestBST(root.left);
            Info rightInfo = largestBST(root.right);

            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

            if (root.data <= leftInfo.max && root.data >= rightInfo.min) {
                return new Info(false, size, min, max);
            }

            if (leftInfo.isValid && rightInfo.isValid) {
                maxBSTSize = Math.max(maxBSTSize, size);
                return new Info(true, size, min, max);
            }

            return new Info(false, size, min, max);
        }

        // merge two BST
        public static Node mergeBST(Node root1, Node root2) {
            ArrayList<Integer> list1 = new ArrayList<>();
            inOrderStore(root1, list1);
            ArrayList<Integer> list2 = new ArrayList<>();
            inOrderStore(root2, list2);

            // merging list1 && list2
            ArrayList<Integer> finalList = new ArrayList<>();

            int i = 0, j = 0;
            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i) <= list2.get(j)) {
                    finalList.add(list1.get(i));
                    i++;
                } else {
                    finalList.add(list2.get(j));
                    j++;
                }
            }

            while (i < list1.size()) {
                finalList.add(list1.get(i));
                i++;
            }

            while (j < list1.size()) {
                finalList.add(list2.get(j));
                j++;
            }
            
            return buildBST(finalList, 0, finalList.size() - 1);
        }

        public static void inOrderStore(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
            inOrderStore(root.left, list);
            list.add(root.data);
            inOrderStore(root.right, list);
        }

        public static Node buildBST(ArrayList<Integer> list, int si, int ei) {
            if (si > ei) {
                return null;
            }
            int mid = (si + ei) / 2;
            Node root = new Node(list.get(mid));
            root.left = buildBST(list, si, mid - 1);
            root.right = buildBST(list, mid + 1, ei);

            return root;
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // int nodes[] = { 6, 10, 8, 9, 7, 12, 3, 4, 5, 2, 1 };
        // int nodes[] = { 8, 6, 5, 3, 10, 11, 12 };
        // // int nodes[] = { };
        // Node root = null;
        // for (int i = 0; i < nodes.length; i++) {
        // root = tree.addInBST(root, nodes[i]);
        // }

//        Node root1 = new Node(2);
//        root1.left = new Node(1);
//        root1.right = new Node(4);
//
//        Node root2 = new Node(9);
//        root2.left = new Node(3);
//        root2.right = new Node(12);

        // Node root = tree.mergeBST(root1, root2);
//        tree.levelOrder(tree.mergeBST(root1, root2));

         int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
         Node root = tree.buildBST_Sa(null, arr, 0, arr.length - 1);
        // int arr[] = { 8, };
        // int si = 0, ei = arr.length - 1;
        // for (int i = 0; i < arr.length; i++) {
        // int mid = si + (ei - si) / 2;
        // tree.addInBST(null, mid);

        // }
//         root = tree.buildBSTFromSA(root, arr, si, ei);

        // System.out.println();
         tree.inOrder(root);
        // System.out.println();
        // System.out.println(tree.search(root, 10));
        // System.out.println(tree.search(root, 19));

        // root = tree.delete(root, 5);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.printInRange(root, 1, 6);
        // tree.printPath(root);
        // static ArrayList<Integer> lis = new ArrayList<>();
        // tree.storeInorder(root);
        // System.out.println(tree.cheakBST());
        // System.out.println(tree.isValidBST(root, null, null));
        // tree.inOrder(root);
        // tree.levelOrder(root);
        // tree.inOrderr(root);
        // root = tree.balancedBST(root, 0, 6);
        // System.out.println();
        // root = tree.mirrorBST(root);
        // // tree.inOrder(root);
        // tree.levelOrder(root);

        // tree.largestBST(root);
        // System.out.println(tree.maxBSTSize);
        System.out.println();
    }
}
