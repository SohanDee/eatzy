import Accordion from "@mui/material/Accordion";
import AccordionActions from "@mui/material/AccordionActions";
import AccordionSummary from "@mui/material/AccordionSummary";
import AccordionDetails from "@mui/material/AccordionDetails";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import { Button, Checkbox, FormControlLabel, FormGroup } from "@mui/material";
import { useState } from "react";

const ingredients = [
  {
    category: "Nuts and Seeds",
    ingredients: ["Cashews"],
  },
  {
    category: "Protein",
    ingredients: ["Bacon strips", "Ground beef"],
  },
];

const MenuCard = () => {
  const [selectedIngredients, setSelectedIngredients] = useState([]);

  const handleCheckBoxChange = (e) => {
    const { name, checked } = e.target;
    console.log(checked);
    if (checked) setSelectedIngredients((prev) => [...prev, name]);
    else setSelectedIngredients((prev) => prev.filter((i) => i != name));
  };

  return (
    <div>
      <Accordion>
        <AccordionSummary expandIcon={<ExpandMoreIcon />}>
          <div className="lg:flex items-center justify-between">
            <div className="lg:flex items-center lg:gap-5">
              <img
                className="w-[7rem] h-[7rem] object-cover"
                src="./images/banner.jpg"
                alt="menu item"
              />
              <div className="space-y-1 lg:space-y-5 lg:max-w-2xl">
                <p className="font-semibold text-xl">Burger</p>
                <p>LKR 750</p>
                <p className="text-gray-400">nice food</p>
              </div>
            </div>
          </div>
        </AccordionSummary>
        <AccordionDetails>
          <form>
            <div className="flex gap-5 flex-wrap">
              {ingredients.map((item, index) => {
                return (
                  <div key={index}>
                    <p>{item.category}</p>
                    <FormGroup>
                      {item.ingredients.map((ingredient, index) => (
                        <FormControlLabel
                          key={index}
                          control={
                            <Checkbox
                              name={ingredient}
                              checked={selectedIngredients.includes(ingredient)}
                              onChange={handleCheckBoxChange}
                            />
                          }
                          label={ingredient}
                        />
                      ))}
                    </FormGroup>
                  </div>
                );
              })}
            </div>
            <div className="pt-5">
              <Button variant="contained" disabled={false} type="submit">
                {true ? "Add to Cart" : "Out of Stock"}
              </Button>
            </div>
          </form>
        </AccordionDetails>
      </Accordion>
    </div>
  );
};

export default MenuCard;
