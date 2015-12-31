package DataStructures;

import java.util.*;

public class HashTable<K,V>{

	private final int INIT_TABLE_SIZE = 31; 
	private List<LinkedList<AbstractMap.SimpleEntry<K,V>>> table;
	/*The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the lookup cost (reflected in most of the operations of the HashMap class, including get and put).*/
	private float loadFactor;
	private int capacity;
	private int numEntries;

	public HashTable(){
		this.capacity = INIT_TABLE_SIZE;
		this.table = createTable(this.capacity);
		this.numEntries = 0;
	}

	public HashTable(int initCapacity){
		this.capacity = getNextGreatestPrime(initCapacity);
		this.table = createTable(this.capacity);
		this.numEntries = 0;
	}

	private List<LinkedList<AbstractMap.SimpleEntry<K,V>>> createTable(int capacity){
		List<LinkedList<AbstractMap.SimpleEntry<K,V>>> newTable = new ArrayList<LinkedList<AbstractMap.SimpleEntry<K,V>>>(capacity);
		for(int i=0; i < capacity; i++){
			newTable.add(new LinkedList<AbstractMap.SimpleEntry<K,V>>());
		}
		return newTable;
	}

	public void resizeTable(int newCapacity){
			
	}

	public V put(K key, V value){
		AbstractMap.SimpleEntry<K,V> entry = find(key);
		if(entry == null){
			if(key == null){
				return null;
			}
			LinkedList<AbstractMap.SimpleEntry<K,V>> bucketList = this.table.get(getIndex(key));
			bucketList.appendToTail(new AbstractMap.SimpleEntry<K,V>(key,value));
			this.numEntries++;

			return null;
		}
		V oldValue = entry.getValue();
		entry.setValue(value);
		return oldValue;
	}

	public V get(K key){
		AbstractMap.SimpleEntry<K,V> entry = find(key);

		return (entry == null ? null : entry.getValue());
	}

	public V remove(K key){
		AbstractMap.SimpleEntry<K,V> entry = find(key);
		
		if(entry == null){
			return null;
		}

		LinkedList<AbstractMap.SimpleEntry<K,V>> bucketList = this.table.get(getIndex(key));
		bucketList.remove(entry);
		
		this.numEntries--;

		return entry.getValue();
	}

	public boolean contains(K key){
		AbstractMap.SimpleEntry<K,V> entry = find(key);
		return entry != null;
	}
	
	public int getNumEntries(){
		return this.numEntries;
	}

	protected AbstractMap.SimpleEntry<K,V> find(K key){
		if(key == null){
			return null;
		}
		LinkedList<AbstractMap.SimpleEntry<K,V>> bucketList = this.table.get(getIndex(key));
		LinkedListNode<AbstractMap.SimpleEntry<K,V>> runner = (LinkedListNode<AbstractMap.SimpleEntry<K,V>>)bucketList.getHead();
		
		while(runner != null && !runner.getData().getKey().equals(key)){
			runner = runner.getNext();
		}

		return (runner==null ? null : runner.getData());
	}

	protected int getIndex(K key){
		return key.hashCode() % this.capacity;
	}

	protected int getNextGreatestPrime(int val){
		if(val <= 2){
			return 2; 
		}
		
		if(val % 2 == 0){
			val++;
		}

		while(!isPrime(val)){
			val+=2;
		}

		return val;
	}

	protected boolean isPrime(int number){
		//if value is 2 is prime
		if(number == 2){
			return true;
		}

		//if values are less than 2 or even it is not prime
		if(number <= 1 || number % 2 == 0){
			return false;
		}
		
		//check all odd values <= sqrt(number)
		for(int i = 3; i*i <= number; i+=2){
			if(number % i == 0){
				return false;
			}
		}

		return true;
	}
	
	public String toString(){
		String str = "";
		for(int i=0; i < this.capacity; i++){
			str += "[" + Integer.toString(i) + "]->";
			str += this.table.get(i).toString();
		}
		return str;
	}
}
