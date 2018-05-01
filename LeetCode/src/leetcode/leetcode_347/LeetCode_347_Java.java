package leetcode.leetcode_347;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Ji YongGuang.
 * @date 9:43 2018/4/28.
 */
public class LeetCode_347_Java {

    private class Freq implements Comparable<Freq> {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
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
                if (priorityQueue.size() < k) {
                    //  因为我们所实现的默认是最大堆，所以可以修该对象的compareTo方法逻辑来获取我们想要的实际元素排列顺序
                    // enQueue 操作默认父元素小于子元素 子元素上浮。
                    // 我们想要出队的时候通过getFront方法获得到堆中最小元素，只能让enQueue中的上浮逻辑 `parent(index)).compareTo(array.get(index)) < 0`
                    // 在这种情况下返回-1. 即父元素比子元素大，那么子元素上浮，这样最后队顶元素则是最小元素。
                    priorityQueue.add(new Freq(element, elements.get(element)));
                } else if (elements.get(element) > priorityQueue.peek().freq) {
                    // 如果排队元素freq大于队列中最小元素的freq那么置换两元素
                    priorityQueue.remove();
                    priorityQueue.add(new Freq(element, elements.get(element)));
                }
            }

            // TODO 此时PriorityQueue中存了k个数组中平率出现最高的元素，那么只需把PriorityQueue内容转化成List<Integer>返回即可
            List<Integer> res = new LinkedList<>();
            while (!priorityQueue.isEmpty()) {
                res.add(priorityQueue.remove().e);
            }
            return res;
        }
    }
}