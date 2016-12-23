package PrintAnagrams;

/*SingleLL Class */
/*Programmed by A-Shawni Mitchell, October 28, 2016 */

public class SingleLL {
	
	private Node start;
	
	//Constructor Method
	public SingleLL() {
		start=null;
	}
	
	public void displayList() {
		
		Node p;
		if(start==null){
			System.out.println("______");
			return;
		}
		p=start;
		while(p!=null){
			System.out.print(p.info + "  ");
			p=p.link;
		}
		System.out.println();
	}
	
	
	//Search Method
	public boolean search(String x){
		
		Node p=start;
		while(p!=null){
			if(p.info.getWord().equals(x))
				break;
			p=p.link;
		}
		if(p==null){
			//System.out.println(x + " is not found in the list.");
			return false;
		}
		else 
			return true;
	}
	
	
	//Insert at Beginning Method
	public void insertInBeginning(Word data) {
		
		Node temp = new Node(data);
		temp.link=start;
		start=temp;
	}

	//Delete Method
	public void deleteNode(String x) {
		
		if(start==null) {
			System.out.println("Word " + x + " not present\n");
			return;
		}
		
		if(start.info.getWord().equals(x)){ //Word at beginning of list
			start=start.link;
		}
		
		Node p=start;
		while(p.link!=null){
			if(p.link.info.getWord().equals(x))
				break;
			p=p.link;
		}
		if(p.link==null)
			System.out.println("Word "+ x +" is not present.\n");
		else
			p.link=p.link.link;
	}
}
