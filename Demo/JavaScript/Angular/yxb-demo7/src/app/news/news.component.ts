import { Component, OnInit , ViewChild } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.less']
})
export class NewsComponent implements OnInit {

  @ViewChild("footer") footer:any;
  constructor() { }

  ngOnInit() {
  }

  get_child_msg(){
    alert(this.footer.msg);
  }

  run_child_method(){
    this.footer.run();
  }

}
