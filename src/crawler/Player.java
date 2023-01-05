package crawler;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Player {

	private boolean hasSword;
	private boolean hasShield;
	private boolean hasBackpack;
	private boolean hasKey;
	private boolean hasShoes;
	private boolean isAlive;
	private int health;
	private int gold;
	
	//Fred's image variables
	private JLayeredPane fred;
	private JLabel labelFredsSword;
	private JLabel labelFredsShield;
	private JLabel labelFredsKey;
	private JLabel labelFredsBackpack;
	private JLabel labelFredsShoes;
	
	public Player() {
		this.hasSword = false;
		this.hasShield = false;
		this.hasBackpack = false;
		this.hasKey = false;
		this.hasShoes = false;
		this.health = 3;
		this.gold = 0;
		this.isAlive = true;
		this.fred = buildFredsImage();
	}
	
	/*
	 * Mutator Methods
	 */
	public void addGold(int gold) {
		this.gold += gold;
	}
	public void addHealth(int health) {
		this.health += health;
		if (this.health <= 0) {
			isAlive = false;
		}
	}
	public void aquireSword() {
		setSwordVisible();
		this.hasSword = true;
	}
	public void aquireShield() {
		setShieldVisible();
		this.hasShield = true;
	}
	public void breakShield() {
		this.labelFredsShield.setVisible(false);
		this.hasShield = false;
	}
	public void aquireBackpack() {
		setBackpackVisible();
		this.hasBackpack = true;
	}
	public void aquireKey() {
		setKeyVisible();
		this.hasKey = true;
	}
	public void aquireShoes() {
		setShoesVisible();
		this.hasShoes = true;
	}
	public void playerDies() {
		this.isAlive = false;
	}
	public void moveFred(int xPos, int yPos) {
		fred.setBounds(xPos, yPos, 239, 400);
	}
	
	
	/*
	 * Getter methods for each instance variable.
	 */
	public JLayeredPane getFred() {
		return fred;
	}
	public boolean getHasSword() {
		return hasSword;
	}
	public boolean getHasShield() {
		return hasShield;
	}
	public boolean getHasBackpack() {
		return hasBackpack;
	}
	public boolean getHasKey() {
		return hasKey;
	}
	public boolean getHasShoes() {
		return hasShoes;
	}
	public boolean getIsAlive() {
		return isAlive;
	}
	public int getHealth() {
		return health;
	}
	public int getGold() {
		return gold;
	}
	
	
	
	/*
	 * Build Fred's image
	 * 
	 * These method build Fred's overall image
	 * and control what items are part of it
	 */
	private JLayeredPane buildFredsImage() {
		
		JLayeredPane layers = new JLayeredPane();  //this will layer Fred's images appropriately
		layers.setBounds(0,0, 239, 400);
		
		
		//build image labels 
		JLabel fred = new JLabel(AllImages.getFredsImage(0));
		labelFredsSword = new JLabel(AllImages.getFredsImage(1));
		labelFredsShield = new JLabel(AllImages.getFredsImage(2));
		labelFredsBackpack = new JLabel(AllImages.getFredsImage(3));
		labelFredsKey = new JLabel(AllImages.getFredsImage(4));
		labelFredsShoes = new JLabel(AllImages.getFredsImage(5));
		
		//setBounds
		fred.setBounds(0,0,239,400);
		labelFredsSword.setBounds(0,0,239,400);
		labelFredsShield.setBounds(0,0,239,400);
		labelFredsBackpack.setBounds(0,0,239,400);
		labelFredsKey.setBounds(0,0,239,400);
		labelFredsShoes.setBounds(0,0,239,400);
		
		
		//set everything except Fred as invisible
		labelFredsSword.setVisible(false);
		labelFredsShield.setVisible(false);
		labelFredsBackpack.setVisible(false);
		labelFredsKey.setVisible(false);
		labelFredsShoes.setVisible(false);
		
		//add everything to the Layered Pane on the appropriate layers
		layers.add(fred, Integer.valueOf(2));
		layers.add(labelFredsSword, Integer.valueOf(6));
		layers.add(labelFredsShield, Integer.valueOf(5));
		layers.add(labelFredsBackpack, Integer.valueOf(1));
		layers.add(labelFredsKey, Integer.valueOf(4));
		layers.add(labelFredsShoes, Integer.valueOf(3));
		
		return layers;
	}
	
	private void setSwordVisible() {
		labelFredsSword.setVisible(true);
	}
	private void setShieldVisible() {
		labelFredsShield.setVisible(true);
	}
	private void setBackpackVisible() {
		labelFredsBackpack.setVisible(true);
	}
	private void setKeyVisible() {
		labelFredsKey.setVisible(true);
	}
	private void setShoesVisible() {
		labelFredsShoes.setVisible(true);
	}
	
}
