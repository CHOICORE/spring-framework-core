package me.choicore.study.springframework.core.order.entity;

public class Order {

    private Long orderId;

    private Long memberId;

    private String itemName;

    private int itemPrice;

    private int discountPrice;


    public Order(final Long orderId, final Long memberId, final String itemName, final int itemPrice, final int discountPrice) {

        this.orderId = orderId;
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatedPrice() {
        if (itemPrice <= discountPrice) {
            return itemPrice; // 할인 금액이 상품 금액보다 크거나 같으면 기본 상품 가격 반환
        }
        return itemPrice - discountPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(final Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(final int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(final int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
