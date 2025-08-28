import { Card, Chip, IconButton } from '@mui/material'
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';

const RestaurantCard = () => {
  return (
    <div>
        <Card className='w-[18rem]'>
            <div className={`${true?"cursor-pointer":"cursor-not-allowed"} relative`}>
                <img className='w-full h-[10rem] rounded-t-md object-cover' 
                src="/images/banner.jpg" alt="restaurant image" />
                <Chip size='small' className='absolute top-2 left-2'
                color={true?"success":"error"}
                label={true?"open":"closed"}/>
                <div className='p-4 textPart lg:flex w-full justify-between'>
                    <div className='space-y-1'>
                        <p className='font-semibold text-lg'>Matara Bath Kade</p>
                        <p className='text-gray-500 text-sm'>hello adakdbanbdak dajdakdakbd</p>
                    </div>
                    <div>
                        <IconButton>
                            {true? <FavoriteIcon color='red'/> : <FavoriteBorderIcon />}
                        </IconButton>
                    </div>
                </div>
            </div>
        </Card>
    </div>
  )
}

export default RestaurantCard