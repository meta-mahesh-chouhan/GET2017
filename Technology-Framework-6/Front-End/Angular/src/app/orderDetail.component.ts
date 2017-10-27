import { Component , OnInit } from '@angular/core';
import { Order } from './order';
import { OrderService } from './order.service';
import { OrderDetail } from './orderDetail';
import { ActivatedRoute, ParamMap } from '@angular/router';



@Component({
    selector: 'orderDetail',
    templateUrl: './orderDetail.component.html'
  })

  export class OrderDetailComponent  implements OnInit {
    orderDetail: OrderDetail[] ;
    constructor(
    private orderService:OrderService,
    private route: ActivatedRoute
    ) {}
    ngOnInit(): void {
        this.route.paramMap
        .switchMap((params: ParamMap) => this.orderService.getOrderDetail(+params.get('orderId')))
        .subscribe(orderDetail => this.orderDetail = orderDetail);
      }
     
    }