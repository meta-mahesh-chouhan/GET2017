import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent }  from './app.component';
import { ProductComponent } from './product.component';
import { ProductService } from './product.service';
@NgModule({
  imports:      [ BrowserModule ],
  declarations: [ProductComponent],
  bootstrap:    [ProductComponent]
})
export class AppModule { }
