
											Garbage collection Part-5 || finalization-2
										===================================================


 ---------
  Case 3: 
 ---------

  -> Even though Object eligible for GC for multiple but garbage collector call finalize() method only once. 


		class FinalizeDemo1
		{
			
			static FinalizeDemo1 s;
			
			public static void main(String args[]) throws Exception
			{
				FinalizeDemo1 f = new FinalizeDemo1();
				System.out.println(f.hashCode());
				f=null;
				System.gc();
				Thread.sleep(5000);
				System.out.println(s.hashCode());
				s=null;
				System.gc();
				Thread.sleep(10000);
				System.out.println("End of Main");
			}
			public void finalize()
			{
				System.out.println("Finalize Method call");
				s=this;
			}
		}
	Output:
	
	798154996
	Finalize Method call
	798154996
	End of Main
   

 -> In the above even though object eligible for GC two times but garbage collector calls finalize() method only once.
	
-----------
  Case 4: 
-----------

 -> We can't except excat behaviour of garbage collector it is different from JVM to JVM hence a for the following 
	quations we can't excat answers.
	
	1. when excatly JVM runs garbage collector.
	
	2. In which order garbage collector identify eligible objects.
	
	3. In which order garbage collector destroyes eligible objects.
	
	4. Whether garbage collector destroyes all eligible objects or not.
	
	5. What is algorithm followed by garbage collector ect.
	

 Note:
	
	1. Whenever program runs with low memory then JVM runs garbage collector but we can't except excatly at what time.
	
	2. Most of the garbage collectors follow standard algorithm MARK and SWIP algorithm. It doesn't mean every garbage
	   collector follow the same algorithm.
	   


		class Test 
		{
			static int count = 0;
			public static void main(String args[])
			
			{				   |------>// If we keep on increasing this number at certain memory problem will be 
				for(int i=0;i<10;i++)  // raised then JVM runs garbage collector. GC calls  finalize() calls method
				{					   // no every object separatly and destroyes that object.
					Test t = new Test();
					t=null;
				}
			}
			public void finalize()
			{
				System.out.println("Finalize method call : "+ ++count);
			}
		}
  

-----------------------
  Case 5: Memory Leaks 
-----------------------

 -> The objects which are not using in our program and which are eligible for GC such type of user less objects are called 
	Memory leaks.
	
  -> In our program if memory leaks prasent then the program will be termented by riasing OutOfMemoryError.
 
  -> Hence a  if an object no longer required it is highly recomanded to make that object eligible for GC.
 
  -> The following are various third party memory management tools to identify Memory leaks.

		1. HP OVO
		2. HP J METHOD
		3. JProbe
		4. Patrol
		5. IBM Tivoli.
		

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		.
		.
		.
		.
		Student s1cr = new Stude();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	