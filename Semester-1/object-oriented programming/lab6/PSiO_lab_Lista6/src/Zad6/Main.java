package Zad6;

public class Main {
    public static void main(String[] args) {
        Renderable[] scene = new Renderable[10];

        scene[0] = new Sprite();
        scene[1] = new TextLabel("Witaj w grze!");
        scene[2] = new RectangleShape();
        scene[3] = new ImageTexture();
        scene[4] = new Sprite();
        scene[5] = new TextLabel("Wynik: 100 pkt");
        scene[6] = new RectangleShape();
        scene[7] = new ImageTexture();
        scene[8] = new Sprite();
        scene[9] = new TextLabel("Game Over");

        for (int i=0; i<scene.length; i++) {
            scene[i].render();
        }
    }
}
