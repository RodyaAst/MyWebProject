import { Component, OnInit } from '@angular/core';
import {UserEntry} from "../../user/UserEntry";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
})
export class StartPageComponent implements OnInit {

  private static URL: string = "http://localhost:8080/user/byId?id=1";
  private static URL2: string = "https://jsonplaceholder.typicode.com/todos?_limit=2"
  public user: UserEntry = {};
  public test: string = "One";

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }

  public confirmForm():void {
    this.http.get(StartPageComponent.URL)
      .subscribe(res => {
        this.user = res;
        this.test = "two";
        console.log(this.user);
        console.log("-----");
        console.log(this.user.name);
        console.log("-----");
        console.log(this.user.age);
      })
  }

}
