import { Injectable } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';

@Injectable()
export class ProductService {
    getProduct() : Product[] {
        return PRODUCTS;
    } 
}
