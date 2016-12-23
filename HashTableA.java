package PrintAnagrams;

public class HashTableA {

	private String[] array;
	private int m; //size of list
	int n; //number of records
	
	//Constructors
	public HashTableA(){
		this(11);
	}
	
	public HashTableA(int tableSize) {
		 
		m=tableSize;
		array = new String[tableSize];
		n=0;
	}
	
	//hash method
	long hash(long key){
		return (key%m);
	}
	
	//insert method
	public void insert1(String w)  {
		
		if(n >= m/2)
			rehash( nextPrime(m*2) );
		insert(w);
	}
	
	public void insert(String w) {
		
		long k = base26(w);
		int h = (int) hash(k);
		
		int location = h;
		
		for(int i=1;i<m;i++) {
			
			if(array[location]==null || array[location].equals("#")) {
				array[location]=w;
				n++;
				return;
			}
			
			if(array[location].equals(w))
				return; //No Duplicate Keys
			
			location = (h+i) % m;
		}
		System.out.println("Table is Full : Record can't be inserted");
	}
	
	//rehash method
	private void rehash(int newSize) {
		
		HashTableA temp = new HashTableA(newSize);
		
		for(int i=0;i<m;i++)
			if(array[i] !=null && ! array[i].equals("#"))
				temp.insert(array[i]);
		
		array = temp.array;
		m=newSize;
	}
	
    //Search Method
	public boolean search(String key){
		
		long k = base26(key);
		int h = (int) hash(k);
		int location=h;
		
		for(int i=1;i<m;i++) {
			
			if(array[location]==null)
				return false;
			if(array[location].equals(key))
				return true;
			location = (h+i) % m;
		}
		return false;
	}
	
    //Display Method
	public void displayTable(){
		
		for(int i=0;i<m;i++) {
			
			System.out.print(" [" + i + "]   -->   ");
			
			if(array[i] !=null && !array[i].equals("#"))
				System.out.println(array[i]);
			else
				System.out.println("______");
		}
	}
	
    //Delete Word
	public void delete(String key) {
		
		long k = base26(key);
		int h = (int) hash(k);
		int location = h;
		
		for(int i=1;i<m;i++){
			
			if(array[location]==null)
				return;
			if(array[location].equals(key)){
				
				array[location] = "#";
				n--;
				if(n>0 && n<=m/8){
					rehash( nextPrime(m/2) );
				}
			}
			location = (h+i) % m;		
		}
	}
	
    //Next Prime
	int nextPrime(int x) {
	
		while(!isPrime(x))
			x++;
		return x;
	}
	
    //isPrime
	boolean isPrime(int x) {
	
		for(int i=2;i<x;i++) {
			if(x%i==0)
				return false;
		}
		return true;	
	}
	
	//base26 Method
	private long base26(String w) {
				
		long adder=0;
		int val = 0;
		for(int i=0;i<w.length();i++) {
			val = (int) (w.charAt(i));
			adder = (long) adder*26 + val ;
		}
		return Math.abs(adder);
	}
	
}
