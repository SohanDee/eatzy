import { Button, Card } from "@mui/material";
import React from "react";

const OrderCard = () => {
  return (
    <Card className="flex justify-between items-center p-5">
      <div className="flex items-center space-x-5">
        <img
          className="h-16 w-16 object-cover"
          src="/images/banner.jpg"
          alt="Order Image"
        />
        <div>
          <p className="text-lg">Biriyani</p>
          <p>LKR: 3900</p>
        </div>
      </div>
      <div>
        <Button className="cursor-not-allowed">Completed</Button>
      </div>
    </Card>
  );
};

export default OrderCard;
