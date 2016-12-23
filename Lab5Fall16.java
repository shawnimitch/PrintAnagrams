package PrintAnagrams;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/*Print Anagram Using Hash Table */
/*Programmed by A-Shawni Mitchell, October 28, 2016 */

public class Lab5Fall16 {

	private static Scanner in;	
	
	/* FillwordSet Method Chaining*/
	private static void fillWordSetChaining(HashTableLL englishWordSet){
		
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/shawnimitch/Documents/School/Eclipse/Lab3/src/Lab3Anagram/words.txt"))){
			String currentLine;
			while((currentLine = br.readLine()) != null){
				Word w = new Word(currentLine);
				englishWordSet.insert(w);
			}
		} catch (IOException e){
			System.out.println("Error reading the file: "+ e.getMessage());
		}
	}
	
	 /*Print Anagrams by Chaining */
	public static void printAnagramsLL(HashTableLL chain, String prefix, String word) {
		
		if(word.length() <= 1) {
			String str = prefix + word;
			if(chain.search(str)) {
				System.out.println(str);
				//chain.delete(str);
			}
		}
		
		else {
			for(int i=0;i<word.length();i++){
				String cur = word.substring(i, i+1);
				String before = word.substring(0, i);
				String after = word.substring(i+1);
				printAnagramsLL(chain, prefix+cur,before+after);
			}
		}
	}
	
	/* FillwordSet Method */
	private static void fillWordSetProbing(HashTableA englishWordSet){

		try(BufferedReader br = new BufferedReader(new FileReader("/Users/shawnimitch/Documents/School/Eclipse/Lab3/src/Lab3Anagram/words.txt"))){
			String currentLine;
			while((currentLine = br.readLine()) != null){
				String w = currentLine;
				englishWordSet.insert1(w);
			}
		} catch (IOException e){
			System.out.println("Error reading the file: "+ e.getMessage());
		}
	}
	
	 /*Print Anagrams by Probing */
	public static void printAnagramsProbing(HashTableA englishWordSet, String prefix, String word) {
		
		if(word.length() <= 1) {
			String str = prefix + word;
			if(englishWordSet.search(str)) {
				System.out.println(str);
				englishWordSet.delete(str);
			}
		}
		
		else {
			for(int i=0;i<word.length();i++){
				String cur = word.substring(i, i+1);
				String before = word.substring(0, i);
				String after = word.substring(i+1);
				printAnagramsProbing(englishWordSet, prefix+cur,before+after);
			}
		}
	}
	
	/* FillwordSet Method */
	private static void fillWordSet(HashSet<String> englishWordSet){
		
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/shawnimitch/Documents/School/Eclipse/Lab3/src/Lab3Anagram/words.txt"))){
			String currentLine;
			while((currentLine = br.readLine()) != null){
				englishWordSet.add(currentLine);
			}
		} catch (IOException e){
			System.out.println("Error reading the file: "+ e.getMessage());
		}
	}
	
	 /*Print Anagrams by Hash Set */
	public static void printAnagrams(HashSet<String> englishWordSet, String prefix, String word) {
			
		if(word.length() <= 1) {
			String str = prefix + word;
			if(englishWordSet.contains(str)) {
				System.out.println(str);
				englishWordSet.remove(str);
				}
		}
			
		else {
			for(int i=0;i<word.length();i++){
				String cur = word.substring(i, i+1);
				String before = word.substring(0, i);
				String after = word.substring(i+1);
				printAnagrams(englishWordSet, prefix+cur,before+after);
				}
			}
		}
	
	/*  Main Method */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		int c;
		int tableSize;
		String word;
		
		long startTimeChaining=0;
		long endTimeChaining=0;
		long totalTimeChaining=0;
		
		long startTimeProbing=0;
		long endTimeProbing=0;
		long totalTimeProbing=0;
		
		long startTimeSet=0;
		long endTimeSet=0;
		long totalTimeSet=0;
		
		System.out.println("**************** WELCOME TO LAB 5 ************************");
		System.out.println();
		
		System.out.println("Please select your option to Print Anagrams \n");
		System.out.println("Please select '1' for Chaining Method or '2' for Probing Method or '3' for Hash Set Method");
		c = in.nextInt();
	
		switch(c) {
		
		case 1:
			System.out.println("What is the size of the table you want to build? \n");
			tableSize = in.nextInt();
	
			HashTableLL chain = new HashTableLL(tableSize);
			fillWordSetChaining(chain);
			
			System.out.println("What is the word you want to Print Anagrams of?");
			word = in.next();
			
			startTimeChaining=System.nanoTime();
			printAnagramsLL(chain,"",word);
			endTimeChaining=System.nanoTime();
			totalTimeChaining=endTimeChaining-startTimeChaining;
			System.out.println();
			System.out.println("The time for linear chaining is : " + totalTimeChaining);
			break;
			
		case 2:
			System.out.println("What is the size of the table you want to build? \n");
			tableSize = in.nextInt();
			
			HashTableA probe = new HashTableA(tableSize);
			
			fillWordSetProbing(probe);
			
			System.out.println("What is the word you want to Print Anagrams of?");
			word = in.next();
			
			startTimeProbing = System.nanoTime();
			printAnagramsProbing(probe,"",word);
			endTimeProbing = System.nanoTime();
			totalTimeProbing = endTimeProbing - startTimeProbing;
			System.out.println();
			System.out.println("The time for linear probing is : " + totalTimeProbing);
			break;
			
		case 3:
			HashSet<String>englishWordSet=new HashSet<String>();
			fillWordSet(englishWordSet);
			
			System.out.println("What is the word you want to Print Anagrams of?");
			word = in.next();
			
			startTimeSet = System.nanoTime();
			printAnagrams(englishWordSet,"",word);
			endTimeSet = System.nanoTime();
			totalTimeSet = endTimeSet - startTimeSet;
			System.out.println();
			System.out.println("The time for Hash Set is : " + totalTimeSet);
			break;
			
		default:
			System.out.println("Incorrect input");
			break;
				
		}
		
	}

}
