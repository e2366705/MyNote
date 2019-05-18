import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.less']
})
export class SearchComponent implements OnInit {

  public keywords:string;
  public history_List:any[] = [
    {
      title:'do homeword',
      status:0
    },
    {
      title:'go shopping',
      status:1
    },
    {
      title:'play games',
      status:0
    },

  ];

  constructor() { }

  ngOnInit() {
  }

  doSearch(){
    //   如果关键字不存在 返回-1  就push  也就是有没有重复的数据
    if(this.if_has_ketwords(this.history_List , this.keywords)){
        this.history_List.push({
          title:this.keywords,
          status:0         // 0 表示 待办事项  1 表示已经完成的事项
        });
    }
    this.keywords='';
  }

  doAdd(ev){
    if(ev.keyCode == 13){
      this.doSearch();
    }
  }

  delete_history(key){
    this.history_List.splice(key,1);
  }



  if_has_ketwords(history_List:any , keywords:any){

    if(!keywords){
      return false;
    }

    for(let i=0 ; i < history_List.length;i++){
      if(history_List[i].title == keywords){
        return false;
      }
    }

    return true;

  }

}
