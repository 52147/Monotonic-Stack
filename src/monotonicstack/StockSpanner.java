package monotonicstack;

import java.util.Stack;

/**
 * 901. Online Stock Span
 * 
 * span : 
 * - stock's price today is defined as the maximum number of consecutive days
 * - (starting from today and going backward)
 *    for which the stock price was less than or equal to today's price.  
 *    
 *      
 *      
 * Implement the StockSpanner class:
 * 1. StockSpanner() Initializes the object of the class
 * 2. int next(int price) 
 *    Returns the span of the stock's price given that today's price is price.
 *    
 * 
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * Output
 * [null, 1, 1, 1, 2, 1, 4, 6]
 *   
 * Explanation
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // return 1
 * stockSpanner.next(80);  // return 1
 * stockSpanner.next(60);  // return 1
 * stockSpanner.next(70);  // return 2
 * stockSpanner.next(60);  // return 1
 * stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
 * stockSpanner.next(85);  // return 6
 * 
 *
 */
public class StockSpanner {
	
	Stack <int[]> s;
	
	public StockSpanner() {
		s = new Stack<>();
	}
	
	// input price
	// return input price's span
	public int next(int price) {
		
		// if the stack is empty, we set the span with 1
		if(s.isEmpty()) {
			s.push(new int[] {price, 1});
			return 1;
		}
		
		int span = 1; // initialize each span with 1
		
		// if we find the price is larger than the input price
		// we stop pop and increase the span
		// otherwise
		// we pop the span is smaller than the input price
		// and add the span in the stack in the input span
		// and then add it to the stack
		// this operation is for not count the span from the first input
		while(!s.isEmpty() && s.peek()[0] <= price) {
			span += s.peek()[1];
			s.pop();
		}
		
		s.push(new int[] {price, span});
		
		return span;
		
		
		
	}

}



/**
 * Time:
 * The worst case: O(N)
 * Consider the input prices are added in the following order: 
 * [5,4,3,2,1,6]. 
 * The spans are [1,1,1,1,1,6]. 
 * Checking the span for price 6 would require individually 
 * checking all the previously added prices on the stack which is O(n).
 */
