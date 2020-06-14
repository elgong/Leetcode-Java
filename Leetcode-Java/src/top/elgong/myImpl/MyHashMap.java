package top.elgong.myImpl;

import java.util.Map;

/*
*  自己实现的hashmap ：
*   待优化：
*           1. 扩容机制
*           2. 红黑树
* */
// public class MyHashMap<K, V> implements Map<K, V> {
public class MyHashMap<K, V> {

    // 内部节点
    static class Node<K, V> {
        final K key;
        // final int hash;
        V value;
        Node<K, V> nextNode;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        V getValue(){
            return value;
        }

        K getKey(){
            return key;
        }

        void setValue(V value){
            this.value = value;
        }
    }


    private Node[] table;
    private int size;
    private int INIT_CAP = 16;

    public MyHashMap( int cap) {
        // 擦拭农户
        if (cap < INIT_CAP){
            cap = INIT_CAP;
        }

        table = new Node[cap];
    }

    public void put(K key, V value){

        int hash = 0;
        Node<K, V> node;
        if (key != null){
            hash = key.hashCode() ^ (key.hashCode() >>> 16);
        }
        // 可优化
        int index = hash % table.length;

        // 第一个位置为空
        if ((node =table[index]) == null){
            table[index] = new Node(key, value);
        } else {
            while (node.nextNode != null){
                node = node.nextNode;
                if (node.key == key || node.key.equals(key)){
                    node.setValue(value);
                    break;
                }
            }

            if (node.nextNode == null){
                node.nextNode = new Node(key, value);
            }
        }
    }

    public V get(K key){

        int hash = 0;

        if (key != null){
            hash =  key.hashCode() ^ (key.hashCode() >>> 16);
        }

        int index = hash % table.length;

        Node<K, V> node = table[index];

        if (node == null){
            return null;
        } else if (node.key == key || node.key.equals(key)){
            return node.value;
        } else{

            do{
                node = node.nextNode;
                if (node != null && (node.key == key || node.key.equals(key))){
                    return node.value;
                }
            }while (node != null);
        }

        return null;

    }


    // 测试
    static class Test{
        public static void main(String[] args) {
            MyHashMap<String, Integer> myHashMap = new MyHashMap(16);

            System.out.println("put:");
            for (int i = 0; i < 16 * 2; i++){

                myHashMap.put(String.valueOf(i), i);
                System.out.print("   |"  + String.valueOf(i) + ":" + i);
            }

            System.out.println("\nget:");
            for (int i = 0; i < 16 * 2; i++){

                Integer value = myHashMap.get(String.valueOf(i));
                System.out.print("   |"  + String.valueOf(i) + ":" + value);
            }
        }
    }
}
