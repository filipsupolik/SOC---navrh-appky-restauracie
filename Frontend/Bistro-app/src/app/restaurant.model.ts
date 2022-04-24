import { Food } from "./food.model";

export interface Restaurant {
    id: number;
    restaurantName: string;
    description: string;
    openingDay: string;
    closingDay: string;
    openingTime: string;
    closingTime: string;
    address: string;
    food: Food[];
}