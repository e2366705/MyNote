import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {

  public title:string = "i am home page title";
  public msg:string = "i am fathers msg...";

  constructor() {}

  ngOnInit() {}

  run(){
    alert("i am father run method.....")
  }

}
