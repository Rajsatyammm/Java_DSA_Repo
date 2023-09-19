package Tree;
import java.util.*;
public class BuildPreorderTree {

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
    public static Node root = null;
    static class BinaryTree {

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

        public static void traversePreorder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            traversePreorder(root.left);
            traversePreorder(root.right);
        }

        public static void traverseInorder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            traverseInorder(root.left);
            System.out.print(root.data + " ");
            traverseInorder(root.right);
        }

        public static void traversePostorder(Node root) {
            if (root == null) {
                return;
            }

            traversePostorder(root.left);
            traversePostorder(root.right);
            System.out.print(root.data + " ");

        }

        public static int height(Node root) {

            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            int maxHeight = Math.max(lh, rh) + 1;
            return maxHeight;
        }

        public static int countNodes(Node root) {
            // base case
            if (root == null) {
                return 0;
            }

            // recursive step
            int lNode = countNodes(root.left);
            int rNode = countNodes(root.right);
            return (lNode + rNode + 1);
        }

        public static int sumOfNodes(Node root) {
            // base case
            if (root == null) {
                return 0;
            }

            // recursive step
            int lNode = sumOfNodes(root.left);
            int rNode = sumOfNodes(root.right);
            return (lNode + rNode + root.data);
        }

        public static int findDiameter(Node root) { // T(n) = O(n2)
            // base case
            if (root == null) {
                return 0;
            }
            // recursive step
            int lDia = findDiameter(root.left);
            int rDia = findDiameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int diaUsingRoot = lh + rh + 1;
            return Math.max(diaUsingRoot, Math.max(lDia, rDia));
        }

        public static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root) {
            // base case
            if (root == null) {
                return new Info(0, 0);
            }

            Info left = diameter(root.left);
            Info right = diameter(root.right);
            int ht = Math.max(left.ht, right.ht) + 1;
            int Diam = Math.max(ht, Math.max(left.diam, right.diam));

            return new Info(Diam, ht);
        }

        static Queue<Node> q = new LinkedList<>();

        public static void levelOrder(Node root) {
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

        public static boolean isIdentical(Node node, Node subroot) {
            // if node and subnode both becomes null then return true bcz nthing to cmpare
            if (node == null && subroot == null) {
                return true;
            } else {
                // if node is null but subroot is not null or node.data not equals to
                // subnode.data then return false
                if (node == null || subroot == null || node.data != subroot.data) {
                    return false;
                }
            }

            // cheak if the left part is identical
            if (!isIdentical(node.left, subroot.left)) {
                return false;
            }
            // cheak if the right part is identical
            if (!isIdentical(node.right, subroot.right)) {
                return false;
            }

            return true;
        }

        public static boolean isSubtree(Node root, Node subroot) {
            // base case
            // if root becomes null then return false bcuz nthing left to compare to the
            // subroot
            if (root == null) {
                return false;
            }

            if (root.data == subroot.data) { // found node where the root data is same
                if (isIdentical(root, subroot)) { // cheak the whole subtree is identical to root or not
                    return true;
                }
            }

            // if any of the subtree having the root data equal to subtree data then return
            // true otherwise false
            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);

        }

        public static class Infoo {
            Node node;
            int hd; // horizontal distance

            public Infoo(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root) {

            Queue<Infoo> q = new LinkedList<>(); // for level order traversal
            Map<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;

            q.add(new Infoo(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Infoo curr = q.remove();
                if (curr == null) {
                    // System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Infoo(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);

                    }

                    if (curr.node.right != null) {
                        q.add(new Infoo(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }

        }

        public static void helper(Node node, int level, int k) {
            if (node == null) {
                return;
            }
            if (level == k) {
                System.out.print(node.data + " ");
                return;
            }
            helper(node.left, level + 1, k);
            helper(node.right, level + 1, k);

        }

        public static void kthLevel(Node root, int k) {
            if (k <= 0) {
                return;
            }
            helper(root, 1, k);
        }

        // lowest common ancistor
        public static Node lca(Node root, int n1, int n2) {

            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }

            Node left = lca(root.left, n1, n2);
            Node right = lca(root.right, n1, n2);

            if (right == null) {
                return left;
            }

            if (left == null) {
                return right;
            }

            return root;
        }

        public static int calcHeight(Node curr, int n1) {
            if (curr == null) {
                return -1;
            }
            if (curr.data == n1) {
                return 0;
            }

            int lfht = calcHeight(curr.left, n1);
            int rtht = calcHeight(curr.right, n1);

            if (lfht == -1 && rtht == -1) {
                return -1;
            } else if (lfht == -1) {
                return rtht + 1;
            } else {
                return lfht + 1;
            }

        }

        public static int minmDistbwnNodes(Node root, int n1, int n2) {
            Node curr = lca(root, n1, n2);

            int dist1 = calcHeight(curr, n1);
            int dist2 = calcHeight(curr, n2);

            return dist1 + dist2;
        }

        public static int KAncistor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int lft = KAncistor(root.left, n, k);
            int rght = KAncistor(root.right, n, k);

            if (lft == -1 && rght == -1) {
                return -1;
            }
            int max = Math.max(lft, rght);
            if (max + 1 == k) {
                return root.data;
            }
            return max + 1;
        }

        public static int sumTree(Node root) {
            if(root == null) {
                return 0;
            }
            int left = sumTree(root.left);
            int right = sumTree(root.right);
            int data = root.data;
            int ltData = root.left == null ? 0 : root.left.data;
            int rtData = root.right == null ? 0 : root.right.data;
            root.data = left + right + ltData + rtData;
            return data;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        // int[] subtree = { 2, 4, -1, -1, 5, -1, -1 };
        BinaryTree tree = new BinaryTree();
        // BuildPreorderTree tree = new BuildPreorderTree();
        root = tree.buildTree(nodes);
        // Node subroot = tree.buildTree(subtree);
        // System.out.println(root.data);
        // tree.traversePreorder(root);
        // tree.traverseInorder(root);
        // tree.traverseInorder(subroot);
        // tree.traversePostorder(root);

        // tree.levelOrder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.findDiameter(root));
        // System.out.println(tree.diameter(root).diam);
        // tree.isSubtree(root, );
        // tree.topView(root);
        // tree.kthLevel(root, 3);
        // System.out.println(tree.lca(root, 4, 5).data);
        // System.out.println(tree.minmDistbwnNodes(root, 4, 6));
        // System.out.println(tree.KAncistor(root, 4, 1));
        System.out.println(tree.sumTree(root));
        tree.traversePreorder(root);
    }
}