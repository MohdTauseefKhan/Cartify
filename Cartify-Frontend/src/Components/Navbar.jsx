import { NavLink } from "react-router-dom";
import styles from "./Styles/Navbar.module.css";
const Navbar = () => {
  const getClass = ({ isActive }) => {
    return isActive ? `${styles.nav} ${styles.active}` : styles.nav;
  };
  return (
    <div className={styles.container}>
      <input type="text" placeholder="Search for products" />
      <div>
        <NavLink to="/profile" className={getClass}>
          Profile
        </NavLink>
        <NavLink to="/cart" className={getClass}>
          Cart
        </NavLink>
      </div>
    </div>
  );
};

export default Navbar;
