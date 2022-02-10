package awtFormApp;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class regform extends Frame implements ActionListener{
	Button b1,b2,b3,b4,b5,b6;
	Label l1, l2,l3,l4,l5,l6,l7,l8,l9;
	TextField t1,t2,t3;
	TextArea a1,a2;
	Checkbox c1,c2,c3,c4,c5;
	CheckboxGroup cbg ;
	List l;
	Choice c;
	
	regform() {
		
		setLayout(null);
		//closing
		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
		setVisible(true);
		setSize(900,800);
		setTitle("any Thing");
		setResizable(false);
		
		
		l1 = new Label("Register Form");
		add(l1);
		l1.setBounds(300, 50, 150, 50);
		
		
		l2 = new Label("First Name");
		add(l2);
		l2.setBounds(200, 100, 70, 20);
		t1 = new TextField(50);
		add(t1);
		t1.setBounds(400, 100, 100, 20);
		
		
		l3 = new Label("Address");
		add(l3);
		l3.setBounds(200, 130, 60, 20);
		a1 = new TextArea(10,20);
		add(a1);
		a1.setBounds(400, 130, 200, 200);
		
		
		
		l4 = new Label("hobbies");
		add(l4);
		l4.setBounds(200, 350, 100, 20);
		c1 = new Checkbox("foot");
		add(c1);
		c1.setBounds(400, 350, 100, 20);
		c2 = new Checkbox("bask");
		add(c2);
		c2.setBounds(550, 350, 100, 20);
		c3 = new Checkbox("golf");
		add(c3);
		c3.setBounds(700, 350, 100, 20);
		
		
		l5 = new Label("gender");
		add(l5);
		l5.setBounds(200, 400, 100, 20);
		cbg = new  CheckboxGroup();
		c4 = new Checkbox("male", cbg, false);
		add(c4);
		c4.setBounds(400, 400, 100, 20);
		c5 = new Checkbox("female", cbg, false);
		add(c5);
		c5.setBounds(500, 400, 100, 20);
		
		l8 = new Label("Delete client");
		add(l8);
		l8.setBounds(650, 380, 200, 20);
		t2 = new TextField(50);
		add(t2);
		t2.setBounds(650, 400, 200, 20);
		b4 = new Button("delete data");
		add(b4);
		b4.setBounds(650, 430, 200, 50);
		b4.addActionListener(this);
		
		
		b5 = new Button("export data");
		add(b5);
		b5.setBounds(650, 480, 200, 50);
		b5.addActionListener(this);
		
		l9 = new Label("import data");
		add(l9);
		l9.setBounds(650, 530, 200, 20);
		t3 = new TextField(50);
		t3.setText("enter file path!");
		add(t3);
		t3.setBounds(650, 550, 200, 20);
		b6 = new Button("import data");
		add(b6);
		b6.setBounds(650, 570, 200, 20);
		b6.addActionListener(this);
		
		
		
		l6 = new Label("list");
		add(l6);
		l6.setBounds(200, 450, 100, 20);
		l = new List(4); 
		add(l);
		l.add("c++");	l.add("java");	l.add("c#");
		l.setBounds(400, 450, 100, 45);
		
		
		l7 = new Label("Choice");
		add(l7);
		l7.setBounds(200, 510, 100, 20);
		c = new Choice();
		c.add("1");
		c.add("2");
		c.add("3");
		add(c);
		c.setBounds(400, 510, 200, 20);
		
		
		
		b1 = new Button("send data");
		add(b1);
		b1.setBounds(300, 540, 100, 50);
		b1.addActionListener(this);
		b2 = new Button("clear inserted");
		add(b2);
		b2.setBounds(400, 540, 100, 50);
		b2.addActionListener(this);
		b3 = new Button("affiche data");
		add(b3);
		b3.setBounds(500, 540, 100, 50);
		b3.addActionListener(this);
		
		
		a2 = new TextArea(10,20);
		add(a2);
		a2.setText("si vous voulez import data, il feut etre de 6 champs separe par (,) \n l'affiche sera commeca:\nname, address, hobies, gender, lang, choice");
		a2.setBounds(5, 600, 850, 150);	
	}
	
	public static void main(String[] args) {
		regform r = new regform();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button eventSource = (Button) e.getSource();
		connection coni = new connection();
		if (eventSource == b1) {
			String namesend = t1.getText();
			String addresss = a1.getText();
			java.util.List<String> hob = new java.util.ArrayList<String>();
			String gender;
			String lng = l.getSelectedItem();
			String cho = c.getSelectedItem();
			
			if(c1.getState()) {
			//hob.add(c1.getLabel());
			}
			if(c2.getState()) {
			hob.add(c2.getLabel());
			}
			if(c3.getState()) {
			hob.add(c3.getLabel());
			}
			if(c4.getState()) {
			gender = "male";
			}else if(c5.getState()) {
				gender = "female";
			}else {
				//raise exception or send not selected or :
				System.out.println("gender not specified!");
				gender = "";
			}
			System.out.println(namesend + "  " + addresss + " " + hob + " " + gender + " " + lng +" "+ cho);
			coni.addRecord(namesend, addresss, hob.toString() , gender, lng, cho);
			//call sender constructor
		}else if(eventSource == b2) {
			t1.setText("");
			a1.setText("");
			c1.setState(false);
			c2.setState(false);
			c3.setState(false);
			c4.setState(false);
			c5.setState(false);
		}else if(eventSource == b3) {
			String res = "";
			java.util.ArrayList<client> aff = (ArrayList<client>) coni.getRecordes();
			for(int i =0; i<aff.size();i++) {
				res += aff.get(i).toString()+"\n";
			}
			a2.setText(res);
		}else if(eventSource == b4) {
			int idD = Integer.parseInt(t2.getText());
coni.deleteRecordID(idD);
		}else if(eventSource == b5) {
			//make String of file name and date
			try {
				FileWriter fout = new FileWriter("clients.txt");
				java.util.ArrayList<client> aff = (ArrayList<client>) coni.getRecordes();
				for(int i =0; i<aff.size();i++) {
					fout.write(aff.get(i).toString()+"\n");
				}
				fout.close();
				a2.setText("\t\tfile saved in same directory");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(eventSource == b6) {
			String pa = t3.getText();
			coni.importdata(pa);
		}
	}
	//ok
}