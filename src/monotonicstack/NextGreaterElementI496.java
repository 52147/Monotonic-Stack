package monotonicstack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * 496. Next Greater Element I
 * 
 * find x's first greater element that is to the right of x in the same array.
 * 
 * if there is not next greater element, then the answer of the query is -1.
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * 
 * use stack to compare the each encounter value in the nums2 array
 * use map to store the result for next larger number
 *
 */

public class NextGreaterElementI496 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> s = new Stack<>();

		HashMap<Integer, Integer> map = new HashMap<>();
		
		// we push every element of nums2 on the stack
		// if nums2[i] is larger than stack's top element
		// we pop all the element until we encounter the element is larger than or equal to nums[2]
		// map the pop element as key and nums[i] as value(next larger element)
		for (int i = 0; i < nums2.length; i++) {

			while (!s.isEmpty() && nums2[i] > s.peek()) {
				map.put(s.pop(), nums2[i]);
			}

			s.push(nums2[i]);
		}
		// element is popped out of the stack when a next greater element is found out in the nums2
		// therefore, the elements remaining in the stack do not have the next greater element in the nums2
		// so map the element's value with -1
		while (!s.isEmpty()) {
			map.put(s.pop(), -1);
		}

		int[] res = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}

		return res;
	}
}

/**
 * time: O(n)
 * - nums2 is scanned once.
 * - n element be pushed and popped once.
 * - nums1 is scanned once.
 * - All together requires O(n + n + m) equal to n
 * - thus, time be simplified to O(n)
 * 
 * space: O(n)
 * - map store n key-value pairs 
 * - stack contains at most n elements
 * 
 * 
 */


