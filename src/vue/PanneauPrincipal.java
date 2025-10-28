package vue;

import modele.physique.Position;
import modele.reseau.Antenne;
import modele.reseau.Cellulaire;
import modele.reseau.Reseau;
import observer.MonObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanneauPrincipal extends JPanel implements MonObserver {

    private static int RAYON_ANTENNE = 20;
    private static int RAYON_INDIVIDU = 10;

    Dimension taille;
    Reseau reseau = Reseau.getInstance();

    public PanneauPrincipal(Dimension taille) {
        this.taille = taille;
        rafraichirDessin();
        reseau.attacherObserver(this);
    }

    private void rafraichirDessin() {
        validate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // convertit en moteur graphique 2D
        Graphics2D g2 = (Graphics2D) g;

        // appel au paint de base
        super.paintComponent(g);
        // efface l'cran
        g2.clearRect(0, 0, taille.width, taille.height);

        dessineCellulaires(g2);
        dessineAntennes(g2);

        // termine le dessin
        g2.dispose();
    }

    public void dessineCellulaires(Graphics2D g) {
        ArrayList<Cellulaire> cellulaires = reseau.getCellulaires();

        // dessine tous les cellulaires
        for (Cellulaire cellulaire : cellulaires) {
            Position position = cellulaire.getPosition();

            if (cellulaire.estConnecte()) {
                double test = cellulaire.getNumConnexion() / (double) Integer.MAX_VALUE;
                test *= 3;
                if (test <= 1) {
                    g.setColor(new Color((float) test % 1, 0.0f, 0.0f));
                } else if (test <= 2) {
                    test -= 1.0;
                    g.setColor(new Color(0.0f, (float) test % 1, 0.0f));
                } else {
                    test -= 2.0;
                    g.setColor(new Color((float) test % 1, 0.0f, (float) test % 1));
                }
            } else {
                g.setColor(Color.BLUE);
            }

            g.fillOval(
                    (int) position.getX() - RAYON_INDIVIDU,
                    (int) position.getY() - RAYON_INDIVIDU,
                    2 * RAYON_INDIVIDU,
                    2 * RAYON_INDIVIDU
            );
        }
    }

    public void dessineAntennes(Graphics2D g) {
        ArrayList<Antenne> antennes = reseau.getAntennes();

        for (Antenne antenne : antennes) {
            Position position = antenne.getPosition();
            g.setColor(Color.DARK_GRAY);
            g.fillOval(
                    (int) position.getX() - RAYON_ANTENNE,
                    (int) position.getY() - RAYON_ANTENNE,
                    2 * RAYON_ANTENNE,
                    2 * RAYON_ANTENNE
            );
        }
    }

    @Override
    public void avertir() {
        rafraichirDessin();
    }
}

