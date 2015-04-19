package br.pereira.mpengine.util;

public abstract class Pool<T extends Poolable> {
	
	public static final int DEFAULT_POOL_SIZE = 100;
	
	private Poolable[] pool;
	private int endIndex;
	
	public Pool() {
		pool = new Poolable[DEFAULT_POOL_SIZE];
		endIndex = 0;
	}
	
	public T get() {
		if (isEmpty()) {
			T pooledObject = newInstance();
			pooledObject.init();
			
			return pooledObject;
		} else {
			@SuppressWarnings("unchecked")
			T pooledObject = (T) pool[endIndex--];
			pooledObject.reset();
			
			return pooledObject;
		}
	}
	
	public void release(T object) {
		if (!isFull()) {
			pool[endIndex++] = object;
		}
	}
	
	public boolean isEmpty() {
		return endIndex == 0;
	}
	
	public boolean isFull() {
		return endIndex >= pool.length;
	}

	protected abstract T newInstance();
	
}
