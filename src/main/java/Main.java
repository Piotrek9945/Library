import app.Library;

public class Main {

    public static void main(String[] args){
        Library ev = new Library();
        ev.addNewBookToLibrary("Pan Tadeusz", 1783, "Adam Mickiewicz");
        ev.lendBook(1, "asd");
        ev.removeBookFromLibrary(1);
        ev.listLibraryBookList();
    }

}
