import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.less']
})
export class FooterComponent implements OnInit {

  public msg:string = "footer-> msg";

  constructor() { }

  ngOnInit() {
  }

  run(){
    alert("i am footer run method....")
  }

}
