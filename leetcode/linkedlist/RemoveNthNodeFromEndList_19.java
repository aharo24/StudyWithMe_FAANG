package linkedlist;

/**
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNthNodeFromEndList_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length = 0;
    ListNode first = head;
    while (first != null) {
      length++;
      first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
      length--;
      first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
  }
}