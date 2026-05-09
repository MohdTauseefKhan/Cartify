import axios from "axios";
import ProductCard from "./ProductCard";
import { useState, useEffect } from "react";

const Product = () => {
  const [product, setProduct] = useState([]);

  useEffect(() => {
    const products = async () => {
      const response = await axios.get("http://localhost:8080/products");

      setProduct(response.data);
    };

    products();
  }, []);

  return (
    <div className="min-h-screen bg-zinc-100 p-4 sm:p-6 lg:p-10">
      <div className="mx-auto grid max-w-7xl place-items-center grid-cols-2 gap-3 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
        {product.map((p, key) => (
          <ProductCard
            key={key}
            name={p.name}
            category={p.category}
            price={p.price}
            oldPrice={p.oldPrice}
            rating={p.rating}
            reviews={p.review}
            image="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80"
            badge={p.badge}
            onAddToCart={() => console.log("Added to cart")}
            onWishlist={() => console.log("Wishlist")}
          />
        ))}
      </div>
    </div>
  );
};

export default Product;
