import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService{


    createDb() {
     const products = [
    { id : 1000, name : 'Bangur Cement', price : 290.29},
    { id : 1001, name : 'Fila Shoes', price : 1350.49},
    { id : 1002, name : 'Wrangler Jeans', price : 4520.49},
    { id : 1003, name : 'Reebok Shoes', price : 850.49},
    { id : 1004, name : 'Nvidia Graphic Card', price : 1999.49},
    { id : 1005, name : 'Maggi Noodles', price : 75.50},
    { id : 1006, name : 'Saccha Moti Sabudana', price : 62.45},
    { id : 1007, name : 'Bambino Macroni', price : 30.78},
    { id : 1008, name : 'HP Pavilion G4', price : 25599.49},
    { id : 1009, name : 'Moto E', price : 5350.49},
    { id : 1010, name : 'Redmi Note 4', price : 10000},
    { id : 1011, name : 'Bean bag', price : 2450.49},
    { id : 1012, name : 'Yamaha FZ', price : 95000},
    { id : 1013, name : 'Himani Navratna Oil', price : 160.00}
    ];

    return { products };
    }


}