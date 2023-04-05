# API_Restaurant


## API

#### Fetch all items

```http
  GET /api/menu/${tableNumber}/getMenu
```

#### Fetch items by category

```http
  GET /api/menu/${tableNumber}/getMenuByCategory/${categoryId}
```

#### Places an order

```http
  POST /api/order/${tableNumber}/addOrder
```
This endpoint takes a list of the following object.

| Parametre    | Tip     | Açıklama                           |
| :--------    | :------- | :-------------------------------- |
| `foodId`     | `int` | **Gerekli**.                         |
| `quantity`   | `int` | **Gerekli**.                         |
| `unitPrice`  | `double` | **Gerekli**.                      |


#### Environment Variables
You should set the environment variables inside of the application.properties file.

 RESTAURANT_DATABASE_HOST

 RESTAURANT_DB_NAME,

 RESTAURANT_DB_USER,

 RESTAURANT_DB_PASS,

 RESTAURANT_API_AWS_SES_FROM_EMAIL,

 RESTAURANT_API_AWS_REGION,

 RESTAURANT_API_ACCESS_KEY,

 RESTAURANT_API_SECRET_ACCESS_KEY

## Frontend

### Technologies

React 17

React Router

React Redux

NodeJS ^16

Axios

Bootstrap


### Installation

Install API_Restaurant Frontend with npm or yarn

```bash
  cd API_Restaurant/frontend
  npm install
  npm run start
```

```bash
  cd API_Restaurant/frontend
  yarn
  yarn start
```
### Build

```bash
  cd API_Restaurant/frontend
  npm run build
```

```bash
  cd API_Restaurant/frontend
  yarn build
```

### Deployment

You can serve everywhere if can possible to run NodeJS ^16

### Folder Structure
```
.
├── package.json
├── public
│   ├── favicon.ico
│   ├── index.html
│   ├── logo192.png
│   ├── logo512.png
│   ├── manifest.json
│   └── robots.txt
└── src
    ├── App.js
    ├── assets
    │   └── images
    │       ├── ALL.png
    │       ├── Bakery.png
    │       ├── Dessert.png
    │       ├── Drinks.png
    │       ├── Meals.png
    │       ├── banner-02.jpg
    │       ├── hamburger.png
    │       └── res-logo.png
    ├── components
    │   ├── Footer
    │   │   └── Footer.jsx
    │   ├── Header
    │   │   └── Header.jsx
    │   ├── Helmet
    │   │   └── Helmet.js
    │   ├── Layout
    │   │   └── Layout.js
    │   └── UI
    │       ├── cart
    │       │   ├── CartItem.jsx
    │       │   └── Carts.jsx
    │       ├── common-section
    │       │   └── CommonSection.jsx
    │       └── product-card
    │           └── ProductCard.jsx
    ├── index.css
    ├── index.js
    ├── pages
    │   ├── AllFoods.jsx
    │   ├── Cart.jsx
    │   ├── Checkout.jsx
    │   ├── FoodDetails.jsx
    │   └── Home.jsx
    ├── routes
    │   └── Routers.js
    ├── services
    │   ├── foods.service.js
    │   ├── image.service.js
    │   ├── index.js
    │   └── order.service.js
    ├── store
    │   ├── shopping-cart
    │   │   ├── cartSlice.js
    │   │   └── cartUiSlice.js
    │   └── store.js
    └── styles
        ├── all-foods.css
        ├── cart-item.css
        ├── cart-page.css
        ├── category.css
        ├── checkout.css
        ├── common-section.css
        ├── footer.css
        ├── header.css
        ├── home.css
        ├── pagination.css
        ├── product-card.css
        ├── product-details.css
        ├── shopping-cart.css
        └── slider.css
```