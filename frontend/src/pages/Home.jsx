import React, { useState, useEffect } from "react";
import Helmet from "../components/Helmet/Helmet.js";
import { Container, Row, Col } from "reactstrap";
import ProductCard from "../components/UI/product-card/ProductCard.jsx";
import { getAllFoods } from "../services/foods.service.js";
import { getAllCategories } from "../services/foods.service.js";
import "../styles/home.css";

const Home = () => {
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("ALL");
  const [allProducts, setAllProducts] = useState([]);
  const [filteredProducts, setFilteredProducts] = useState([]);

  function sortArrayByKey(array, key) {
    array.sort((firstElement, secondElement) => {
      return firstElement[key] - secondElement[key];
    });
  }

  useEffect(() => {
    
    getAllFoods().then((res) => {
      setAllProducts(res.data);
    });

    getAllCategories().then((res) => {
      const categories = [{ id: 0, categoryName: "ALL" }, ...res.data];
      sortArrayByKey(categories, "id");
      setCategories(categories)
    });
  }, []);

  useEffect(() => {
    if (selectedCategory === "ALL") {
      setFilteredProducts(allProducts);
    }

    if (selectedCategory === "Drinks") {
      const filteredProducts = allProducts.filter(
        (item) => item.categoryId === 1
      );

      setFilteredProducts(filteredProducts);
    }

    if (selectedCategory === "Meals") {
      const filteredProducts = allProducts.filter(
        (item) => item.categoryId === 2
      );

      setFilteredProducts(filteredProducts);
    }

    if (selectedCategory === "Bakery") {
      const filteredProducts = allProducts.filter(
        (item) => item.categoryId === 3
      );

      setFilteredProducts(filteredProducts);
    }

    if (selectedCategory === "Dessert") {
      const filteredProducts = allProducts.filter(
        (item) => item.categoryId === 4
      );

      setFilteredProducts(filteredProducts);
    }
  }, [allProducts, selectedCategory]);

  return (
    <Helmet title="Home">

      <section>
        <Container>
          <Row>
            <Col lg="12" className="text-center">
              <h2>Popular Foods</h2>
            </Col>

            <Col lg="12">
              <div className="food__category d-flex align-items-center justify-content-center gap-4">
                {categories.map((item) => (
                  <button 
                    className={`d-flex align-items-center gap-2`}
                    onClick={() => setSelectedCategory(item.categoryName)}
                    key={item.id}
                  >
                    <img src={require(`../assets/images/${item.categoryName}.png`).default} alt="" />
                    {item.categoryName}
                  </button>
                ))}
  
              </div>
            </Col>

            {filteredProducts.map((item) => (
              <Col lg="3" md="4" sm="6" xs="6" key={item.foodId} className="mt-5">
                <ProductCard item={item} />
              </Col>
            ))}
          </Row>
        </Container>
      </section>

    </Helmet>
  );
};

export default Home;
