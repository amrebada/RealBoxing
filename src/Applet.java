import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;


public class Applet extends JFrame {
	private static BufferedReader input;
	private static PrintWriter output;
	private static Draw draw ;
	public Applet() {
		setSize(1000, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		draw = new Draw();
		
		draw.setFocusable(true);
		draw.setBounds(0, 0, getWidth(), getHeight());
		add(draw);
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Applet applet = new Applet();
		
		Socket s = new Socket(args[0], 2000);
		input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        output = new PrintWriter(s.getOutputStream(), true);
		while(true){
			output.println(draw.return_value());
		
			draw.set_enemy_value(input.readLine());
		
		}
	}

}
