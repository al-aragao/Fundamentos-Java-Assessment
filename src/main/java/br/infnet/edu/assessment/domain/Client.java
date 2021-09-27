package br.infnet.edu.assessment.domain;

import java.util.UUID;

public class Client extends Entity{
    private String name;
    private String document;
    private String email;      

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Client(UUID id,String name, String document, String email) {
        super(id);
        this.name = name;
        this.document = document;
        this.email = email;
    }
    
    public Client(String name, String document, String email) {
        super(UUID.randomUUID());
        this.name = name;
        this.document = document;
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("CL;")
               .append(this.id).append(";")
               .append(this.getCreatedOnString()).append(";")
               .append(this.getModifiedOnString()).append(";")
               .append(this.name).append(";")
               .append(this.document).append(";")
               .append(this.email);
        
        return builder.toString();
    }
    
    
    
    
}
