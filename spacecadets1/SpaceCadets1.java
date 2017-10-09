package spacecadets1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SpaceCadets1 {

    public static void main(String[] args) throws IOException {
        //boolean to control repetition of the process
        Boolean b = true;
        while (b) {
            //input using a buffered reader for input email id
            System.out.println("Input an Email ID: ");
            BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
            String emailid = input1.readLine();
            //concatenation of the main url and the email id to produce the full specific url
            String urlstring = "http://www.ecs.soton.ac.uk/people/" + emailid;
            URL url = new URL(urlstring);
            //second buffered reader used to read the html from the website
            BufferedReader input2 = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            String fullname;
            //looping through each line in the hmtl source code
            while ((inputLine = input2.readLine()) != null) {
//            System.out.println(inputLine);
                //searching for the line which includes the name
                if (inputLine.contains("property=\"name\"")) {
                    //using substrings to find the full name from that specific hmtl source code line and printing
                    fullname = inputLine.substring(inputLine.indexOf("name\"") + 6, inputLine.indexOf("</h1>"));
                    System.out.println(fullname);
                }
            }
            input2.close();
            //option to leave the program or go again
            System.out.print("Type \"N\" to leave or press enter to continue.");
            String ans = input1.readLine();
            if(ans.equals("N")){
                b=false;
            }
        }
    }

}
