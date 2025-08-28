import { Button, TextField, Typography } from "@mui/material";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { useNavigate } from "react-router-dom";
import {object, string} from "yup";

const initialValues = {
  email: "",
  password: "",
};

const LoginSchema = object({
  email: string().email("invalid email").required("required"),
  password: string().required("required"),
});

const LoginForm = () => {
    const handleSubmit = (values) => {
        console.log(values);
    }

    const navigate = useNavigate();
  return (
    <div>
        <Typography variant="h5" className="text-center">Login</Typography>
      <Formik
        initialValues={initialValues}
        onSubmit={(values) => handleSubmit(values)}
        validationSchema={LoginSchema}
      >
        {({errors, touched}) => (
          <Form>
            <Field
              as={TextField}
              label="Email"
              name="email"
              fullWidth
              variant="outlined"
              margin="normal"
              error={touched.email && Boolean(errors.email)}
              helperText={<ErrorMessage name="email" />}
            />
            <Field
              as={TextField}
              type="password"
              label="Password"
              name="password"
              fullWidth
              variant="outlined"
              margin="normal"
              error={touched.password && Boolean(errors.password)}
              helperText={<ErrorMessage name="password" />}
            />
            <Button sx={{mt:2, padding:'1rem'}} variant="contained" fullWidth type="submit">Log in</Button>
          </Form>
        )}
      </Formik>
      <Typography variant="body2" align="center" sx={{mt:3}}>Don't have an account?
        <Button size="small" onClick={() => navigate("/account/register")}>
            Register
        </Button>
      </Typography>
    </div>
  );
};

export default LoginForm;
