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
	   int index = Math.abs(hash) % DEFAULT_CAPACITY;
	   
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
   
   public V get(K key)
   {
	   if(key==null)
	   {
		   throw new RuntimeException("Key cannot be null");
	   }
	   int hash = key.hashCode();
	   int index = Math.abs(hash) % DEFAULT_CAPACITY;
	   
	   if(table[index].key == key)
	   {
		   return table[index].value;
	   }
	   else
	   {
		   Entry<K, V> current = table[index];
		   while(current!=null && !current.key.equals(key))
		   {
			   current = current.next;
		   }
		   if(current.key.equals(key))
		     return current.value;
		   return null;
	   }
   }
   
   public void remove(K key)
   {
	   if(key==null)
	   {
		   throw new RuntimeException("Key cannot be null");
	   }
	   int hash = key.hashCode();
	   int index = Math.abs(hash) % DEFAULT_CAPACITY;
	   Entry<K, V> prev = table[index];
	   Entry<K, V> current = prev.next;
	   while(current!=null)
	   {
		   if(current.key.equals(key))
		   {
			   prev.next = current.next;
			   return;
		   }
		   prev = current;
		   current = current.next;
	   }
   }
   
   public boolean containsKey(K key)
   {
	   if(key==null)
	   {
		   throw new RuntimeException("Key cannot be null");
	   }
	   int hash = key.hashCode();
	   int index = Math.abs(hash) % DEFAULT_CAPACITY;
	   Entry<K, V> current = table[index];
	   while(current!=null)
	   {
		   if(current.key.equals(key))
		   {
			   return true;
		   }
		   current = current.next;
	   }
	   return false;
   }
   
   public int size()
   {
	   int count = 0;
	   for (int i = 0; i < table.length; i++) 
	   {
		  int sum = 0;
		  Entry<K, V> current = table[i];
		  while(current!=null)
		  {
			  sum+=1;
			  current = current.next;
		  }
		  count+=sum;
	   }
	   return count;
   }
   
   public boolean isEmpty()
   {
	   if(table.length==0) {
		   return true;
	   }
	   return false;
   }
   
   public void clear()
   {
	   for (int i = 0; i < table.length; i++) {
	        table[i] = null;
	   }
   }
   
   public boolean containsValue(V value)
   {
	   for (int i = 0; i < table.length; i++) 
	   {
		  Entry<K, V> current = table[i];
		  while(current!=null)
		  {
			  if(value==null && current.value==null) {return true;}
			  if(current.value.equals(value))
			  {
				  return true;
			  }
			  current = current.next;
		  }
	   }
	   return false;
   }
}
