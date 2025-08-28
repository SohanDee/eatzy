import HomeIcon from "@mui/icons-material/Home";
import { Button, Card } from "@mui/material";

const AddressCard = ({ item, showButton, handleSelectAddress }) => {
  return (
    <Card className="w-64 p-5">
      <div className="space-y-3 text-gray-500">
        <div className="flex gap-5 text-white">
          <HomeIcon />
          <h1 className="font-semibold text-lg">Home</h1>
        </div>
        <p>"Shithila", Keselhenawa, Dombagoda, Horana</p>
        {showButton && (
          <Button variant="outlined" fullWidth onClick={handleSelectAddress}>
            Select
          </Button>
        )}
      </div>
    </Card>
  );
};

export default AddressCard;
