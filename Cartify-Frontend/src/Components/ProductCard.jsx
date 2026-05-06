import React from "react";
import styles from "../Styles/ProductCard.module.css";

export default function ProductCard({
  name,
  category,
  price,
  oldPrice,
  rating,
  reviews,
  image,
  badge = "New",
  inStock = true,
  onAddToCart,
  onWishlist,
}) {
  const discount =
    oldPrice && oldPrice > price
      ? Math.round(((oldPrice - price) / oldPrice) * 100)
      : null;

  return (
    <div className={styles.card}>
      <div className={styles.imageWrap}>
        <img className={styles.image} src={image} alt={name} />

        <div className={styles.badges}>
          <span className={styles.badgeBlack}>{badge}</span>
          {discount !== null && (
            <span className={styles.badgeWhite}>-{discount}%</span>
          )}
        </div>

        <button
          className={styles.wishlistBtn}
          onClick={onWishlist}
          aria-label="Add to wishlist"
        >
          ♥
        </button>
      </div>

      <div className={styles.content}>
        <div>
          <p className={styles.category}>{category}</p>
          <h3 className={styles.name}>{name}</h3>
        </div>

        <div className={styles.ratingRow}>
          <span className={styles.rating}>★ {rating.toFixed(1)}</span>
          <span className={styles.reviews}>({reviews} reviews)</span>
        </div>

        <div className={styles.priceRow}>
          <span className={styles.price}>₹{price.toLocaleString()}</span>
          {oldPrice && (
            <span className={styles.oldPrice}>
              ₹{oldPrice.toLocaleString()}
            </span>
          )}
        </div>

        <button
          className={styles.cartBtn}
          onClick={onAddToCart}
          disabled={!inStock}
        >
          {inStock ? "Add to Cart" : "Out of Stock"}
        </button>
      </div>
    </div>
  );
}
