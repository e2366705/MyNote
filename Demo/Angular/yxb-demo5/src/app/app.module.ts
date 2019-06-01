import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { from } from 'rxjs';

import { XxxxxService } from './xxxxx.service';
import { DomComponent } from './dom/dom.component';
import { HeadComponent } from './head/head.component';

@NgModule({
  declarations: [
    AppComponent,
    DomComponent,
    HeadComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [XxxxxService],
  bootstrap: [AppComponent]
})
export class AppModule { }