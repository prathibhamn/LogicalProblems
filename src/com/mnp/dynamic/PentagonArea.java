package com.mnp.dynamic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PentagonArea
{

    public static void main( String[] args )
    {
        Map<String, Integer> lmap = new HashMap<>();
        lmap.entrySet()
            .stream()
            .sorted( Map.Entry.comparingByValue() )
            .collect( Collectors.toMap( Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        ( oldValue,
                                          newValue ) -> oldValue,
                                        LinkedHashMap::new ) );
        System.out.println( PentagonArea.trapArea( 5, 40, 16 ) );
    }

    static int trapArea( int n,
                         double p,
                         double r )
    {

        return (int) Math.round( -p * p / Math.tan( p = Math.PI / n ) / 4 / n + r * r * n / 2 * Math.sin( p * 2 ) );
    }
}
