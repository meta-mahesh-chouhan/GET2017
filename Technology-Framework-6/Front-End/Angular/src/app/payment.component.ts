
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from './order.service';
import { Order } from './order';
import{ CartService } from './cart-service';

@Component({
selector: 'my-payment',
templateUrl: './payment.component.html',
})
export class PaymentComponent implements OnInit{
    
    constructor(private orderService:OrderService,
                private cartService:CartService ){}

    ngOnInit(): void {
        
      }
    saveOrder(cardN:number,cardE:number,cardC:number):void{
       let order: Order = {
        orderId: 0,
        cardNumber: cardN,
        cvv: cardC,
        amount: 10000,
        dop: '',
        userId:localStorage.getItem("username")
       }  
          this.orderService.saveOrder(order);
         
      }


}