//Problem : Palindrome Linked List 

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?


///



// Solution//


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
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;  
        ListNode end=null;
        ListNode mid=null;
        ListNode prev=null;
        ListNode nextn=null;
        boolean test=false;
        int size=0;
        
        
        //edge case for empty list//
        
        if (head==null)
            return true;
        
        //edge case for single node list
        
        if (head.next==null)
            return true;
        
        
        
        
        // for list with more than 1 node
        
        
        //calculating size of the list
        
        while(curr.next!=null)
        {
            size++;
            if(curr.next.next==null)
                size++;
            curr=curr.next;
            
        }    
        
        
        //current points back to head
        
        curr=head;
                
        for (int i=1;i<=size;i++)
        {
            
            //for list with odd number of nodes//
            
            if (size%2==1)
            {
            
                
                //conditions for middle node//
                
                if (i==((size/2)+1))
                {
                    mid=curr;
                    prev=curr;
                    curr=curr.next;
                    
                }
                
                  //Reversing the 2nd half of list//
        
                 //By changing "next" pointers of each node to the previous node // 
                
                else if (i>((size/2)+1))
                {
                    
                    nextn=curr.next;
                    curr.next=prev;
                    prev=curr;
                    if(i==size)
                        //last node//
                        end=curr;
                    curr=nextn;
                    
                }
                
                //1st half of list,normal traversal//
                
                else
                    curr=curr.next;
            }
            
            //for list with even number of nodes//
            
            else
            {
                
                //conditions for middle node//
                
                 if (i==(size/2))
                {
                    mid=curr;
                    prev=curr;
                    curr=curr.next;
                    
                    
                }
                
                                
                  //Reversing the 2nd half of list//
        
                 //By changing "next" pointers of each node to the previous node //
                
                else if (i>(size/2))
                    
               {
                    nextn=curr.next;
                    curr.next=prev;
                    prev=curr;
                    if(i==size)
                        //last node
                        end=curr;
                    curr=nextn;
                
                
                }
                
                //1st half of list,normal traversal//
            
                 else
                    curr=curr.next;
            
        }
                    
            
            
        }
        
        //comparison//
        
        for (int i=1;i<=(size/2);i++)
        {
            //comparing 1st half of list with "reversed" 2nd half of list //
            
            if (head.val==end.val)
                test=true;
            
            else
            {
                test=false;
                break;
            }
            
            head=head.next;
            end=end.next;
            
        }
        
        
        return test;
        
        
    }
}

////



/// Submission Result /////


Runtime: 1 ms, faster than 97.62% of Java online submissions for Palindrome Linked List.
Memory Usage: 41.8 MB, less than 94.67% of Java online submissions for Palindrome Linked List.


//////
