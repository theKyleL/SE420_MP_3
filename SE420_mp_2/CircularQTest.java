import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularQTest {
	
	CircularQueue<Integer> q;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/* @param n/a
	 * @return n/a
	 * Test that a queue of size 0 throws an invalid capacity exception
	 * 
	 */
	@Test
	public void testSizeEqual0() throws Exception {
		
		try{
			q = new CircularQueue<Integer>(10);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param int
	 * @return boolean
	 * This test verifies that the add() function properly inserts a value into the queue.
	 * 
	 */
	@Test
	public void testAdd() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		q.add(0);
		assertTrue(q.size()==1);
			
	}
	
	/* @param int
	 * @return int
	 * This test verifies that the remove function extracts a value from the queue.
	 * 
	 */
	@Test
	public void testRemove1() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		q.offer(20); // add number to queue 
		assertTrue(20==q.remove());
	}

	/* @param n/a
	 * @return int or null
	 * This test verifies that a null value will be returned when attempting to remove a value from an empty queue.
	 * 
	 */
	@Test
	public void testRemoveFromEmpty() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertNull(q.remove());
		
	}
	
	/* @param n/a
	 * @return integer or null
	 * This test polls an empty queue to verify that a null value is returned.
	 * 
	 */
	@Test
	public void testPollEmpty() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertEquals(null, q.poll());
		
	}	
	
	/* @param n/a
	 * @return int
	 * This test verifies that the poll function returns the element at the head of the queue.
	 * 
	 */
	@Test
	public void testPoll() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertNull(q.poll());
		q.offer(4);
		assertNotNull(q.poll());
		
	}		
	
	/* @param n/a
	 * @return int
	 * 
	 * This test verifies that the peek function returns the value at the head of the queue without removing the value from the queue.
	 */
	@Test
	public void testPeek() throws Exception {
		
		q = new CircularQueue<Integer>(1);
		q.offer(1);
		assertTrue(q.peek()==1);
		assertTrue(q.peek()==1);
		
	}
	
	/* @param n/a
	 * @return int or null
	 * 
	 * This test verifies that the peek() function returns null when the queue is empty and not null when the queue is not empty.
	 */
	@Test
	public void testPeekEmptyQueue() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertTrue(q.peek()==null);
		q.offer(1);
		assertFalse(q.peek()!=null);
		
	}
	/* @param n/a
	 * @return boolean
	 * Tests that the isEmpty() function correctly identifies when a queue is empty.
	 * 
	 */
	@Test
	public void testIsEmpty() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertTrue(q.isEmpty());
		
	}

	/* @param n/a
	 * @return boolean
	 * tests that the isEmpty() function correctly identifies when a queue is empty.
	 * 
	 */
	@Test
	public void testIsEmptyFalse() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		q.offer(1);
		assertTrue(!q.isEmpty());
		
	}
	
	/* @param n/a
	 * @return integer
	 * 
	 * This tests that the size() function correctly returns the number of elements in the queue.
	 */
	@Test
	public void testSize() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertEquals(0, q.size());
		
	}
	
	/* @param n/a
	 * @return integer
	 * This test that the getQueueCapacity() function returns the maximum size of the queue.
	 * 
	 */
	@Test
	public void testGetCapacity() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertEquals(10, q.getQueueCapacity());
		
	}
	
	/* @param n/a
	 * @return integer
	 * This test case verifies that the getRemainingQueueSpace() function returns the number of open spaces in the queue.
	 * 
	 */
	@Test
	public void testGetRemainingQueueSpace() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		assertEquals(10, q.getRemainingQueueSpace());
		q.offer(0);
		assertEquals(9, q.getRemainingQueueSpace());
		
	}
	
	/* @param n/a
	 * @return boolean
	 * isQueueFull() function returns true if all of the elements of the circular queue are full.
	 * 
	 */
	@Test
	public void testIsQueueFull() throws Exception {
		
		q = new CircularQueue<Integer>(3);
		assertFalse(q.isQueueFull());
		q.offer(0);
		q.offer(1);
		q.offer(2);
		assertTrue(q.isQueueFull());
		
	}
	
	/* @param n/a
	 * @return Object[]
	 * This tests that the toArray() function creates an array out of the existing queue.
	 * 
	 */
	@Test
	public void testToArray() throws Exception {
		
		q = new CircularQueue<Integer>(3);
		assertFalse(q.isQueueFull());
		q.offer(3);
		
		Object[] testArray = q.toArray();
		assertEquals(3, testArray[0]);
		
		
}	
	
	/* @param n/a
	 * @return int or exception
	 * This test that the element() function returns the head of an array when present but throws an exception when the queue is empty.
	 * 
	 */
	@Test
	public void testElement() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.element();
		}
		catch(Exception e){
			System.out.println(e);
		}
		q.offer(1);
		q.element();
	}	
	
	/* @param Object
	 * @return boolean
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testContains() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.contains(q);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param Collection<?>
	 * @return boolean
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testContainsAll() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.containsAll(q);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param n/a
	 * @return Iterator<E>
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testIterator() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.iterator();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param Object
	 * @return boolean
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testRemove() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.remove(q);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param Collection<?>
	 * @return boolean
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testRemoveAll() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.removeAll(q);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param Collection<?>
	 * @return boolean
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testAddAll() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.addAll(q);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param Collection<?>
	 * @return boolean
	 * 
	 * Test not yet implemented for incomplete function
	 */
	@Test
	public void testRetainAll() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		try{
			q.retainAll(q);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	/* @param n/a
	 * @return Object[]
	 * 
	 * This test verifies that an array is created from the queue
	 */
	@Test
	public void testToArray2() throws Exception {
		
		q = new CircularQueue<Integer>(10);
		Integer[] testArray = new Integer[5];
		
		try{
			q.toArray(testArray);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
//	/* @param 
//	 * @return
//	 * 
//	 * 
//	 */
//	@Test
//	public void testTemplate() throws Exception {
//		
//		q = new CircularQueue<Integer>(10);
//		
//	}	
	
}
