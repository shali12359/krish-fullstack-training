import { Component, OnInit } from '@angular/core';
import employees from './data/employee.json';
import { Employee } from './Employee.model';

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {
  title: string = 'Employee Management Solution';
  employees: Employee[] = employees;
  showIcon: boolean = false;
  private _designationFilter: string = '';
  filterEmp: Employee[] = employees;
  message: string = '';

  // SETTER
  set designationFilter(value: string) {
    this._designationFilter = value;
    this.filterByDesignation();
  }

  // GETTER
  get designationFilter(): string {
    return this._designationFilter;
  }

  constructor() { }

  ngOnInit(): void {
  }

  // DISPLAY / HIDE ICON
  toggleIcon() {
    this.showIcon = !this.showIcon;
  }

  // FILTER OPTION
  filterByDesignation() {
    this.filterEmp = this.employees.filter(employee => employee.designation.includes(this.designationFilter));
  }

  // SHOW EMPLOYEE PROGRESS
  onMessageReceived(value: string) {
    this.message = value;
  }
}
