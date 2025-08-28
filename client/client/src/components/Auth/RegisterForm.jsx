import {
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  TextField,
  Typography,
} from "@mui/material";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { useNavigate } from "react-router-dom";
import { object, string } from "yup";

const initialValues = {
  fullName: "",
  email: "",
  password: "",
  role: "ROLE_CUSTOMER",
};

const SignUpSchema = object({
  fullName: string().required("required").min(3, "Too Short"),
  email: string().email("Invalid email").required("required"),
  password: string().min(8, "Too short").required("required"),
});

const RegisterForm = () => {
  const navigate = useNavigate();

  const handleSubmit = (values) => {
    console.log(values);
  };

  return (
    <div>
      <Typography variant="h5" className="text-center">
        Register
      </Typography>
      <Formik
        initialValues={initialValues}
        validationSchema={SignUpSchema}
        onSubmit={(values) => handleSubmit(values)}
      >
        {({ values, errors, touched }) => (
          <Form>
            <Field
              as={TextField}
              label="Full Name"
              name="fullName"
              fullWidth
              variant="outlined"
              margin="normal"
              error={touched.fullName && Boolean(errors.fullName)}
              helperText={<ErrorMessage name="fullName" />}
            ></Field>
            <Field
              as={TextField}
              label="Email"
              name="email"
              fullWidth
              variant="outlined"
              margin="normal"
              error={touched.email && Boolean(errors.email)}
              helperText={<ErrorMessage name="email" />}
            ></Field>
            <Field
              as={TextField}
              label="Password"
              name="password"
              type="Password"
              fullWidth
              variant="outlined"
              margin="normal"
              error={touched.password && Boolean(errors.password)}
              helperText={<ErrorMessage name="password" />}
            ></Field>
            <FormControl fullWidth margin="normal">
              <InputLabel id="role">Role</InputLabel>
              <Field
                as={Select}
                labelId="role"
                name="role"
                label="Role"
              >
                <MenuItem value="ROLE_CUSTOMER">Customer</MenuItem>
                <MenuItem value="ROLE_RESTAURANT_OWNER">
                  Restaurant Owner
                </MenuItem>
              </Field>
            </FormControl>
            <Button
              sx={{ mt: 2, padding: "1rem" }}
              variant="contained"
              fullWidth
              type="submit"
            >
              Register
            </Button>
          </Form>
        )}
      </Formik>
      <Typography variant="body2" align="center" sx={{ mt: 3 }}>
        Already have an account?
        <Button size="small" onClick={() => navigate("/account/login")}>
          Login
        </Button>
      </Typography>
    </div>
  );
};

export default RegisterForm;
