package org.nazar.service.dataVerify;

public class DataVerify {
	
	 private static final int PASS_LENGTH =8;
     
     public static boolean isValidlength(String input){
                
    
                 char [] data =  input.toCharArray();
                 boolean isValid=false;
                
                 if(!(data.length<PASS_LENGTH)){
                           
                            isValid=true;
                           
                 }
                
                
                 return isValid;
     }
    
     public static boolean isDigit(String input){
                
                 char [] data =  input.toCharArray();
                            boolean isFound=false;
                
                
                 for(int i=0; i<data.length; i++){
                           
                            if(Character.isDigit(data[i])){
                                       
                                        isFound=true;
                                       
                            }else{
                                       
                                        continue;
                            }
                
                 }
                
                 return isFound;
                
                
                
     }
    
                
                
    
     public static boolean foundUpperCase(String input){
                
                            char [] data =  input.toCharArray();
                            boolean isFound=false;
                           
    
                
                 for(int i=0; i<data.length; i++){
                           
                            if(Character.isUpperCase(data[i])){
                                       
                                        isFound=true;
                                       
                            }else{
                                       
                                        continue;
                            }
                
                 }
                
                 return isFound;
     }
    
  
    
     public static char[] clearWhiteSpaces(String s){
                
                 char[] data = s.toCharArray();
                
                 for(int i=0; i<data.length-1; i++){
                           
                            if(Character.isWhitespace(data[i])){
                                       
                                        //Object src, int srcPos, Object dest, int destPos, int length
                                       
                                        System.arraycopy(data, i+1, data, i, (data.length-(i+1)));
                                       
                                        char [] newArray = new char[data.length-1];
                                       
                                        System.arraycopy(data, 0, newArray, 0, data.length-1);
                                       
                                        data= newArray;
                                       
                            }else{
                                       
                                       
                                        continue;
                            }
                           
                           
                 }
                
                 return data;
                
                
     }

}
