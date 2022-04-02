import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

class CloseButton extends Button
{
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        this.setBackground(new Color(255,85,85));

        int x=this.getWidth()-4;
        int y=this.getHeight()-4;
        g.drawLine(4,4,x,y);
        g.drawLine(4,y,x,4);
    }
}

public class Main implements ActionListener
{
    JFrame frame;
    JPanel p1,p2;
    JPanel p3=new JPanel();
    JLabel l,l0;
    JButton b1,b2,b3,b4;
    JButton exit;
    CloseButton close;
    DefaultTableModel model1,model2;
    JTable table1,table2;
    
    Main()
    {
        frame=new JFrame("Main-menu");
        p1=new JPanel();
        l=new JLabel("Library Management", SwingConstants.CENTER);
        l.setFont(new Font("Candara",1,40));
        l0=new JLabel(" System", SwingConstants.CENTER);
        l0.setFont(new Font("Candara",1,40));
        p1.setLayout(new GridLayout(2,1));
        p1.add(l);
        p1.add(l0);

        b1=new JButton("Book");
        b2=new JButton("Customer");
        b3=new JButton("Issue a book");
        b4=new JButton("Defaulter list");
        p2=new JPanel();
        p2.setLayout(null);
        b1.setBounds(100,20,200,50);
        b2.setBounds(100,80,200,50);
        b3.setBounds(100,140,200,50);
        b4.setBounds(100,200,200,50);
        b1.setFont(new Font("Candara",2,18));
        b2.setFont(new Font("Candara",2,18));
        b3.setFont(new Font("Candara",2,18));
        b4.setFont(new Font("Candara",2,18));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);

        close=new CloseButton();
        close.setBounds(855,0,15,15);
        close.setVisible(false);
        p2.add(close);

        table1=new JTable(model1);
        model1=(DefaultTableModel)table1.getModel();
        model1.addColumn("Book Name");
        model1.addColumn("Author Name");
        model1.addColumn("Book Type");
        model1.addColumn("Book nos");
        model1.addColumn("Book price");

