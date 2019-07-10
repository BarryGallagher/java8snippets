package com.barryg.java8snippets;

import java.time.LocalDate;

public class Relationship {
    String id;
    String relationshipType;
    LocalDate startDate;
    LocalDate endDate;
    
    long personId;
    long organisationId;
    
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public long getPersonId() {
      return personId;
    }
    public void setPersonId(long personId) {
      this.personId = personId;
    }
    public long getOrganisationId() {
      return organisationId;
    }
    public void setOrganisationId(long organisationId) {
      this.organisationId = organisationId;
    }
    public String getRelationshipType() {
      return relationshipType;
    }
    public void setRelationshipType(String code) {
      this.relationshipType = code;
    }
    public LocalDate getStartDate() {
      return startDate;
    }
    public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
    }
    public LocalDate getEndDate() {
      return endDate;
    }
    public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
    }
  
    public Relationship(String id, String code, LocalDate startDate, LocalDate endDate, long personId, long organisationId) {
      super();
      this.id = id;
      this.relationshipType = code;
      this.startDate = startDate;
      this.endDate = endDate;
      this.personId = personId;
      this.organisationId = organisationId;
    }
    
    
    
}
