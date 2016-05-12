import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;

import Controllers.*;
import Models.*;

public class GameControllers extends javax.swing.JFrame {
	GamePanel gamePanel;
	PlayerController playerCont;
	TurnController turnCont;
	AIController ai;
	Map map;
	InfluenceMap neutralFound;
	InfluenceMap neutralFog;
	InfluenceMapController imc;
	InfluenceMap buildableInfluenceMap;
	int turnNumber;
	int currentPlayer;
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final double SCALE = 1.2;
	public static final String NAME = "Game";
	
	
	
	public GameControllers() throws java.io.IOException{
		neutralFound = new InfluenceMap(1);
		neutralFog = new InfluenceMap(1);
		imc = new InfluenceMapController();
		map = new Map(System.getProperty("user.dir") + "/assets/map1.txt", 0);
		playerCont = new PlayerController();
		turnCont = new TurnController();
		buildableInfluenceMap = new InfluenceMap(0);
		buildableInfluenceMap.setType("Buildable");
		
		playerCont.StartPlayer1();
		playerCont.StartPlayer2();
		map.MapUpdate(playerCont);
		imc.AllMapUpdate(map, playerCont);
		turnNumber = 1;
		currentPlayer = 1;
		ai = new AIController();
		
		
		
//		Map temp = new Map(System.getProperty("user.dir") + "/assets/map1.txt", 0);
//		ma.add(temp);
//		ma.get(0).MapUpdate(playerCont.getEntityContainer(1), ma.get(0));
//		ma.get(0).MapUpdate(playerCont.getEntityContainer(2), ma.get(0));
//		
//		temp  = new Map(ma.get(0));
//		ma.add(temp);
//		temp  = new Map(ma.get(0));
//		ma.add(temp);
//		
//		ma.get(1).MapSightUpdate(playerCont.getEntityContainer(1), ma.get(1));
//		ma.get(2).MapSightUpdate(playerCont.getEntityContainer(2), ma.get(2));
		
		turnCont.FillMoves(playerCont.getEntityContainer(currentPlayer));
		
		
		/*  Buranin ustu cok onemli    */
		
		
		final javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setPreferredSize(new java.awt.Dimension(400, 720));
		
		final GamePanel gamePanel = new GamePanel(map);
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
    	final javax.swing.JScrollPane jScrollPane1;
        final javax.swing.JScrollPane jScrollPane2;
        final javax.swing.JScrollPane jScrollPane3;
        javax.swing.JSeparator jSeparator1;
        javax.swing.JButton neutral_map;
        javax.swing.JButton player1_map;
        javax.swing.JButton player2_map;
        final javax.swing.JTextArea player_info;
        final javax.swing.JTextArea tile_info;
        javax.swing.JButton execute;
        final javax.swing.JTextPane console_command;
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
        execute = new javax.swing.JButton();
        console_command = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();

        next_move.setText("Next Move");
        //TODO: map update ve sight update ile alakalı daha etkili yol bul
        next_move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//System.out.println("You clicked Next Move");
            	
            	works();
            	
            	if (turnCont.getContainer().getSize()==0){
            		System.out.println("No more moves. End turn!");
            	}
            }
        });

        end_turn.setText("End Turn");
        end_turn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	while(turnCont.getContainer().getSize()!=0){
            		works();
                	
                	
            	}
            	changePlayer(currentPlayer);
            	turnCont.FillMoves(playerCont.getEntityContainer(currentPlayer));
            	//System.out.println("You clicked End Turn");
            	
            }
        });

        player2_map.setText("Player2 Map");
        player2_map.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt)
            {
        		//System.out.println("You clicked Player 2 Map");
        		gamePanel.setFound(playerCont.getPlayer(2).getIsFound());
        		gamePanel.setFogMap(playerCont.getPlayer(2).getFog());
            }
        });

       

        player1_map.setText("Player1 Map");
        player1_map.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt)
            {
        		//System.out.println("You clicked Player 1 Map");
        		gamePanel.setFound(playerCont.getPlayer(1).getIsFound());
        		gamePanel.setFogMap(playerCont.getPlayer(1).getFog());
            }
        });
        
        neutral_map.setText("Neutral Map");
        neutral_map.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	gamePanel.setFound(neutralFound);
            	gamePanel.setFogMap(neutralFog);
            	//System.out.println("You clicked neutral map");
            }
        });

        execute.setText("Execute");
        execute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//System.out.println("You clicked Refresh");
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
                	playerInfo = "Player " + t.getOwner() + ":\n\nIncome: " + playerCont.getPlayer(t.getOwner()).getIncome() + "\nTotal Gold: " + playerCont.getPlayer(t.getOwner()).getTreasure();
                }
                
                player_info.setText(playerInfo);
                jScrollPane3.setViewportView(player_info);
                
                //TODO: Barış, make cheat menu multi lined and use delimeters for parameter passing.
                ArrayList<String> commands = new ArrayList<String>();
                ArrayList<String> lines = new ArrayList<String>();
                int size;
                String setTextString = "";
                for(String line:console_command.getText().split("\n", 99)){
                	lines.add(line);
                }
                size = lines.size();
            	for(int i = 0;i<size;i++){
            		commands.clear();
            		for (String retval: lines.get(i).split(",", 99))
                    {
//            			System.out.println(i+". line "+retval);
                    	commands.add(retval);
                    }
            		if(!lines.get(i).equals(""))
            			System.out.println((i+1)+". line executed: "+lines.get(i));
            		setTextString = execute_command(commands);
            	}
                //test_command(commands);
                
            	console_command.setText(setTextString + "Enter a command to execute");
            	jScrollPane2.setViewportView(console_command);
            
            	
            }

			private void test_command(ArrayList<String> commands) {
				int size = commands.size();
				for(int i = 0;i<size;i++)
					System.out.println(commands.get(i));
				
			}

			//if setText used return true
			private String execute_command(ArrayList<String> c) {
				String s = "";
				if(c.get(0).equalsIgnoreCase("showEntity")){
					
					playerCont.getEntityContainer(Integer.parseInt(c.get(1))).PrintToConsole();
				}else
				if(c.get(0).equalsIgnoreCase("help")){
					System.out.println();
				}else
				if(c.get(0).equalsIgnoreCase("helpcreate")){
					s = "create(owner, x, y, entity)\nEntity 1 = Town\nEntity 2 = Tower\nEntity 3 = Mine1\nEntity 4 = Mine2\nEntity 5 = Barracks\nEntity 6 = Tile Improvement\nEntity 7 = Melee\nEntity 8 = Range\nEntity 9 = Cavalier\nEntity 10 = Siege\nEntity 11 = Worker\n";
					return s;
				}else
				if(c.get(0).equalsIgnoreCase("create")){
					playerCont.getEntityContainer(Integer.parseInt(c.get(1))).Create(Integer.parseInt(c.get(2)), Integer.parseInt(c.get(3)), Integer.parseInt(c.get(4)), Integer.parseInt(c.get(1)));
				}else
				if(c.get(0).equalsIgnoreCase("showFog")){
					playerCont.getPlayer(Integer.parseInt(c.get(1))).getFog().printList();
				}else
				if(c.get(0).equalsIgnoreCase("showFound")){
					playerCont.getPlayer(Integer.parseInt(c.get(1))).getIsFound().printList();
				}else if(c.get(0).equalsIgnoreCase("mapUpdate")){
					map.MapUpdate(playerCont);
					imc.AllMapUpdate(map, playerCont);
				}else if(c.get(0).equalsIgnoreCase("showBattleIM")){
					ai.CalculateSituation(map, currentPlayer, playerCont.getPlayer(currentPlayer).getIsFound(), playerCont.getPlayer(currentPlayer).getFog(), playerCont.getPlayer(currentPlayer));
					ai.getBattleInfluenceMap().printList();
				}else if(c.get(0).equalsIgnoreCase("showDefenceIM")){
					ai.CalculateSituation(map, currentPlayer, playerCont.getPlayer(currentPlayer).getIsFound(), playerCont.getPlayer(currentPlayer).getFog(), playerCont.getPlayer(currentPlayer));
					ai.getDefensivenessInfluenceMap().printList();
				}else if(c.get(0).equalsIgnoreCase("showBuildableIM")){
					imc.BuildableInfluenceMapCalculation(map, playerCont, buildableInfluenceMap);
					buildableInfluenceMap.printList();
				}else if(c.get(0).equalsIgnoreCase("renderatm")){
					gamePanel.setSpecial(ai.getAtm());
				}else if(c.get(0).equalsIgnoreCase("renderBattleIM")){
					gamePanel.setSpecial(ai.getBattleInfluenceMap());
				}else if(c.get(0).equalsIgnoreCase("renderDefenceIM")){
					gamePanel.setSpecial(ai.getDefensivenessInfluenceMap());
				}else if(c.get(0).equalsIgnoreCase("renderBuildableIM")){
					gamePanel.setSpecial(buildableInfluenceMap);
				}else if(c.get(0).equalsIgnoreCase("showatm")){
					imc.UpdateATM(map, ai.getAtm());
					ai.getAtm().printList();
				}else if(c.get(0).equalsIgnoreCase("printMap")){
					map.PrintMap();
				}
				return s;
				
			}
        });
        
        
        
        console_command.setEditable(true);
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
                .add(execute, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                        .add(jScrollPane1))
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(execute, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
	public void works(){
		ai.DirectAI(turnCont.getContainer(), map,turnNumber,playerCont.getEntityContainer(currentPlayer),playerCont.getPlayer(currentPlayer).getIsFound(),playerCont.getPlayer(currentPlayer));
		imc.IsFoundCalculation(map, playerCont.getPlayer(currentPlayer));
    	imc.FogCalculation(map, playerCont.getPlayer(currentPlayer));
	}
	public void changePlayer(int x){
		
		if(x == 2){
			currentPlayer = 1;
			//ai.CalculateSituation(map, currentPlayer,playerCont.getPlayer(currentPlayer).getIsFound());
			turnNumber++;
		}else if(x == 1){
			currentPlayer = 2;
			//ai.CalculateSituation(map, currentPlayer,playerCont.getPlayer(currentPlayer).getIsFound());
		}
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