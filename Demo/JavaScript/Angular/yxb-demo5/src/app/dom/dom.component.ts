import { Component, OnInit , ViewChild } from '@angular/core';

@Component({
  selector: 'app-dom',
  templateUrl: './dom.component.html',
  styleUrls: ['./dom.component.less']
})
export class DomComponent implements OnInit {


  @ViewChild('box') box:any;
  @ViewChild('head') head:any;
  constructor() { }

  ngOnInit() {
  }


  showBox(){
    let showBox:any = document.getElementById('head');
    showBox.style.transform = 'translate(0,0)';
  }
  hiddenBox(){
    let showBox:any = document.getElementById('head');
    showBox.style.transform = 'translate(100%,0)';
  }


}
