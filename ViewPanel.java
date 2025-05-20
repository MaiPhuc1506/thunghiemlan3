import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {
    public static DefaultListModel<String> dataListModel = new DefaultListModel<>();
    private JList<String> dataList;

    public ViewPanel() {
        setLayout(new BorderLayout());

        dataList = new JList<>(dataListModel);
        add(new JScrollPane(dataList), BorderLayout.CENTER);
    }
}