import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class link {

    //一种好玩的方法,估计很多人一想这个题就是暴力和哈希
    //大概解释一下这个题，我只需要一直向前走，如果能遇到一个和我一眼的点，我在一同继续向后走，如果不同，则是失败
    //但这样的时间复杂度肯定是极高的，所以采用另一种方法，我直接采用窗口，如果扫到末位的窗口一致，则说明有相交可能性，我就去维护一个窗口
    // 41845和561845,本来想着从末尾开始，但是一想算了吧，我懂点礼貌，从开头开始尊重一下链表
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */

        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                //法子一，滑动窗口,上层代码保持一致,整体遍历一次，维护一个窗口，个人觉得还可以，但是打大样本可能出问题哈哈哈哈哈哈，闹着玩红行
                if (headA == null || headB == null) { //首先边界肯定得卡
                    return null;
                }

                ListNode top = headA;
                ListNode bot = headB;
                List<ListNode> list = new ArrayList<ListNode>();一串最大窗口
                //维护滑动窗口,保持卡临界值
                while(top.next && bot.next) {
                    if(top == bot){
                        list.add(top); //放入窗口
                    }else{
                        if(list.size() != 0){
                            list.clear(); //清除数据重新维护
                        }
                    }
                    top = top.next; //同时向后走
                    bot = bot.next; //同时向后走
                }

                //查询窗口是否存在,若存在则说明ok返回第一位，不存在则返回null
                return list.size() == 0 ? null : list.getItem(0);
            }
        }

        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                //法二，暴力双指针，也不是很暴力，之前看过题解
                if (headA == null || headB == null) { //首先边界肯定得卡
                    return null;
                }

                ListNode top = headA;
                ListNode bot = headB;
                //之前刷过这个方法，不得不说很巧妙，两边都持续遍历，最终到同一个节点上
                while (top != bot) { //等于的话就不走了，不等于的话继续执行下面的语句,指向b，然后最终扫描到公共节点，然后翻车到null
                    top = top == null ? headB : top.next;
                    bot = bot == null ? headA : bot.next;
                }
                retunr top;
            }
        }







    }

