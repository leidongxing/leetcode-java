package test;

/**
 * @author LeiDongxing
 * created on 2021/11/2
 * 删除链表中的节点
 */
public class DeleteNodeInALinkedList {
    /**
     * 普通的删除操作 直接删除上一个节点的next节点 指向next节点的next节点
     * @param node 要删除的节点
     */
    public void deleteNode(ListNode node) {
        //修改当前值 修改为下一个节点值 顶替下一个节点
        node.val = node.next.val;
       //然后直接删除下一个节点
        node.next=node.next.next;
    }
}
