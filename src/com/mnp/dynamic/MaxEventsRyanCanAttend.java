package com.mnp.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MaxEventsRyanCanAttend
{
    /**
    
    8 10
    2 3
    4 5
    11 12
    3 4
    5 6
    6 7
    8 9
    10 11
    7 8
    1 4
    **/

    public static void main( String[] args )
    {
        List<String> evenDetails = new ArrayList<>();
        List<String> evenDetails1 = new ArrayList<>();

        evenDetails1.add( "4 5" );
        evenDetails1.add( "3 4" );
        evenDetails1.add( "5 6" );
        evenDetails1.add( "2 3" );

        evenDetails.add( "8 10" );
        evenDetails.add( "2 3" );
        evenDetails.add( "4 5" );
        evenDetails.add( "11 12" );
        evenDetails.add( "3 4" );
        evenDetails.add( "5 6" );
        evenDetails.add( "6 7" );
        evenDetails.add( "8 9" );
        evenDetails.add( "10 11" );
        evenDetails.add( "7 8" );
        evenDetails.add( "1 4" );

        findMaximumEvents1( evenDetails1 );
        findMaximumEvents1( evenDetails );
       
        findMaximumEvents2( evenDetails1 );
        findMaximumEvents2( evenDetails );
        

    }
    static void findMaximumEvents1( List<String> eventDetails )
    {
        Map<Integer, Integer> lEvntMap = new TreeMap<Integer, Integer>();
        for( String evntDetail : eventDetails )
        {
            String[] splitArray = evntDetail.split( " " );
            lEvntMap.put( Integer.valueOf( splitArray[0] ), Integer.valueOf( splitArray[1] ) );
        }


        Iterator<Map.Entry<Integer, Integer>> lFindEvntCount1 = lEvntMap.entrySet().iterator();

        Integer lPreviousEndTime = null;
        Integer lCount = 0;
        while( lFindEvntCount1.hasNext() )
        {
            Entry<Integer, Integer> evnt = lFindEvntCount1.next();
            if( lPreviousEndTime == null )
            {
                lPreviousEndTime = evnt.getValue();
                lCount++;
            }
            else if( ( lPreviousEndTime < evnt.getKey() ) )
            {
                lCount++;
                lPreviousEndTime = evnt.getValue();
            }

        }
        System.out.println( "answer " + lCount );
    }
    //Proper Solution
    static void findMaximumEvents2( List<String> eventDetails )
    {
        Map<Integer, Integer> lEvntMap1 = new HashMap<Integer, Integer>();
        for( String evntDetail : eventDetails )
        {
            String[] splitArray = evntDetail.split( " " );
            lEvntMap1.put( Integer.valueOf( splitArray[0] ), Integer.valueOf( splitArray[1] ) );
        }

        List<Map.Entry<Integer, Integer>> lentryLst = new ArrayList<>();
        lentryLst.addAll( lEvntMap1.entrySet() );
        //Based on end time
        Collections.sort( lentryLst, new Comparator<Entry<Integer, Integer>>()
        {

            @Override
            public int compare( Entry<Integer, Integer> o1,
                                Entry<Integer, Integer> o2 )
            {
                return o1.getValue().compareTo( o2.getValue() );
            }

        } );
        Iterator<Map.Entry<Integer, Integer>> lFindEvntCount = lentryLst.iterator();


        Integer lPreviousEndTime = null;
        Integer lCount = 0;
        while( lFindEvntCount.hasNext() )
        {
            Entry<Integer, Integer> evnt = lFindEvntCount.next();
            if( lPreviousEndTime == null )
            {
                lPreviousEndTime = evnt.getValue();
                lCount++;
            }
            else if( ( lPreviousEndTime < evnt.getKey() ) )
            {
                lCount++;
                lPreviousEndTime = evnt.getValue();
            }

        }
        System.out.println( "answer 2 " + lCount );
    }

}
