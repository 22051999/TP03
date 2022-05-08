/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class Sac {
    
  private Item[] items;

  private int capacity;

  public Sac (Item[] items, int capacity) {
    this.items = items;
    this.capacity = capacity;
  }

  public void display() {
    if (items != null  &&  items.length > 0) {
      System.out.println("Sac problem");
      System.out.println("Capacity : " + capacity);
      System.out.println("Items :");

      for (Item item : items) {
        System.out.println("- " + item.str());
      }
    }
  }

 
  public Solution solve() {
    int NB_ITEMS = items.length;
   
    int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

    
    for (int i = 0; i <= capacity; i++)
      matrix[0][i] = 0;

    
    for (int i = 1; i <= NB_ITEMS; i++) {
   
      for (int j = 0; j <= capacity; j++) {
        if (items[i - 1].weight > j)
          matrix[i][j] = matrix[i-1][j];
        else
         
          matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight] 
				  + items[i-1].value);
      }
    }

    int res = matrix[NB_ITEMS][capacity];
    int w = capacity;
    List<Item> itemsSolution = new ArrayList<>();

    for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
      if (res != matrix[i-1][w]) {
        itemsSolution.add(items[i-1]);
      
        res -= items[i-1].value;
        w -= items[i-1].weight;
      }
    }

    return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
  }

  public static void main(String[] args) {
    
    Item[] items = {new Item("Elt1", 4, 12), 
	                new Item("Elt2", 2, 1), 
					new Item("Elt3", 2, 2), 
					new Item("Elt4", 1, 1),
                    new Item("Elt5", 10, 4)};

    Sac s = new Sac (items, 15);
    s.display();
    Solution solution = s.solve();
    solution.display();
  }
    
}
