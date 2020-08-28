package by.kremen.bookshop;

import by.kremen.bookshop.library.*;
import by.kremen.exceptions.*;

public interface Work {
    void SaleBook(Book b) throws EmptyShelf, NoMatch;
    void SaleJournal(Journal j) throws EmptyShelf, NoMatch;
    void SaleCard(PostCard p) throws EmptyShelf, NoMatch;
    void SortByPrice() throws EmptyShelf;
    void AddToLibrary(Literature b);
}
