import Controllers.*;
import Models.*;

public class GameControllers extends javax.swing.JFrame {
	GamePanelTest gamePanel;
	PlayerController playerCont;
	TurnController turnCont;
	AIController ai;
	public Map m;
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final double SCALE = 1;
	public static final String NAME = "Game";
	
	
	
	public GameControllers() throws java.io.IOException{
		playerCont = new PlayerController("test");
		turnCont = new TurnController();
		ai = new AIController();
		
		final Map m = new Map(System.getProperty("user.dir") + "/assets/map1.txt", 0);
		
		
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
        javax.swing.JScrollPane jScrollPane3;
        javax.swing.JSeparator jSeparator1;
        javax.swing.JButton neutral_map;
        javax.swing.JButton player1_map;
        javax.swing.JButton player2_map;
        javax.swing.JTextArea player_info;
        javax.swing.JTextArea tile_info;
        javax.swing.JButton refresh;
        javax.swing.JTextPane turn_log;
        // End of variables declaration
        
        next_move = new javax.swing.JButton();
        end_turn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        player2_map = new javax.swing.JButton();
        neutral_map = new javax.swing.JButton();
        player1_map = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tile_info = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        player_info = new javax.swing.JTextArea();
        refresh = new javax.swing.JButton();
        turn_log = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();

        next_move.setText("Next Move");
        next_move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked Next Move");
            	
            	turn_log.setText("Player 1 moved archer1 to x:15 y:19 and attacked to Player 2 warrior at x:16 y:19\nWhat a move\nReally");
                jScrollPane2.setViewportView(turn_log);
            }
        });

        end_turn.setText("End Turn");
        end_turn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked End Turn");
            	
            	turn_log.setText("Player 1 moved archer1 to x:15 y:19 and attacked to Player 2 warrior at x:16 y:19\nPlayer 1 built a tile improvement at x:25 y:40\nPlayer 1 ends turn.");
                jScrollPane2.setViewportView(turn_log);
            }
        });

        player2_map.setText("Player2 Map");
        player2_map.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt)
            {
        		MapUpdate(playerCont.getEntityContainer(2),m);
        		MapUpdate(playerCont.getEntityContainer(1),m);
            }
        });

        neutral_map.setText("Neutral Map");
        neutral_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked neutral map");
            }
        });

        player1_map.setText("Player1 Map");
        player1_map.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                /*boolean re = ai.checkMove(2, 2, playerCont.getEntityFromPlayerWithIndex(1, 0),m);
                if(re){
                	System.out.println("Bastýðýn yere gider");
                }else{
                	System.out.println("Gidemez");
                }*/
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.out.println("You clicked Refresh");
            	panel.revalidate();
            	Tile t;
            	t = gamePanel.getSelectedTile();
            	String tileInfo = "Tile info at x: " + t.getX() + ", y: " + t.getY() + "\nHealth : " + t.getHitpoint()*t.getType() + "\nI got the tile. \nIt works!";
                tile_info.setText(tileInfo);
                jScrollPane1.setViewportView(tile_info);
                
                String playerInfo;
                
                if (t.getOwner() == 0)
                {
                	playerInfo = "Neutral Map: --\n\nIncome: --\nTotal Gold: --";
                }
                else
                {
                	playerInfo = "Player " + t.getOwner() + ":\n\nIncome: " + playerCont.getPlayer(t.getOwner()).getRevenue() + "\nTotal Gold: " + playerCont.getPlayer(t.getOwner()).getTreasure();
                }
                
                player_info.setText(playerInfo);
                jScrollPane3.setViewportView(player_info);
                
            }
        });
        
        
        
        turn_log.setEditable(false);
        tile_info.setEditable(false);
        player_info.setEditable(false);
        
        //Need to add external JAR swing.jar to project buildpath to work! it is in the assets folder.
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1)
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
                .add(refresh, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createSequentialGroup()
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 196, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 188, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .add(jScrollPane2)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 286, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jScrollPane3))
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(refresh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(player1_map)
                        .add(player2_map)
                        .add(neutral_map))
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(end_turn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(next_move, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(57, Short.MAX_VALUE))
            );
        
        pack();
		
		setResizable(false);
		setLocationRelativeTo(null);
		//gamePanel.setM(m2);
		
	}
	
	public PlayerController getPlayerControlelr(){
		return this.playerCont;
	}
	void MapUpdate(EntityContainer e, Map m){
		int size = e.getSize();
		for(int i = 0;i<size;i++){
			m.getTile(e.getEntityFromIndex(i).getX(), e.getEntityFromIndex(i).getY()).setOwner(e.getEntityFromIndex(i).getOwner());
			m.getTile(e.getEntityFromIndex(i).getX(), e.getEntityFromIndex(i).getY()).setEntity(e.getEntityFromIndex(i).getEntityType());
		}
	}
	
}
