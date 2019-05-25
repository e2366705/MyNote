import { Component, OnInit , ViewChild } from '@angular/core';

@Component({
  selector: 'app-dom',
  templateUrl: './dom.component.html',
  styleUrls: ['./dom.component.less']
})
export class DomComponent implements OnInit {


  @ViewChild('box') box:any;
  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    console.log(this.box);
    this.box.nativeElement.style.color='red';
    this.box.nativeElement.style.background='black';
  }

}
