import { Component } from '@angular/core';
import { Product } from './product';
import { PRODUCTS } from './mock-product';

@Component({
  selector: 'my-app',
  template: `<h1>Products</h1>`,
})

export class AppComponent  { name = 'Angular'; }
