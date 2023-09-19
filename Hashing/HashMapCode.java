
package Hashing;
import java.security.Key;
import java.util.*;

public class HashMapCode {

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // no of nodes in bucket
        private int N;

        private LinkedList<Node> buckets[];

        @SuppressWarnings("uncheaked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int idx = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return idx;
                }
                idx++;
            }
            return -1;
        }

        @SuppressWarnings("uncheaked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // T(n) = O(lambda) O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            // if di = -1 key not exist
            // else key exist and we have to update the value

            if (di != -1) { // update
                Node node = buckets[bi].get(di);
                node.value = value;
            } else { // add new Node
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { // T(n) = O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) { // T(n) = O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) { // key exist
                Node node = buckets[bi].get(di);
                return node.value;
            } else { // key doesn't exist
                return null;
            }
        }

        public V remove(K key) { // T(n) = O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) { // update
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else { // add new Node
                return null;
            }
        }

        public List<K> keySet() {
            List<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node N : ll) {
                    keys.add(N.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 100);
        hm.put("US", 80);

        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Pak"));

        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
        // System.out.println(hm);
        List<String> key = new ArrayList<>();
        key = hm.keySet();
        System.out.println(key);
    }
}
