package Zad3;

public class TechnicalArticle extends Article {
    protected String technology;

    public TechnicalArticle(String title, String author, String text,String technology) {
        super(title, author, text);
        this.technology = technology;
    }

    public void render() {
        super.render();
        System.out.println("Technology: " + technology);
    }
}
