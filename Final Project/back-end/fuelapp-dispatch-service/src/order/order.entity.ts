import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
class Order {
    @PrimaryGeneratedColumn()
    public orderId: number;

    @Column()
    public amount: number;

    @Column()
    public type: string;

    @Column()
    public stationName: string;

    @Column()
    public stationId: number;

    @Column()
    public status: string;

    @Column()
    public dispatchDate: string;
}

export default Order;