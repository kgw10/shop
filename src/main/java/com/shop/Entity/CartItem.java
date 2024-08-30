package com.shop.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
public class CartItem extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cart_item_id")
    private Long id;

    private int quantity; // 상품 수량

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    public void addQuantity(int quantity) {

        this.quantity += quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static CartItem createCartItem( Cart cart, Item item, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);

        return cartItem;
    }

}