// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer cache;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
        cache = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (cache == null) {
            if (iter.hasNext()) cache = iter.next();
        }
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (cache == null) {
            if (iter.hasNext()) return iter.next();
        } else {
            int res = cache;
            if (iter.hasNext()) cache = iter.next();
            else cache = null;
            return res;
        }
        return null;
	}

	@Override
	public boolean hasNext() {
	    return cache != null || iter.hasNext();
	}
}