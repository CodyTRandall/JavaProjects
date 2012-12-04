package sjsu.cs146.bottomUpTwoThreeFourTree;

import junit.framework.TestCase;

public class BottomUpTwoThreeFourTreeTest extends TestCase
{
	BottomUpTwoThreeFourTree tree1;
   
    protected void setUp() throws Exception
    {
		super.setUp();
		tree1 = new BottomUpTwoThreeFourTree();
    }

    public void testAdd()
    {
		tree1.insert(60);
		tree1.insert(30);
		tree1.insert(10);
		assertEquals("10 30 60", tree1.search(30));
		tree1.insert(20);
		assertEquals("10 20", tree1.search(10));
		tree1.insert(40);
		assertEquals("40 60", tree1.search(40));
		tree1.insert(50);
		assertEquals("40 50 60", tree1.search(50));
		assertEquals("30", tree1.search(30));
		assertEquals("10 20", tree1.search(20));
		//tree1.insert(70);
		//assertEquals("60 70", tree1.search(70));
		//assertEquals("30 50", tree1.search(50));
    }  

    public void testSearch()
    {

	//assertEquals(10, p1.getPosition());
	//assertTrue(p1.isInJail());
	//assertFalse(p1.isOutOfGame());

    } 
    
}