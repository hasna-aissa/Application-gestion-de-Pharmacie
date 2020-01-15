/**
 * 
 */
package connexion;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
/**
 * @author ZATeC
 *
 */
public class MaFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jl=new JLabel("UserName");
	JTextField jt=new JTextField(20);
	JLabel jl2=new JLabel("Password");
	JTextField jt2=new JTextField(20);
	JButton jb=new JButton("Sign in");
	public MaFrame() {
		getContentPane().add(jl);
		getContentPane().add(jt);
		getContentPane().add(jl2);
		getContentPane().add(jt2);
		getContentPane().add(jb);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaconneion","root","");
					Statement stat=con.createStatement();
					String sql="select pass from connexion where username='"+jt.getText()+"'";
					ResultSet rs=stat.executeQuery(sql);
					
					if(rs.next()) {
							JOptionPane.showMessageDialog(null, "login successfuly... ");
					}
					else {
						JOptionPane.showMessageDialog(null, "login insuccessfuly... ");
					}
					con.close();
				}
				catch(Exception e1) {
					System.out.print(e);
				}
			}
			
		});
		setVisible(true);
		setBounds(30,30,500,500);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String []args) {
		new MaFrame();
	}
}
