import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GameControllers extends JFrame {
	GamePanel gamePanel;
	public Map m;
	public Map m2;
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final double SCALE = 1;
	public static final String NAME = "Game";
	
	
	
	public GameControllers() throws IOException{
		Map m = new Map();
		m.setTileType(1, 0, 1);
		
		Map m2  = new Map(1);
		
		
		final JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setPreferredSize(new Dimension(400, 720));
		
		final GamePanel gamePanel = new GamePanel(m);
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		gamePanel.setPreferredSize(new Dimension(1920, 1920));

        final JScrollPane scroll = new JScrollPane(gamePanel);

		setMinimumSize(new Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		setMaximumSize(new Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		setPreferredSize(new Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.EAST);
        add(scroll, BorderLayout.CENTER);
        setVisible(true);
		
        pack();
		
		setResizable(false);
		setLocationRelativeTo(null);
		gamePanel.setM(m2);
		
	}
	
}
