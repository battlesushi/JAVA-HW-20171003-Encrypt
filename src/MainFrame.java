import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbtnEx=new JButton("Example");
    private JButton jbtnEncrypt=new JButton("Encrypt");
    private JButton jbtnClear=new JButton("Clear");
    private JButton jbtnExit=new JButton("Exit");
    private JLabel jlab=new JLabel("Key");
    private JTextField jtf=new JTextField("3");
    private JTextArea jtaL=new JTextArea();
    private JTextArea jtaR=new JTextArea();
    private JScrollPane jspL=new JScrollPane(jtaL);
    private JScrollPane jspR=new JScrollPane(jtaR);
    private JPanel jpn=new JPanel(new GridLayout(6,1,3,3));
    private int count=0;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpn,BorderLayout.CENTER);
        jpn.add(jbtnEx);
        jpn.add(jbtnEncrypt);
//        jlab.setHorizontalAlignment(JLabel.CENTER);
        jpn.add(jlab);
        jpn.add(jtf);
        jpn.add(jbtnClear);
        jpn.add(jbtnExit);
        cp.add(jspL,BorderLayout.WEST);
        cp.add(jspR,BorderLayout.EAST);
//        jtaL.setPreferredSize(new Dimension(225,500));//設定偏好大小  用在此會無法無限往下拉
//        jtaR.setPreferredSize(new Dimension(225,500));
        jspL.setPreferredSize(new Dimension(225,500));//設定偏好大小
        jspR.setPreferredSize(new Dimension(225,500));
        jtaL.setLineWrap(true);//遇到邊界自動換行
        jtaR.setLineWrap(true);
        jbtnEx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("The Department of Computer Science and Information Engineering," +
                        " formerly the Department of Information Technology, was established in " +
                        "2001. The department first offered a Master program only. In 2002, the und" +
                        "ergraduate program was established. The Doctoral program was established in 2" +
                        "006. Each year the department admits about 80 undergraduates, 15 graduate students" +
                        " and 3 Ph.D. students.");
            }
        });
        jbtnEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[]= jtaL.getText().toCharArray();
                int len=data.length;
                for(int i=0;i<len;i++){
                    data[i]+=Integer.parseInt(jtf.getText());//Key的 字串轉整數  為左邊範文做加密
                }
                jtaR.setText(new String(data));
            }
        });
        jbtnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
            }
        });
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}