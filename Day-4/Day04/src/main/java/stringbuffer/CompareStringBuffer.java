package stringbuffer;

public class CompareStringBuffer {

 static void   compareStrings(String string )
       {   //Create string buffer
           StringBuffer stringBuffer= new StringBuffer();
           //create start time of string buffer
           long startTimeSBF = System.nanoTime();
           //loop for appending elements of string
           for(int i=0;i<string.length();i++) {
               stringBuffer.append(string.charAt(i));
           }
           //create end time taken by string buffer
           long endTimeSBF = System.nanoTime();
           //printing the time taken by appending all the elements
           System.out.println("StringBuffer: "+ (endTimeSBF - startTimeSBF));

           StringBuilder stringBuilder= new StringBuilder();

           long startTimeSB = System.nanoTime();
            for(int j=0;j<string.length();j++) {
             stringBuilder.append(string.charAt(j));

            }
           long endTimeSB = System.nanoTime();
           System.out.println("StringBuilder: "+ (endTimeSB - startTimeSB));

       }

    public static void main(String[] args) {
                //create string
                String string = new String("Hello! guys");
                //Pringting the time taken by String Builder and Buffer
        compareStrings(string);
    }
}
