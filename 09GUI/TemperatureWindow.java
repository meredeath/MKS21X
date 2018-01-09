
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton fc;
    private JButton cf;
    private JTextField t;
    
    public TemperatureWindow() {
        this.setTitle("Meredith's Temperature Window");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane=this.getContentPane();
	pane.setLayout(new FlowLayout());

	fc= new JButton("fahrenheit to celsius");
	cf = new JButton("celsius to fahrenheit");
	t = new JTextField(17);

	fc.addActionListener(this);
	cf.addActionListener(this);
	t.addActionListener(this);
	
	pane.add(fc);
	pane.add(cf);
	pane.add(t);
    }

    public static double fToC(double temp){
	return ((temp-32)*5)/9;
    }
    public static double cToF(double temp){
	return ((temp*9)/5)+32;
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("fahrenheit to celsius")){
	    double answer = fToC(Double.parseDouble(t.getText()));
	    t.setText(""+answer);
	}
	if(event.equals("celsius to fahrenheit")){
	    double answer=cToF(Double.parseDouble(t.getText()));
	    t.setText(""+answer);
	}
    }
    public static void main(String[] args) {
        TemperatureWindow g = new TemperatureWindow();
        g.setVisible(true);
	
    }
}
