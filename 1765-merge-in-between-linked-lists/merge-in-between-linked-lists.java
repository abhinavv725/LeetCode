/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = list1;
        ListNode bNode = list1;

        ListNode temp1 = list1;

        // Get aNode = node at position (a - 1)
        // Get bNode = node at position (b)
        for(int i=0; i <= b; i++){
            if(i == (a-1)){
                aNode = temp1;
            }else if(i == b){
                bNode = temp1.next;
                temp1.next = null;
            }
            temp1 = temp1.next;
        }
        //Connect aNode to list2
        aNode.next = list2;

        //Go to end of list2 and connect to bNode
        ListNode tail2 = list2;     
        while(tail2.next != null){
            tail2 = tail2.next;
        }
        tail2.next = bNode;

        return list1;
    }
}