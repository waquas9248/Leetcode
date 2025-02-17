//Neetcode - 150
// You are given the beginning of a linked list head, and an integer n.
// Remove the nth node from the end of the list and return the beginning of the list.
// O(n) tine complexity



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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if( head == null )
            return null;
        
        int length = 1;

        ListNode temp = head;

        while( temp.next != null ){
            temp = temp.next;
            length++;
        }

        int remIndex = length - n;

        int i = 0;
        temp = head;

        ListNode prev = null;
        ListNode next= null;

        while( i < remIndex ){

            next = temp.next;

            prev = temp;

            temp = temp.next;

            i++;

        }
        
        if( prev == null )
            return head.next;

        prev.next = temp.next;

        return head;

    }
}
