import { Kafka } from "kafkajs";
import fetch from "node-fetch";

const kafka = new Kafka({
  clientId: "dispatch-service",
  brokers: ["localhost:9092"],
});

const consumer = kafka.consumer({ groupId: "dispatch" });

await consumer.subscribe({ 
    topic: "dispatch-topic",
    fromBeginning: true
});

await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
        console.log({ partition, value: message.value.toString()})
        const response = await fetch("http://localhost:3000/dispatches", {
          method: "POST",
          body: message.value.toString(),
          headers: {
            "Content-Type": "application/json",
          },
        });
    }    
})
