package stringbuilder;

import java.util.HashSet;

public class RemoveDuplicates {
       String removeDuplicate(String string1 )
      {
          //create StringBuilder to store string
          StringBuilder stringBuilder= new StringBuilder();
          //create Hase Set
          HashSet<Character> haseset=new HashSet<>();

         for(int i=0;i<string1.length();i++)
         {
             char c= string1.charAt(i);
           if( ! haseset.contains(c))
           {
               haseset.add(c);
               stringBuilder.append(c);
           }

         }

          return stringBuilder.toString();
      }
    public static void main(String[] args) {
           RemoveDuplicates remove= new RemoveDuplicates();
           //create string from which duplicate will be remove
           String string1 = "Sandeep";
           String string2=remove.removeDuplicate(string1);
         //Printing the output
           System.out.println(string2);

    }
}
