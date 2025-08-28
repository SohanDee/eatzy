import { Box, Modal } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import { style } from "../Cart/style";
import RegisterForm from "./RegisterForm";
import LoginForm from "./LoginForm";

const Auth = () => {
  const location = useLocation();
  const navigate = useNavigate();
  
  return (
    <Modal
      onClose={() => navigate('/')}
      open={
        location.pathname == "/account/register" ||
        location.pathname == "/account/login"
      }
    >
      <Box sx={style}>
        {location.pathname=='/account/register'? <RegisterForm /> : <LoginForm />}
      </Box>
    </Modal>
  );
};

export default Auth;
