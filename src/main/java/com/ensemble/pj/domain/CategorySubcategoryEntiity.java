package com.ensemble.pj.domain;

import com.ensemble.pj.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class CategorySubcategoryEntiity implements Serializable {

    @Column(name="category_entity_id")
    private UUID categoryEntityid;

    @Column(name="subcategory_entity_id")
    private UUID subcategoryEntityId;

    public CategorySubcategoryEntiity(){}
    public CategorySubcategoryEntiity(UUID categoryEntityid, UUID subcategoryEntityId){
        this.categoryEntityid = categoryEntityid;
        this.subcategoryEntityId = subcategoryEntityId;
    }

    public UUID getCategoryEntityid() {
        return categoryEntityid;
    }
    public void setCategoryEntityid(UUID categoryEntityid) {
        this.categoryEntityid = categoryEntityid;
    }

    public UUID getSubcategoryEntityId() {
        return subcategoryEntityId;
    }
    public void setSubcategoryEntityId(UUID subcategoryEntityId) {
        this.subcategoryEntityId = subcategoryEntityId;
    }

    @Override
    public String toString() {
        return "CategorySubcategoryEntiity{" +
                "categoryEntityid=" + categoryEntityid +
                ", subcategoryEntityId=" + subcategoryEntityId +
                '}';
    }
}
