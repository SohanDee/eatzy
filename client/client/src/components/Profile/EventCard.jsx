import {
  Card,
  CardActions,
  CardContent,
  CardMedia,
  IconButton,
  Typography,
} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";

const EventCard = () => {
  return (
    <div>
      <Card sx={{ width: 345 }}>
        <CardMedia sx={{ height: 345 }} image="/images/banner.jpg" />
        <CardContent>
          <Typography variant="h5">Matara Bath Kade</Typography>
          <Typography variant="body2">50% off of your first order</Typography>
            <div className="py-2 space-y-2">
            <p className="text-gray-500">{"colombo"}</p>
            <div className="flex items-center justify-between">
            <div className="space-y-2">
                <p className="text-sm text-green-500">February 14, 2025 12:00 AM</p>
            <p className="text-sm text-red-500">February 15, 2025 12:00 AM</p>
                </div>
            {false &&<CardActions>
          <IconButton>
            <DeleteIcon />
          </IconButton>
        </CardActions>}
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

export default EventCard;
