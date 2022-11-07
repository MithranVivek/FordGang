package org.fordgang;

public class Memory {
	
	public static void main(String[] args) {
		
		// literal same string same different memory
		String s1 = "Mahanya";
		String S2 = "Mahan";         
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(S2));
		System.out.println("---------------------------- next");
		// Non literal same string but different memory 
		String x1 = new String("Ganishya");
		String x2 = new String ("Ganish"); 
		System.out.println(System.identityHashCode(x1));
		System.out.println(System.identityHashCode(x2));
		System.out.println("---------------------------- next");
		// ImMutable 
		String s3 = "ramesh";
		String s4 = "ramesh";
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
		String r = s3.concat(s4);
		System.out.println(r);
		System.out.println(System.identityHashCode(r));
		System.out.println("---------------------------- next");
		//mutable 
		StringBuffer x5 = new StringBuffer ("Ramesh");
		StringBuffer x6 = new StringBuffer ("kumar");
		System.out.println(System.identityHashCode(x5));
		System.out.println(System.identityHashCode(x6));
		x5.append(x6);
		System.out.append(x5);
		System.out.println(" ");
		System.out.println(System.identityHashCode(x5));
		System.out.println("---------------------------- end");
	}

}
