import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {Access} from './../entities/access';
import 'rxjs/add/operator/map'



@Injectable()
export class AccessService {

    public logged: boolean = false;
     public data;

    constructor(private http: Http) {
     }
     findIp(access:Access) {
       
        var params = JSON.stringify(access);
        console.log("params"+ params);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log("before return");
      return this.http.post('http://localhost:8080/access/findIp',params, options)
            .map((response: Response) => {
                 let res = <Access> response.json().result;
                 console.log("after return");
                 return res;
            });
    }


    



}
