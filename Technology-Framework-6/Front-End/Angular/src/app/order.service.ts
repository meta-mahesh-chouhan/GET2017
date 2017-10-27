import { Injectable } from '@angular/core';
import { Product } from './Product';
import { Order } from './order';
import { Headers, Http } from '@angular/http';
import { OrderDetail } from './orderDetail';

@Injectable()
export class OrderService {
    constructor(private http: Http) { }

    static order: Order[] = [];
    static orderDetail: OrderDetail[] = [];
    private orderAddUrl = 'http://localhost:8080/Assignment4/rest/product/getAllOrder'; 
    private orderSaveUrl = 'http://localhost:8080/Assignment4/rest/product/order'; 
    private getOrderDetailUrl = "http://localhost:8080/Assignment4/rest/product/getOrderDetail";
    private headers = new Headers({'Content-Type': 'application/json'});
    private currentUser:String; 
    getOrder(): Promise<Order[]> {
        this.currentUser=localStorage.getItem("username");
        const url = `${this.orderAddUrl}/${this.currentUser}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as Order[])
        .catch();
    }
    saveOrder(order:Order){
        this.currentUser=localStorage.getItem("username");
            const url = `${this.orderSaveUrl}/${this.currentUser}`;
            console.log(order.amount +"cvv" + order.cvv + "cardnumber" + order.cardNumber);
            return this.http.post(url, JSON.stringify({amount:order.amount,cvv:order.cvv,cardNumber:order.cardNumber}), {headers: this.headers})
            .toPromise()
            .catch();
            
    }
    getOrderDetail(orderId:number): Promise<OrderDetail[]> {
         const url = `${this.getOrderDetailUrl}/${orderId}`;
        console.log(url);
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as OrderDetail[]
        )
        .catch();
    }
   
}