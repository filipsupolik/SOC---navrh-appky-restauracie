import { Food } from "./food.model";

export interface Restaurant {
    id: number;
    restaurantName: string;
    description: string;
    deliveryTimeMinutes: number;
    openingTime: string;
    address: string;
    food: Food[];
}