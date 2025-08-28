import ShoppingBagIcon from "@mui/icons-material/ShoppingBag";
import FavoriteIcon from "@mui/icons-material/Favorite";
import HomeIcon from "@mui/icons-material/Home";
import AccountBalanceWalletIcon from "@mui/icons-material/AccountBalanceWallet";
import NotificationsIcon from "@mui/icons-material/Notifications";
import EventIcon from "@mui/icons-material/Event";
import LogoutIcon from "@mui/icons-material/Logout";
import { Divider, Drawer, useMediaQuery } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";


const menu = [
  { title: "Orders", icon: <ShoppingBagIcon /> },
  { title: "Favourites", icon: <FavoriteIcon /> },
  { title: "Addresses", icon: <HomeIcon /> },
  { title: "Payments", icon: <AccountBalanceWalletIcon /> },
  { title: "Notifications", icon: <NotificationsIcon /> },
  { title: "Events", icon: <EventIcon /> },
  { title: "Logout", icon: <LogoutIcon /> },
];
const ProfileNavigation = ({ open, handleClose }) => {
  const isSmallScreen = useMediaQuery("(max-width:900px)");
  const navigate = useNavigate();

  const handleNavigate = (item) => {
    navigate(`/my-profile/${item.title.toLowerCase()}`);
  };

  return (
    <div>
      <Drawer
        variant={isSmallScreen ? "temporary" : "permanent"}
        onClose={handleClose}
        sx={{ zIndex: 1 }}
        anchor="left"
        open={isSmallScreen ? open : true}
      >
        <div className="w-[50vw] lg:w-[20vw] h-[100vh] flex flex-col justify-center text-xl gap-8 pt-16">
          {menu.map((item, index) => (
            <React.Fragment key={index}>
              <div
                className="px-5 flex items-center space-x-5 cursor-pointer"
                onClick={() => handleNavigate(item)}
              >
                {item.icon}
                <span>{item.title}</span>
              </div>
              {index !== menu.length - 1 && <Divider />}
            </React.Fragment>
          ))}
        </div>
      </Drawer>
    </div>
  );
};

export default ProfileNavigation;
