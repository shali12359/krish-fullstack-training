import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";
import Order from "./order.entity";


@Injectable()
export class OrderService {
    constructor(
        @InjectRepository(Order) private orderRepository: Repository<Order>,
    ) {}

    // find all
    getAllOrders() {
        return this.orderRepository.find();
    }
}