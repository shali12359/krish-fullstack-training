import { Injectable } from '@nestjs/common';
import { Client, ClientKafka, Transport } from '@nestjs/microservices';

@Injectable()
export class AppService {
  @Client({
    transport: Transport.KAFKA,
    options: {
      client: {
        brokers: ['localhost:9092'],
      },
      consumer: {
        groupId: 'groupId' 
      }
    }
  })
  // client: ClientKafka;

  // async onModuleInit() {
  //   this.client.subscribeToResponseOf('dispatch-topic');
  //   await this.client.connect();
  // }
  
  getHello(): string {
    return 'Hello World!';
  }
}
