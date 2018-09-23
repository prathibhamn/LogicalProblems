package com.mnp.strings;

public class StringMisc
{
    public static void main( String[] args )
    {
        //String localPrefix = "297"; //1
        String localPrefix = new Integer(297).toString().intern();
        String prefix = "297"; //2
        if( prefix == localPrefix )
        {
            System.out.println( "Strings are equal" );
        }
        else
        {
            System.out.println( "Strings are different" );
        }
    }
}
