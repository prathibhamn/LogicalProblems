package com.mnp.dynamic;

public class WonkyWords
{
public static void main( String[] args )
{
    System.out.println( wonkyWords("I","You","I Love You"));
    
}

static int  wonkyWords(String indicator1, String indicator2, String text) {
    String requeireString = text.substring(text.indexOf(indicator1)+1,text.indexOf(indicator2));
    int lenght =requeireString.split( " " ).length;
    if(lenght==1)
        return  100;
        if  (lenght ==2)
        {
            return 400;
        }
        else{
            return 3;
        }
    //System.out.println(requeireString);
    
    
}

}
