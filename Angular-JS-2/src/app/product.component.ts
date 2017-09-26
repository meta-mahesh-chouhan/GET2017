import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { Router } from '@angular/router';
@Component({
    templateUrl : './product.component.html',
    styleUrls : ['product.component.css']
})

export class ProductComponent implements OnInit {
  
    title = 'Product Component';
    selectedProduct : Product;
    products : Product[];

    constructor(private productService : ProductService , private router : Router){}
    
    getProducts(): void {
        this.productService
            .getProducts()
            .then(products => this.products = products);
      }

      ngOnInit(): void {
        this.getProducts();
    }

    createProduct(id : number, name : string, price : number): void {
        this.productService.create(id,name, price).then(product => { this.products.push(product)});
    }

    editDetails():void {
        this.router.navigate(['/productdetails',this.selectedProduct.id]);
    }
    
    onSelect(product : Product) : void {
        this.selectedProduct = product;
    }

    deleteProduct(product : Product):void{
        this.productService.delete(product.id)
        .then(() => {
            this.products = this.products.filter(p => p !== product);
            if (this.selectedProduct === product) { this.selectedProduct = null; }
          });
    }
}