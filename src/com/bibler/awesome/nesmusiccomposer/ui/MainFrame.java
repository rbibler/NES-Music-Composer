package com.bibler.awesome.nesmusiccomposer.ui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.bibler.awesome.nesmusiccomposer.menus.MainFrameMenu;
import com.bibler.awesome.nesmusiccomposer.utils.UndoStack;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -4596167093653505485L;
	private MainPanel mainPanel;
	private MainFrameMenu menu;
	
	public MainFrame() {
		super();
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException  | InstantiationException | IllegalAccessException e) {}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new MainFrameMenu(this);
		setJMenuBar(menu);
		mainPanel = new MainPanel(this);
		add(mainPanel);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		pack();
		setVisible(true);
	}
	
	public void advanceOneTick() {
		mainPanel.getPianoRollView().advanceOneTick();
	}
	
	public PianoRollView getPianoRollView() {
		return mainPanel.getPianoRollView();
	}
	
	public void undo() {
		UndoStack.undo();
	}
	
	public void redo() {
		UndoStack.redo();
	}

}
