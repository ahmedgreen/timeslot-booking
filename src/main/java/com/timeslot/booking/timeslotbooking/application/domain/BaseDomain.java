package com.timeslot.booking.timeslotbooking.application.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseDomain implements Serializable {
    private LocalDateTime created;
    private LocalDateTime updated;
    private long version;

    @PrePersist
    protected void onCreate(){
        created = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updated = LocalDateTime.now();
    }

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getCreated(){
        return created;
    }

    public void setCreated(LocalDateTime created){
        this.created = created;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime getUpdated(){
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Version
    @Access(AccessType.PROPERTY)
    public long getVersion(){
        return  version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
