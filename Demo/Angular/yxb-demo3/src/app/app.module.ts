import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { Test001Component } from './test001/test001.component';
import { from } from 'rxjs';
import { SearchComponent } from './search/search.component';

import { XxxxxService } from './xxxxx.service';

@NgModule({
  declarations: [
    AppComponent,
    Test001Component,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [XxxxxService],
  bootstrap: [AppComponent]
})
export class AppModule { }