import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';
import { Product } from './product';
import { ProductService } from './product.service';
@Component({
    templateUrl : './product-details.component.html',
    styleUrls : ['./product-details.component.css']
})

export class ProductDetailsComponent {
    title = 'Product Details';
    product : Product ;

    constructor(
        private productService : ProductService,
        private route: ActivatedRoute,
        private location: Location
      ) {}
    
      ngOnInit(): void {
        this.route.paramMap
          .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
          .subscribe(product => this.product = product);
      }
    
      save(): void {
        this.productService.update(this.product)
          .then(() => this.goBack());
      }
    
      goBack(): void {
        this.location.back();
      }

}