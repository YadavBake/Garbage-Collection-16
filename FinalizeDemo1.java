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
		