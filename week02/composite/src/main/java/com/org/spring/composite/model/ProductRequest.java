package com.org.spring.composite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_request")
public class ProductRequest {
    @EmbeddedId
    private ProductRequestId id;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("adminId")
    @JoinColumn(name = "admin_id")
    private MyAdmin admin;

    @Column(name = "requested_date")
    private Date requestedDate;

    public ProductRequest(Product product, MyAdmin admin, Date requestedDate) {
        this.id = new ProductRequestId(product.getId(), admin.getId());
        this.product = product;
        this.admin = admin;
        this.requestedDate = requestedDate;
    }
}
