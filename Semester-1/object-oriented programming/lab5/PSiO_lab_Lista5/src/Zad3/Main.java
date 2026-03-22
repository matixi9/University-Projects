package Zad3;

public class Main {
    public static void main(String[] args) {
        Content[] contents = new Content[5];

        contents[0] = new Article("Java", "DaVinci", "qwert");
        contents[1] = new TechnicalArticle("Python", "Sas", "qwert","Python");

        contents[0].render();
        contents[1].render();

    }
}
