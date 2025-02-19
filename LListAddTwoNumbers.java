//Neetcode - 150
// You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
// The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
// Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Return the sum of the two numbers as a linked list.
// O(n) time, constant space

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int n1 = 0;
        
        ListNode temp = l1;
        
        while( temp != null ){   
            temp = temp.next;
            n1++;
        }

        temp = l2;

        int n2 = 0;

        while( temp != null ){
            temp = temp.next;
            n2++;
        }

        ListNode main = null;
        ListNode other = null;

        int pad = 0;
        
        if (n1 >= n2){
            main = l1;
            other = l2;
            pad = n2;
        }else{
            main = l2;
            other = l1;
            pad = n1;
        }
    
        ListNode prev = null;

        int sum = 0;
        int carry = 0;

        ListNode head = main;

        while( main != null ){
            
            int otherVal = 0;

            if ( pad != 0 ){
                otherVal = other.val;
                other = other.next;
                pad--;
            }
            
            sum = (carry + main.val + otherVal) % 10;
            carry = (carry + main.val + otherVal) / 10;
            main.val = sum;  
            prev = main;
            main = main.next;
          
        }

        if( carry == 1 ){
            temp = new ListNode(carry);
            prev.next = temp;
        }

        return head;

    }
}
