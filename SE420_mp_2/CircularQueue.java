import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author
 * 
 */
public class CircularQueue<E> implements FixedSizeQueueInterface<E> {
	private int capacity;
	private E dataArray[];
	private int tail; // bug: tail was used as head
	private int head; // bug: head was used as tail. Fix: swap head/tail
	private int size;

	/**
	 * This constructor will instantiate a new circular queue of the size given
	 * as an attribute.
	 * 
	 * @param maxQueueSize This is the capacity of the circular queue.
	 * @throws Exception An exception will be thrown if an invalid capacity is passed into the method.
	 */
	public CircularQueue(int maxQueueSize) throws Exception {
		super();
		if (maxQueueSize<1) // bug: incorrect test for argument. Values greater than zero should bypass if statement. 
			// fix: test maxQueueSize equal to 0
		{
			throw new Exception("Queue capacity invalid.");
		}
		this.capacity = maxQueueSize + 1; 	
		clear();
	}

	@Override
	public boolean add(E arg0) {
		return offer(arg0);
	}

	@Override
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			return dataArray[head]; // bug: element should return the value of the head, if it exists.
		}							// fix: set return element of dataArray to head
	}

	@Override
	public boolean offer(E arg0) {
		boolean retVal = false;
		if (this.size < this.capacity) {
			this.dataArray[tail+1] = arg0;
			tail = (tail+1) % capacity; // bug: new tail value should be tail+1
										// fix: tail = tail+1
			this.size++;
			retVal = true;
		}
		return retVal;
	}

	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return dataArray[head];// bug: peek should return the value from head, not head-1
									// fix: dataArray[head-1] becomes dataArray[head]
		}
	}

	@Override
	public E poll() {
		E retVal = null;
		if (size == 0) {
			// DO nothing.
		} 
		else {
			retVal = dataArray[head]; // bug: need value from head, not head-1	fix: change value from head-1 to head
			dataArray[head] = null; // bug: set head value to null, not head-1 value to null	fix: set old head value to null
			head = (head + 1) % capacity;
			size--;
		}
		return retVal;

	}

	@Override
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			E retVal = dataArray[head]; // bug: looking in wrong element	fix: set dataArray element to head
			dataArray[head] = null;
			head = (head+1) % capacity;
			size--;
			
			return retVal;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.dataArray = ((E[]) new Object[capacity]);
		this.tail = 0;
		this.head = 0;
		this.size = 0;
		this.dataArray[head] = null; // set initial location to null
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean isEmpty() { // bug: returns true when the capacity is greater than zero... correcting 'if' statement
		if (this.size == 0) {	// fix: change this.size!=0 to this.size==0 
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object retVal[] = new Object[size];

		for (int index = 0; index < size; index++) {
			int myOffset = (tail + index) % this.capacity;
			retVal[index] = this.dataArray[myOffset];
		}
		return retVal;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int getQueueCapacity() {
		return this.capacity - 1;
	}

	@Override
	public int getRemainingQueueSpace() {
		return getQueueCapacity() - this.size; // Bug: used incorrect capacity
		//return this.capacity - this.size;	// fix: retrieve capacity from getCapacity()
	}

	@Override
	public boolean isQueueFull() {
		return (this.size == this.capacity-1); // bug: value of capacity was incorrect
												// fix: value of capacity was reduced
	}

}
