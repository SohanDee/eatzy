import React from 'react'
import Slider from 'react-slick'
import { topMeals } from './topMeal'
import CarouselItem from './CarouselItem'
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

const MultiItemCarousel = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 5,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    arrows: false
  };
  return (
    <div>
      <Slider {...settings}>
        {topMeals.map((item) => {
         return <CarouselItem key={item.id} image={item.image} title={item.title} />
        })}
      </Slider>
    </div>
  )
}

export default MultiItemCarousel