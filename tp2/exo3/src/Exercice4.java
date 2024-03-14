
public class Exercice4{
  public static void main(String[] args){

    int cpt=0;

    String s1 = args[0];

    char s2='.';

    if(args.length == 1){
      s2 = 'a';
    }
    else if(args.length == 2){
      s2=args[1].charAt(0);
    }

    for(int i = 0; i<s1.length(); i++){
       if(s1.charAt(i) == s2){
         cpt+=1;
       }
    }

    System.out.println("il y a "+cpt+" a dans : "+args[0]);
  }
}
