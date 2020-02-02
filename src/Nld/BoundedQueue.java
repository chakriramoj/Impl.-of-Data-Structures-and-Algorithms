package Nld;

import java.util.Arrays;

public class BoundedQueue<T> {
	private T[] queue;
	private int size;
	private int arrayLength;
	private int startingPointer;

	@SuppressWarnings("unchecked")
	BoundedQueue(int size) {
		queue = (T[]) new Object[size];
		arrayLength=size;
		this.size = 0;
		startingPointer = 0;
	}

	public boolean offer(T x) {
		if (arrayLength == size) {
			return false;
		} else {
			queue[(startingPointer + size) % arrayLength] = x;
			size++;
			return true;
		}
	}

	public T poll() {
		if (size == 0) {
			return null;
		} else {
			size--;
			int IndexOfFirstElement = startingPointer;
			startingPointer = (startingPointer + 1) % arrayLength;
			return queue[IndexOfFirstElement];
		}

	}

	public T peek() {
		if (size == 0) {
			return null;
		} else {
			return queue[startingPointer];
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		size = 0;
		startingPointer = 0;
	}

	public void toArray(T[] a) {
		if (size == 0) {
			return;
		}
		
		for (int i = startingPointer,j=0; i < startingPointer + size; i++, j++) {
			a[j] = queue[i % arrayLength];
		}
	}

	public static void main(String[] args) {
		BoundedQueue<Float> queue = new BoundedQueue<Float>(5);
		queue.offer(1f);
		queue.offer(2f);
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.offer(3f));
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty());
		queue.clear();
		System.out.println(queue.isEmpty());
		queue.offer(3f);
		queue.offer(4f);
		queue.offer(5f);
		queue.offer(6f);
		System.out.println(queue.offer(7f));
		System.out.println(queue.offer(8f));
		Float[] elementsOfQueue = new Float[5];
		queue.toArray(elementsOfQueue);
		System.out.println(Arrays.toString(elementsOfQueue));
		queue.clear();
		System.out.println(queue.size() + " " + queue.isEmpty());

	}
}
