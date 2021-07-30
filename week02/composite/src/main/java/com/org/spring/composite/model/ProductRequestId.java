package com.org.spring.composite.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable

public class ProductRequestId implements Serializable{
    @Column(name="product_id")
    private Integer productId;
    @Column(name="admin_id")
    private Integer adminId;
}
