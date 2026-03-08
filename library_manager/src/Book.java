public class Book {

    private String title;
    private String author;
    private int pages;

    // Konstruktor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // Methode, um Seiten zu lesen
    public void readPages(int pagesRead) {
        pages -= pagesRead;
        if (pages < 0) {
            pages = 0;
        }
    }

    // toString-Methode für sauberen Output
    @Override
    public String toString() {
        return title + " by " + author + " (" + pages + " pages left)";
    }
}