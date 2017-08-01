

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import br.com.schedule.panel.SchedulePanel;

public class Schedule extends JFrame {

	private SchedulePanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Schedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 556);
		contentPane = new SchedulePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				Date diaSelecionado = contentPane.getSelectedDay(me.getPoint());
				
				System.out.println(diaSelecionado);
			}
		});
	}
}
