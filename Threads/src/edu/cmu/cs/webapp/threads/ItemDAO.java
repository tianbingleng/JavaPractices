package edu.cmu.cs.webapp.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemDAO {
	private List<Item> itemList = new ArrayList<Item>();
	private int lastId = 0;
	
	public synchronized void addToTop(Item item) {
		lastId = lastId + 1;
		item.uniqueId = lastId;

		itemList.add(0,item);
	}
	
	// Returns the position in which the item was inserted (i.e., the size of the list)
	public synchronized int addToBottom(Item item) {
		lastId = lastId + 1;
		item.uniqueId = lastId;

		itemList.add(item);
		return itemList.size();
	}
	
	public synchronized void delete(int id) {
		Iterator<Item> iterator = itemList.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			if (item.uniqueId == id) {
				iterator.remove();
			}
		}
	}

	public synchronized Item[] getItems() {
		return itemList.toArray(new Item[itemList.size()]);
	}
	
	public synchronized int size() {
		return itemList.size();
	}
}