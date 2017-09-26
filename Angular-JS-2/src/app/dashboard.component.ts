import { Component , OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';

@Component({
    templateUrl : './dashboard.component.html',
    styleUrls : ['dashboard.component.css']
})


export class DashboardComponent implements OnInit{
 
    title = 'DashBoard';
    products : Product[];

    constructor(private productService : ProductService){}

    ngOnInit(): void {
        this.productService.getProducts().then( products => this.products = products.slice(0,6));
}

}