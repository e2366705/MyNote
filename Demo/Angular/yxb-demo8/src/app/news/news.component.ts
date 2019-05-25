import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.less']
})
export class NewsComponent implements OnInit {

  public list:any[] = [];

  constructor(public http:HttpClient) { }

  ngOnInit() {
  }

  getDate(){
    let api = "http://a.itying.com/api/productlist";
    this.http.get(api).subscribe((response:any)=>{

      this.list = response.result;

      console.log(this.list);

    });
  }

}
