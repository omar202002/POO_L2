package calc.gui;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import calc.Calculator;

import java.awt.event.WindowAdapter;

/**
 * Permet de visualiser à l'écran tout objet implémentant l'interface
 * Calculette.
 * 
 * @see Calculator.Calculette
 */
public class CalculatorView {

    private static final String SURPRISE_BUTTON_TEXT = " ??? ";

    private Calculator calc; // l'objet calculette associe
    private JTextField text; // ecran de la vue calculette

    /**
     * Crée une nouvelle VueCalculette en lui associant une Calculette
     * 
     * @param c
     *            une calculette
     */
    public CalculatorView(Calculator c) {
        this.calc = c;
    }

    /** Affiche à l'écran cette VueCalculette */
    public void run() {

        GridLayout g14 = new GridLayout(1, 4);
        GridLayout g41 = new GridLayout(4, 1);

        // le panel centre va contenir les colonnes de chiffres et le panel droit
        Panel centre = new Panel();
        centre.setLayout(g14);
        // ce dernier contenant les touches + et =
        Panel droit = new Panel();
        droit.setLayout(new GridLayout(2, 1));
        // le panel compose reunit les panels centre et haut
        Panel compose = new Panel();
        compose.setLayout(new BorderLayout());
        // ce dernier contenant les touches Raz, / , * et -
        Panel haut = new Panel();
        haut.setLayout(g14);

        // 1ere colonne de chiffres : 7 , 4 , 1 et 0
        Panel chiffres = new Panel();
        chiffres.setLayout(g41);
        chiffres.add(new BoutonCalculette(" 7 ", new Action() {
            protected void process() {
                calc.pressDigit(7);
            }
        }));
        chiffres.add(new BoutonCalculette(" 4 ", new Action() {
            protected void process() {
                calc.pressDigit(4);
            }
        }));
        chiffres.add(new BoutonCalculette(" 1 ", new Action() {
            protected void process() {
                calc.pressDigit(1);
            }
        }));
        chiffres.add(new BoutonCalculette(" 0 ", new Action() {
            protected void process() {
                calc.pressDigit(0);
            }
        }));
        centre.add(chiffres);
        // 2eme colonne de chiffres : 8 , 5 et 2
        chiffres = new Panel();
        chiffres.setLayout(g41);
        chiffres.add(new BoutonCalculette(" 8 ", new Action() {
            protected void process() {
                calc.pressDigit(8);
            }
        }));
        chiffres.add(new BoutonCalculette(" 5 ", new Action() {
            protected void process() {
                calc.pressDigit(5);
            }
        }));
        chiffres.add(new BoutonCalculette(" 2 ", new Action() {
            protected void process() {
                calc.pressDigit(2);
            }
        }));
        chiffres.add(new BoutonCalculette(SURPRISE_BUTTON_TEXT, new Action() {
         protected void process() {
             calc.pressSuprise();
         }
     }));
        centre.add(chiffres);
        // 3eme colonne de chiffres : 9 , 6 et 3 plus la touche Del
        chiffres = new Panel();
        chiffres.setLayout(g41);
        chiffres.add(new BoutonCalculette(" 9 ", new Action() {
            protected void process() {
                calc.pressDigit(9);
            }
        }));
        chiffres.add(new BoutonCalculette(" 6 ", new Action() {
            protected void process() {
                calc.pressDigit(6);
            }
        }));
        chiffres.add(new BoutonCalculette(" 3 ", new Action() {
            protected void process() {
                calc.pressDigit(3);
            }
        }));
        chiffres.add(new BoutonCalculette("Del", new Action() {
            protected void process() {
                calc.pressDel();
            }
        }));
        centre.add(chiffres);

        // les "grandes" touches + et =
        droit.add(new BoutonCalculette(" + ", new Action() {
            protected void process() {
                calc.pressPlus();
            }
        }));
        droit.add(new BoutonCalculette(" = ", new Action() {
            protected void process() {
                calc.pressEquals();
            }
        }));
        centre.add(droit);

        // les touches du haut Raz, / * et -
        haut.add(new BoutonCalculette("CC ", new Action() {
            protected void process() {
                calc.pressClear();
            }
        }));
        haut.add(new BoutonCalculette(" / ", new Action() {
            protected void process() {
                calc.pressDiv();
            }
        }));
        haut.add(new BoutonCalculette(" x ", new Action() {
            protected void process() {
                calc.pressMult();
            }
        }));
        haut.add(new BoutonCalculette(" - ", new Action() {
            protected void process() {
                calc.pressMinus();
            }
        }));

        // organisation finale dans compose
        compose.add(BorderLayout.NORTH, haut);
        compose.add(BorderLayout.CENTER, centre);

        text = new JTextField(Integer.toString(calc.getCurrentValue()));
        text.setEditable(false);
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));

        JFrame f = new JFrame("Calculette");
        f.addWindowListener(new Quitteur());
        f.add(BorderLayout.NORTH, text);
        f.add(BorderLayout.CENTER, compose);
        f.pack();
        f.setLocation(50, 50);
        f.setSize(new Dimension(300,300));
        f.setVisible(true);
    }

    // toute action sur la vue doit mettre a jour l'affichage
    // de la valeur
    abstract private class Action implements ActionListener {
        abstract protected void process();

        public void actionPerformed(ActionEvent e) {
            process();
            text.setText(Integer.toString(calc.getCurrentValue()));
        }
    }

    private class Quitteur extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    // (factorisation de code)
    private class BoutonCalculette extends Button {
        BoutonCalculette(String nom, ActionListener action) {
            super(nom);
            addActionListener(action);
        }
    }
}
