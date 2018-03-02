import java.io.*;
import java.util.*;

public class WordLadder {
	private Queue<Stack<String>> candidate;
	private Set<String> smallDict;
	private boolean flag;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WordLadder wl=new WordLadder();
		Set<String> dict= new HashSet<String>();
		String word1,word2;
		int tryWord;
		wl.flag=false;
		System.out.print("Dictionary file name? ");
		BufferedReader br = new BufferedReader(new 
                InputStreamReader(System.in));
		String fileName=br.readLine();
		//System.out.println(fileName);
		//get the dictionary file
		
		FileInputStream inputStream = new FileInputStream(fileName);  
        BufferedReader brDict = new BufferedReader(new InputStreamReader(inputStream)); 
        String dictLine=brDict.readLine();
        while (dictLine != null) {
        		//System.out.println(dictLine);
        		dict.add(dictLine);
        		dictLine=brDict.readLine();
        }
        brDict.close();
        //get the words in dictionary
        
        
        while (true) {
	        System.out.print("Word #1 (or Enter to quit): ");
	        tryWord=br.read();
	        //System.out.println(tryWord);
	        if (tryWord==10) {break;}
	        word1=(char)tryWord+br.readLine();
	        word1=word1.toLowerCase();
	        //System.out.println(word1);
	        System.out.print("Word #2 (or Enter to quit): ");
	        tryWord=br.read();
	        if (tryWord==10) {break;}
	        word2=(char)tryWord+br.readLine();
	        word2=word2.toLowerCase();
	        //System.out.println(word2);
	        //get start word and the end word
	        
	        if (word1.compareTo(word2)==0) {
	        		System.out.println("The two words must be different.");
	        		continue;
	        }
	        else if (word1.length()!=word2.length()) {
	        		System.out.println("The two words must be the same length.");
	        		continue;
	        }
	        else if (!dict.contains(word1)||!dict.contains(word2)) {
	        		System.out.println("The two words must be found in the dictionary.");
	        		continue;
	        }
	        //check the possible error case
	        
	        wl.smallDict= new HashSet<String>();
	        Iterator<String> it = dict.iterator();  
	        String fit;
	        while (it.hasNext()) {  
	        	  fit = it.next(); 
	        	  if (fit.length()==word1.length())
	        		  wl.smallDict.add(fit);
	        	}
	        //filter the dictionary according to the length of word
	        
	        wl.candidate=new LinkedList<Stack<String>>();
	        Stack<String> ladder=new Stack<String>();
	        ladder.add(word1);
	        wl.smallDict.remove(word1);
	        wl.candidate.offer(ladder);
	    
	        wl.findNeighbor(word2);
	        while (!wl.candidate.isEmpty() && !wl.flag) {
	        		wl.findNeighbor(word2);
	        }
	        if (wl.flag) {
	        		ladder=wl.getTail();
	        		wl.printLadder(ladder,word1,word2);
	        }
	        else {
	        		System.out.println("No word ladder found from "+word2+" back to "+word1+".");
	        }
	        
	        
	        wl.candidate.clear();
	        wl.smallDict.clear();
	        wl.flag=false;
	        //clear the container
        }
        System.out.println("Have a nice day.");
	}
	
	public void findNeighbor(String target) {
		//find the suitable words
		Stack<String> temp=this.candidate.poll();
		Stack<String> t;
		String word=temp.peek();
		String cddWord;
		String part1="",part2="";
		for (int j='a';j<='z';j++) {
			cddWord=(char)j+word.substring(1);
			if (this.smallDict.contains(cddWord)) {
				//System.out.println(cddWord);
				temp.push(cddWord);
				t=copyStack(temp);
				this.candidate.offer(t);
				temp.pop();
				this.smallDict.remove(cddWord);
				if (cddWord.compareTo(target)==0) {
					this.flag=true;
					return ;
				}
			}
		}
		for (int i=0;i<word.length()-2;i++) {
			for (int j='a';j<='z';j++) {
				part1=word.substring(0, 1+i);
				part2=word.substring(2+i,word.length());
				cddWord=part1+(char) j+part2;
				if (this.smallDict.contains(cddWord)) {
					//System.out.println(cddWord);
					temp.push(cddWord);
					t=copyStack(temp);
					this.candidate.offer(t);
					temp.pop();
					this.smallDict.remove(cddWord);
					if (cddWord.compareTo(target)==0) {
						this.flag=true;
						return;
					}
				}
			}
		}
		for (int j='a';j<='z';j++) {
			cddWord=word.substring(0,word.length()-1)+(char)j;
			if (this.smallDict.contains(cddWord)) {
				//System.out.println(cddWord);
				temp.push(cddWord);
				t=copyStack(temp);
				this.candidate.offer(t);
				temp.pop();
				this.smallDict.remove(cddWord);
				if (cddWord.compareTo(target)==0) {
					this.flag=true;
					return ;
				}
			}
		}
		
		return ;
	}
	
	public Stack<String> getTail(){
	Stack<String> stk=null;
	while (!this.candidate.isEmpty()) {
	stk=this.candidate.poll();
	}
	return stk;
	}
	
	public void printLadder(Stack<String> stk,String str1,String str2) {
		//print the wordladder
		System.out.println("A ladder from "+str2+" back to "+str1+":");
		while (!stk.empty()) {
			System.out.print(stk.pop()+" ");
		}
		System.out.print("\n");
		return;
	}
	
	public Stack<String> copyStack(Stack<String> stk){
		Stack<String> s=new Stack<String>();
		Stack<String> q=new Stack<String>();
		while (!stk.empty()) {
			q.push(stk.pop());
		}
		while (!q.isEmpty()) {
			stk.push(q.peek());
			s.push(q.pop());
		}
		return s;
	}
	
	
}
