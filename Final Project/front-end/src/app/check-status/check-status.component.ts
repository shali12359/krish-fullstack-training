import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  // selector: 'app-check-status',
  templateUrl: './check-status.component.html',
  styleUrls: ['./check-status.component.css']
})
export class CheckStatusComponent implements OnInit {
  referenceId: any;
  orderRef: any;
  orderStatus: any;
  url: string ='http://localhost:9091/order/all';
  url2: string ='http://localhost:9091/order/';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
      this.http.get<any>(this.url).subscribe((data:any) => {
        this.orderRef = data;
      })
  }

  clickSubmit() {
    console.log(this.referenceId);

    this.http.get<any>(this.url2 + this.referenceId).subscribe((data:any) => {
        this.orderStatus = data;
      })
  }
}
