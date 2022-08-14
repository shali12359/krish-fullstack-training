import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  // selector: 'app-submit-order',
  templateUrl: './submit-order.component.html',
  styleUrls: ['./submit-order.component.css']
})
export class SubmitOrderComponent implements OnInit {
  stationName: any;
  stationId: any;
  fuelAmount: any;
  fuelType: any;
  url: string = "http://localhost:9091/order/create";

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.stationName = "Select Fuel Station";
    this.stationId = "Select Fuel Station Id";
    this.fuelAmount = "Select Fuel Amount";
    this.fuelType = "Select Fuel Type";
  }

  clickSubmit() {
    console.log(this.stationName);
    console.log(this.stationId);
    console.log(this.fuelAmount);
    console.log(this.fuelType);

    this.http.post(this.url, {
      "stationName" : this.stationName,
      "stationId" : this.stationId,
      "amount" : this.fuelAmount,
      "type" : this.fuelType,
      "status": "Created",
      "dispatchDate": "No Stock"
      }).toPromise().then((data: any) => 
        // console.log("Data: " + data)
        alert("Order Created with Order Id: " + data.orderId)
      )
  }
}
