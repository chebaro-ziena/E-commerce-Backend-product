package com.example.product_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private int quantity;
    private String img;

    // Constructors
    public Product() {}

    public Product(String name, Double price, String img, int quantity) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public int getquantity() { return quantity; }
    public void setquantity(int quantity) { this.quantity = quantity; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
}



    



// {
//   "products": [
//     { "name": "Phone", "price": 699, "img": "https://i5.walmartimages.com/asr/16423849-b4ae-4509-8265-058b4f9d91be.f8f66415329864bd6d7bfd0bd92557a0.jpeg", "quantity": 66 },
//     { "name": "Laptop", "price": 1299, "img": "https://m.media-amazon.com/images/I/510uTHyDqGL._UF1000,1000_QL80_.jpg", "quantity": 80 },
//     { "name": "Headphones", "price": 199, "img": "https://cliqlb.com/cdn/shop/files/AirpodsMaxSilver-115877.jpg", "quantity": 7 }
//   ]
// }
