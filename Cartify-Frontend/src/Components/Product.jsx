import ProductCard from "./ProductCard";

const Product = () => {
  return (
    <div className="min-h-screen bg-zinc-100 p-4 sm:p-6 lg:p-10">
      <div className="mx-auto grid max-w-7xl place-items-center grid-cols-2 gap-3 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
        <ProductCard
          name="Minimal Leather Sneakers"
          category="Footwear"
          price={3499}
          oldPrice={4999}
          rating={4.8}
          reviews={126}
          image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
          badge="Best Seller"
          onAddToCart={() => console.log("Added to cart")}
          onWishlist={() => console.log("Wishlist")}
        />
      </div>
    </div>
  );
};

export default Product;
