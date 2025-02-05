package stringbuffer;

public class ConcatenateStrings {
    //create method to concate strings
    public static String concateStrings(String []string)
    {
        //create  stringbuffer which will store the string elements
        StringBuffer stringBuffer1=new StringBuffer();

        for(int i=0;i<string.length;i++)
        {
          stringBuffer1.append(string[i]);
        }

          return stringBuffer1.toString();
    }
    public static void main(String[] args) {
        //create an array
        String[]  string= {"Sandeep","is","good","person"};
        //StringBuffer stringBuffer= new StringBuffer();
        //create  new string
        String string3=new String();
        //to store the resulatant string
        string3=concateStrings(string);
        //printed the string
        System.out.println(string3);

    }
}
