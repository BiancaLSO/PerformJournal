package com.ensemble.pj.domain;

import static org.apache.commons.lang3.time.DateFormatUtils.formatUTC;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Transient
    private String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";

    @Column(columnDefinition = "BINARY(16)")
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name="uuid2",
            strategy = "uuid2"
    )
    private UUID id;

    @Version
    private Integer version;

    @CreatedDate
    private Long createdAt;

    @LastModifiedDate
    private Long modifiedAt;

    public BaseEntity() {
        this.createdAt = System.currentTimeMillis();
        this.modifiedAt = this.createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdString() {
        if (id != null) {
            return id.toString();
        }
        else {
            return null;
        }
    }

    public void setId(String id) {
        if (StringUtils.isNotBlank(id)) {
            this.id = UUID.fromString(id);
        }
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public BaseEntity setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String formattedCreatedAt() {
        return this.createdAt != null ? formatUTC(this.createdAt, DATETIME_FORMAT) : null;
    }

    public Long getModifiedAt() {
        return modifiedAt;
    }

    public BaseEntity setModifiedAt(Long modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String formattedModifiedAt() {
        return this.modifiedAt != null ? formatUTC(this.modifiedAt, DATETIME_FORMAT) : null;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        BaseEntity rhs = (BaseEntity) obj;
        return new EqualsBuilder()
                .append(id, rhs.id)
                .isEquals();
    }
}
