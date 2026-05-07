import Navbar from "../Components/Navbar";
import Categories from "../Components/Categories";
import Product from "../Components/Product";
import Footer from "../Components/Footer";
import "@fontsource/inter";

const Home = () => {
  return (
    <div className="w-full">
      <Navbar />
      <Categories />
      <Product />
      <Footer />
    </div>
  );
};

export default Home;
