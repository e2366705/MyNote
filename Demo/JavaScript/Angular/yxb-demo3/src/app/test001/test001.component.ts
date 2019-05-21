import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test001',
  templateUrl: './test001.component.html',
  styleUrls: ['./test001.component.less']
})
export class Test001Component implements OnInit {

  public peopleinfo:any={
    username:'jack',
    sex:'2',
    city_list:['北京' , '上海' , '深圳' , '广州' , '重庆' , '成都'],
    city:'北京',

    hobby:[
      {
        title:'movie',
        checked:false
      },
      {
        title:'music',
        checked:true
      },
      {
        title:'shopping',
        checked:true
      },
      {
        title:'Games', 
        checked:false
      },
  
  ]
  }

  constructor() { 
  }
  ngOnInit() {
  }

  doSubmit(){

  }
}
