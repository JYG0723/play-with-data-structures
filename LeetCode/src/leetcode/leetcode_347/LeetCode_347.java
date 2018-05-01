package leetcode.leetcode_347;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Ji YongGuang.
 * @date 21:01 2018/4/27.
 * 前K个高频元素
 */
public class LeetCode_347 {

    private class Freq implements Comparable<Freq> {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {

            // this = 父
            if (this.freq > o.freq) {
                return -1;
            } else if (this.freq < freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            // TODO 把数组中元素都存到映射中 (K,V)并通过映射来统计各元素统计次数
            TreeMap<Integer, Integer> elements = new TreeMap<>();
            for (int element :
                    nums) {
                if (elements.containsKey(element)) {
                    elements.put(element, elements.get(element) + 1);
                } else {
                    elements.put(element, 1);
                }
            }

            // TODO 把映射中的对象（K,V） 封装成一个对象。并存到PriorityQueue中，PriorityQueue中只存k个元素。后来的元素，和已存的最小元素比较，如果大于那么移除
            PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
            for (Integer element : elements.keySet()) {
                if (priorityQueue.getSize() < k) {
                    //  因为我们所实现的默认是最大堆，所以可以修该对象的compareTo方法逻辑来获取我们想要的实际元素排列顺序
                    // enQueue 操作默认父元素小于子元素 子元素上浮。
                    // 我们想要出队的时候通过getFront方法获得到堆中最小元素，只能让enQueue中的上浮逻辑 `parent(index)).compareTo(array.get(index)) < 0`
                    // 在这种情况下返回-1. 即父元素比子元素大，那么子元素上浮，这样最后队顶元素则是最小元素。
                    priorityQueue.enQueue(new Freq(element, elements.get(element)));
                } else if (elements.get(element) > priorityQueue.getFront().freq) {
                    // 如果排队元素freq大于队列中最小元素的freq那么置换两元素
                    priorityQueue.deQueue();
                    priorityQueue.enQueue(new Freq(element, elements.get(element)));
                }
            }

            // TODO 此时PriorityQueue中存了k个数组中平率出现最高的元素，那么只需把PriorityQueue内容转化成List<Integer>返回即可
            List<Integer> res = new LinkedList<>();
            while (!priorityQueue.isEmpty()) {
                res.add(priorityQueue.deQueue().e);
            }
            return res;
        }
    }

    public static void main(String[] args) {

        int[] nums = {5, 1, -1, -8, -7, 8, -5, 0, 1, 10, 8, 0, -4, 3, -1, -1, 4, -5, 4, -3, 0, 2, 2, 2, 4, -2, -4, 8,
                -7, -7, 2, -8, 0, -8, 10, 8, -8, -2, -9, 4, -7, 6, 6, -1, 4, 2, 8, -3, 5, -9, -3, 6, -8, -5, 5, 10,
                2, -5, -1, -5, 1, -3, 7, 0, 8, -2, -3, -1, -5, 4, 7, -9, 0, 2, 10, 4, 4, -4, -1, -1, 6, -8, -9, -1,
                9, -9, 3, 5, 1, 6, -1, -2, 4, 2, 4, -6, 4, 4, 5, -5, 7};
        int k = 7;
        LeetCode_347 leetCode_347 = new LeetCode_347();
        leetCode_347.new Solution().topKFrequent(nums, k);
    }
}
