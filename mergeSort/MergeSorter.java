
package a4;

import java.util.*;

public class MergeSorter {

    public static <AnyType extends Comparable<? super AnyType>> boolean checkSort( AnyType[] a ){
        for( int i = 1; i < a.length; i++ ){
            if(a[i].compareTo(a[i-1])>0){
                return false;
            }
        }
        return true;
    } 
    static <AnyType extends Comparable<? super AnyType>> void mergeSort2( AnyType[] a){
        AnyType [] a1 = (AnyType[]) new Comparable[a.length];
        
        mergeSort2(a, a1, 0, a.length-1);
    }
    
    static <AnyType extends Comparable<? super AnyType>> void mergeSort2(AnyType[] a, AnyType[] a1, int left, int right){
        if(left<right){
            int center = (left+right)/2;
            mergeSort2(a, a1, left, center);
            mergeSort2(a, a1, center+1, right);
            merge2(a, a1, left, center+1, right);
        }
    }
    
    static <AnyType extends Comparable<? super AnyType>> void merge2(AnyType[] a, AnyType[] a1, int leftC, int rightC, int rightEnd){
        /**********
         * LeftC....LeftEnd.RightC.....RightEnd
         */
        //Define the end of the left
        int leftEnd = rightC-1;
        int tmpC = leftC;
        int numElements = rightEnd-leftC+1;
        AnyType loser = null;
        AnyType [] winArray= (AnyType[]) new Comparable[a.length];
        
        while(leftC<= leftEnd && rightC <= rightEnd){
            //Compare the elements
            if(a[leftC].compareTo(a[rightC])<=0){
                a1[tmpC++] = a[leftC++];
                loser = a[rightC];
            }else{
                a1[tmpC++] = a[rightC++];
                loser = a[leftC];
            }
        }
        
        //Copy the rest of the first half
        while(leftC <= leftEnd){
            a1[tmpC++] = a[leftC++];
        }
        
        //Copy the rest of the right half
        while(rightC <= rightEnd){
            a1[tmpC++] = a[rightC++];
        }
        
        //Copy the array back
        for(int i=0; i<numElements; i++,rightEnd--){
            a[rightEnd] = a1[rightEnd];
        }
    }
 
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort4(AnyType[] a){
        AnyType [] a1 = (AnyType[]) new Comparable[a.length];
        AnyType [] a2 = (AnyType[]) new Comparable[a.length];
        AnyType [] a3 = (AnyType[]) new Comparable[a.length];
        AnyType [] a4 = (AnyType[]) new Comparable[a.length];
        

       
        mergeSort4(a,a1,a2,a3,a4,0,a.length);
    }    
    
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort4(AnyType[] a, AnyType[] a1, AnyType[] a2, AnyType[] a3, AnyType[] a4, int left, int right){     
        if(right-left>4){
            int center1 = (right+left)/4;
            int center2 = center1*2;
            int center3 = center1*3;
            mergeSort4(a,a1,a2,a3,a4,left,center1);
            mergeSort4(a,a1,a2,a3,a4,center1+1,center2);
            mergeSort4(a,a1,a2,a3,a4,center2+1,center3);
            mergeSort4(a,a1,a2,a3,a4,center3+1,right);
            merge4(a,a1,a2,a3,a4,left,center1+1,center2+1,center3+1,right);
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>> void merge4(AnyType[] a, AnyType[] a1, AnyType[] a2, AnyType[] a3, AnyType[] a4, int left, int center1, int center2, int center3, int right){
        int end1 = center1-1;
        int end2 = center2-1;
        int end3 = center3-1;
        int end4 = right;
        int tmpC = left;
        int total = left+center1+center2+center3+right;
        boolean empty1 = false;
        boolean empty2 = false;
        boolean empty3 = false;
        boolean empty4 = false;
        
        while(true){
            //Compare the elements from left to right
            //If left is less than all
            if(a[left].compareTo(a[center1])<=0 && 
                    a[left].compareTo(a[center2])<=0 &&
                    a[left].compareTo(a[center3])<=0 &&
                    a[left].compareTo(a[right])<=0 &&
                    !empty1){
                
                a1[tmpC++] = a[left++];
                if(left == end1){
                    empty1 = true;
                }
            }else if(a[center1].compareTo(a[center2])<=0 &&
                    a[center1].compareTo(a[center3])<=0 &&
                    a[center1].compareTo(a[right])<=0 &&
                    !empty2){
                
                a1[tmpC++] = a[center1++];
                if(center1 == end2){
                    empty2 = true;
                }
            }else if(a[center2].compareTo(a[center3])<=0 &&
                    a[center2].compareTo(a[right])<=0 &&
                    !empty3){
                
                a1[tmpC++] = a[center2++];
                if(center2 == end3){
                    empty3 = true;
                }
            }else if(!empty4){
                a1[tmpC++] = a[center3++];
                if(center3 == end4){
                    empty4 = true;
                }
            }else{
                break;
            }
        }
        //Copy the array back
        for(int i=0; i<total; i++,right--){
            a[right] = a1[right];
        }
    }

     public static <AnyType extends Comparable<? super AnyType>> void mergeSort4Tree(
    
}
