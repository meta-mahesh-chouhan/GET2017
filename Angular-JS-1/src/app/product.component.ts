import { Component } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';

@Component({
    selector : 'my-app',
    templateUrl : './ProductList.html',
    providers : [ ProductService],
})

export class ProductComponent {
    title = 'Products';
    products : Product[];
    
    constructor(private productService: ProductService) { 
        this.products = this.productService.getProduct();
    }
}