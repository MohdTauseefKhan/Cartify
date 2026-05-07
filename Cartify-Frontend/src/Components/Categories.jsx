import React from "react";
import { NavLink } from "react-router-dom";

const Categories = () => {
  const getClass = ({ isActive }) =>
    `p-2 rounded-xl text-center justify-center text-[8px] md:text-sm lg:text-lg ${isActive ? "text-white bg-black font-bold" : "font-light text-zinc-500"}`;
  return (
    <div className="flex flex-row justify-between mx-8 border-2 rounded-2xl">
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
