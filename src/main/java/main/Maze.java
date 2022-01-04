package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Hashtable;

public class Maze {
    public static final int size = 64;
    private static final String[] GENERATION_METHODS = {"0. Binary Tree", "1. DFS", "2. Eller's", "3. Kruskal's", "4. Prim's", "5. Sidewinder"};
    private static final String[] SOLVING_METHODS = {"0. BFS", "1. DFS", "2. Dijkstra's"};
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int HEIGHT = (int) ((int) screenSize.getHeight() - (screenSize.getHeight() * 0.2));
    public static final int WIDTH = HEIGHT;
    public static final int W = WIDTH / size;
    public static int speed = 0;
    public static boolean generated, solved;
    private int cols, rows;

    public Maze() {
        cols = Math.floorDiv(WIDTH, W);
        rows = cols;

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                createAndShowGUI();
            }
        });
    }

    public static void main(String[] args) {
        new Maze();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Java Mazes");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        frame.setContentPane(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MazeGridPanel grid = new MazeGridPanel(rows, cols);
        grid.setBackground(Color.WHITE);

        JPanel mazeBorder = new JPanel();
        final int BORDER_SIZE = 1;
        mazeBorder.setBounds(0, 0, WIDTH + BORDER_SIZE, HEIGHT + BORDER_SIZE);
        mazeBorder.setBackground(Color.WHITE);
        mazeBorder.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));

        mazeBorder.add(grid);

        container.add(mazeBorder);

        CardLayout cardLayout = new CardLayout();

        JButton runButton = new JButton("Run");
        JButton solveButton = new JButton("Solve");
        JButton resetButton = new JButton("Reset");
        JButton solveAgainButton = new JButton("Solve Again");

        JComboBox<String> genMethodsComboBox = new JComboBox<>(GENERATION_METHODS);
        JComboBox<String> solveMethodsComboBox = new JComboBox<>(SOLVING_METHODS);

        genMethodsComboBox.setMaximumRowCount(genMethodsComboBox.getModel().getSize());
        solveMethodsComboBox.setMaximumRowCount(solveMethodsComboBox.getModel().getSize());

        Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(1, new JLabel("Fast"));
        labels.put(40, new JLabel("Slow"));

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        card1.setLayout(new GridBagLayout());
        card2.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(5, 0, 5, 18);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.7;
        c.gridx = 0;
        c.gridy = 0;
        card1.add(genMethodsComboBox, c);
        card2.add(solveMethodsComboBox, c);


        c.gridheight = 2;
        c.weightx = 0.3;
        c.gridx = 1;
        c.gridy = 0;
        card1.add(runButton, c);
        card2.add(solveButton, c);

        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;

        JPanel card3 = new JPanel();
        card3.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        card3.add(solveAgainButton, c);
        c.gridx = 0;
        c.gridy = 1;
        card3.add(resetButton, c);
        c.gridx = 0;
        c.gridy = 2;

        JPanel cards = new JPanel(cardLayout);
        cards.setBorder(new EmptyBorder(0, 20, 0, 0));
        cards.setOpaque(false);
        cards.add(card1, "gen");
        cards.add(card2, "solve");
        cards.add(card3, "reset");

        container.add(cards);

        runButton.addActionListener(event -> {
            generated = false;
            solved = false;
            grid.generate(genMethodsComboBox.getSelectedIndex());
            cardLayout.next(cards);
        });

        solveButton.addActionListener(event -> {
            if (generated) {
                grid.solve(solveMethodsComboBox.getSelectedIndex());
                cardLayout.last(cards);
            } else {
                JOptionPane.showMessageDialog(frame, "Please wait until the maze has been generated.");
            }
        });

        solveAgainButton.addActionListener(event -> {
            if (solved) {
                grid.resetSolution();
                cardLayout.show(cards, "solve");
            } else {
                JOptionPane.showMessageDialog(frame, "Please wait until the maze has been solved.");
            }
        });

        resetButton.addActionListener(event -> {
            frame.setVisible(false);
            createAndShowGUI();
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
