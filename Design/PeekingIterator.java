// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;
public class PeekingIterator implements Iterator<Integer> {
    public Iterator<Integer> iter;
    public Integer pk;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
        this.pk = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (this.pk == null) {
            if (iter.hasNext()) {
                this.pk = iter.next();
            }
        }
        return this.pk;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (this.pk != null) {
            return this.pk;
        } else {
            if (iter.hasNext()) {
                return iter.next();
            }
        }
        return null;
	}

	@Override
	public boolean hasNext() {
	    return this.pk == null && !iter.hasNext();
	}
}