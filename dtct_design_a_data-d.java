import java.awt.*;
import javax.swing.*;
import java.util.*;

public class DataDrivenGamePrototypeDashboard {
    private JFrame frame;
    private JPanel gameDataPanel;
    private JTable gameDataTable;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addGameButton;
    private JButton deleteGameButton;
    private DefaultTableModel tableModel;

    private List<Game> games;

    public DataDrivenGamePrototypeDashboard() {
        initUI();
        loadGames();
    }

    private void initUI() {
        frame = new JFrame("Data-Driven Game Prototype Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameDataPanel = new JPanel();
        gameDataPanel.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[] {"Game ID", "Game Name", "Genre", "Release Date"}, 0);
        gameDataTable = new JTable(tableModel);
        gameDataTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        JScrollPane tableScrollPane = new JScrollPane(gameDataTable);

        searchField = new JTextField();
        searchButton = new JButton("Search");
        addGameButton = new JButton("Add Game");
        deleteGameButton = new JButton("Delete Game");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchField);
        buttonPanel.add(searchButton);
        buttonPanel.add(addGameButton);
        buttonPanel.add(deleteGameButton);

        gameDataPanel.add(tableScrollPane, BorderLayout.CENTER);
        gameDataPanel.add(buttonPanel, BorderLayout.NORTH);

        frame.getContentPane().add(gameDataPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void loadGames() {
        games = new ArrayList<>();
        // Load game data from database or file
        // For demonstration purposes, let's hardcode some data
        games.add(new Game(1, "Super Mario Bros.", "Platformer", "1985-09-13"));
        games.add(new Game(2, "The Legend of Zelda", "Action-Adventure", "1986-02-21"));
        games.add(new Game(3, "Pac-Man", "Arcade", "1980-05-22"));

        for (Game game : games) {
            tableModel.addRow(new Object[] {game.getId(), game.getName(), game.getGenre(), game.getReleaseDate()});
        }
    }

    private class Game {
        private int id;
        private String name;
        private String genre;
        private String releaseDate;

        public Game(int id, String name, String genre, String releaseDate) {
            this.id = id;
            this.name = name;
            this.genre = genre;
            this.releaseDate = releaseDate;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getGenre() {
            return genre;
        }

        public String getReleaseDate() {
            return releaseDate;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DataDrivenGamePrototypeDashboard();
            }
        });
    }
}