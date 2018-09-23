package com.mnp.dynamic;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Your task is to build a type-ahead feature for an upcoming product.

When the user enters a word or set of words, we want to be able to "predict" what they're going to type next with some level of accuracy. We've chosen to implement this using the N-Gram algorithm defined here http://en.wikipedia.org/wiki/N-gram.

Your program should return a tuple of predictions sorted high to low based on the prediction score (up to a maximum of three decimal places, or pad with zeroes up to three decimal places i.e. 0.2 should be shown as 0.200), (if predictions share the same score, they are sorted alphabetically.) Words should be split by whitespace with all non-alphanumeric characters stripped off the beginning and end.

Prediction scores are calculated like this:
Occurrences of a word after an N-gram / total number of words after an N-gram
e.g. for an N-gram of length 2: 
ONE TWO ONE TWO THREE TWO THREE
"TWO" has the following predictions:
THREE:0.666,ONE:0.333
"THREE" occurred 2 times after a "TWO" and "ONE" occurred 1 time after a "TWO", for a total of 3 occurrences after a "TWO".

Your program will run against the following text. You may hardcode it into your program: 
Mary had a little lamb its fleece was white as snow;
And everywhere that Mary went, the lamb was sure to go. 
It followed her to school one day, which was against the rule;
It made the children laugh and play, to see a lamb at school.
And so the teacher turned it out, but still it lingered near,
And waited patiently about till Mary did appear.
"Why does the lamb love Mary so?" the eager children cry;"Why, Mary loves the lamb, you know" the teacher did reply."
Input:
Your program should read lines of text from standard input. Each line contains a number followed by a string, separated by a comma. The number is the n-gram length. The string is the text from the user. You will be predicting the text following this string.
Output:
For each line of input print a single line to standard output which is the predictions for what the user is going to type next.
 * @author MN.Prathibha
 *
 */
public class NGramAlog
{

    public static void main( String[] args )
    {

        String line = "the";
        String paragraph = "Mary had a little lamb its fleece was white as snow;\r\n"
            + "And everywhere that Mary went, the lamb was sure to go. \r\n"
            + "It followed her to school one day, which was against the rule;\r\n"
            + "It made the children laugh and play, to see a lamb at school.\r\n"
            + "And so the teacher turned it out, but still it lingered near,\r\n"
            + "And waited patiently about till Mary did appear.\r\n"
            + "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

        Map<String, String> lMap = nGramMethod( line, paragraph );
        List<Entry<String, String>> list = new LinkedList<Entry<String, String>>( lMap.entrySet() );
        Collections.sort( list, new Comparator<Entry<String, String>>()
        {
            @Override
            public int compare( Entry<String, String> o1,
                                Entry<String, String> o2 )
            {

                return o2.getValue().compareTo( o1.getValue() );
            }

        } );

        Iterator<Entry<String, String>> lIterator = list.iterator();
        while( lIterator.hasNext() )
        {
            Entry<String, String> lEntry = lIterator.next();
            System.out.print( lEntry.getKey() + "," + lEntry.getValue() + ";" );
        }
    }

    private static Map<String, String> nGramMethod( String line,
                                                    String paragraph )
    {
        Pattern pattern = Pattern.compile( line );
        Matcher matcher = pattern.matcher( paragraph );
        String splChars = "*|,\":<>[]{}`\';()@&$#%";
        int totalOccurance = 0;
        int lineIndex = 0;
        Map<String, String> lPredMap = new ConcurrentHashMap<>();
        String wrd = "";
        while( matcher.find() )
        {
            totalOccurance++;
            lineIndex = matcher.end();
            wrd = paragraph.substring( lineIndex + 1, paragraph.indexOf( " ", lineIndex + 1 ) );
            for( int i = 0; i < wrd.length(); i++ )
            {
                if( splChars.indexOf( wrd.charAt( i ) ) != -1 )
                {
                    wrd = wrd.substring( 0, wrd.indexOf( wrd.charAt( i ) ) );
                    break;
                }
            }
            if( !lPredMap.containsKey( wrd ) )
            {
                lPredMap.put( wrd, 1 + "" );
            }
            else
            {

                lPredMap.put( wrd, ( Integer.valueOf( lPredMap.get( wrd ) ) + 1 ) + "" );
            }
        }
        pattern = Pattern.compile( line );
        matcher = pattern.matcher( paragraph );
        double val = 0;
        Iterator<Entry<String, String>> lIterator = lPredMap.entrySet().iterator();
        while( lIterator.hasNext() )
        {
            Entry<String, String> lEntry = lIterator.next();
            val = (double) Double.valueOf( lEntry.getValue() ) / totalOccurance;
            lEntry.setValue( String.format( "%.3f", val ) );
        }
        return lPredMap;
    }

}
