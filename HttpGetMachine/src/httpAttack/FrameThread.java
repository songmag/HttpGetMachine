package httpAttack;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameThread extends JFrame implements Runnable,ViewControllerMapper,ViewHandler{
	private JTextField area = new JTextField(50);
	private JButton btn = new JButton("RUN");
	private JTextField count = new JTextField(50);
	public FrameThread()
	{
		super("HTTP Get Request Machine");
		LayoutManager manager= new BorderLayout(); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(700,120));
		this.getContentPane().add(panel);
		panel.setLayout(manager);
		JLabel info = new JLabel("I want that this program don`t be used to illegality");
		info.setFont(new Font("±¼¸²",0,30));
		JLabel label = new JLabel("URL");
		JLabel label2 = new JLabel("COUNT");
		label.setSize(new Dimension(20,40));
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BorderLayout());
		westPanel.add(label,BorderLayout.NORTH);
		westPanel.add(label2,BorderLayout.SOUTH);
		panel.add(westPanel,BorderLayout.WEST);
		panel.add(info,BorderLayout.NORTH);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(area,BorderLayout.NORTH);
		centerPanel.add(count,BorderLayout.SOUTH);
		panel.add(centerPanel);
		panel.add(btn,BorderLayout.SOUTH);
		this.pack();
	}
	public void run() {
		this.setVisible(true);
	}
	public String getURL() {
		return area.getText();
	}
	public void disableButton() {
		btn.setEnabled(false);
	}
	public void addActionListener(ActionListener listener) {
		btn.addActionListener(listener);
	}
	public int getCount() {
		return Integer.parseInt(this.count.getText());
	}
	public void ableButton() {
		btn.setEnabled(true);
	}
}
class ThreadRunObject{
	private FrameThread thread;
	private AttackController controller;
	
	public ThreadRunObject(FrameThread thread)
	{
		this.thread = thread;
	}
	public void runThread()
	{
		this.controller = new AttackController(thread);
		Thread t = new Thread(thread);
		t.start();
	}
}
