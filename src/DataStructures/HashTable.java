package DataStructures;

import java.util.*;

public class HashTable<K,V>{

	protected final int INIT_TABLE_SIZE = 31; 
	private List<LinkedList<AbstractMap.SimpleEntry<K,V>>> table;
	private Set<AbstractMap.SimpleEntry<K,V>> entrySet;
	/*The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the lookup cost (reflected in most of the operations of the HashMap class, including get and put).*/
	private float loadFactor;
	private int capacity;

	public HashTable(){
		setUpTable(INIT_TABLE_SIZE, .75f);
		this.entrySet = new HashSet<AbstractMap.SimpleEntry<K,V>>(INIT_TABLE_SIZE);
	}

	public HashTable(int initCapacity){
		setUpTable(getNextGreatestPrime(initCapacity), .75f);
		this.entrySet = new HashSet<AbstractMap.SimpleEntry<K,V>>(initCapacity);
	}

	public HashTable(int initCapacity, float loadFactor){
		setUpTable(getNextGreatestPrime(initCapacity), loadFactor);
		this.entrySet = new HashSet<AbstractMap.SimpleEntry<K,V>>(initCapacity, loadFactor);
	}

	private void setUpTable(int capacity, float loadFactor){
		this.capacity = capacity;
		this.table = createTable(capacity);
		this.loadFactor = loadFactor;
	}

	private List<LinkedList<AbstractMap.SimpleEntry<K,V>>> createTable(int capacity){
		List<LinkedList<AbstractMap.SimpleEntry<K,V>>> newTable = new ArrayList<LinkedList<AbstractMap.SimpleEntry<K,V>>>(capacity);
		for(int i=0; i < capacity; i++){
			newTable.add(new LinkedList<AbstractMap.SimpleEntry<K,V>>());
		}
		return newTable;
	}

	private void resizeTable(int newCapacity){
		List<LinkedList<AbstractMap.SimpleEntry<K,V>>> oldTable = this.table;
		setUpTable(newCapacity, this.loadFactor);
		for(int i=0; i < oldTable.size(); i++){
			LinkedList<AbstractMap.SimpleEntry<K,V>> bucketList = oldTable.get(i);
			LinkedListNode<AbstractMap.SimpleEntry<K,V>> runner = bucketList.getHead();
			while(runner != null){
				AbstractMap.SimpleEntry<K,V> entry = runner.getData();
				put(entry.getKey(), entry.getValue());
				runner = runner.getNext();
			}
		}
	}

	public V put(K key, V value){
		if(key == null){
			return null;
		}

		AbstractMap.SimpleEntry<K,V> entry = find(key);
		if(entry == null){
			if((((float)this.entrySet().size() / this.capacity)) > this.loadFactor){
				resizeTable(getNextGreatestPrime(this.capacity * 2));
			}

			LinkedList<AbstractMap.SimpleEntry<K,V>> bucketList = this.table.get(getIndex(key));
			AbstractMap.SimpleEntry<K,V> newEntry = new AbstractMap.SimpleEntry<K,V>(key,value);
			this.entrySet.add(newEntry);
			bucketList.appendToTail(newEntry);

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

	public Set<AbstractMap.SimpleEntry<K,V>> entrySet(){
		return this.entrySet;
	}

	public V remove(K key){
		AbstractMap.SimpleEntry<K,V> entry = find(key);
		
		if(entry == null){
			return null;
		}

		LinkedList<AbstractMap.SimpleEntry<K,V>> bucketList = this.table.get(getIndex(key));
		this.entrySet.remove(entry);
		bucketList.remove(entry);
		
		return entry.getValue();
	}

	public boolean contains(K key){
		AbstractMap.SimpleEntry<K,V> entry = find(key);
		return entry != null;
	}
	
	public int size(){
		return this.entrySet.size();
	}

	protected int capacity(){
		return this.capacity;
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
