import React from "react";
import styles from "../Styles/Categories.module.css";
import { NavLink } from "react-router-dom";

const Categories = () => {
  const getClass = ({ isActive }) => {
    return isActive ? `${styles.category} ${styles.active}` : styles.category;
  };
  return (
    <div className={styles.categories}>
      <NavLink to="/categories/For you" className={getClass}>
        For you
      </NavLink>
      <NavLink to="/categories/Mens" className={getClass}>
        Mens
      </NavLink>
      <NavLink to="/categories/Womens" className={getClass}>
        Womens
      </NavLink>
      <NavLink to="/categories/Mobiles" className={getClass}>
        Mobiles
      </NavLink>
      <NavLink to="/categories/Furniture" className={getClass}>
        Furniture
      </NavLink>
    </div>
  );
};

export default Categories;
