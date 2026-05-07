import React from "react";
import { Heart, ShoppingCart, Star } from "lucide-react";

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
    <div className="group w-full max-w-55 sm:max-w-60 md:max-w-62.5 overflow-hidden rounded-2xl border border-zinc-200 bg-white text-zinc-900 shadow-sm transition duration-300 hover:-translate-y-1 hover:shadow-lg dark:border-zinc-800 dark:bg-zinc-950 dark:text-white">
      <div className="relative aspect-square overflow-hidden bg-zinc-100 dark:bg-zinc-900">
        <img
          src={image}
          alt={name}
          className="h-full w-full object-cover transition duration-500 group-hover:scale-105"
        />

        <div className="absolute left-3 top-3 flex flex-wrap gap-2">
          <span className="rounded-full bg-black px-2 py-1 text-[10px] font-medium text-white">
            {badge}
          </span>

          {discount !== null && (
            <span className="rounded-full bg-white px-2 py-1 text-[10px] font-medium text-black ring-1 ring-zinc-200">
              -{discount}%
            </span>
          )}
        </div>

        <button
          onClick={onWishlist}
          aria-label="Add to wishlist"
          className="absolute right-3 top-3 rounded-full bg-white/90 p-2 text-black transition hover:bg-black hover:text-white dark:bg-black/80 dark:text-white"
        >
          <Heart className="h-4 w-4" />
        </button>
      </div>

      <div className="space-y-2 p-3">
        <div>
          <p className="text-[10px] uppercase tracking-[0.15em] text-zinc-500 dark:text-zinc-400">
            {category}
          </p>

          <h3 className="mt-1 text-sm font-semibold leading-tight">{name}</h3>
        </div>

        <div className="flex items-center gap-2">
          <div className="flex items-center gap-1">
            <Star className="h-3.5 w-3.5 fill-black text-black dark:fill-white dark:text-white" />

            <span className="text-xs font-medium">{rating.toFixed(1)}</span>
          </div>

          <span className="text-xs text-zinc-500 dark:text-zinc-400">
            ({reviews})
          </span>
        </div>

        <div className="flex items-center gap-2">
          <span className="text-lg font-bold">₹{price.toLocaleString()}</span>

          {oldPrice && (
            <span className="text-xs text-zinc-500 line-through dark:text-zinc-400">
              ₹{oldPrice.toLocaleString()}
            </span>
          )}
        </div>

        <button
          onClick={onAddToCart}
          disabled={!inStock}
          className="flex w-full items-center justify-center gap-2 rounded-xl bg-black px-4 py-2 text-sm font-medium text-white transition hover:bg-zinc-800 disabled:cursor-not-allowed disabled:bg-zinc-300 disabled:text-zinc-500 dark:bg-white dark:text-black dark:hover:bg-zinc-200 dark:disabled:bg-zinc-700 dark:disabled:text-zinc-400"
        >
          <ShoppingCart className="h-4 w-4" />

          {inStock ? "Add to Cart" : "Out of Stock"}
        </button>
      </div>
    </div>
  );
}
