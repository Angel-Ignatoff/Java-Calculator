package com.example;
import java.io.IOException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@WebServlet("/Converter")
public class Convertor extends Login{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Some hexadecimal data has been submitted");
		
		String user = request.getSession().getAttribute("unamee").toString();
		
		System.out.println("Session data: " + user);
		
		String input = request.getParameter("bin-number");
		
		System.out.println("User data: " + input);
		
		int result = 100001010;
		
		request.getSession().setAttribute("CONVERTER_RESULT", result);
		
		request.getRequestDispatcher("/user-welcome.jsp").forward(request, response);
	}
		
		//Insert normal/pure java logic to convert from binary to hex
		//......
		
		// Java program to convert Hexadecimal to Binary
		  
		
		  
		
		  
		    // declaring the method to convert
		    // Hexadecimal to Binary
		  public String hexToBinary(String hex)
		    {
		  
		        // variable to store the converted
		        // Binary Sequence
		        String binary = "";
		  
		        // converting the accepted Hexadecimal
		        // string to upper case
		        hex = hex.toUpperCase();
		  
		        // initializing the HashMap class
		        HashMap<Character, String> hashMap
		            = new HashMap<Character, String>();
		  
		        // storing the key value pairs
		        hashMap.put('0', "0000");
		        hashMap.put('1', "0001");
		        hashMap.put('2', "0010");
		        hashMap.put('3', "0011");
		        hashMap.put('4', "0100");
		        hashMap.put('5', "0101");
		        hashMap.put('6', "0110");
		        hashMap.put('7', "0111");
		        hashMap.put('8', "1000");
		        hashMap.put('9', "1001");
		        hashMap.put('A', "1010");
		        hashMap.put('B', "1011");
		        hashMap.put('C', "1100");
		        hashMap.put('D', "1101");
		        hashMap.put('E', "1110");
		        hashMap.put('F', "1111");
		  
		        int i;
		        char ch;
		  
		        // loop to iterate through the length
		        // of the Hexadecimal String
		        for (i = 0; i < hex.length(); i++) {
		            // extracting each character
		            ch = hex.charAt(i);
		  
		            // checking if the character is
		            // present in the keys
		            if (hashMap.containsKey(ch))
		  
		                // adding to the Binary Sequence
		                // the corresponding value of
		                // the key
		                binary += hashMap.get(ch);
		  
		            // returning Invalid Hexadecimal
		            // String if the character is
		            // not present in the keys
		            else {
		                binary = "Invalid Hexadecimal String";
		                return binary;
		            }
		        }
		  
		        // returning the converted Binary
		        return binary;
		    }
		  
		    // Driver Code
		    public static void main(String[] args)
		    {
		  
		        // instantiating the class
		        HexaBinary ob = new HexaBinary();
		        
		        // input hexadecimal to convert into binary
		        String hex = "afcde";
		        
		        System.out.println(hex.toUpperCase());
		        
		        // printing and calling the
		        // hexToBinary() function
		        System.out.println(ob.hexToBinary(hex));
		        
		    
		        //http://download.eclipse.org/releases/kepler

		        
		        
		        //Java program to convert HexaDecimal to Decimal
		        //given hexadecimal number
		            String hexnum = "";
		                    
		           //converting hex to decimal by passing base 16 
		               int num = Integer.parseInt(hexnum,16);
		                    
		               System.out.println("Decimal equivalent of given hex number: "+num);
		              
		        
		        
		    }
		
		
		    
		
		
	}

