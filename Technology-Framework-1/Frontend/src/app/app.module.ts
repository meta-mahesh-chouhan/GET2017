import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './component/app/app.component';
import { ContactUsComponent } from './component/contactus/contactus.component';
import { ProductComponent } from './component/product/product.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';
import { ProductService } from './service/product-service/product.service';
import { ProductDetailsComponent } from './component/product-details/product-details.component';
import { FormsModule }   from '@angular/forms';
import { ProductSearchComponent } from './component/product-search/product-search.component';
import { ProductSearchService } from './service/product-search-service/product-search.service';
@NgModule({
  declarations: [
    AppComponent,
    ContactUsComponent,
    ProductComponent,
    DashboardComponent,
    ProductDetailsComponent,
    ProductSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    HttpModule,
    FormsModule
  ],
  providers: [ ProductService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
