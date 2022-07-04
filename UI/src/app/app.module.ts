import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {UserComponent} from "./user/user.component";
import {FormsModule} from "@angular/forms";
import {StartPageComponent} from './main_page/start-page/start-page.component';
import {HttpClientModule} from "@angular/common/http";
import { HeaderComponent } from './header/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    StartPageComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
