import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

//public class JTableButtonRenderer implements TableCellRenderer {
//
//	@Override
//	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
//			int arg5) {
//		JButton button = new JButton("edit");
//		return button;
//	}
//}

class JTableButtonRenderer implements TableCellRenderer {        
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
            boolean hasFocus, int row, int column) {
        JButton button = (JButton)value;
        return button;  
    }
}