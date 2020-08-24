package app.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import game.Game;
import game.GameManager;

public class GameFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private Game game;
	private GamePanel gamePanel;

	public GameFrame(final String frameTitle)
	{
		super(frameTitle);

		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenuItem newGameMenuItem = new JMenuItem("New");
		
		newGameMenuItem.addActionListener(this);

		gameMenu.add(newGameMenuItem);
		menuBar.add(gameMenu);
		setJMenuBar(menuBar);

		setSize(500, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setGame(GameManager.setupGame(20, 20));
		this.gamePanel = new GamePanel(getGame(), 15, 50, 50);
		add(gamePanel);
		
		setVisible(true);
		
		startNewGame();
	}

	public Game getGame()
	{
		return game;
	}

	private void setGame(Game game)
	{
		this.game = game;
	}

	public GamePanel getPanel()
	{
		return gamePanel;
	}
	
	private void startNewGame() {
		try
		{
			GameManager.playGame(getGame(), getPanel());
		} catch (InterruptedException exception)
		{
			//TODO: throw error pop-up
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		setGame(GameManager.setupGame(20, 20));
		getPanel().setGame(getGame());
		
		new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				startNewGame();
			}
		}).start();
		
	}
}
