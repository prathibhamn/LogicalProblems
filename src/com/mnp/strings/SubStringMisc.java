package com.mnp.strings;

public class SubStringMisc
{
    public static void main( String[] args )
    {

        String str= "abc";
        str.substring( 2,2 );
        String strObj = new String("bcd22222222222222222222222222222222222");
        strObj.intern();
        String strObj1 = new String("bcd22222222222222222222222222222222222");
        System.out.println( strObj==strObj1 );
        char two = '2';
        char threee = '3';
        strObj1.replace(two, threee );
        Integer[] i = { 1337, 424242 };
        for(Integer j :i)
        {
            System.out.println( System.identityHashCode(j));
        }
        System.out.println(i );
        int[] i2 = { 1337, 424242 };
        
        int[] i21 = new int[5];
        System.out.println(i21);
        for(int kl:i21)
        {
            System.out.println( kl );
        }
        
        int[][] i3 = new int[5][3];
        int[][] i5 = new int[5][];
        System.out.println( i3 );
        for(int[] i4 : i3)
        {
            System.out.println( i4 );
            for(int i7:i4)
            {
                System.out.println( i7 );
            }

        }
        
        for(int[] i6 : i5)
        {
            System.out.println( i6 );
           // for(int i7:i6)
            {
               // System.out.println( i7 );
            }
        }
       System.out.println( i5 );
        //System.out.println( i2 );
        
        Integer s=20;
        Integer p= 30;
        swap(s,p=s);
        System.out.println( s  );
        System.out.println( p );
        
        Integer[][] k = 
                //new Integer[5][];
         new Integer[5][3];
        //k[4][2]=2;
        for(Integer[] l : k)
        {
            System.out.println( l );
            for(Integer m :l)
            {
                System.err.println( m );
            }
        }
        System.err.println( k );
        
        SubStringMisc[] lSubStringMisc= new SubStringMisc[6];
        System.out.println(lSubStringMisc  );
        for(SubStringMisc sbStringMisc:lSubStringMisc)
        {
            System.out.println( sbStringMisc );
        }
        
        Integer[] pp = new Integer[5];
        System.out.println( pp );
        for(Integer m :pp)
        {
            System.out.println(m);
        }
    }
    
    static void swap(Integer i , Integer j)
    {
        Integer temp = i;
        i=j.intValue();
        j=temp.intValue();
                
    }
}
