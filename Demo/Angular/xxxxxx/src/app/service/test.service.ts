import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(
    private http_client: HttpClient
  ) { }

  getUsers(){
    return this.http_client.get("http://jsonplaceholder.typicode.com/users");
  }

}
