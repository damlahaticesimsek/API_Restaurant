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
 RESTAURANT_DB_NAME
 RESTAURANT_DB_USER
 RESTAURANT_DB_PASS
 RESTAURANT_API_AWS_SES_FROM_EMAIL
 RESTAURANT_API_AWS_REGION
 RESTAURANT_API_ACCESS_KEY
 RESTAURANT_API_SECRET_ACCESS_KEY