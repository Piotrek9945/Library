import app.Library;

public class Main {

    public static void main(String[] args){
        Library ev = new Library();
        ev.addNewBookToLibrary("Pan Tadeusz", 1783, "Adam Mickiewicz");
        ev.addNewBookToLibrary("Ogniem i Mieczem", 1745, "Henryk Sienkiewicz");
        ev.addNewBookToLibrary("Kaczor Donald", 1970, "Walt Disney");
        ev.lendBook(2, "Piotr Babiuch");
        ev.removeBookFromLibrary(1);
        ev.listLibraryBookList();
        ev.listBookDetailsById(2);
    }

}
