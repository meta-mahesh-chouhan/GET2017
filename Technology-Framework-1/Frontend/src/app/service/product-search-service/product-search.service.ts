import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable} from 'rxjs/Observable';
import { Product } from '../../modal/product';

import 'rxjs/add/operator/map';
@Injectable()
export class ProductSearchService {

    constructor(private http : Http){
    }

    search(term : string) : Observable<Product[]>{

        return this.http.get(`api/products/?name=${term}`)
        .map(response => response.json().data as Product[] );
    }
}