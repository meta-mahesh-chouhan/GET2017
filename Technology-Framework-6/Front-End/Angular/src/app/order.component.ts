import { Component } from '@angular/core';
import { Router } from '@angular/router';
import{ CartItem } from './cart-item';
import { CartService } from './cart-service';
import { Order } from './order';
import { OrderService } from './order.service';


@Component({
selector: 'my-order',
templateUrl: './order.component.html',
})
export class OrderComponent {

    order:Order[];
    cartItem: CartItem[];
    constructor(private orderServices: OrderService, private router: Router) { }
  
    ngOnInit() {
      this.getOrderProduct();
    }
  
    getOrderProduct(): void {
      this.orderServices.getOrder().then(order => this.order = order);
    }
  
    goToDetail(orderId:number): void {
      this.router.navigate(['/orderDetail',orderId]);
    }
  

}