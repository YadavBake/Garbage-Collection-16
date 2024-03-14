
								Garbage collection Part-2 || The ways to make object eligible for GC
							============================================================================

 
----------------------------------------------
  The ways to make an object Eligible for GC 
----------------------------------------------  

 -> Even though programmer is not responsible to distroye useless objects it is highly recomanded to make an object 
	eligible for GC if it is no longer required.
	
 -> An object is said to be eligible for GC if and only if it doesn't containe any reference variable.
 
 -> The following are various ways to make an object eligible for GC.
 
------------------------------------- 
 1. Nullfying the reference variable 
-------------------------------------  

 -> If an object no longer required then assign null to it's reference variables then that object automatically eligible
	for garbage collection.

 -> This approach is nothing but Nullfying the reference variables.

 
															   -----------
	                                                     s1--->|  Obj1   |
	Student s1 = new Student();                         	   -----------
	Student s2 = new Student();                         	   -----------
	                                                     s2--->|  Obj2 	 | 
	// Till here no object is eligible for GC           	   -----------
	
	s1=null; // If we declare s1=null then obj1 is eligible for GC becaouse there is no reference is there.
	
	// One object eligible for GC  
	
		   -----------	
	 s1    |  Obj1   |
		   -----------
		   
	s2=null; // If we declare s2=null then obj1 is eligible for GC becaouse there is no reference is there.
		   
		   -----------
     s2    |  Obj2 	 | 	
    	   -----------
		   
	// Two  object eligible for GC  	   
	
----------------------------------------	
 2. Reassigning the reference variables 
-----------------------------------------

 -> If an object no longer required then reassign it's reference variable to some other object then old object by default 
	eligible for garbage collection.
	
	Ex. 
	
											   -----------
                                         s1--->|  Obj1   |
	Student s1 = new Student();         	   -----------
	Student s2 = new Student();         	   -----------
                                         s2--->|  Obj2 	 | 
                                        	   -----------
	// Till here no object is eligible for GC  

	s1= new Student();	// Here Obj1 is eligible for GC because s1 is reassign to obj3 and after compliting obj1 work.			
                                    
    // Now one object eligible for GC 			   -----------                                
									         s1--->|  Obj3   |
                                            	   -----------
								            	   -----------
	                                         s1    |  Obj1   |
	                                        	   -----------
												   
	s2=s1;// Here obj2 is eligible for GC becaouse s2 is reassign to obj3 after compliting obj2 work.

	// Now two object eligible for GC.
	
										   -----------
                                     s1--->|  Obj3   |
                                     |---->-----------
                                     |	   -----------
                                     s2    |  Obj2   |
                                    	   -----------

-----------------------------------										   
 3. Object created inside a method 
----------------------------------- 
 
	-> The objects which are created inside a method are by default eligible for GC once a method complites.
	
	Ex.
 
 
	class Test
	{
		public static void main(String args[])
		{
			m1(); // After compliting m1() two object eligible for GC 
		}
		public static void m1()								   -----------
		{                                                s1--->|  Obj1   |
			Student s1 = new Student();		            	   -----------
			Student s2 = new Student();                 	   -----------
		}                                                s2--->|  Obj2 	 | 
	}                                                   	   -----------

 
 
	class Test 									
	{																				  -----------
		public static void main(String args[])                                  s1    |  Obj1   |<-----s
		{                                                                       	  -----------
			Student s = m1(); // one object eligible for GC                     	   -----------
		}                                                                       s2     |  Obj2 	 |
		public static Student m1()                                              	   -----------
		{									       -----------
			Student s1= new Student();       s1--->|  Obj1   |
			Student s2= new Student();      	   -----------
			return s1;                      	   -----------
		}                                    s2--->|  Obj2 	 | 
	}                                       	   -----------


	
	class Test																		  -----------
	{                                                                           s1    |  Obj1   |
		public static void main(String [] args)                                 	  -----------
		{                                                                       	   -----------
			m1(); // After compliting m1() two object eligible for GC           s2     |  Obj2 	 |
		}                                                                       	   -----------
		public static Student m1()				      -----------
		{                                       s1--->|  Obj1   |
			Student s1= new Student();	        	   -----------
			Student s1= new Student();	        	   -----------
            Student s2= new Student();          s2--->|  Obj2 	 | 
            return s1;                          	   -----------
		}
	}



	class Test 
	{																	      -----------
		static Student s ;                                              s1    |  Obj1   |
		                                                                	   -----------
		public static void main(String args[])                          	   -----------
		{                                                               s---->|  Obj2 	 |
			m1(); // one object eligible for GC                         	   -----------
		}
		public static void m1()					      -----------
		{                                       s1--->|  Obj1   |
			s = new Student();                  	   -----------
			Student s1 = new Student();         	   -----------
		}                                       s2--->|  Obj2 	 |
	}                                           	   -----------


 -----------------------
 4. Island of Isolation 
 -----------------------
 
  -> 
  
	class Test 
	{
		Test i;
		
		public static void main(String args[])			
		{												
			Test t1 = new Test();						
			Test t2 = new Test();                       
			Test t3 = new Test();                       		 	 ---------------------
                                                                 	 | 			 	      | 
            // Till know no object eligible for Gc.              	 ||->----------       |
                                                                  t1-||->|    i   |--     |	
			t1.i = t2;                                               ||  ----------  |    |
			                                                         ||  ----------  |    |
			t2.i = t3;                                            t2-||->|    i   |<--    |
			                                                         ||  ----------  |    |
			t3.i = t1;                                           	 ||	 ----------  |    |
			                                                      t3-||->|    i   |<-|    |
			                                                         |   ----------       |
            // Till know no object eligible for GC.              	 |                    |
                                                                 	 ----------------------
			t1 = null;
																		 ---------------------		
			// Till know no object eligible for GC.                 	| 			 	     |                                         
			t2 = null;                                              	||->----------       |
			                                                         t1 || |    i   |-- |    |
            // Till know no object eligible for GC.					    ||  ----------  |    |													
			t3 = null;                                                  ||  ----------  |    |
            // Here Three object eligible for Gc.					 t2 ||  |    i   |<--    |													
		} 		                                                        ||  ----------  |    |
														            	||	----------  |    |
	}                                                                t3 ||--|    i   |<-|    |
                                                                        |   ----------       |
														            	|                    |
														            	 ---------------------
																		 Island of Isolation 
				
 note: 
 
	-> If an object doesn't containe any reference variable then it is eligible for garbage collection always.
	
	-> Even though object having references some time it is eligible for garbage collection( If all references are 
	   internal references) 
	   
		Eg. 
		
			Island of Isolation.
			
			
	
    
    
    
     
     
     
     
     
    
     
     
    
    
