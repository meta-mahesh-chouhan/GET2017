import { Component } from '@angular/core';
import { ProductSearchService } from '../../service/product-search-service/product-search.service';
import { Product } from '../../modal/product';
import { Router } from '@angular/router';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';

// Observable class extensions
import 'rxjs/add/observable/of';

// Observable operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
@Component({
    selector : 'search',
    templateUrl : './product-search.component.html',
    styleUrls : ['./product-search.component.css'],
    providers: [ProductSearchService]
})

export class ProductSearchComponent {
    products : Observable<Product[]>;

    private searchTerms = new Subject<string>();
    
    
  constructor(
    private productSearchService: ProductSearchService,
    private router: Router) {}

    search(term: string): void {
      this.searchTerms.next(term);
    }

    ngOnInit(): void {
        this.products = this.searchTerms
          .debounceTime(300)     
          .distinctUntilChanged()  
          .switchMap(term => term  
            ? this.productSearchService.search(term)
            : Observable.of<Product[]>([]))
          .catch(error => {
            console.log(error);
            return Observable.of<Product[]>([]);
          });
      }

      gotoDetail(product: Product): void {
        let link = ['/productdetails', product.id];
        this.router.navigate(link);
      }

}