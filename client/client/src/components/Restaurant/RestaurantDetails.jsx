import { Divider, FormControl, FormControlLabel, Grid, Radio, RadioGroup, Typography } from '@mui/material'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import TodayIcon from '@mui/icons-material/Today';
import { useState } from 'react';
import MenuCard from './MenuCard';

const categories = [
  "pizza",
  "biriyani",
  "burger",
  "chicken",
  "Kottu",
  "Fried Rice",
  "Cake"
]

const foodTypes = [
  {label:"All", value:"all"},
  {label:"Vegetarian only", value:"vegetarian"},
  {label:"Non-Vegetarian", value:"non_vegetarian"},
  {label:"Seasonal", value:"seasonal"}
]

const menu = [1,1,1,1,1,1,1]

const RestaurantDetails = () => {

  const [foodType, setFoodType] = useState("all");
  const [category, setCategory] = useState("");
  const handleFilter = (e) => {
    console.log(e.target.value, e.target.name);
  }

  return (
    <div className='px-5 lg:px-20'>
        <section>
          <h3 className='text-gray-500 py-2 mt-10'>Home/india/matara bath kade/3</h3>
          <div>
            <Grid container spacing={2}>
              <Grid size={{xs:12}}>
                  <img className='w-full h-[40vh] object-cover' src='./images/banner.jpg' alt='restaurant image'></img>
              </Grid>
              <Grid size={{xs:12, lg:6}}>
                  <img className='w-full h-[40vh] object-cover' src='./images/banner.jpg' alt='restaurant image'></img>
              </Grid>
              <Grid size={{xs:12, lg:6}}>
                  <img className='w-full h-[40vh] object-cover' src='./images/banner.jpg' alt='restaurant image'></img>
              </Grid>
            </Grid>
          </div>
          <div className='pt-3 pb-5'>
            <h1 className='text-4xl font-semibold'>Matara Bath Kade</h1>
            <p className='text-gray-500 mt-1'>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Cumque at 
              quidem voluptas, minus quia qui deleniti impedit similique repudiandae 
              repellat dolorem numquam itaque necessitatibus, quam magni veritatis animi 
              fugit porro?</p>
            <div className='space-y-3 mt-3'>
              <p className='text-gray-500 flex items-center gap-3'>
              <LocationOnIcon />
              <span>Battaramulla, Colombo</span>
            </p>
             <p className='text-gray-500 flex items-center gap-3'>
              <TodayIcon />
              <span>Mon - Fri 8.00am - 10.00pm</span>
            </p>
            </div>
          </div>
        </section>
        <Divider />
        <section className='pt-[2rem] lg:flex relative'>
          <div className='space-y-10 lg:w-[20%] filter'>
            <div className='box space-y-5 lg:sticky top-28 shadow-md'>
              <div>
                <Typography variant='h5' sx={{paddingBottom:"1rem"}}>
                  Food Type
                </Typography>
                <FormControl className='py-10 space-y-5' component={"fieldset"}>
                  <RadioGroup 
                    onChange={handleFilter} 
                    name='food_type' 
                    value={foodType}>
                      {foodTypes.map((foodType) => (
                        <FormControlLabel 
                          key={foodType.value} 
                          value={foodType.value} 
                          control={<Radio/>} 
                          label={foodType.label} />
                    ))}
                  </RadioGroup>
                </FormControl>
              </div>
              <Divider sx={{ my: 5 }}/>
              <div>
                <Typography variant='h5' sx={{paddingBottom:"1rem"}}>
                  Food Category
                </Typography>
                <FormControl className='py-10 space-y-5' component={"fieldset"}>
                  <RadioGroup 
                    onChange={handleFilter} 
                    name='food_category' 
                    value={category} >
                      {categories.map((category, index) => (
                        <FormControlLabel 
                          key={index} 
                          value={category} 
                          control={<Radio/>} 
                          label={category} />
                    ))}
                  </RadioGroup>
                </FormControl>
              </div>
            </div>
          </div>
          <div className='space-y-5 lg:w-[80%] lg:pl-10 menu'>
            {menu.map((menuItem, index) => (
              <MenuCard key={index}/>
            ))}
          </div>
        </section>
    </div>
  )
}

export default RestaurantDetails