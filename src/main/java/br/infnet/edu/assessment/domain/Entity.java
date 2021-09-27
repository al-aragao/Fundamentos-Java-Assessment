package br.infnet.edu.assessment.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public abstract class Entity {
    protected UUID id;
    protected LocalDateTime createdOn;
    protected LocalDateTime modifiedOn;

    protected Entity() {
        this.id = UUID.randomUUID();
        this.createdOn = LocalDateTime.now();
        this.modifiedOn = LocalDateTime.now();
    }
    
    protected Entity(UUID id) {
        this.id = id;
        this.createdOn = LocalDateTime.now();
        this.modifiedOn = LocalDateTime.now();
    }    

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    
    public String getCreatedOnString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return createdOn.format(format);
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public String getModifiedOnString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return modifiedOn.format(format);
    }
    
    protected void updateModifiedOn(){
        this.modifiedOn = LocalDateTime.now();
    }

    @Override
    public abstract String toString();
    
}
