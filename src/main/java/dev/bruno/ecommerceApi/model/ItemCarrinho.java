package dev.bruno.ecommerceApi.model;

import jakarta.persistence.*;

@Entity
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    @ManyToOne
    private Carrinho carrinho;
}
