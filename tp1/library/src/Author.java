
/**
 * Define author of books
 */

public class Author {
   /**
    * an Author is defined by its lastname, firstname, and birth year
    *
    * @param lastname  author's lastname
    * @param firstname author's firstname
    * @param birhtyear author's birth year
    */
   public Author(String lastname, String firstname, int birthYear) {
      this.lastname = lastname;
      this.firstname = firstname;
      this.birthYear = birthYear;
   }

   private String lastname;
   private String firstname;
   private int birthYear;

   /**
    * this author's lastname
    *
    * @return this author's lastname
    */
   public String getLastname() {
      return this.lastname;
   }

   /**
    *this author's firstname
    *
    * @return this author's firstname
   */
   public String getFirstname() {
     return this.firstname;
   }

   /**
   *this author's birthYear
   *
   *@ return this author's birthYear
   */
   public int getBirthYear() {
     return this.birthYear;
   }

   /**
   *this author's full name
   *
   *@return this author's fulname
   */
   public String getFullName() {
     return this.firstname +" "+ this.lastname;
   }

   /**
    * get author information as a String
    *
    * @return description for this author
    */
   public String toString() {
      return this.firstname + " " + this.lastname + " born in " + this.birthYear;
   }

}
