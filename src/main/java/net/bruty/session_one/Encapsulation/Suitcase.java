package net.bruty.session_one.Encapsulation;

public class Suitcase {

    private final int _maxItemCount;
    private int _currentItems;

    public Suitcase(int maxCount) {
        _maxItemCount = maxCount;
        _currentItems = 0;
        System.out.println(" ** Suitcase System ** ");
        display();
    }

    private void display() {
        System.out.println("Items: \t" + _currentItems + "/" + _maxItemCount);
    }

    public void addItem() {
        if (_currentItems < _maxItemCount) {
            _currentItems++;
            System.out.println("Adding item");
            display();
            return;
        }
        System.out.println("No more items can be added!");
    }

    public void removeItem() {
        if (_currentItems > 0) {
            _currentItems--;
            System.out.println("Removing item");
            display();
            return;
        }
        System.out.println("No more items can be removed as the suitcase is empty!");
    }
}
