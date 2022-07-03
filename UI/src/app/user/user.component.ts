import { Component } from '@angular/core';
import {UserEntry} from "./UserEntry";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
})
export class UserComponent {
  title = 'angular-basics';
  public textUnderInput: string = "";
  public user: UserEntry = {};
  public mas: string[] = ["1", "2", "3"];
  public users: any = [
    {name: "Gnom", age: 25},
    {name: "Rodya", age: 26}
  ]


  constructor() {
  }



  public onInput(event: any): void {
    this.textUnderInput = event.target.value;
  }

  public cleanFormName(): void {
    this.user.firstName = "";
  }

  public cleanFormAge(): void {
    this.user.firstName = undefined;
  }
}
