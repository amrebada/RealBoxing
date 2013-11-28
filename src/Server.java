
import java.io.IOException;
import java.net.ServerSocket;




public class Server {

	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(2000);
		System.out.println("......Server Started");
		
		while (true){
			 try {
		            while (true) {
		                Game game = new Game();
		                Game.Player player_red = game.new Player(server.accept(), 'R');
		                Game.Player player_blue = game.new Player(server.accept(), 'B');
		                player_red.set_enemy(player_blue);
		                player_blue.set_enemy(player_red);
		                player_red.start();
		                player_blue.start();
		            }
		        } finally {
		            server.close();
		        }
			
		}
	}
}
