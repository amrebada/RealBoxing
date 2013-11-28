import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Draw extends JPanel implements MouseMotionListener,
		ActionListener, MouseListener {

	private int ENEMY_Point=280;
	private int ME_Shape;
	private int ENEMY_Shape;
	private final int ME_Defence = 1;
	private final int ME_Attack = 2;
	private final int ENEMY_Defence = 1;
	private final int ENEMY_Attack = 2;

	private int ME_X;
	private int ME_Y;

	private int ENEMY_X=300;
	private int ENEMY_Y;

	private Timer t = new Timer(10, this);
	private int ME_Point=280;


	public Draw() {

		ME_Shape = ME_Defence;
		ENEMY_Shape = ENEMY_Defence;
		addMouseListener(this); 
		addMouseMotionListener(this);
	
	}

	@Override
	public void paint( Graphics g) {
		t.start();
		g.setColor(Color.white);
		g.fill3DRect(0, 0, this.getWidth(), this.getHeight(), true);
		
		if (ENEMY_Shape == ENEMY_Defence) {
			Defence_ENEMY(ENEMY_X, g);
		} else if (ENEMY_Shape == ENEMY_Attack) {

				Attack_ENEMY(ENEMY_X,g);

				if(ME_X>=ENEMY_X && ME_X<=ENEMY_X+300){
					if(ME_Point==0){
						System.out.println("YOU LOSE");
						System.exit(0);
					}else{
					ME_Point--;
					}
				}
			
			
		}
		if (ME_Shape == ME_Defence) {

			Defence_ME(ME_X, g);

		} else if (ME_Shape == ME_Attack) {
			Attack_ME(ME_X, ME_Y, g);

			if(ME_X>=ENEMY_X && ME_X<=ENEMY_X+300){
				if(ENEMY_Point==0){
					System.out.println("YOU WIN");
					System.exit(0);
				}
			}
		
			
		}

		g.setColor(Color.gray);
		g.fillRect(0, 0, 300, 50);
		g.fillRect(700, 0, 300, 50);
		g.setColor(Color.red);
		g.fillRect(10, 10, ME_Point, 30);
		g.setColor(Color.blue);
		g.fillRect(710, 10, ENEMY_Point, 30);
		g.setColor(Color.white);
		g.drawString("YOUR POINT", 100, 25);
		g.drawString("ENEMY POINT", 800, 25);
	}

	private void Attack_ENEMY(int eNEMY_X2, Graphics g){
		int[] body_x = { eNEMY_X2 + 100, eNEMY_X2 + 200, eNEMY_X2 + 200,
				eNEMY_X2 + 300, eNEMY_X2 + 300, eNEMY_X2, eNEMY_X2,
				eNEMY_X2 + 100 };
		int[] body_y = { 350, 350, 450, 450, getHeight(), getHeight(), 450, 450 };
		int[] left_hand_x = { eNEMY_X2 + 25, eNEMY_X2 + 75, eNEMY_X2 + 100,
				eNEMY_X2 };
		int[] hand_y = { 450, 450, getHeight(), getHeight() };

		g.setColor(Color.decode("#802A2A"));
		g.fillRoundRect(eNEMY_X2, 100, 300, 250, 10, 10);
		g.fillPolygon(body_x, body_y, 8);

		g.setColor(Color.white);
		g.fillRect(eNEMY_X2, 250, 350, 20);
		g.fillRect(eNEMY_X2, 300, 350, 20);
		g.setColor(Color.blue);
		g.fillRoundRect(eNEMY_X2, 100, 300, 25, 10, 10);
		g.fillArc(eNEMY_X2, 100, 300, 50, 180, 180);
		g.fillRoundRect(eNEMY_X2, 100, 25, 250, 10, 10);
		g.fillArc(eNEMY_X2, 100, 50, 250, 270, 180);
		g.fillRoundRect(eNEMY_X2 + 275, 100, 25, 250, 10, 10);
		g.fillArc(eNEMY_X2 + 250, 100, 50, 250, 90, 180);
		g.setColor(Color.white);
		g.fillOval(eNEMY_X2 + 100, 175, 25, 50);
		g.fillOval(eNEMY_X2 + 175, 175, 25, 50);
		g.setColor(Color.black);
		g.fillOval(eNEMY_X2 + 105, 190, 15, 15);
		g.fillOval(eNEMY_X2 + 180, 190, 15, 15);
		g.drawArc(eNEMY_X2 + 90, 160, 35, 25, 0, 100);
		g.drawArc(eNEMY_X2 + 175, 160, 35, 25, 80, 100);
		g.setColor(Color.decode("#602A2A"));
		g.fillPolygon(left_hand_x, hand_y, 4);
		
		g.setColor(Color.blue);
		g.fillOval(eNEMY_X2, 400, 100, 100);
		g.fillOval(eNEMY_X2 + 100, 300, 200, 200);
		
	}

	private void Defence_ENEMY(int eNEMY_X2, Graphics g) {
		int[] body_x = { eNEMY_X2 + 100, eNEMY_X2 + 200, eNEMY_X2 + 200,
				eNEMY_X2 + 300, eNEMY_X2 + 300, eNEMY_X2, eNEMY_X2,
				eNEMY_X2 + 100 };
		int[] body_y = { 350, 350, 450, 450, getHeight(), getHeight(), 450, 450 };
		int[] left_hand_x = { eNEMY_X2 + 25, eNEMY_X2 + 75, eNEMY_X2 + 100,
				eNEMY_X2 };
		int[] right_hand_x = { eNEMY_X2 + 225, eNEMY_X2 + 275, eNEMY_X2 + 300,
				eNEMY_X2 + 200 };
		int[] hand_y = { 450, 450, getHeight(), getHeight() };

		g.setColor(Color.decode("#802A2A"));
		g.fillRoundRect(eNEMY_X2, 100, 300, 250, 10, 10);
		g.fillPolygon(body_x, body_y, 8);

		g.setColor(Color.white);
		g.fillRect(eNEMY_X2, 250, 350, 20);
		g.fillRect(eNEMY_X2, 300, 350, 20);
		g.setColor(Color.blue);
		g.fillRoundRect(eNEMY_X2, 100, 300, 25, 10, 10);
		g.fillArc(eNEMY_X2, 100, 300, 50, 180, 180);
		g.fillRoundRect(eNEMY_X2, 100, 25, 250, 10, 10);
		g.fillArc(eNEMY_X2, 100, 50, 250, 270, 180);
		g.fillRoundRect(eNEMY_X2 + 275, 100, 25, 250, 10, 10);
		g.fillArc(eNEMY_X2 + 250, 100, 50, 250, 90, 180);
		g.setColor(Color.white);
		g.fillOval(eNEMY_X2 + 100, 175, 25, 50);
		g.fillOval(eNEMY_X2 + 175, 175, 25, 50);
		g.setColor(Color.black);
		g.fillOval(eNEMY_X2 + 105, 190, 15, 15);
		g.fillOval(eNEMY_X2 + 180, 190, 15, 15);
		g.drawArc(eNEMY_X2 + 90, 160, 35, 25, 0, 100);
		g.drawArc(eNEMY_X2 + 175, 160, 35, 25, 80, 100);
		g.setColor(Color.decode("#602A2A"));
		g.fillPolygon(left_hand_x, hand_y, 4);
		g.fillPolygon(right_hand_x, hand_y, 4);
		g.setColor(Color.blue);
		g.fillOval(eNEMY_X2, 400, 100, 100);
		g.fillOval(eNEMY_X2 + 200, 400, 100, 100);

	}

	private void Attack_ME(int mE_X2, int mE_Y2, Graphics g) {
		int X_left = mE_X2 - 250;
		int X_right = mE_X2 - 50;
		int y_left = this.getHeight() - 300;
		int y_right = mE_Y2 - 50;
		int[] left_hand_x = { X_left + 50, X_left + 150, X_left + 200, X_left };
		int[] left_hand_y = { y_left + 100, y_left + 100, this.getHeight(),
				this.getHeight() };
		int[] right_hand_x = { X_right + 50, X_right + 150, X_right + 200,
				X_right };
		int[] right_hand_y = { y_right + 100, y_right + 100,
				this.getHeight() + 500, this.getHeight() + 500 };
		// left_hand
		g.setColor(Color.decode("#FFDFC4"));
		g.fillPolygon(left_hand_x, left_hand_y, 4);
		g.setColor(Color.black);
		g.fillOval(X_left, y_left, 200, 150);
		g.setColor(Color.red);
		g.fillArc(X_left, y_left, 200, 150, 0, 180);
		g.setColor(Color.yellow);
		g.fillRoundRect(X_left, y_left + 50, 150, 50, 10, 10);
		g.fillArc(X_left, y_left, 200, 150, 180, 100);
		g.setColor(Color.black);
		g.drawLine(X_left + 50, y_left + 100, X_left + 110, y_left + 100);
		// left_right
		g.setColor(Color.decode("#FFDFC4"));
		g.fillPolygon(right_hand_x, right_hand_y, 4);
		g.setColor(Color.black);
		g.fillOval(X_right, y_right, 200, 150);
		g.setColor(Color.red);
		g.fillArc(X_right, y_right, 200, 150, 0, 180);
		g.setColor(Color.yellow);
		g.fillRoundRect(X_right + 50, y_right + 50, 150, 50, 10, 10);
		g.fillArc(X_right, y_right, 200, 150, 260, 100);
		g.setColor(Color.black);
		g.drawLine(X_right + 90, y_right + 100, X_right + 150, y_right + 100);
	}

	private void Defence_ME(int mE_X2, Graphics g) {
		int X_left = mE_X2 - 250;
		int X_right = mE_X2 + 50;
		int y = this.getHeight() - 300;
		int[] left_hand_x = { X_left + 50, X_left + 150, X_left + 200, X_left };
		int[] hand_y = { y + 100, y + 100, this.getHeight(), this.getHeight() };
		int[] right_hand_x = { X_right + 50, X_right + 150, X_right + 200,
				X_right };

		// left_hand
		g.setColor(Color.decode("#FFDFC4"));
		g.fillPolygon(left_hand_x, hand_y, 4);
		g.setColor(Color.black);
		g.fillOval(X_left, y, 200, 150);
		g.setColor(Color.red);
		g.fillArc(X_left, y, 200, 150, 0, 180);
		g.setColor(Color.yellow);
		g.fillRoundRect(X_left, y + 50, 150, 50, 10, 10);
		g.fillArc(X_left, y, 200, 150, 180, 100);
		g.setColor(Color.black);
		g.drawLine(X_left + 50, y + 100, X_left + 110, y + 100);
		// right_hand
		g.setColor(Color.decode("#FFDFC4"));
		g.fillPolygon(right_hand_x, hand_y, 4);
		g.setColor(Color.black);
		g.fillOval(X_right, y, 200, 150);
		g.setColor(Color.red);
		g.fillArc(X_right, y, 200, 150, 0, 180);
		g.setColor(Color.yellow);
		g.fillRoundRect(X_right + 50, y + 50, 150, 50, 10, 10);
		g.fillArc(X_right, y, 200, 150, 260, 100);
		g.setColor(Color.black);
		g.drawLine(X_right + 90, y + 100, X_right + 150, y + 100);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		ME_X = e.getX();
		ME_Y = e.getY();

		// System.out.println("X : " + e.getX() + " : " + "Y : " + e.getY());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		ME_Shape = ME_Attack;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ME_Shape = ME_Defence;

	}


	public String return_value(){
		return ME_X+"-"+ME_Y+"-"+ME_Shape+"-"+ME_Point;
	}
	public void set_enemy_value(String value){
		if(value!=""){
		String[] split = value.split("-");
		this.ENEMY_X=Integer.parseInt(split[0])-150;
		this.ENEMY_Y=Integer.parseInt(split[1]);
		this.ENEMY_Shape=Integer.parseInt(split[2]);
		this.ENEMY_Point=Integer.parseInt(split[3]);
		}
	}
}
