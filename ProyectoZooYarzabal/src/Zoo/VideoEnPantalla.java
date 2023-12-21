package Zoo;

import java.awt.Window;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.DefaultFullScreenStrategy;

public class VideoEnPantalla extends DefaultFullScreenStrategy {
	private final JFrame frame;
	
	public VideoEnPantalla(JFrame frame, EmbeddedMediaListPlayerComponent component) {
		super(frame);
		this.frame = frame;
	}

	@Override
	public void enterFullScreenMode() {
		// TODO Auto-generated method stub
		super.enterFullScreenMode();
		frame.setAlwaysOnTop(true);
	}

	@Override
	public void exitFullScreenMode() {
		// TODO Auto-generated method stub
		super.exitFullScreenMode();
		frame.setAlwaysOnTop(false);
	}

	
	

}
