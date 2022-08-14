import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-control-order',
  templateUrl: './control-order.component.html',
  styleUrls: ['./control-order.component.css']
})
export class ControlOrderComponent implements OnInit {
  orders: any;
  url: string ='http://localhost:9091/order/all';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>(this.url).subscribe((data:any) => {
        this.orders = data;
      })
  }

}
