import { Component, OnInit } from '@angular/core';
import { TestService } from '../service/test.service'

@Component({
  selector: 'app-test001',
  templateUrl: './test001.component.html',
  styleUrls: ['./test001.component.less']
})
export class Test001Component implements OnInit {


  users:any[];
  constructor(public testService:TestService) {

    this.testService.getUsers().subscribe(users=>{
      // console.log(users);
      this.users = users;
    })
  }



  ngOnInit() {
  }

}
