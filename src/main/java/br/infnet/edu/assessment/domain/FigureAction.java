package br.infnet.edu.assessment.domain;

import br.infnet.edu.assessment.infrastructure.crossCutting.exceptions.NegativeNumberException;
import java.util.UUID;

public class FigureAction extends Product {

    public FigureAction(String name, float value, int amount, int size, String brand, int modelNumber) throws NegativeNumberException {
        super(UUID.randomUUID(), name, value, amount);
        this.size = size;
        this.brand = brand;
        this.modelNumber = modelNumber;
    }
    
    public FigureAction(UUID id, String name, float value, int amount, int size, String brand, int modelNumber) throws NegativeNumberException {
        super(id, name, value, amount);
        this.size = size;
        this.brand = brand;
        this.modelNumber = modelNumber;
    }
    
    private int size;
    private String brand;
    private int modelNumber;

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws NegativeNumberException {
        
        if(size <= 0)
        {
            throw new NegativeNumberException("O tamanho deve ser informado");
        }
        
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }     
    
    public void setValue(float value)throws NegativeNumberException {
        if(value <= 0){
            throw new NegativeNumberException("O valor do produto é requerido");
        }
        this.value = value;
    }

    public void setAmount(int amount) throws NegativeNumberException {
        if(amount <= 0){
            throw new NegativeNumberException("O valor do produto é requerido");
        }
        this.amount = amount;
    }

    
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
                
        builder.append("PFA;")
               .append(this.id).append(";")
               .append(this.getCreatedOnString()).append(";")
               .append(this.getModifiedOnString()).append(";")
               .append(this.name).append(";")
               .append(this.value).append(";")
               .append(this.amount).append(";")
               .append(this.size).append(";")
               .append(this.brand).append(";")
               .append(this.modelNumber).append(";");
        
        return builder.toString();
    }

    @Override
    protected float generateTotalToPay() {
        return this.amount * this.value;
    }
    
}
