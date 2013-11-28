import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;


public class client_test {

	private static BufferedReader input;
	private static PrintWriter output;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		String showInputDialog = JOptionPane.showInputDialog(null);
		String[] split = showInputDialog.split("-", 0);
		for(int i = 0 ; i < split.length;i++)
		System.out.println(split[i]);

	}

}
