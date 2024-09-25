package Collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class ArrayList1 {

	public static void main(String[] args) {
	
		//created a array list which size is 5
		ArrayList a1=new ArrayList(5);
		a1.add(100);
		a1.add(200);
		a1.add(300);
		a1.add("Somanath");
		System.out.println(a1);
		//copy one collection object data to another collection object 
		ArrayList a2=new ArrayList(a1);
		System.out.println("a2="+a2);
		System.out.println("size of a2="+a2.size());
		System.out.println("Element at index 2 is:"+a2.get(2));
		//System.out.println("Replace the element of a2 in index 3 "+a2.set(3, a2));
		System.out.println(a1.contains(100));
		
		//linked list in collection framework
		List ll=new LinkedList(a2);
		System.out.println("print all the data of linked list: "+ll);
		System.out.println("print using Iterator");
		//print the element using iterator method
		Iterator itr=a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("print usingList Iterator");
		//print the element using ListIterator method
				ListIterator litr=a1.listIterator();
				while(litr.hasNext()) {
					System.out.println(litr.next());
				}
				
				System.out.println("print usingList Iterator in backward direction.");
				//print the element using ListIterator method in backward direction
				
				while(litr.hasPrevious()) {
					System.out.println(litr.previous());
				}
				
				//vector in collection framework
				Vector v=new Vector();
				v.add("Hello");
				v.add("i");
				v.add("am");
				v.add("Somanath");
				System.out.println(v);
				
				//print element using Enumeration
				Enumeration e=v.elements();
				while(e.hasMoreElements()) {
					System.out.println(e.nextElement());
				}
				
				//stack collection framework
				Stack s=new Stack();
				s.push(ll);
				s.push(8990);
				System.out.println("print all the data of stack: "+s);
				
				//hashset collection framework
				HashSet h=new HashSet(ll);
				System.out.println("print all the data of HashSet: "+h);
				
				//TreeSet collection framework
				TreeSet t=new TreeSet();
				t.add(12);
				t.add(23);
				t.add(34);
				System.out.println("print all the data of TreeSet: "+t);
				
	}
}
