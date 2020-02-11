package httpAttack;

public class Main {

	public static void main(String[] args) {
		ThreadRunObject object = new ThreadRunObject(new FrameThread());
		object.runThread();
	}

}
