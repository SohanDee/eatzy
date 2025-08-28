import { CssBaseline, ThemeProvider } from "@mui/material";
import "./App.css";
import { Navbar } from "./components/Navbar/Navbar";
import { darkTheme } from "./Theme/DarkTheme";
import { Home } from "./components/Home/Home";
import RestaurantDetails from "./components/Restaurant/RestaurantDetails";
import Cart from "./components/Cart/Cart";
import Profile from "./components/Profile/Profile";
import CustomerRouter from "./Routers/CustomerRouter";
import Auth from "./components/Auth/Auth";

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <Navbar />
      {/* <Home /> */}
      {/* <RestaurantDetails /> */}
      {/* <Cart /> */}
      {/* <Profile /> */}
      <Auth />
      <CustomerRouter />
    </ThemeProvider>
  );
}

export default App;
