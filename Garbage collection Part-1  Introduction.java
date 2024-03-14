
											 	Garbage collection Part-1 || Introduction
											================================================

 ---------------------
  Garbage Collection  
 ---------------------

	1. Introduction.
	2. The ways to make an object eligible for GC.
	3. The methods for requesting JVM to run garbage collector (GC).
	4. Finalization.
	
	
==========================================================================================================================

-----------------
  Introduction
-----------------


 -> In old languages like C++ programer is responsible to create new object to distroyed useless objects. useally 
	programer taking very care while creating object and neglecting distruction of useless objects because of his 
	neglectance at sertain point for creation of new object suficient memory may not be available(Because total 
	memory field with uselss Object only) and total application will be down with memory problem hence a 
	OutOfMemoryError is very comman problem in old languages like C++.
	
	
 -> But in java programer is responsible only for creation of objects and programer is not responsible to distroyed 
	useless objects. Sun people provided one assitance to distroyed useless Objects. This assitance is always running 
	in the bakc ground(Demon Thread.) and distroyed useless objects, Just becuase of asitance the chance of failing java 
	programer with memory problems is very very very Low this assitance is nothing but Garbage Collector.
	
	
 -> Hence a the main objective of Garbage collector is to destroyed useless objects.	
    
 
