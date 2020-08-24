package app.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import game.GameUI;
import game.board.Point;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, GameUI
{

	private static final long serialVersionUID = -5194744397408657473L;

	private final int size;
	private final int panelX;
	private final int panelY;
	private final int panelWidth;
	private final int panelHeight;

	private Game game;

	public GamePanel(final Game game, final int size, final int panelX,
			final int panelY)
	{
		addKeyListener(this);
		setFocusable(true);

		setGame(game);
		this.size = size;
		this.panelX = panelX;
		this.panelY = panelY;
		this.panelWidth = game.getBoard().getRows() * size;
		this.panelHeight = game.getBoard().getCols() * size;
	}

	@Override
	public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// draw play area
		drawBoard(g2d);

		// draw food
		drawFood(g2d);

		// draw snake
		drawSnake(g2d);

		// display score
		drawScore(g2d);

	}

	private void drawScore(Graphics2D g2d)
	{
		g2d.drawString("Score: " + String.valueOf(game.getScore()), panelX,
				panelHeight + panelY + 20);
	}

	private void drawSnake(Graphics2D g2d)
	{
		Point[] points = game.getSnake().getSet().getPoints();

		g2d.setColor(Color.RED);
		g2d.fillRect(getPanelX(points[points.length - 1].getX()),
				getPanelY(points[points.length - 1].getY()), size, size);
		g2d.setColor(Color.BLUE);

		for (int i = points.length - 2; i >= 0; i--)
		{

			g2d.fillRect(getPanelX(points[i].getX()),
					getPanelY(points[i].getY()), size, size);
		}

	}

	private void drawFood(Graphics2D g2d)
	{
		g2d.setColor(Color.GREEN);
		g2d.fillRect(getPanelX(game.getFood().getPoint().getX()),
				getPanelY(game.getFood().getPoint().getY()), size, size);
	}

	private void drawBoard(Graphics2D g2d)
	{
		g2d.drawRect(panelX - 1, panelY - 1, panelWidth + 1, panelHeight + 1);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(panelX, panelY, panelWidth, panelHeight);
	}

	private int getPanelX(int boardX)
	{
		return (panelX + boardX * size);
	}

	private int getPanelY(int boardY)
	{
		return (panelY + boardY * size);
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_LEFT)
		{
			game.getSnake().changeDirection(true);
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			game.getSnake().changeDirection(false);
		}

	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Game getGame()
	{
		return game;
	}

	@Override
	public void refreshUI()
	{
		repaint();
	}

	public void setGame(Game game)
	{
		this.game = game;
	}
}
