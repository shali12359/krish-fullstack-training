import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-delivery-schedule',
  templateUrl: './delivery-schedule.component.html',
  styleUrls: ['./delivery-schedule.component.css']
})
export class DeliveryScheduleComponent implements OnInit {
  dispatchedOrders: any;
  url: string ='http://localhost:3000/allAllocated';
  url2: string ='http://localhost:3000/updateDispatch/';
  
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>(this.url).subscribe((data:any) => {
        this.dispatchedOrders = data;
      })
  }

  
  dispatchOrder(id) {
    console.log("Dispatched: " + id);

    this.http.put<any>(this.url2 + id, {}, {})
    .subscribe(data => data.id);
     window.location.reload();
  }
}
