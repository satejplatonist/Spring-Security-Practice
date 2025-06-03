package main;

public class MyHashMap<K,V> 
{
   private static final int DEFAULT_CAPACITY = 50;
   
   @SuppressWarnings("unchecked")
   private Entry<K, V>[] table = new Entry[DEFAULT_CAPACITY];
   
   private static class Entry<K,V>
   {
	   private final K key;
	   private V value;
	   
	   private Entry<K,V> next;

	   public Entry(K key, V value) 
	   {
		  this.key = key;
		  this.value = value;
	   }
	   
	   
   }
    
   public void put(K key, V value)
   {
	   if(key == null)
	   {
		   throw new RuntimeException("Key cannot be null");
	   }
	   int hash = key.hashCode();
	   int index = hash % DEFAULT_CAPACITY;
	   
	   Entry<K, V> entry = new Entry<K, V>(key, value);
	   
	   if(table[index]==null)
	   {
		   table[index] = entry;
	   }
	   else
	   {
		   Entry<K, V> current = table[index];
		   while(current.next != null)
		   {
			   if(current.key.equals(key))
			   {
				   current.value = value;
				   return;
			   }
			   current = current.next;
		   }
		   current.next = entry;
	   }
   }
}
