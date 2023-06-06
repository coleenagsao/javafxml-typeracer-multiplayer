package networking;

import model.User;

public interface IServer {
	public void sendChatMessage(String content);
	public boolean checkCanStartGame();
	public void sendClose();
}
