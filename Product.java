package programming1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Product {
    public static void main(String[] args) {
        List<Product> products = readProduct(
                "C:/Users/Admin/IdeaProjects/Welcome/out/production/Welcome/programming1/product.csv");
    }

    private static ArrayList<Product> readProduct(String path){
        String line;
       ArrayList<Product> products = new ArrayList<>();
       int i = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line= br.readLine())!=null){

                String[] attributes = line.split(",");
                if(i==0){
                    continue;

                }
                System.out.println(attributes[0]);
                Product product = new Product(Integer.parseInt(attributes[0]),attributes[1],attributes[2],
                        Float.parseFloat(attributes[3]),Integer.parseInt(attributes[4]));
                products.add(product);
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return products;
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
}

