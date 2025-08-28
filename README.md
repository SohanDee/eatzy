# 🍽️ Eatzy – Online Food Ordering and Delivery System

**Eatzy** is a full-stack portfolio project that simulates a modern online food ordering platform. It allows customers to browse food items, place orders, and make payments, while restaurant owners manage their menus, events, and orders through a dedicated dashboard.

Built using **Spring Boot (backend)** and **React (frontend)**, this project highlights my ability to create secure, scalable, and user-friendly web applications.

---

## 🌟 Features

- 🔐 **Role-based Access**  
  Separate dashboards for `CUSTOMER` and `RESTAURANT_OWNER`.

- 🛒 **Cart & Orders**  
  Add to cart, place orders, track order status.

- 💳 **Stripe Payment Integration**  
  Secure online payments.

- ⭐ **Favorites & Reviews**  
  Customers can favorite food items and leave reviews.

- 🎉 **Restaurant Events**  
  Owners can promote special events.

- ✉️ **Email Support**  
  Password resets and order confirmations via email.

- 🧾 **Authentication & Security**  
  JWT-based login and Spring Security for protected routes.

---

## 🛠️ Tech Stack

### 🔗 Frontend
- React 18  
- Tailwind CSS  
- Material UI (MUI)  
- Redux  
- Axios  
- React Router DOM  

### 🔧 Backend
- Spring Boot 3  
- Spring Security  
- Spring Data JPA  
- MySQL  
- JWT  
- JavaMailSender  
- Stripe API  

---

## 📦 Core Entities

- **User**  
  Represents both customers and restaurant owners, including login credentials, profile details, favorites, addresses, and roles.

- **Restaurant**  
  Contains data about the restaurant including name, owner, description, menu items, events, contact info, and ratings.

- **Food**  
  Menu items linked to restaurants, including name, price, description, category, and dietary tags.

- **Category**  
  Groups food items under a specific label like “Desserts”, “Main Course”, etc., specific to each restaurant.

- **Order**  
  Contains customer, restaurant, items, totals, status, and payment info.

- **OrderItem**  
  Represents individual food items within an order along with quantity and total price.

- **Cart**  
  Holds unplaced order items for a customer.

- **CartItem**  
  Represents individual food items inside the customer’s cart.

- **Event**  
  Represents restaurant events with image, time, and location.

- **IngredientCategory**  
  Groups ingredients into custom categories (e.g., “Toppings”, “Sauces”) for better food customization.

- **IngredientsItem**  
  Represents individual ingredients (e.g., “Cheese”, “Ketchup”) with stock tracking.

---

## 📁 Backend Folder Structure

```

src/
├── config/
├── controllers/
├── models/
├── repositories/
├── services/
├── utils/
└── application.properties

````

---

## 🚀 Getting Started

### 🖥️ Backend (Spring Boot)

1. Clone the repository  
2. Configure your database settings in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/eatzy
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   jwt.secret=your_jwt_secret

3. Run the application via your IDE or using Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

### 🌐 Frontend (React)

```bash
cd frontend
npm install
npm start
```

---

## 🎯 Project Objectives

* Showcase full-stack development using **React** and **Spring Boot**
* Implement **secure authentication** and **role-based access**
* Integrate third-party services like **Stripe** and **JavaMailSender**
* Build a scalable, real-world application structure

---

## 📬 Contact

**Developer**: Sohan Wijemanna   
**Website**: [sohanwijemanna.dev](https://sohanwijemanna.dev/)  
**LinkedIn**: [linkedin.com/in/sohan-wijemanna](https://www.linkedin.com/in/sohan-wijemanna)  
**Email**: [sohandeemantha@gmail.com](mailto:sohandeemantha@gmail.com)

---

⭐ If you found this project helpful or interesting, please consider giving it a star!

