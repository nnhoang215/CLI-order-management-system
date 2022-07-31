package programming1;

import programming1.Product;

import java.util.Map;

public class ShoppingCart {
    public class CartEntry{
        private Product product;
        private int quantity;

        public CartEntry(Product product, int quantity){
            this.product = product;
            this.quantity = quantity;
        }
        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            if (quantity>0){
                this.quantity = quantity;
            }else{
                System.out.println("Invalid input.");
            }
        }
    }


}