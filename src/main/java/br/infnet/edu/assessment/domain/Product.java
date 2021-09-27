package br.infnet.edu.assessment.domain;

import br.infnet.edu.assessment.infrastructure.crossCutting.exceptions.NegativeNumberException;
import java.util.UUID;

public abstract class Product extends Entity{

    protected Product(UUID id, String name, float value, int amount) throws NegativeNumberException {
        super(id);
                
        this.name = name;
        
        if(amount <= 0){
            throw new NegativeNumberException("A quantidade do produto é requerido");
        }
        this.amount = amount;
                
        if(value <= 0){
            throw new NegativeNumberException("O valor do produto é requerido");
        }
        this.value = value;
    }
    
    protected String name;
    protected float value;
    protected int amount;

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public int getAmount() {
        return amount;
    }  
    
    protected abstract float generateTotalToPay();
}
