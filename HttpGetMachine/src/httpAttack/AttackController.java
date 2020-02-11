package httpAttack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackController{
	private String url;
	private int count;
	private ViewHandler handler;
	private HTTPAttack attacker;
	
	public AttackController(ViewControllerMapper mapper)
	{
		mapper.addActionListener(new ButtonAction());
		this.url = null;
		this.handler = (ViewHandler) mapper;
	}
	public void runAction()
	{
		System.out.println("HTTP GET");
		handler.disableButton();
		attacker = new HTTPAttackImpl(url);
		handler.disableButton();
		attacker.runAttack(count);
		handler.ableButton();
	}
	class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("TEST");
			url=handler.getURL();
			count = handler.getCount();
			runAction();
		}
	}
}
