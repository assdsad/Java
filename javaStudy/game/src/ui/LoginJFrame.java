package ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame() {
        this.setSize(488, 430);
        //设置标题
        this.setTitle("登录");
        //让这个页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
