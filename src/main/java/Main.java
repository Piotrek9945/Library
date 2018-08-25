import evidence.LibraryEvidence;

public class Main {

    public static void main(String[] args){
        LibraryEvidence ev = new LibraryEvidence();
        ev.addNewBookToLibrary("Pan Tadeusz", 1783, "Adam Mickiewicz");
        ev.addNewBookToLibrary("Ogniem i Mieczem", 1812, "Henryk Sienkiewicz");
        ev.addNewBookToLibrary("Kaczor Donald", 1212, "Walt Disney");
        ev.lendBook(2, "Piotr Babiuch");
        ev.listBookDetailsById(ev.searchBook(null, null, "Adam Mickiewicz").getId());
        ev.listLibraryBookList();
    }

}
