import { Controller, Get } from '@nestjs/common';
import { EventPattern, MessagePattern, Payload } from '@nestjs/microservices';
import { KafkaMessage } from 'kafkajs';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @MessagePattern('dispatch-topic') // Our topic name
  getHello(@Payload() message) {
    console.log(message.orderId);
  }

  @Get()
  getHello2(): string {
    return this.appService.getHello();
  }
}
