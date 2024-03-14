public class TbMain {
  public static void main(String[] args) {
    int[] tab1;
    tab1 = new int[10];
    tab1 = {1,55,3,8,4,9,59,2,20,11};
    for (int i =0;i<10;i++ ) {
      System.out.println(tab1[i]);
    }

    System.out.println("--------------------------");

    int taille = tab1.length;
    for(int i=0; i < taille; i++) {
      for(int j=1; j < (taille-i); j++){
              if(tab[j-1] > tab[j]){
                      tmp = tab[j-1];
                      tab[j-1] = tab[j];
                      tab[j] = tmp;
                    }

            }
      }
  }
}
