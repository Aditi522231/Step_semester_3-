package assignment_problems;

// Class encapsulating online store shopping cart logic
class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    // Constructor setting final cartId and initializing fixed-capacity prices array
    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.itemCount = 0;
    }

    // Adds item price to the internal array if capacity permits
    public void addItem(double price) {
        if (this.itemCount < this.prices.length) {
            this.prices[this.itemCount] = price;
            this.itemCount++;
        } else {
            System.out.println("Cart is full. Cannot add item price: " + price);
        }
    }

    // Computes and returns total sum on request by iterating through stored prices
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < this.itemCount; i++) {
            total += this.prices[i];
        }
        return total;
    }

    // Read-only getter for item count
    public int getItemCount() {
        return this.itemCount;
    }

    // Read-only getter for cart ID
    public String getCartId() {
        return this.cartId;
    }
}

public class question5 {

    public static void main(String[] args) {
        // Instantiate Cart matching sample input
        Cart cart = new Cart("CART-5", 20);

        // Add item prices
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        // Print calculated total and item count
        System.out.println("cart.getTotal() -> " + (int) cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
