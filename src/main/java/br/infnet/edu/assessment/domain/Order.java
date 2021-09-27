package br.infnet.edu.assessment.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order extends Entity{

    public Order(String deliveryAddress) {
        super(UUID.randomUUID());
        this.internalCode = UUID.randomUUID().toString().replace("-", "").substring(0,7);
        this.isDelivered = false;
        this.deliveryAddress = deliveryAddress;
        this.products = new ArrayList<Product>();
    }
    
    public Order(String deliveryAddress, Client client) {
        super(UUID.randomUUID());
        this.internalCode = UUID.randomUUID().toString().replace("-", "").substring(0,7);
        this.isDelivered = false;
        this.deliveryAddress = deliveryAddress;
        this.client = client;
        this.products = new ArrayList<Product>();
    }
    
    public Order(UUID id, String deliveryAddress, String internalCode, boolean isDelivered) {
        super(id);
        this.internalCode = internalCode;
        this.isDelivered = isDelivered;
        this.deliveryAddress = deliveryAddress;
        this.products = new ArrayList<Product>();
    }
    
    public Order(UUID id, String deliveryAddress, String internalCode, boolean isDelivered, Client client) {
        super(id);
        this.internalCode = internalCode;
        this.isDelivered = isDelivered;
        this.deliveryAddress = deliveryAddress;
        this.client = client;
        this.products = new ArrayList<Product>();
    }
    
    public Order(UUID id, String deliveryAddress, String internalCode, boolean isDelivered, Client client, List<Product> products) {
        super(id);
        this.internalCode = internalCode;
        this.isDelivered = isDelivered;
        this.deliveryAddress = deliveryAddress;
        this.client = client;
        this.products = products;
    }
    
    private String internalCode;
    private boolean isDelivered;
    private String deliveryAddress;
    private Client client;
    private List<Product> products;

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public boolean isIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public void addProduct(Product product){
        this.products.add(product);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
               
        builder.append(this.id).append(";")
               .append(this.getCreatedOnString()).append(";")
               .append(this.client.getName()).append(";")
               .append(this.getTotalAmount());
        
        return builder.toString();
    }

    private String getTotalAmount() {
        float amount = 0;
        
        for (int i = 0; i < this.products.size(); i++) {
            amount = (this.products.get(i).getAmount() * this.products.get(i).getValue()) + amount;
        }
        
        return String.format("%.2f", amount);
    }
    
}
