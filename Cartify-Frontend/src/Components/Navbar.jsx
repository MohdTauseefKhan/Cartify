import { NavLink } from "react-router-dom";
import { ShoppingBag, User } from "lucide-react";
import logo from "../assets/logo.png";

const Navbar = () => {
  const getClass = ({ isActive }) =>
    `flex items-center flex-col lg:flex-row text-[8px] lg:text-sm md:text-sm ml-4 p-1 ${
      isActive ? "text-white bg-black text-bold rounded-md" : ""
    }`;
  return (
    <div className="flex flex-row w-full justify-between py-5">
      <div className="flex flex-row items-center flex-1">
        <img src={logo} alt="logo" className="h-10 md:h-12 lg:12" />
        <input
          className="rounded-lg border-2 h-full text-xs text-center lg:text-left md:text-left lg:text-sm md:text-sm flex-1"
          type="text"
          placeholder="Search for products..."
        />
      </div>
      <div className="flex flex-row mr-4 items-center">
        <NavLink to="/profile" className={getClass}>
          <User /> Profile
        </NavLink>
        <NavLink to="/cart" className={getClass}>
          <ShoppingBag /> Cart
        </NavLink>
      </div>
    </div>
  );
};

export default Navbar;
