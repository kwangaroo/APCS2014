import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConvert extends JFrame implements ActionListener{
    private Container pane;

    private JButton toFr;
    private JButton toCl;
    private JTextField num;
    private String temp;

    public TempConvert(){
	this.setTitle("Temperature Converter 2k14 (ver 1.0.0)");
	this.setSize(600,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	toFr = new JButton("Convert to Farenheit");
	toCl = new JButton("Convert to Celsius");
	num = new JTextField(6);
	toFr.addActionListener(this); 
	toCl.addActionListener(this);
	toFr.setActionCommand("CtF");
	toCl.setActionCommand("FtC");
	pane.add(num);
	pane.add(toFr);
	pane.add(toCl);


    }

    public void actionPerformed(ActionEvent e){
	int intTemp = Integer.parseInt(num.getText());
	String a = e.getActionCommand();
	if (a.equals("CtF")){
	    num.setText(intTemp * 9/5 + 32 + ""); 
	}
	if (a.getActionCommand.equals("FtC")){
	    num.setText((intTemp - 32) * 5/9);
	}
    }

    public static void main(String[]args){
	TempConvert a = new TempConvert();
	a.setVisible(true);
    }
}
