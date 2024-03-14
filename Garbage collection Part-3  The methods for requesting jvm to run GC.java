
										Garbage collection Part-3 || The methods for requesting jvm to run GC
									===========================================================================

 ----------------------------------------
  The ways for requesting JVM to Run GC  
 ----------------------------------------

  -> Once we made an object eligible for GC it may not be distroyed immeadiatly by Garbege collector whenver JVM runs 
	 GC then only the object will be distroyed.

  -> But  when exctly JVM run garbage collector we can't except it is different from JVM to JVM.

  -> Initiated of waiting until JVM runs garbage collector we can request JVM to run garbage collector programatically 
	 but whether JVM except our request or not there is guarantee but most of the time JVM except our request.
	 
  -> The following are two ways for requesting JVM to run garbage Collector.

	
----------------------------
  1. By Using System class 
----------------------------

 -> System class containes a static method gc() for this purpose.

	   --------------
	   |System.gc();|
	   --------------
	   
-----------------------------	
  2. By Using Runtime class 	
-----------------------------	

 -> Java Application can communicate with JVM by using Runtime Object.
 
 -> Runtime class prasent in java.lang package and it is a singlton class.
 
 -> We can create Runtime Object by using Runtime.getRuntime() method.	

		--------------------------------------
		|Runtime r = new Runtime.getRuntime()|
		--------------------------------------
 
 -> Once we got Runtime object we can call the following methods on that object.

	
	1. totalMemory();
	
		- It returns Number of bytes of totalMemory prasent in the heap(That is heap size).
		
	2. freeMemory():
		
		- It returns number of bytes of freeMemory prasent in the heap..
		
	3. gc();
		
		- For requesting JVM to run garbage collector.
		



    								-----	
									|. .|	
		---------------	 Runtime	| -	|
		|			  |-> Object-->	-----
	    |             |				  |	
	    |             |               |
		|             |  freeMemory() |
        |    java     |-------------->^		  -----
        | Application |  4567 byte    |       |. .|
        |             |<------------- |       | - |
        |             |  totalMemory()|       -----
        |             |-------------->^			| 
        |             |   6789 byte   |-------->|
        |             |<--------------|			^
		---------------               |			|
									 JVM		|
											   GC  
											   
											   
		import java.util.Date;
		class RuntimeDemo
		{
			public static void main(String args[])
			{
				Runtime r = Runtime.getRuntime(); // Here i got Runtime object 
				
				System.out.println(r.totalMemory());
				System.out.println(r.freeMemory());
				for(int i = 1 ; i<=10000; i++)
				{
					Date d = new Date();
					d=null;
				}
				
				System.out.println(r.freeMemory());
				r.gc();
				System.out.println(r.freeMemory());
			}
		}
				
 Note: 
 
	-> gc() method prasent in System class is a static method where as gc() method prasent in Runtime classes instance 
	   method.
	   
 Q) Which of the following is valid way for requesting JVM to run garbage collector ?
 
 
	1. Syste.gc(); //valid 
	
	2. Runtime.gc(); // invalid 
	
	3. (new Runtime()).gc();//invalid
	
	4. Runtime.getRuntime().gc(); //valid 
	
	
    -> It is convient to use System class gc() method when compared with Runtime class gc() method.

	-> With respect to performance it is highly recomanded to use Runtime class gc() method when compared System class 
	   gc() method because System class gc() method internally calls Runtime class gc() method.


	class System
	{
		public static void gc()
		{
			Runtime.getRuntime().gc();
		}	
	}

	
											   
											   
											   
											   
											   
											   
											   
											   
											   
											   