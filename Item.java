/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author asus
 */
public class Item {
    
    public String name;
	public int value;
	public int weight;
	
	public Item(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public String str() {
		return name + " [value = " + value + ", weight = " + weight + "]";
	}
    
}
