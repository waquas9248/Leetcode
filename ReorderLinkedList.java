//Neetcode - 150
// You are given the head of a singly linked-list.
// The positions of a linked list of length = 7 for example, can intially be represented as:
// [0, 1, 2, 3, 4, 5, 6]
// Reorder the nodes of the linked list to be in the following order:
// [0, 6, 1, 5, 2, 4, 3]
// Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
// [0, n-1, 1, n-2, 2, n-3, ...]
// You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
// Time complexity required - O(n), Space - O(1)


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
    public void reorderList(ListNode head) {

        ListNode temp = head;

        if( head == null )
            return;

        //find length of list - 'n'
        int n = 1;
        while( temp.next != null ){
            temp = temp.next;
            n++;
        }
        
        int i = 1;
        temp = head;
        //reverse the last half and hold the end as lastHead
        while( i < n/2 ){
            temp = temp.next;
            i++;
        }

        //head of 2nd half
        ListNode lastHead = temp.next;
        ListNode prev = null;
        temp.next = null;
      
        //reverse 2nd half
        while( lastHead != null ){
            ListNode dummy = lastHead.next;

            lastHead.next = prev;

            prev = lastHead;

            lastHead = dummy;

        }

        ListNode last = prev;
        ListNode first = head;

        ListNode nextFirst = null;
        ListNode nextLast = null;

        // while either get to null
        while( last != null && head != null ){

            nextFirst = first.next;
            nextLast = last.next;
            first.next = last;
            first = last;
            last = nextFirst;

        }
        // if n is odd, ensure correct last pointer
        if( n % 2 == 1 )
            first.next = nextLast;
      
    }
}
