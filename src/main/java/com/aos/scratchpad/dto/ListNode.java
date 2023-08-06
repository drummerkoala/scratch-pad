package com.aos.scratchpad.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode {
     int val;
     ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
