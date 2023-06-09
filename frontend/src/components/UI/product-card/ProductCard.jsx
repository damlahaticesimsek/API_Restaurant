import React from "react";

import "../../../styles/product-card.css";

import { Link } from "react-router-dom";

import { useDispatch } from "react-redux";
import { cartActions } from "../../../store/shopping-cart/cartSlice";

const ProductCard = (props) => {
  const { foodId, foodName, imagePath, price } = props.item;
  const dispatch = useDispatch();

  const addToCart = () => {
    dispatch(
      cartActions.addItem({
        id: foodId,
        title: foodName,
        image01: imagePath,
        price,
      })
    );
  };

  return (
    <div className="product__item">
      <div className="product__img">
        <Link to={`/foods/${foodId}`}>
          <img src={imagePath} alt="product-img" className="w-50" style={{objectFit:'contain', width: '100px', height: '100px'}} />
        </Link>
      </div>

      <div className="product__content">
        <h5>
          <Link to={`/foods/${foodId}`}>{foodName}</Link>
        </h5>
        <div className=" d-flex align-items-center justify-content-between ">
          <span className="product__price">${price}</span>
          <button className="addTOCart__btn" onClick={addToCart}>
            Add to Cart
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
