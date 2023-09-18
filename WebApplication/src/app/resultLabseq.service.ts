import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ResultLabseqService {
    private baseUrl='http://localhost:8080/api/labseq'
    
    constructor(private http: HttpClient){}

    getResultLabSeq(_n: number):Observable<any>{
        return this.http.get(`${this.baseUrl}/${_n}`);
    }
}