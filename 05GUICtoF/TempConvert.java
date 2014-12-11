import javax.swing.*;
import java.awt.*;

public class TempConvert extends JFrame{
    private Container pane;

    private JButton toFr;
    private JButton toCl;
    private JTextField num;

    public TempConvert(){
	this.setTitle("Temperature Converter 2k14 (ver 1.0.0)");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	toFr = new JButton("Convert to Farenheit");
	toCl = new JButton("Convert to Celsius");
	num = new JTextField(6);
	pane.add(num);
	pane.add(toFr);
	pane.add(toCl);
    }

    public static void main(String[]args){
	TempConvert a = new TempConvert();
	a.setVisible(true);
    }
}
