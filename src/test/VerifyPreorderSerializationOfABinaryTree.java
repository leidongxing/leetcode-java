package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/12
 * 验证二叉树的前序序列化
 */
public class VerifyPreorderSerializationOfABinaryTree {
    //前序遍历 根左右  栈方法
    //一个节点有两个#  则认为是叶子节点
    public boolean isValidSerialization2(String preorder) {
        List<String> stack = new ArrayList<>();
        String[] orders = preorder.split(",");
        for (String str : orders) {
            stack.add(str);
            int i = stack.size();
            //当前为#  栈顶也是# 下一个不是#
            while (stack.size() >= 3 && "#".equals(stack.get(i - 1)) && "#".equals(stack.get(i - 2)) && !"#".equals(stack.get(i - 3))) {
                stack.remove(i - 1);
                stack.remove(i - 2);
                //将上一个替换为#
                stack.remove(i - 3);
                stack.add("#");
                i -= 2;
            }
        }
        return stack.size() == 1 && "#".equals(stack.get(0));
    }

    //入度 多少节点指向它
    //出度 它指向多少节点
    //根节点入度=0 出度=2   普通节点入度=1 出度=2  叶子节点入度=1 出度=0
    //所有节点入度之和=出度之和
    public boolean isValidSerialization(String preorder) {
        String[] orders = preorder.split(",");
        //表示出度-入度
        int diff = 1;
        for (String str : orders) {
            //每个节点都要 -1入度
            diff--;
            if (diff < 0) {
                return false;
            }
            //非叶子节点 +2出度
            if (!"#".equals(str)) {
                diff += 2;
            }
        }
        //差值=0
        return diff == 0;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));//true
        System.out.println(v.isValidSerialization("1,#"));//false
        System.out.println(v.isValidSerialization("9,#,#,1"));//false
        System.out.println(v.isValidSerialization("#,7,6,9,#,#,#"));//false

    }
}
