package Zad3;

public class Article extends Content {
    protected String text;

    public Article(String title, String author,String text) {
        super(title, author);
        this.text = text;
    }

    public void render() {
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);

    }

}
