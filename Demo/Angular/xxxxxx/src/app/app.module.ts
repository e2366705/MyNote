import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule }    from '@angular/common/http';
import { TestService } from './service/test.service';

import { AppComponent } from './app.component';
import { Test001Component } from './test001/test001.component';

@NgModule({
  declarations: [
    AppComponent,
    Test001Component
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [TestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
