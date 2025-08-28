import {
  Box,
  Button,
  Card,
  Divider,
  Grid,
  Modal,
  TextField,
} from "@mui/material";
import { useState } from "react";
import CartItem from "./CartItem";
import AddressCard from "./AddressCard";
import AddLocationIcon from "@mui/icons-material/AddLocation";
import { ErrorMessage, Field, Formik, Form } from "formik";
import { number, object, string } from "yup";
import { style } from "./style";

const items = [1, 1, 1];

const initialValues = {
  streetAddress: "",
  state: "",
  pincode: "",
  city: "",
};

const validationSchema = object({
  streetAddress: string().required("Street address is required"),
  state: string().required("State is required"),
  pincode: number()
    .typeError("Pincode must be a number")
    .required("Pincode is required"),
  city: string().required("City is required"),
});

const Cart = () => {
  const createOrderUsingSelectedAddress = () => {};

  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const handleSubmit = (value) => {
    console.log(value);
    setOpen(false);
  };

  return (
    <>
      <main className="lg:flex justify-between">
        <section className="lg:w-[60%] space-y-6 lg:min-h-screen pt-10">
          {items.map((item) => (
            <CartItem />
          ))}
          <Divider />
          <div className="bill-details px-5 text-sm">
            <p className="font-extralight py-5">Bill Details</p>
            <div className="space-y-3">
              <div className="flex justify-between text-gray-400 items-center">
                <p>Item Total</p>
                <p className="text-lg">LKR 3700</p>
              </div>
              <div className="flex justify-between text-gray-400 items-center">
                <p>Delivery Fee</p>
                <p className="text-lg">LKR 350</p>
              </div>
              <div className="flex justify-between text-gray-400 items-center">
                <p>Restaurant Charges</p>
                <p className="text-lg">LKR 200</p>
              </div>
              <Divider />
              <div className="flex justify-between text-gray-400 pt-6 text-lg items-center font-semibold">
                <p>Total Pay</p>
                <p>LKR 4250</p>
              </div>
            </div>
          </div>
        </section>
        <Divider orientation="vertical" flexItem />
        <section className="lg:w-[40%] flex justify-center px-5 pb-10 lg:pb-0">
          <div>
            <h1 className="text-center font-semibold text-2xl py-10">
              Choose Delivery Address
            </h1>
            <div className="flex gap-5 flex-wrap justify-center">
              {[1, 1, 1, 1, 1].map((item) => (
                <AddressCard
                  handleSelectAddress={createOrderUsingSelectedAddress}
                  item={item}
                  showButton={true}
                />
              ))}
              <Card className="w-64 p-5">
                <div className="space-y-3 text-gray-500">
                  <div className="flex flex-col items-center gap-5 text-white">
                    <AddLocationIcon />
                    <h1 className="font-semibold text-lg ">Add New Address</h1>
                  </div>
                  <Button variant="outlined" fullWidth onClick={handleOpen}>
                    Add
                  </Button>
                </div>
              </Card>
            </div>
          </div>
        </section>
      </main>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Formik
            initialValues={initialValues}
            onSubmit={handleSubmit}
            validationSchema={validationSchema}
          >
            {({ touched, errors }) => (
              <Form>
                <Grid container spacing={2}>
                  <Grid size={{ xs: 12 }}>
                    <Field
                      as={TextField}
                      name="streetAddress"
                      label="Street Address"
                      fullWidth
                      variant="outlined"
                      error={
                        touched.streetAddress && Boolean(errors.streetAddress)
                      }
                      helperText={
                        <ErrorMessage name="streetAddress">
                          {(msg) => <span className="text-red-600">{msg}</span>}
                        </ErrorMessage>
                      }
                    />
                  </Grid>
                  <Grid size={{ xs: 12, md: 6 }}>
                    <Field
                      as={TextField}
                      name="state"
                      label="State"
                      variant="outlined"
                      error={touched.state && Boolean(errors.state)}
                      helperText={
                        <ErrorMessage name="state">
                          {(msg) => <span className="text-red-600">{msg}</span>}
                        </ErrorMessage>
                      }
                    />
                  </Grid>
                  <Grid size={{ xs: 12, md: 6 }}>
                    <Field
                      as={TextField}
                      name="pincode"
                      label="Pin code"
                      variant="outlined"
                      error={touched.pincode && Boolean(errors.pincode)}
                      helperText={
                        <ErrorMessage name="pincode">
                          {(msg) => <span className="text-red-600">{msg}</span>}
                        </ErrorMessage>
                      }
                    />
                  </Grid>
                  <Grid size={{ xs: 12 }}>
                    <Field
                      as={TextField}
                      name="city"
                      label="City"
                      fullWidth
                      variant="outlined"
                      error={touched.city && Boolean(errors.city)}
                      helperText={
                        <ErrorMessage name="city">
                          {(msg) => <span className="text-red-600">{msg}</span>}
                        </ErrorMessage>
                      }
                    />
                  </Grid>
                  <Grid size={{ xs: 12 }}>
                    <Button fullWidth variant="contained" type="submit">
                      Use Address
                    </Button>
                  </Grid>
                </Grid>
              </Form>
            )}
          </Formik>
        </Box>
      </Modal>
    </>
  );
};

export default Cart;
