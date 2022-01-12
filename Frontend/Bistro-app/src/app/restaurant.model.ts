import { Food } from "./food.model";

export interface Restaurant {
    id: number;
    restaurantName: string;
    food: Food[];
}