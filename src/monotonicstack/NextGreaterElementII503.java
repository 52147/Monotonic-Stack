package monotonicstack;

import java.util.Stack;

/**
 * 
 * 503. Next Greater Element II
 * 
 * Given a circular integer array nums(i.e. the next element of nums[nums.length - 1] is nums[0])
 * , return the next greater number for every element in nums.
 *
 * Approach using Stack
 * 
 * - because is a circular array
 * - we need stack to record the first pass (start from the right)
 * - and do the second pass(start from the right) to correct the larger number
 *
 *
 */
public class NextGreaterElementII503 {
	
	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		
		Stack<Integer> stack = new Stack<>();
		
		// circular array: traverse index: i % nums.length
		// need two pass to get the correct result
		// because first pass we not consider the left side of the traverse number
		for(int i = 2 *nums.length - 1; i >= 0; i--) {
			
			while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop(); // not find the number in stack is bigger than the traversed number keep pop and find until found or empty
			}
			
			// set the result array : -1 if not found the next larger number(stack empty) or found in the stack(top of the stack)
			result[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
			
			// push the element because this element is the next element of the traverse element
			// need this element to find whether is the next larger element
			stack.push(i % nums.length);
		}
		
		return result;
		
		
	}
	

}
/**
 * time: O(N) two traversals of the nums array
 * 
 * space: O(N) a stack of size n is used.
 * 
 */



