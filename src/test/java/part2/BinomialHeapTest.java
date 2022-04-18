package part2;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinomialHeapTest {

    @Test
    public void checkIsEmpty(){
        BinomialHeap heap = new BinomialHeap();
        Assert.assertTrue(heap.isEmpty());
        heap.insert(1);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void checkMakeEmpty() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(1);
        assertFalse(heap.isEmpty());
        heap.makeEmpty();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void checkInsert(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(0);
        assertTrue(heap.isEmpty());
        heap.insert(-1);
        assertTrue(heap.isEmpty());
        heap.insert(1);
        assertFalse(heap.isEmpty());
        assertEquals(heap.getSize(), 1);
        heap.insert(1);
        assertFalse(heap.isEmpty());
        assertEquals(heap.getSize(), 2);
    }

    @Test
    public void checkDelete(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(1);
        heap.extractMin();
        assertTrue(heap.isEmpty());
        heap.extractMin();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void checkGetSize(){
        BinomialHeap heap = new BinomialHeap();
        assertEquals(heap.getSize(), 0);
        heap.insert(1);
        assertEquals(heap.getSize(), 1);
        heap.extractMin();
        assertEquals(heap.getSize(), 0);
        heap.insert(2);
        heap.insert(3);
        assertEquals(heap.getSize(), 2);
        heap.insert(-3);
        assertEquals(heap.getSize(), 2);
    }

    @Test
    public void checkMergeHeap(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(6);
        heap.insert(5);
        assertEquals(heap.getNodes().key, 5);
        assertEquals(heap.getNodes().child.key, 6);
        heap.insert(6);
        heap.insert(5);
        assertEquals(heap.getNodes().child.key, 5);
        assertEquals(heap.getNodes().child.sibling.key, 6);
        heap.makeEmpty();
        heap.insert(6);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        assertEquals(heap.getNodes().key, 2);
        assertEquals(heap.getNodes().child.key, 5);
        assertEquals(heap.getNodes().child.sibling.key, 3);
        assertEquals(heap.getNodes().child.child.key, 6);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        assertEquals(heap.getNodes().key, 1);
        assertEquals(heap.getNodes().child.key, 2);
        heap.extractMin();
        heap.insert(13);
        assertEquals(heap.getNodes().key, 2);
        assertEquals(heap.findMinimum(), 2);
        heap.makeEmpty();
        heap.insert(3);
        heap.insert(6);
        heap.insert(5);
        heap.insert(1);
        assertEquals(heap.getNodes().key, 1);
        assertEquals(heap.getNodes().child.key, 3);
    }

    @Test
    public void findMinTest(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        assertEquals(heap.findMinimum(), 1);
        heap.extractMin();
        assertEquals(heap.findMinimum(), 2);
    }

    @Test
    public void extractMinTest(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(5);
        heap.insert(6);
        heap.insert(3);
        heap.insert(1);
        heap.extractMin();
        assertEquals(heap.getNodes().key, 3);
        heap.extractMin();
        assertEquals(heap.getNodes().key, 5);
        heap.extractMin();
        assertEquals(heap.getNodes().key, 6);
        heap.extractMin();
        assertTrue(heap.isEmpty());
        assertEquals(heap.extractMin(), -1);
        heap.makeEmpty();
        heap.insert(3);
        heap.insert(6);
        heap.insert(5);
        heap.insert(1);
        heap.extractMin();
        assertEquals(heap.getNodes().key, 5);
        heap.extractMin();
        assertEquals(heap.getNodes().key, 5);

    }
}
