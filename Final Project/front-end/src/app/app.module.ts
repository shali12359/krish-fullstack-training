import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { SubmitOrderComponent } from './submit-order/submit-order.component';
import { CheckStatusComponent } from './check-status/check-status.component';
import { RouterModule } from '@angular/router';
import { ControlOrderComponent } from './control-order/control-order.component';
import { DispatchReportComponent } from './dispatch-report/dispatch-report.component';
import { DeliveryScheduleComponent } from './delivery-schedule/delivery-schedule.component';

@NgModule({
  declarations: [
    AppComponent,
    SubmitOrderComponent,
    CheckStatusComponent,
    ControlOrderComponent,
    DispatchReportComponent,
    DeliveryScheduleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'submit_order', component: SubmitOrderComponent },
      { path: 'check_status', component: CheckStatusComponent },
      { path: 'order_control', component: ControlOrderComponent },
      { path: 'dispatch_report', component: DispatchReportComponent },
      { path: 'delivery_schedule', component: DeliveryScheduleComponent },
      { path: '', redirectTo: 'submit_order', pathMatch: 'full' }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
