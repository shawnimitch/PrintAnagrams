package PrintAnagrams;

/*HatableLL Class */
/*Programmed by A-Shawni Mitchell, October 28, 2016 */

public class HashTableLL {

	private SingleLL[] array;
	private int m; //size of list
	private int n; //number of records
	
	public HashTableLL(){
		this(11);
	}
	
	/*Constructor*/
	public HashTableLL(int tableSize){
		
		m=tableSize;
		array=new SingleLL[tableSize];
	}
	
	/*Hash Method*/
	long hash(long key){
		return (key%m);
	}
	
	public void displayTable() {
		
		System.out.println("Number on words : "+n);
		for(int i=0;i<m;i++){
			System.out.print(" [" + i + "]  -->  ");
			
			if(array[i] != null)
				array[i].displayList();
			else
				System.out.println("_____");
		}
	}
	
	//Search Method
	public boolean search(String key) {
		
		long k = base26(key);
		int h = (int) hash(k);
		
		if(array[h] != null)
			return array[h].search(key);
		return false;
	}
	
	//Insert Method
	public void insert(Word w) {
		
		long key = base26(w.getWord());
		int h = (int) hash(key);
		
		if(array[h]==null)
			array[h] = new SingleLL();
		
		array[h].insertInBeginning(w);
		n++;
	}
	
	//Delete Method
	public void delete(String key) {
		
		long k = base26(key);
		int h = (int) hash(k);
		
		if(array[h] != null){
			array[h].deleteNode(key);
			n--;
		}
		else
			System.out.println("Word " + key + " not present\n");
			
	}
	
	//Base26Method
	private long base26(String w) {
		
		long adder=0;
		int val = 0;
		for(int i=0;i<w.length();i++) {
			val = (int) w.charAt(i);
			adder = (long) adder*26 + val;
		}
		adder = (adder<0) ? -1*adder : adder;
		return adder;
	}
}
