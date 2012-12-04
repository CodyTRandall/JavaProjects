package sjsu.cs146.taskSet;

import junit.framework.TestCase;

public class TaskSetTest extends TestCase
{
	TaskSet ts;
   
   protected void setUp() throws Exception
   {
      super.setUp();

      ts = new TaskSet();
      
      ts.addTask(8);
      ts.addTask(3);
      ts.addTask(5);
   }

   public void testCompletion(){
	   assertEquals(8, ts.minCompletionTime());
	   
	   ts.addTaskConstraint(0, 2);
	   assertEquals(5, ts.getStartTime(0));
	   assertEquals(13, ts.minCompletionTime());
	   
	   ts.addTaskConstraint(0, 1);
	   assertEquals(13, ts.minCompletionTime());
	   assertEquals(5, ts.getStartTime(0));
	   assertEquals(0, ts.getStartTime(1));
	   assertEquals(0, ts.getStartTime(2));
	   
	   ts.addTaskConstraint(1, 2);
	   assertEquals(16, ts.minCompletionTime());
	   assertEquals(8, ts.getStartTime(0));
	   assertEquals(5, ts.getStartTime(1));
	   assertEquals(0, ts.getStartTime(2));
	   
	   ts.addTaskConstraint(1,0);
	   assertEquals(-1, ts.minCompletionTime());
	   assertEquals(-1, ts.getStartTime(0));
	   assertEquals(-1, ts.getStartTime(1));
	   assertEquals(0, ts.getStartTime(2));
	   
   }

}