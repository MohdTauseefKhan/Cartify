import React from "react";
import styles from "./Styles/Categories.module.css";

const Categories = () => {
  return (
    <div className={styles.categories}>
      <button>For you</button>
      <button>Mens</button>
      <button>Womens</button>
      <button>Mobiles</button>
      <button>Furniture</button>
    </div>
  );
};

export default Categories;
