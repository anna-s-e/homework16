package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count;

    public SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
        this.count = 0;
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        } else {
            System.out.println("Поисковый движок переполнен! Не удалось добавить: " + item.getName());
        }
    }

    public Searchable[] search(String searchString) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (int i = 0; i < count; i++) {
            Searchable item = searchableItems[i];
            if (item.getSearchTerm().toLowerCase().contains(searchString.toLowerCase())) {
                results[foundCount] = item;
                foundCount++;
                if (foundCount >= 5) {
                    break;
                }
            }
        }
        return results;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return searchableItems.length;
    }
}