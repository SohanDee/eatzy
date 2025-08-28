import { Chip, Divider, IconButton } from "@mui/material";
import RemoveCircleOutlineIcon from "@mui/icons-material/RemoveCircleOutline";
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline";

const CartItem = () => {
  return (
    <div className="px-5">
      <div className="lg:flex items-center lg:space-x-5">
        <div>
          <img
            className="w-[8rem] h-[8rem] object-cover"
            src="./images/banner.jpg"
            alt="cart item"
          />
        </div>
        <div className="flex items-center justify-between lg:w-[100%]">
          <div className="space-y-1 lg:space-y-3 ">
            <p className="px-1 text-xl">Biriyani</p>
            <div className="pt-3 space-x-2">
              {[1, 1, 1, 1].map((item) => (
                <Chip label="Bread" />
              ))}
            </div>
            <div className="flex justify-between items-center">
              <div className="flex items-center space-x-1">
                <IconButton>
                  <RemoveCircleOutlineIcon />
                </IconButton>
                <div className="w-5 h-5 text-xs flex items-center justify-center">
                  {5}
                </div>
                <IconButton>
                  <AddCircleOutlineIcon />
                </IconButton>
              </div>
            </div>
          </div>
          <p className="text-right text-gray-400">LKR 2350</p>
        </div>
      </div>
    </div>
  );
};

export default CartItem;
