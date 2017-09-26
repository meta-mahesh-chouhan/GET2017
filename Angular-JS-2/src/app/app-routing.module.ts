import { NgModule } from '@angular/core';
import { RouterModule , Routes } from '@angular/router';
import { ContactUsComponent } from './contactus.component';
import { ProductComponent } from './product.component';
import { ProductDetailsComponent} from './product-details.component';
import { DashboardComponent } from './dashboard.component';
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