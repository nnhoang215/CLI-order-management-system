package programming1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    public static void main(String[] args) {
        List<Product> products = readProduct(
                "C:/Users/Admin/IdeaProjects/Welcome/out/production/Welcome/programming1/product.csv");

        for(Product p: products){
            System.out.println(p);
        }
    }

    private static ArrayList<Product> readProduct(String path){
        String line;
       ArrayList<Product> products = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String headerLine = br.readLine();
            //System.out.println(headerLine);
            while((line= br.readLine())!=null){
                String[] attributes = line.split(",");
                //System.out.println(attributes[0]);
                Product product = createProduct(attributes);
                products.add(product);
                //System.out.println(product);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return products;
    }
    private static Product createProduct(String[] metadata){
        int productID = Integer.parseInt(metadata[0]);
        String productName = metadata[1];
        String category = metadata[2];
        float price = Float.parseFloat(metadata[3]);
        int quantity = Integer.parseInt(metadata[4]);
        return new Product(productID,productName,category,price,quantity);
    }

    private int productID;
    private String productName;
    private String category;
    private float price;
    private int quantity;

    public Product(int productID, String productName, String category, float price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    public int  getProductID(){
        return productID;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public float getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public String toString(){
        return "productID:"+productID + ",productName:"+ productName +
                ",category:" + category + ",price:" + price + ",quantity:"+quantity;
    }
}

