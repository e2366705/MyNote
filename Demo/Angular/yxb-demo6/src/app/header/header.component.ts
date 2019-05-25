import { Component, OnInit ,Input } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.less']
})
export class HeaderComponent implements OnInit {

  // 接收父组件传过来的数据
  @Input() title:any;
  @Input() msg:any;
  @Input() run:any;
  @Input() home:any;

  constructor() { }

  ngOnInit() {
  }

  runFather_method(){
    this.run();
  }

  home_btn(){
    this.home.run();
  }

}

