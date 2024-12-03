package meujogo;

import javax.swing.JFrame;
import meujogo.modelo.Fase;

public class Conteiner extends JFrame {

    public Conteiner() {
        add(new Fase());
        setTitle("Meu Jogo"); //Título do Jogo
        setSize(1024, 728); //Tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quando coloca no X ele fecha
        setLocationRelativeTo(null); //Tela aparece no meio
        this.setResizable(true); //Controle de Aumentar e Diminuir a tela
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Conteiner();
    }
}
