import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Game {

	class Player extends Thread{
		Socket socket;
		char mark;
		Player enemy;
		private BufferedReader input;
		private PrintWriter output;
		
		
		public Player(Socket socket,char mark) throws IOException {
			this.socket=socket;
			this.mark=mark;
			
           
                
		}
		public void set_enemy(Player enemy) throws IOException{
			
			this.enemy=enemy;
		}
		@Override
		public void run() {
			
            try {
            	input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(enemy.socket.getOutputStream(), true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
			try {
				output.println(input.readLine());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("connection close"+socket.getPort());
				stop();
			}
		}
		}
		
	}

}
