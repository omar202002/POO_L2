
public class LibraryMain {

  public static void main(String[] args) {
    Author author_1 = new Author("Tolkien","JRR",1892);
    Book book_1 = new Book("Le Seigneur des Anneaux",author_1,1954,1600);
    System.out.println(book_1);

    System.out.println("--------------------------");

    Book book_2 = new Book("Bilbo le Hobbit",author_1,1937,408);

    Author author_2 = new Author("Herbert","Frank",1920);
    Book book_3 = new Book("Dune",author_2,1965);

    Library library_1 = new Library();
    library_1.addBook(book_1);
    library_1.addBook(book_2);
    library_1.addBook(book_3);

    library_1.displayBooks();

    System.out.println("--------------------------");

    System.out.println("the library contains "+ library_1.getNbBooks() + " books");
  }
}