        table2=new JTable(model2);
        model2=(DefaultTableModel)table2.getModel();
        model2.addColumn("ID");
        model2.addColumn("Name");
        model2.addColumn("Phone");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clear();
                close.setVisible(false);
                p3.setBackground(Color.WHITE);
                p1.setLayout(new GridLayout(2,1));
                frame.setSize(400,410);
            }
        });

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2);
        frame.setVisible(true);
        frame.setSize(400,410);
        frame.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){frame.dispose();}});
    }

    public void actionPerformed(ActionEvent e)
    {
        p3.setBounds(400,0,470,300);
        p2.add(p3);
        clear();
        close.setVisible(true);
        frame.setSize(900,410);
        p1.setLayout(new FlowLayout());

        JButton bt=(JButton)e.getSource();
        if(bt==b1)
        {
            p3.setBackground(new Color(153,217,234));
            bookSection();
        }
        if(bt==b2)
        {
            p3.setBackground(new Color(151,255,151));
            customerSection();
        }

        if(bt==b3)
        {
            p3.setBackground(new Color(255,228,136));
            issueBook();
        }

        if(bt==b4)
        {
            p3.setBackground(Color.PINK);
        }
    }

    void clear()
    {
        p3.removeAll();
        p3.revalidate();
        p3.repaint();
    }

    void bookSection()
    {
        JButton b11,b12,b13;
        b11=new JButton("Add new book");
        b12=new JButton("Search book");
        b13=new JButton("Modify book");
        p3.setLayout(null);
        b11.setBounds(100,80,270,40);
        b12.setBounds(100,130,270,40);
        b13.setBounds(100,180,270,40);
        b11.setFont(new Font("Candara",2,15));
        b12.setFont(new Font("Candara",2,15));
        b13.setFont(new Font("Candara",2,15));
        b11.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clear();
                JLabel l1,l2,l3,l4,l5;
                JTextField t1,t2,t3,t4,t5;
                JButton b;
                l1=new JLabel("Enter book name");
                l2=new JLabel("Enter author name");
                l3=new JLabel("Enter book type");
                l4=new JLabel("Enter number of books");
                l5=new JLabel("Enter book price");
                l1.setBounds(40,40,200,30);
                l2.setBounds(40,80,200,30);
                l3.setBounds(40,120,200,30);
                l4.setBounds(40,160,200,30);
                l5.setBounds(40,200,200,30);
                l1.setFont(new Font("Candara",2,18));
                l2.setFont(new Font("Candara",2,18));
                l3.setFont(new Font("Candara",2,18));
                l4.setFont(new Font("Candara",2,18));
                l5.setFont(new Font("Candara",2,18));
                t1=new JTextField();
                t2=new JTextField();
                t3=new JTextField();
                t4=new JTextField();
                t5=new JTextField();
                t1.setBounds(240,40,200,30);
                t2.setBounds(240,80,200,30);
                t3.setBounds(240,120,200,30);
                t4.setBounds(240,160,200,30);
                t5.setBounds(240,200,200,30);
                t1.setFont(new Font("Candara",0,18));
                t2.setFont(new Font("Candara",0,18));
                t3.setFont(new Font("Candara",0,18));
                t4.setFont(new Font("Candara",0,18));
                t5.setFont(new Font("Candara",0,18));
                
                b=new JButton("Save Book");
                b.setBounds(140,250,200,35);
                b.setFont(new Font("Candara",0,18));

                b.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            if(t1.getText().equals("") ||t2.getText().equals("") ||t3.getText().equals("") ||t4.getText().equals("") ||t5.getText().equals(""))
                            throw new ArithmeticException("Columns are empty");
                            String name=t1.getText();
                            String author=t2.getText();
                            String type=t3.getText();
                            int nos=Integer.parseInt(t4.getText());
                            float price=Float.parseFloat(t5.getText());
                            if(new DBHandler().addBook(name,author,type,nos,price))
                            {
                                JOptionPane.showMessageDialog(p3,"Book data saved successfully");
                                t1.setText("");
                                t2.setText("");
                                t3.setText("");
                                t4.setText("");
                                t5.setText("");
                            }
                            else
                            JOptionPane.showMessageDialog(p3,"Book data not saved");
                        }
                        catch(NumberFormatException e1){JOptionPane.showMessageDialog(p3,"Price and nos must be numeral");}
                        catch(ArithmeticException e1){JOptionPane.showMessageDialog(p3,e1.getMessage());}   
                    }
                });

                p3.add(l1);
                p3.add(l2);
                p3.add(l3);
                p3.add(l4);
                p3.add(l5);
                p3.add(t1);
                p3.add(t2);
                p3.add(t3);
                p3.add(t4);
                p3.add(t5);
                p3.add(b);
            }
        });
        b12.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clear();
                
                JLabel l;
                JComboBox<String> cb;
                JTextField t;
                String[] str={"Book name","Author name","Book type"};
                
                l=new JLabel("Enter book details: ");
                l.setBounds(40,40,200,30);
                l.setFont(new Font("Candara",3,20));

                cb=new JComboBox<>(str);
                cb.setBounds(40,80,195,30);
                cb.setFont(new Font("Candara",2,15));
                
                t=new JTextField();
                t.setFont(new Font("Candara",0,18));
                t.setBounds(245,80,195,30);
                
                table1.setFont(new Font("Candara",0,15));
                table1.setBounds(50,120,380,150);
                JScrollPane sp1 = new JScrollPane();
                sp1.setViewportView(table1);
                p3.add(sp1);

                t.addKeyListener(new KeyAdapter(){
                    public void keyReleased(KeyEvent e)
                    {
                        if(cb.getSelectedItem().toString().equals("Book name"))
                        {
                            searchBook(1,t.getText());                          
                        }
                        else if(cb.getSelectedItem().toString().equals("Author name"))
                        {
                            searchBook(2,t.getText());  
                        }
                        else if(cb.getSelectedItem().toString().equals("Book type"))
                        {
                            searchBook(3,t.getText());  
                        }
                    }
                    public void keyPressed(KeyEvent e)
                    {
                        while(model1.getRowCount()>0)
                        {
                            model1.removeRow(0);
                        }
                    }
                });
                p3.add(l);
                p3.add(cb);
                p3.add(t);
                p3.add(table1);
            }
        });
        b13.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clear();
            }
        });
        p3.add(b11);
        p3.add(b12);
        p3.add(b13);
    }

    void customerSection()
    {
        JButton b11,b12,b13;
        b11=new JButton("Add new customer");
        b12=new JButton("Search customer");
        b13=new JButton("Modify customer");
        p3.setLayout(null);
        b11.setBounds(100,80,270,40);
        b12.setBounds(100,130,270,40);
        b13.setBounds(100,180,270,40);
        b11.setFont(new Font("Candara",2,15));
        b12.setFont(new Font("Candara",2,15));
        b13.setFont(new Font("Candara",2,15));
        b11.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clear();
                JLabel l1,l2;
                JTextField t1,t2;
                JButton b;
                l1=new JLabel("Enter customer name");
                l2=new JLabel("Enter customer phone number");
                l1.setBounds(20,70,230,30);
                l2.setBounds(20,110,230,30);
                l1.setFont(new Font("Candara",2,17));
                l2.setFont(new Font("Candara",2,17));
                t1=new JTextField();
                t2=new JTextField();
                t1.setBounds(250,70,200,30);
                t2.setBounds(250,110,200,30);
                t1.setFont(new Font("Candara",0,18));
                t2.setFont(new Font("Candara",0,18));
                
                b=new JButton("Save Customer");
                b.setBounds(140,230,200,35);
                b.setFont(new Font("Candara",0,18));

                b.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
                            if(t1.getText().equals("") ||t2.getText().equals(""))
                            throw new ArithmeticException("Columns are empty");
                            String name=t1.getText();
                            String mobile=t2.getText();
                            if(new DBHandler().addCustomer(name,mobile))
                            {
                                JOptionPane.showMessageDialog(p3,"Customer data saved successfully");
                                t1.setText("");
                                t2.setText("");
                            }
                            else
                            JOptionPane.showMessageDialog(p3,"Customer data not saved");
                        }
                        catch(ArithmeticException e1){JOptionPane.showMessageDialog(p3,e1.getMessage());}   
                    }
                });

                p3.add(l1);
                p3.add(l2);
                p3.add(t1);
                p3.add(t2);
                p3.add(b);
            }
        });

        b12.addActionListener(new ActionListener()
        {
            
            public void actionPerformed(ActionEvent e)
            {
                clear();
                
                JLabel l;
                JComboBox<String> cb;
                JTextField t;
                String[] str={"Customer name","Customer phone number"};
                
                l=new JLabel("Enter Customer details: ");
                l.setBounds(40,40,200,30);
                l.setFont(new Font("Candara",3,20));

                cb=new JComboBox<>(str);
                cb.setBounds(40,80,195,30);
                cb.setFont(new Font("Candara",2,15));
                
                t=new JTextField();
                t.setFont(new Font("Candara",0,18));
                t.setBounds(245,80,195,30);

                table2.setFont(new Font("Candara",0,15));
                table2.setBounds(50,120,380,150);
                JScrollPane sp1 = new JScrollPane();
                sp1.setViewportView(table2);

                t.addKeyListener(new KeyAdapter(){
                    public void keyReleased(KeyEvent e)
                    {
                        if(cb.getSelectedItem().toString().equals("Customer name"))
                        {
                            searchCustomer(1,t.getText());                          
                        }
                        else if(cb.getSelectedItem().toString().equals("Customer phone number"))
                        {
                            searchCustomer(2,t.getText());  
                        }
                    }
                    public void keyPressed(KeyEvent e)
                    {
                        while(model2.getRowCount()>0)
                        {
                            model2.removeRow(0);
                        }
                    }
                });

                p3.add(l);
                p3.add(cb);
                p3.add(t);
                p3.add(table2);
            }
        });
        
        b13.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clear();
            }
        });
        p3.add(b11);
        p3.add(b12);
        p3.add(b13);
    }

    void issueBook()
    {
        JLabel l1,l2,l3;
        JTextField t1,t2,t3;
        JList<String> lis2,lis1;
        p3.setLayout(null);
        l1=new JLabel("Enter borrower name:");
        l2=new JLabel("Enter book name:");
        l1.setFont(new Font("Candara",2,15));
        l2.setFont(new Font("Candara",2,15));
        l1.setBounds(60,30,170,20);
        l2.setBounds(260,30,170,20);
        t1=new JTextField();
        t2=new JTextField();
        t1.setFont(new Font("Candara",0,15));
        t2.setFont(new Font("Candara",0,15));
        t1.setBounds(60,55,170,20);
        t2.setBounds(260,55,170,20);
        lis1=new JList<>();
        lis2=new JList<>();
        lis2.setFont(new Font("Candara",2,15));
        lis1.setFont(new Font("Candara",2,15));
        lis2.setBounds(60,80,170,150);
        lis1.setBounds(260,80,170,150);

        JScrollPane sp1 = new JScrollPane();
        sp1.setViewportView(lis2);
        JScrollPane sp2 = new JScrollPane();
        sp2.setViewportView(lis1);

        l3=new JLabel("Enter Date:");
        l3.setFont(new Font("Candara",2,15));
        l3.setBounds(60,245,150,20);
        t3=new JTextField();
        t3.setFont(new Font("Candara",0,15));
        t3.setBounds(140,245,170,20);
        
        p3.add(l1);
        p3.add(l2);
        p3.add(t1);
        p3.add(t2);
        p3.add(lis1);
        p3.add(lis2);
        p3.add(l3);
        p3.add(t3);
    }

    void searchCustomer(int option,String str)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=pk1234");
            String query="";
            if(option==1)
            query="select * from customer where customer_name like '"+str+"%';";
            else if(option==2)
            query="select * from customer where customer_mobile like '"+str+"%';";
            
            PreparedStatement st=cn.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            model2.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            cn.close();   
        }
        catch(Exception e1)
        {
            System.out.println(e1.getMessage());
        }
    }
 
    void searchBook(int option,String str)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=pk1234");
            String query="";
            if(option==1)
            query="select * from book where book_name like '"+str+"%';";
            else if(option==2)
            query="select * from book where author_name like '"+str+"%';";
            else if(option==3)
            query="select * from book where book_type like '"+str+"%';";
            
            PreparedStatement st=cn.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            model1.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            cn.close();   
        }
        catch(Exception e1)
        {
            System.out.println(e1.getMessage());
        }
    }
    
    public static void main(String ar[])
    {
        new Main();
    } 
}