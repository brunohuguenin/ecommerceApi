package dev.bruno.ecommerceApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_itens")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    private Integer quantidade;

    private Double precoUnitario;
}
