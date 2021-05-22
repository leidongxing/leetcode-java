package algorithm;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/1/4
 * 一致性hash算法
 */
public class ConsistencyHashing {
    // 虚拟节点的个数
    private static final int VIRTUAL_NUM = 5;

    // 虚拟节点,真实节点的复制品 key=hash值，value=虚拟节点服务器名称
    private static final TreeMap<Integer, String> shards = new TreeMap<>();

    // 真实节点列表
    private static final List<String> realNodes = new LinkedList<>();

    //模拟初始服务器
    private static final String[] servers = {"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.5", "192.168.1.6"};

    static {
        for (String server : servers) {
            realNodes.add(server);
            for (int i = 0; i < VIRTUAL_NUM; i++) {
                String virtualNode = server + "&&VN" + i;
                int hash = getHash(virtualNode);
                shards.put(hash, virtualNode);
            }
        }
        System.out.println("初始节点服务器列表:" + Arrays.toString(servers));
        System.out.println("初始虚拟节点服务器列表:" + shards);
    }

    /**
     * 获取被分配的节点名
     */
    public static String getServer(String node) {
        int hash = getHash(node);
        Integer key;
        SortedMap<Integer, String> subMap = shards.tailMap(hash);
        if (subMap.isEmpty()) {
            key = shards.lastKey();
        } else {
            key = subMap.firstKey();
        }
        String virtualNode = shards.get(key);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }

    /**
     * 添加节点
     */
    public static void addNode(String node) {
        if (!realNodes.contains(node)) {
            realNodes.add(node);
            System.out.println("真实节点[" + node + "] 上线添加");
            for (int i = 0; i < VIRTUAL_NUM; i++) {
                String virtualNode = node + "&&VN" + i;
                int hash = getHash(virtualNode);
                shards.put(hash, virtualNode);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被添加");
            }
        }
    }

    /**
     * 删除节点
     */
    public static void delNode(String node) {
        if (realNodes.contains(node)) {
            realNodes.remove(node);
            System.out.println("真实节点[" + node + "] 下线移除");
            for (int i = 0; i < VIRTUAL_NUM; i++) {
                String virtualNode = node + "&&VN" + i;
                int hash = getHash(virtualNode);
                shards.remove(hash);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被移除");
            }
        }
    }

    /**
     * FNV1_32_HASH算法
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        //模拟客户端的请求
        String[] nodes = {"127.0.0.1", "10.9.3.253", "192.168.10.1"};

        for (String node : nodes) {
            System.out.println("[" + node + "]的hash值为" + getHash(node) + ", 被路由到节点服务器[" + getServer(node) + "]");
        }

        // 添加一个节点(模拟服务器上线)
        addNode("192.168.1.7");
        // 删除一个节点（模拟服务器下线）
        delNode("192.168.1.2");

        for (String node : nodes) {
            System.out.println("[" + node + "]的hash值为" + getHash(node) + ", 被路由到节点服务器[" + getServer(node) + "]");
        }
    }
}