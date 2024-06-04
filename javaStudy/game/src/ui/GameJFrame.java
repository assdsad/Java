package ui;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {

    public GameJFrame(){
        //初始化总页面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        this.setVisible(true);
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的两个选项的对象
        JMenu functionJmenu = new JMenu("功能");
        JMenu aboutJmenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem changeImageItem = new JMenuItem("更换图片");
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登陆");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将条目加入到对应的选项中
        functionJmenu.add(changeImageItem);
        functionJmenu.add(replayItem);
        functionJmenu.add(reloginItem);
        functionJmenu.add(closeItem);

        aboutJmenu.add(accountItem);
        //将两个选项加入到菜单中
        jMenuBar.add(functionJmenu);
        jMenuBar.add(aboutJmenu);

        //给整个页面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(603, 680);
        //设置标题
        this.setTitle("拼图游戏");
        //让这个页面置顶
        this.setAlwaysOnTop(true);
        //设置页面居中
        this.setLocationRelativeTo(null);
        //设置关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//点击×后，虚拟机也会关闭

    }
}
