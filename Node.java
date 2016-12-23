package PrintAnagrams;

/*Node Class */
/*Programmed by A-Shawni Mitchell, October 28, 2016 */

public class Node {
	
	public Word info;
	public Node link;
	
	//Constructor Method
	public Node(Word w) {
		
		info=w;
		link=null;
	}
}
