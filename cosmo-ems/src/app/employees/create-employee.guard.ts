import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CreateEmployeeGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      let deptId: number = Number(route.paramMap.get("id"));

      // SET GUARD FOR THE ROUTE
      if (deptId % 2 == 0) {
        alert("You are not Authorized to go Here..!");
        this.router.navigate(["/home"]);
      }
    
      return true;
  }
  
}
