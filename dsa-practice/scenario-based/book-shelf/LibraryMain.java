public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library("Global library");

        library.addBook("Carol", "Ava", "Coming of age");
        library.addBook("Wonderland", "Ava", "Fantasy");
        library.addBook("My guitar","Rose","Biography");
        library.addBook("Shumon","Sooya","Cartoon");
        library.addBook("Stay focused","Lily","Psychology");
        library.addBook("Trust yourself","Ruby","Psychology");

        library.printCatalog();

        try {
            Book book1 = library.borrowBook("Wonderland","Ava");
            Book book2 = library.borrowBook("Trust yourself","Ruby");
            library.returnBook(book1);
            library.removeBook("Wonderland","Ava");
            library.returnBook(book2);
        }
        catch (BookNotAvailableException e) {
            System.out.println(e);
        }
    }
}
