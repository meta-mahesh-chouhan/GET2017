import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactUsComponent } from './contactus.component';
import { ProductComponent } from './product.component';
import { DashboardComponent } from './dashboard.component';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';
import { ProductService } from './product.service';
import { ProductDetailsComponent } from './product-details.component';
import { FormsModule }   from '@angular/forms';
import { ProductSearchComponent } from './product-search.component';
import { ProductSearchService } from './product-search.service';
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
