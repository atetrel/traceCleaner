package Frames;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import MainCleaner.TraceCleaner;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOutputfileName;
	private File fileSelected;
	private String fileSelectedParent;
	private String fileSelectedName;
	private JLabel lblFileSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		
		fileSelected=null;
		setTitle("TraceCleaner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblBrowseFileTo = new JLabel("Browse file to clean");
		GridBagConstraints gbc_lblBrowseFileTo = new GridBagConstraints();
		gbc_lblBrowseFileTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrowseFileTo.gridx = 2;
		gbc_lblBrowseFileTo.gridy = 1;
		contentPane.add(lblBrowseFileTo, gbc_lblBrowseFileTo);
		
		JLabel lblOutpufileName = new JLabel("OutputFile Name");
		GridBagConstraints gbc_lblOutpufileName = new GridBagConstraints();
		gbc_lblOutpufileName.insets = new Insets(0, 0, 5, 5);
		gbc_lblOutpufileName.gridx = 5;
		gbc_lblOutpufileName.gridy = 1;
		contentPane.add(lblOutpufileName, gbc_lblOutpufileName);
		
		JButton BrowseButton = new JButton("Browse");
		GridBagConstraints gbc_BrowseButton = new GridBagConstraints();
		gbc_BrowseButton.insets = new Insets(0, 0, 5, 5);
		gbc_BrowseButton.gridx = 2;
		gbc_BrowseButton.gridy = 2;
		contentPane.add(BrowseButton, gbc_BrowseButton);
		
		
		// Listeners
		
		BrowseButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
						
				JFileChooser chooser = new JFileChooser(); 
				chooser.setCurrentDirectory(new File("S:\\SER_PILOTAGE_ET_INFOCENTRE\\COMMUN\\Pilotage\\V2\\Reinternalisation Framework\\")); 
				chooser.setAcceptAllFileFilterUsed(false);
				FileFilter filter = new FileNameExtensionFilter("LOG File","LOG");
				chooser.setFileFilter(filter);
				chooser.showOpenDialog(null);
				
				fileSelected = chooser.getSelectedFile();
				fileSelectedName = fileSelected.getName();
				fileSelectedParent = fileSelected.getParentFile().getAbsolutePath();
				lblFileSelected.setText(chooser.getSelectedFile().getName());
				
			}
		});
		
		txtOutputfileName = new JTextField();
		txtOutputfileName.setText("output");
		GridBagConstraints gbc_txtOutputfileName = new GridBagConstraints();
		gbc_txtOutputfileName.insets = new Insets(0, 0, 5, 5);
		gbc_txtOutputfileName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOutputfileName.gridx = 5;
		gbc_txtOutputfileName.gridy = 2;
		contentPane.add(txtOutputfileName, gbc_txtOutputfileName);
		txtOutputfileName.setColumns(10);
		
		
		
		lblFileSelected = new JLabel("<No file selected>");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		contentPane.add(lblFileSelected, gbc_label);
		
		
		JButton btnClean = new JButton("Clean");
		GridBagConstraints gbc_btnClean = new GridBagConstraints();
		gbc_btnClean.insets = new Insets(0, 0, 5, 5);
		gbc_btnClean.gridx = 5;
		gbc_btnClean.gridy = 5;
		contentPane.add(btnClean, gbc_btnClean);
		
		btnClean.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (fileSelected==null){
					JOptionPane.showMessageDialog(null,"No file selected","Warning", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (txtOutputfileName.getText()==null) {
						JOptionPane.showMessageDialog(null,"Type a name for the output file","Warning", JOptionPane.ERROR_MESSAGE);
					}
					else {
						TraceCleaner c = new TraceCleaner(fileSelectedParent,txtOutputfileName.getText(),fileSelected.getAbsolutePath());
						try {
							c.execute();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		
	}

}
