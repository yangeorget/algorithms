package net.yangeorget.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HeapTest {
	@Test
	public void testHeap() 	{
		Heap<Integer> heap = new HeapImpl<Integer>(new Integer[100]);
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		Assert.assertEquals(heap.pop().intValue(), 2);
		Assert.assertEquals(heap.pop().intValue(), 3);
		Assert.assertEquals(heap.pop().intValue(), 3);
		Assert.assertEquals(heap.pop().intValue(), 4);
		Assert.assertEquals(heap.pop().intValue(), 4);
		Assert.assertEquals(heap.pop().intValue(), 5);
		Assert.assertNull(heap.pop());
	}
}
