public class GameControllers extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final double SCALE = 1;
	public static final String NAME = "Game";
	
	
	public GameControllers() throws java.io.IOException{
		final Map m = new Map();
		m.setTileType(5, 5, 1);
		Tile t;
		final Map m2  = new Map(1);
		
		final javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setPreferredSize(new java.awt.Dimension(400, 720));
		
		final GamePanel gamePanel = new GamePanel(m);
		gamePanel.setPreferredSize(new java.awt.Dimension(1920, 1920));

        final javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(gamePanel);

		setMinimumSize(new java.awt.Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		setMaximumSize(new java.awt.Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		setPreferredSize(new java.awt.Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setLayout(new java.awt.BorderLayout());
		
		add(panel, java.awt.BorderLayout.EAST);
        add(scroll, java.awt.BorderLayout.CENTER);
        setVisible(true);  
        
        // Variables declaration
    	javax.swing.JButton end_turn;
        javax.swing.JButton next_move;
    	javax.swing.JScrollPane jScrollPane1;
        javax.swing.JScrollPane jScrollPane2;
        javax.swing.JSeparator jSeparator1;
        javax.swing.JSeparator jSeparator2;
        javax.swing.JButton neutral_map;
        javax.swing.JButton player1_map;
        javax.swing.JButton player2_map;
        javax.swing.JTextArea player_info;
        javax.swing.JTextArea tile_info;
        // End of variables declaration
        
        next_move = new javax.swing.JButton();
        end_turn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        player2_map = new javax.swing.JButton();
        neutral_map = new javax.swing.JButton();
        player1_map = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tile_info = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        player_info = new javax.swing.JTextArea();

        next_move.setText("Next Move");
        next_move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked Next Move");
            }
        });

        end_turn.setText("End Turn");
        end_turn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked End Turn");
            }
        });

        player2_map.setText("Player2 Map");
        player2_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked Player 2");
            }
        });

        neutral_map.setText("Neutral Map");
        neutral_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked neutral map");
                gamePanel.setM(m);
            }
        });

        player1_map.setText("Player1 Map");
        player1_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked Player 1");
                gamePanel.setM(m2);
            }
        });

        tile_info.setEditable(false);
        player_info.setEditable(false);
        
        //TODO: problem is this tile is set only once. We need to set this frequently...
        t = gamePanel.getSelectedTile();
        
        String tileInfo = "\nTile info at x: 1, y: 2\nHealth : " + t.getType() + "\nI got the tile. \nBut only for once! No update here :(";
        tile_info.setText(tileInfo);
        jScrollPane1.setViewportView(tile_info);

        String playerInfo = "Player X: ";
        player_info.setText(playerInfo);
        jScrollPane2.setViewportView(player_info);

        
        //Need to add external JAR swing.jar to project buildpath to work! it is in the assets folder.
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1)
                .add(jSeparator2)
                .add(layout.createSequentialGroup()
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(48, 48, 48)
                            .add(next_move, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(end_turn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(neutral_map)
                            .add(18, 18, 18)
                            .add(player1_map)
                            .add(18, 18, 18)
                            .add(player2_map)))
                    .add(43, 43, 43))
                .add(layout.createSequentialGroup()
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE))
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                    .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(18, 18, 18)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(player1_map)
                        .add(player2_map)
                        .add(neutral_map))
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 237, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(end_turn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(next_move, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(26, 26, 26))
            );
        
        pack();
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
}
