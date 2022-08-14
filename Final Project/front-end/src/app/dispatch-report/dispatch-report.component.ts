import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dispatch-report',
  templateUrl: './dispatch-report.component.html',
  styleUrls: ['./dispatch-report.component.css']
})
export class DispatchReportComponent implements OnInit {
  dispatchedOrders: any;
  url: string ='http://localhost:3000/dispatchOrders';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>(this.url).subscribe((data:any) => {
        this.dispatchedOrders = data;
      })
  }
}
