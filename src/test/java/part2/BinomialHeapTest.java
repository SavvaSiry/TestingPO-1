package part2;

import org.junit.Assert;
import org.junit.Test;

public class BinomialHeapTest {

    @Test
    public void checkIsEmpty(){
        BinomialHeap heap = new BinomialHeap();
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void checkMakeEmpty() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(1);
        Assert.assertFalse(heap.isEmpty());
        heap.makeEmpty();
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void checkInsert(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(0);
        Assert.assertTrue(heap.isEmpty());
        heap.insert(-1);
        Assert.assertTrue(heap.isEmpty());
        heap.insert(1);
        Assert.assertFalse(heap.isEmpty());
        Assert.assertEquals(heap.getSize(), 1);
        heap.insert(1);
        Assert.assertFalse(heap.isEmpty());
        Assert.assertEquals(heap.getSize(), 2);
    }

    @Test
    public void checkDelete(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(1);
        heap.delete(1);
        Assert.assertTrue(heap.isEmpty());
        heap.delete(5);
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void checkGetSize(){
        BinomialHeap heap = new BinomialHeap();
        Assert.assertEquals(heap.getSize(), 0);
        heap.insert(1);
        Assert.assertEquals(heap.getSize(), 1);
        heap.delete(1);
        Assert.assertEquals(heap.getSize(), 0);
        heap.insert(2);
        heap.insert(3);
        Assert.assertEquals(heap.getSize(), 2);
        heap.insert(-3);
        Assert.assertEquals(heap.getSize(), 2);
    }

    @Test
    public void checkDecreaseKeyValue(){
        BinomialHeap heap = new BinomialHeap();
        heap.insert(1);
        heap.decreaseKeyValue(1,5);

    }
}
