package com.gastro.roots.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "RESTAURANT")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DELIVERY_FEE")
    private BigDecimal deliveryFee;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive = Boolean.TRUE;

    @Column(name = "IS_OPEN")
    private Boolean isOpen = Boolean.TRUE;

    @CreationTimestamp
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @UpdateTimestamp
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KITCHEN_ID", nullable = false)
    private Kitchen kitchen;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "RESTAURANT_PAYMENT_FORM",
            joinColumns = @JoinColumn(name = "RESTAURANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PAYMENT_FORM_ID"))
    private Set<PaymentForm> paymentsForm = new HashSet<>();
}
