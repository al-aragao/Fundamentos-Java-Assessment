
package br.infnet.edu.assessment.domain;

import br.infnet.edu.assessment.infrastructure.crossCutting.exceptions.NegativeNumberException;
import java.util.UUID;

public class Costume extends Product{

    public Costume(String name, float value, int amount, String size, String brand, String reference) throws NegativeNumberException {
        super(UUID.randomUUID(), name, value, amount);
        this.size = size;
        this.brand = brand;
        this.reference = reference;
    }
    
    public Costume(UUID id, String name, float value, int amount, String size, String brand, String reference) throws NegativeNumberException {
        super(id, name, value, amount);
        this.size = size;
        this.brand = brand;
        this.reference = reference;
    }
    
    private String size;
    private String brand;
    private String reference;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
                        
        builder.append(this.getClass().getName()).append(";")
               .append(this.name).append(";")
               .append(this.brand).append(";")
               .append(this.reference).append(";")
               .append(this.value).append(";")
               .append(this.amount).append(";");
        
        return builder.toString();
    }

    @Override
    protected float generateTotalToPay() {
        return this.amount * this.value;
    }
    
}
