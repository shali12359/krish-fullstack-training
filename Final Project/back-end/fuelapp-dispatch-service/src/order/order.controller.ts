import { Controller, Get } from "@nestjs/common";
import { OrderService } from "./order.service";


@Controller('orders')
export class OrderController {
    constructor(private readonly orderService: OrderService) {}

    // get all todos
    @Get()
    getTodos() {
        return this.orderService.getAllOrders();
    }
}