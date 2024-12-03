package meujogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player {
    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private java.util.List<Tiro> tiros;
    private boolean isVisivel;

    public Player() {
        this.x = 100; // Coordenada da tela onde o player vai aparecer inicialmente
        this.y = 100;
        isVisivel = true;

        tiros = new ArrayList<Tiro>();
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\spaceship1.png");
        imagem = referencia.getImage();

        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public void update() {
        x += dx; // Esse método é responsável por mover a nave no eixo x e no eixo y
        y += dy;
    }

    public void tiroSimples() {
        this.tiros.add(new Tiro(x + largura, y + (altura / 2)));
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, altura, largura);
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getExtendedKeyCode();

        if (codigo == KeyEvent.VK_A) { // Quando apertar a ele atira
            tiroSimples();
        }

        if (codigo == KeyEvent.VK_UP) { // Quando apertar para cima o dy vira -3
            dy = -3;
        }

        if (codigo == KeyEvent.VK_DOWN) { // Quando apertar para baixo o dy vira 3
            dy = 3;
        }

        if (codigo == KeyEvent.VK_LEFT) { // Quando apertar para esquerda o dx vira -3
            dx = -3;
        }

        if (codigo == KeyEvent.VK_RIGHT) { // Quando apertar para direita o dx vira 3
            dx = 3;
        }
    }

    public void keyReleased(KeyEvent tecla) { // Quando parar de pressionar a tecla o dx e o dy voltam a ser zero
        int codigo = tecla.getExtendedKeyCode();

        if (codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public java.util.List<Tiro> getTiros() {
        return tiros;
    }

}
