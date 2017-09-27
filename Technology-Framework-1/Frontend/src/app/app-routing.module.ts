import { NgModule } from '@angular/core';
import { RouterModule , Routes } from '@angular/router';
import { ContactUsComponent } from './component/contactus/contactus.component';
import { ProductComponent } from './component/product/product.component';
import { ProductDetailsComponent} from './component/product-details/product-details.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
const routes : Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'contactus',  component: ContactUsComponent },
    { path: 'products',  component: ProductComponent },
    { path: 'dashboard',  component: DashboardComponent },
    { path: 'productdetails/:id', component : ProductDetailsComponent}
];

@NgModule({
    imports : [ RouterModule.forRoot(routes)],
    exports : [ RouterModule ]
})

export class AppRoutingModule {

}