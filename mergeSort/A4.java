package a4;

import a4.Sort;
import java.util.Random;


/**
 *  A test class for various sorting methods
 * 
 * @author Jeff Smith, except as noted 
 * @version for Assignment 4, CS 146, SJSU, Spring 2012
 */
public class A4
{
    public static int DUMMY_COUNT = -999;

    /**
     * Randomly rearrange an array.
     * The random numbers used depend on a specified seed
     * @author Mark A Weiss, as modified by Jeff Smith 
     * @param a the array.
     * @param seed the seed 
     */

    public static <AnyType extends Comparable<? super AnyType>>
    void permute(AnyType[] a, long seed)                       {
      Random r = new Random(seed);   
      for( int j = 1; j < a.length; j++ )
        Sort.swapReferences( a, j, r.nextInt(j) );             }

    
    public static void main( String [ ] args )
    {

      CountingComparator cc = new CountingComparator();
      for( int NUM_ITEMS  = 1; NUM_ITEMS  < 10; NUM_ITEMS++)
      {
        StringWrapper [ ] a = new StringWrapper[ NUM_ITEMS ];
        for( int i = 0; i < a.length; i++ )
            a[ i ] = new StringWrapper("s" + i, cc);
        permute(a, NUM_ITEMS  );
        MergeSorter.mergeSort2( a );
        System.out.print("sorted for n = " + a.length 
            + ": " + MergeSorter.checkSort( a ));
        permute(a, NUM_ITEMS  );
       MergeSorter.mergeSort4( a );
        System.out.print("; " + MergeSorter.checkSort( a ));
        permute(a, NUM_ITEMS  );
        MergeSorter.mergeSort4Tree( a );
        System.out.println("; " + MergeSorter.checkSort( a ));*/
      }
      System.out.println();
      
      cc.resetCounter();
            System.out.print("insertionSort ");
            System.out.print("heapsort ");
            System.out.print("mergeSort ");
            System.out.print("mergeSort2 ");
            System.out.print("mergeSort4 ");
            System.out.print("mergeSort4T ");
            System.out.print("quicksort ");
            System.out.println("quickselect ");
            
      for( int NUM_ITEMS  = 100; NUM_ITEMS  < 10000; NUM_ITEMS *=2 )
        {
        StringWrapper [ ] a = new StringWrapper[ NUM_ITEMS ];
        for( int i = 0; i < a.length; i++ )
            a[ i ] = new StringWrapper("s" + i, cc);
        System.out.print(String.format("%4d:",a.length));
            permute(a, NUM_ITEMS  );
            Sort.insertionSort( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();
            
            permute(a, NUM_ITEMS  );
            Sort.heapsort( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();

            permute(a, NUM_ITEMS  );
            Sort.mergeSort( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();

            permute(a, NUM_ITEMS  );
            MergeSorter.mergeSort2( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();

            permute(a, NUM_ITEMS  );
            MergeSorter.mergeSort4( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();

            permute(a, NUM_ITEMS  );
            MergeSorter.mergeSort4Tree( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();

            permute(a, NUM_ITEMS  );
            Sort.quicksort( a );
            System.out.print(String.format("%9d",
              (MergeSorter.checkSort( a )?cc.getCounter():DUMMY_COUNT)));
            cc.resetCounter();

            System.out.print(String.format("%7s", a[NUM_ITEMS/2 - 1]));
            permute(a, NUM_ITEMS  );
            Sort.quickSelect( a, NUM_ITEMS / 2 );
            System.out.print(String.format("%7s", 
                a[ NUM_ITEMS / 2 - 1 ]));
            System.out.print(String.format("%9d",
              cc.getCounter()));
            cc.resetCounter();

          System.out.println();
        }
        
        
        StringWrapper [ ] b = new StringWrapper[1000000];
        for( int i = 0; i < b.length; i++ )
            b[ i ] = new StringWrapper("s" + i, cc);
        
        permute( b, 0 );
        long start = System.currentTimeMillis( );
        Sort.quickSelect( b, b.length  / 2 );
        long end = System.currentTimeMillis( );
        System.out.println( "Timing for Section 1.1 example: " );
        System.out.println( "Selection for N = " + b.length + " takes " + 
                             ( end - start ) + "ms." );
            System.out.print("quickselect ");
            System.out.println("used " + cc.getCounter() +
              " comparisons for n = 1_000_000");
            cc.resetCounter();
        System.out.println( b[ b.length / 2 - 1 ] + " " + b.length / 2 );

        b = new StringWrapper[2000000];
        for( int i = 0; i < b.length; i++ )
            b[ i ] = new StringWrapper("s" + i, cc);
        
        permute( b, 0 );
        start = System.currentTimeMillis( );
        Sort.quickSelect( b, b.length  / 2 );
        end = System.currentTimeMillis( );
        System.out.println( "Timing for Section 1.1 example: " );
        System.out.println( "Selection for N = " + b.length + " takes " + 
                             ( end - start ) + "ms." );
            System.out.print("quickselect ");
            System.out.println("used " + cc.getCounter() +
              " comparisons for n = 2_000_000" );
            cc.resetCounter();
        System.out.println( b[ b.length / 2 - 1 ] + " " + b.length / 2 );
    
    }
}
