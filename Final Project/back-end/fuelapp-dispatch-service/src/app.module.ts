import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { OrderModule } from './order/order.module';
import {config } from './orm.config';

@Module({
  imports: [TypeOrmModule.forRoot(config), OrderModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
