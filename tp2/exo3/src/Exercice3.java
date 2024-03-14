
public class Exercice3{
  public static void main(String[] args){
  
    int cpt=0;
  
    String s = args[0];
  
    for(int i = 0; i<s.length(); i++){
       if(s.charAt(i) == 'a'){
         cpt+=1;    
       }   
    }
    
    System.out.println("il y a "+cpt+" a dans : "+args[0]);
  }
}
