import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;

public class JTableButtonMouseListener extends MouseAdapter implements MouseListener {
	
	  private JTable table;

	public JTableButtonMouseListener(JTable table) {
          this.table = table;
      }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		 int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the column of the button
         int row    = e.getY()/table.getRowHeight(); //get the row of the button
         
         //*Checking the row or column is valid or not
         if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
             Object value = table.getValueAt(row, column);
             if (value instanceof JButton) {
                 //perform a click event
                 ((JButton)value).doClick();
             }
         }


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
