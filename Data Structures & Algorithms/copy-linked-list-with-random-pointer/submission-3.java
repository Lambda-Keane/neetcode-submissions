/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Node cur = head;
        Node dummy = new Node(0);
        Node d = dummy;
        int i = 0;
        while (cur != null) {
            d.next = new Node(cur.val);
            list.add(cur.val);
            cur.val = i;
            map.put(i, d.next);
            i++;
            d = d.next;
            cur = cur.next;
        }
        d.next = null;
        cur = head;
        d = dummy.next;
        while (d != null) {
            if (cur.random == null) {
                d.random  = null;
            } else {
                d.random = map.get(cur.random.val);
            }
            d = d.next;
            cur = cur.next;
        }
        cur = head;
        for (int j : list) {
            cur.val = j;
            cur = cur.next;
        }
        return dummy.next;
    }
}
