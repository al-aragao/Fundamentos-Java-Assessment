package br.infnet.edu.assessment.domain;

import br.infnet.edu.assessment.infrastructure.crossCutting.exceptions.NegativeNumberException;
import java.util.UUID;

public class Manga extends Product {

    public Manga(String name, float value, int amount, int pages, String publishingCompany, int edition) throws NegativeNumberException {
        super(UUID.randomUUID(), name, value, amount);
        this.pages = pages;
        this.publishingCompany = publishingCompany;
        this.edition = edition;
    }
    
    public Manga(UUID id, String name, float value, int amount, int pages, String publishingCompany, int edition) throws NegativeNumberException {
        super(id, name, value, amount);
        this.pages = pages;
        this.publishingCompany = publishingCompany;
        this.edition = edition;
    }
    
    private int pages;
    private String publishingCompany;
    private int edition;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) throws NegativeNumberException {
        
        if(pages <=0 )
        {
            throw new NegativeNumberException("O número de páginas é requerido");
        }
        
        this.pages = pages;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
    
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
                
        builder.append("PM;")
               .append(this.id).append(";")
               .append(this.getCreatedOnString()).append(";")
               .append(this.getModifiedOnString()).append(";")
               .append(this.name).append(";")
               .append(this.value).append(";")
               .append(this.amount).append(";")
               .append(this.publishingCompany).append(";")
               .append(this.edition).append(";")
               .append(this.pages).append(";");
        
        return builder.toString();
    }

    @Override
    protected float generateTotalToPay() {
        return this.amount * this.value;
    }
    
}
