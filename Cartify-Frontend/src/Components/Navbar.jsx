import { NavLink } from "react-router-dom";
import styles from "../Styles/Navbar.module.css";
import { ShoppingBag, User } from "lucide-react";
import logo from "../assets/logo.png";

const Navbar = () => {
  const getClass = ({ isActive }) => {
    return isActive ? `${styles.nav} ${styles.active}` : styles.nav;
  };
  return (
    <div className={styles.container}>
      <img src={logo} alt="logo" />
      <input type="text" placeholder="Search for products..." />
      <span>
        <NavLink to="/profile" className={getClass}>
          <User /> Profile
        </NavLink>
        <NavLink to="/cart" className={getClass}>
          <ShoppingBag /> Cart
        </NavLink>
      </span>
    </div>
  );
};

export default Navbar;
