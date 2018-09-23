package com.mnp.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NGramIntersection
{

    public static void main( String[] args )
    {

    }

    private void process( String file,
                          HashMap<String, Boolean> cmap,
                          int n )
    {
        String[] words = file.split( " " );
        if( words.length < n )
            return;
        for( int i = 0; i < words.length - n; i++ )
        {
            StringBuilder sb = new StringBuilder();
            for( int j = i; j < n + i; j++ )
                sb.append( words[j] + " " );
            String key = sb.toString();
            if( cmap.containsKey( key ) )
                cmap.put( key, Boolean.TRUE );
            else
                cmap.put( key, Boolean.FALSE );
        }
    }

    public List<String> intersectionNGram( String file1,
                                           String file2,
                                           int n )
    {
        List<String> result = new ArrayList<>();
        HashMap<String, Boolean> cmap = new HashMap<>();
        process( file1, cmap, n );
        if( cmap.size() == 0 )
            return result;

        process( file2, cmap, n );
        for( String key : cmap.keySet() )
        {
            if( cmap.get( key ) )
                result.add( key );
        }
        return result;
    }
}
