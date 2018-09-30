package com.mnp.dynamic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ColletionMisc
{
    
    public static void main( String[] args )
    {
        Map<Integer,Integer> lMap = new HashMap<>();
        lMap.put( 1, 1 );
        lMap.put( 2, 2 );
        Set<Entry<Integer,Integer>>lSet=lMap.entrySet();
        Iterator<Entry<Integer,Integer>> lEntryIter= lSet.iterator();
        while(lEntryIter.hasNext())
        {
           System.out.println(  lEntryIter.next());
            //lEntryIter.remove();   
            //lMap.put( 1,3);
            lMap.remove( 1);
        }
        
        List<Integer> lCopyArrList= new CopyOnWriteArrayList<>();
        lCopyArrList.add( 1);
        lCopyArrList.add( 1);
        Iterator<Integer> lCopyLstIterator = lCopyArrList.iterator();
        while(lCopyLstIterator.hasNext())
        {
           Integer l= lCopyLstIterator.next();
            System.out.println( lCopyArrList.add(2));
            System.out.println(l);
        }
    }

}
